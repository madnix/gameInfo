package controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.Member;
import logic.MemberImpl;
import logic.UserBean;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginFormController {

	private Member memberService;
	
	@SuppressWarnings("unused")
	private Validator loginValidator;

	public void setShopService(Member memberService) {
		this.memberService = memberService;
	}

	public void setLoginValidator(Validator loginValidator) {
		this.loginValidator = loginValidator;
	}

	@RequestMapping(value = "/mem_Login.info", method = RequestMethod.GET)
	public ModelAndView mem_Login2(HttpServletResponse response)
			throws Exception {
		// ModelAndView m = new ModelAndView();
		// m.setViewName("member/mem_login");
		// return m;
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("window.open('/mem_login.info', null)");// 주소수정
		out.println("</script>");
		return null;
	}

	@RequestMapping(value = "/mem_Login.info", method = RequestMethod.POST)
	public ModelAndView submit(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("login_id").trim();
		String pass = request.getParameter("login_pwd").trim();

		UserBean user = new UserBean();
		user.setUser_id(id);
		user.setUser_pass(pass);

		UserBean loginUser = this.memberService.getLoginCheck(user);
		
		if (loginUser == null) {
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.')");
			out.println("history.back()");
			out.println("</script>");
			
		} else {
			String login_id = loginUser.getUser_id();
			String login_nickname = loginUser.getUser_nickname();
			String state=loginUser.getUser_state();

			session.setAttribute("id", login_id);
			session.setAttribute("nickname", login_nickname);
			session.setAttribute("userstate", state);

			out.println("<script>");
			out.println("alert('로그인 되었습니다');");
			out.println("window.opener.document.location.href = window.opener.document.URL;");
			out.println("window.close();");
			out.println("</script>");
		}
		return null;
	}

	@RequestMapping(value = "/mem_logout.info", method = RequestMethod.GET)
	public ModelAndView mem_Logout(HttpServletResponse response,
			HttpServletRequest request, HttpSession session) throws Exception {

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
						
		if (session != null) {
			out.println("<script>");
			out.println("alert('로그아웃되셨습니다.')");
			out.println("</script>");
			session.removeAttribute("id");
			session.removeAttribute("nickname");
			session.removeAttribute("state");
			session.invalidate();
		}
		

		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/main.info");

		return model;
	}
	
	@RequestMapping(value = "/mem_kick.info", method = RequestMethod.GET)
	public ModelAndView mem_kick(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");

		this.memberService.deleteMember(id);
		out.println("<script>");
		out.println("alert('탈퇴되었습니다')");
		out.println("location.replace('/GameInfo/mem_list.info')");
		out.println("</script>");
		
		return null;
	}	

	@RequestMapping(value = "/mem_idcheck.info", method = RequestMethod.POST)
	public ModelAndView idcheck(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("idcheck").trim();

		UserBean user = new UserBean();
		user.setUser_id(id);

		this.memberService.idCheck(user);

		UserBean idCheck = this.memberService.idCheck(user);
		if (idCheck != null) {
			out.println("<script>");
			out.println("alert('이미 등록된 아이디입니다')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('사용 가능한 아이디입니다');");
			out.println("window.opener.document.f.join_id.value = '" + id
					+ "';");
			out.println("window.close();");
			out.println("</script>");

			// ModelAndView model = new ModelAndView();
			// model.setViewName("member/mem_join");
			// model.addObject("id", id);

			// return model;
		}
		return null;
	}

	@RequestMapping(value = "/mem_nickcheck.info", method = RequestMethod.POST)
	public ModelAndView nickcheck(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String nick = request.getParameter("nickcheck").trim();

		UserBean user = new UserBean();
		user.setUser_nickname(nick);

		this.memberService.nickCheck(user);

		UserBean nickCheck = this.memberService.nickCheck(user);
		if (nickCheck != null) {
			out.println("<script>");
			out.println("alert('이미 등록된 닉네임입니다')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('사용 가능한 닉네임입니다');");
			out.println("window.opener.document.f.join_nickname.value = '"
					+ nick + "';");
			out.println("window.close();");
			out.println("</script>");

			// ModelAndView model = new ModelAndView();
			// model.setViewName("member/mem_join");
			// model.addObject("id", id);

			// return model;
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value = "/mem_zipcodecheck.info", method = RequestMethod.POST)
	public ModelAndView zipcodecheck(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String dong = request.getParameter("dong").trim();
		MemberImpl member = new MemberImpl();
		List zipcodeList = new ArrayList();
		zipcodeList = member.zipCheck(dong);
		request.setAttribute("zipcodelist", zipcodeList);

		request.setAttribute("dong", dong);

		ModelAndView model = new ModelAndView();
		model.setViewName("member/mem_zipcodecheck");

		return model;
	}

	@RequestMapping(value = "/mem_join.info", method = RequestMethod.GET)
	public String mem_join() {

		return "mem_join";
	}

	@RequestMapping(value = "/mem_join.info", method = RequestMethod.POST)
	public ModelAndView submit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("join_id").trim();
		String pwd = request.getParameter("join_pwd").trim();
		String name = request.getParameter("join_name").trim();
		String nickname = request.getParameter("join_nickname").trim();
		String zip1 = request.getParameter("join_zip01").trim();
		String zip2 = request.getParameter("join_zip02").trim();
		String addr1 = request.getParameter("join_addr01").trim();
		String addr2 = request.getParameter("join_addr02").trim();
		String mail = request.getParameter("join_mail").trim();
		String maildomain = request.getParameter("join_maildomain").trim();
		String phone1 = request.getParameter("join_phone01").trim();
		String phone2 = request.getParameter("join_phone02").trim();
		String phone3 = request.getParameter("join_phone03").trim();
		String birth = request.getParameter("join_birth").trim();

		UserBean user = new UserBean();
		user.setUser_id(id);
		user.setUser_pass(pwd);
		user.setUser_name(name);
		user.setUser_nickname(nickname);
		user.setUser_zip1(zip1);
		user.setUser_zip2(zip2);
		user.setUser_addr1(addr1);
		user.setUser_addr2(addr2);
		user.setUser_mail(mail);
		user.setUser_maildomain(maildomain);
		user.setUser_phone1(phone1);
		user.setUser_phone2(phone2);
		user.setUser_phone3(phone3);
		user.setUser_birth(birth);

		UserBean loginUser = this.memberService.getFindId(user);
		if (loginUser == null) {
			this.memberService.insertMember(user);

			response.sendRedirect("main.info");
		} else {
			out.println("<script>");
			out.println("alert('가입실패')");
			out.println("history.back(-1)");
			out.println("</script>");
		}
		return null;
	}

	@RequestMapping(value = "/mem_edit.info", method = RequestMethod.GET)
	public ModelAndView mem_edit(HttpSession session) throws Exception {

		String id = (String) session.getAttribute("id");
		UserBean user = new UserBean();
		user.setUser_id(id);

		UserBean mem_user = this.memberService.getFindId(user);

		ModelAndView model = new ModelAndView();
		model.setViewName("mem_edit");
		model.addObject("mem_user", mem_user);

		return model;
	}

	@RequestMapping(value = "/mem_edit.info", method = RequestMethod.POST)
	public ModelAndView submit2(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("join_id").trim();
		String pwd = request.getParameter("join_pwd").trim();
		String nickname = request.getParameter("join_nickname").trim();
		String zip1 = request.getParameter("join_zip01").trim();
		String zip2 = request.getParameter("join_zip02").trim();
		String addr1 = request.getParameter("join_addr01").trim();
		String addr2 = request.getParameter("join_addr02").trim();
		String mail = request.getParameter("join_mail").trim();
		String maildomain = request.getParameter("join_maildomain").trim();
		String phone1 = request.getParameter("join_phone01").trim();
		String phone2 = request.getParameter("join_phone02").trim();
		String phone3 = request.getParameter("join_phone03").trim();
		String birth = request.getParameter("join_birth").trim();

		UserBean user = new UserBean();
		user.setUser_id(id);
		user.setUser_pass(pwd);
		user.setUser_nickname(nickname);
		user.setUser_zip1(zip1);
		user.setUser_zip2(zip2);
		user.setUser_addr1(addr1);
		user.setUser_addr2(addr2);
		user.setUser_mail(mail);
		user.setUser_maildomain(maildomain);
		user.setUser_phone1(phone1);
		user.setUser_phone2(phone2);
		user.setUser_phone3(phone3);
		user.setUser_birth(birth);

		UserBean loginUser = this.memberService.getFindId(user);
		if (loginUser != null) {
			this.memberService.updateMember(user);

			response.sendRedirect("main.info");
		} else {
			out.println("<script>");
			out.println("alert('수정실패')");
			out.println("history.back(-1)");
			out.println("</script>");
		}
		return null;
	}

	@RequestMapping(value = "/mem_userinfo.info", method = RequestMethod.GET)
	public ModelAndView mem_info(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		String id = (String) session.getAttribute("id");
		UserBean user = this.memberService.userInfo(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("member/mem_userinfo");
		model.addObject("mem_user", user);
		return model;
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/mem_del.info", method = RequestMethod.POST)
	public ModelAndView mem_del(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		String id = request.getParameter("id");

		session.invalidate();

		this.memberService.deleteMember(id);

		response.sendRedirect("../GameInfo/main.info");

		return null;
	}

	@RequestMapping(value = "/mem_findid.info", method = RequestMethod.POST)
	public ModelAndView findId(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("idcheck").trim();

		UserBean user = new UserBean();
		user.setUser_name(name);

		this.memberService.idFind(user);

		UserBean nameCheck = this.memberService.idFind(user);
		if (nameCheck == null) {
			out.println("<script>");
			out.println("alert('아이디가 존재하지 않습니다')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('회원님의 아이디는 "+nameCheck.getUser_id()+" 입니다');");
			out.println("history.back()");
			out.println("</script>");
		}
		return null;

	}
	@RequestMapping(value = "/mem_findpwd.info", method = RequestMethod.POST)
	public ModelAndView findPwd(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("nameCheck").trim();
		String id = request.getParameter("idCheck");

		UserBean user = new UserBean();
		user.setUser_name(name);
		user.setUser_id(id);

		this.memberService.pwdFind(user);

		UserBean pwdCheck = this.memberService.pwdFind(user);
		if (pwdCheck == null) {
			out.println("<script>");
			out.println("alert('정보가 올바르지 않습니다')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('회원님의 비밀번호는 "+pwdCheck.getUser_pass()+" 입니다');");
			out.println("history.back()");
			out.println("</script>");
		}
		return null;

	}
	

	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/mem_list.info", method=RequestMethod.GET)
	public ModelAndView memlist(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception{

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		UserBean user = new UserBean();
		List<UserBean> userlist = new ArrayList<UserBean>();
		
		String adminid = (String) session.getAttribute("id");

		user.setUser_id(adminid);
		
		UserBean check = this.memberService.admincheck(user);
		
		if(check==null){
			out.println("<script>");
			out.println("alert('관리자 메뉴입니다.')");
			out.println("history.back()");
			out.println("</script>");
		}else{
			int usercount = this.memberService.membercount();
			userlist = this.memberService.mem_List();
			request.setAttribute("memcount", usercount);
			request.setAttribute("memlist", userlist);
		}
		
		ModelAndView model = new ModelAndView();
		model.setViewName("member/mem_list");

		return model;
		
	}
	
	@RequestMapping(value="/mem_gradeup.info", method=RequestMethod.GET)
	public ModelAndView memgradeup(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception{
		
		String id=null;
		if(request.getParameter("id")!=null){
		id= request.getParameter("id");
		}
		
		UserBean user = new UserBean();
		
		user.setUser_id(id);
		
		this.memberService.gradeup(user);
		
		response.sendRedirect("redirect:/main.info");
		
		return null;
	}
	@RequestMapping(value="/mem_gradedown.info", method=RequestMethod.GET)
	public ModelAndView memgradedown(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception{
		
		String id=null;
		if(request.getParameter("id")!=null){
		id= request.getParameter("id");
		}
		
		UserBean user = new UserBean();
		
		user.setUser_id(id);
		
		this.memberService.gradedown(user);
		
		response.sendRedirect("redirect:/main.info");
		
		return null;
	}
}

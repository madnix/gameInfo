package controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.BbsBean;
import logic.CommentBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;

import dao.BbsDao;

@Controller
public class ComxboxFormController {

	private BbsDao bbsService;

	public void setBbsService(BbsDao bbsService) {
		this.bbsService = bbsService;
	}

	@RequestMapping(value = "com_xbox_write.info", method = RequestMethod.GET)
	public ModelAndView bbs_write() {

		ModelAndView model = new ModelAndView();
		model.setViewName("community/com_xbox_write");

		return model;
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/com_xbox_write.info", method = RequestMethod.POST)
	public ModelAndView submit(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		BbsBean bbsbean = new BbsBean();
		String saveFolder = "C:/JavaDevProject/Portfolilo/GameInfo/comxboxupload";

		int fileSize = 5 * 1024 * 1024;

		MultipartRequest multi = null;

		multi = new MultipartRequest(request, saveFolder, fileSize, "UTF-8");

		String nickname = multi.getParameter("nickname").trim();
		String title = multi.getParameter("title").trim();
		String cont = multi.getParameter("cont").trim();
		String pwd = multi.getParameter("pwd").trim();

		File UpFile1 = multi.getFile("admin_file1");
		File UpFile2 = multi.getFile("admin_file2");
		if (UpFile1 != null) {
			String fileName = UpFile1.getName();
			Calendar c = Calendar.getInstance();

			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH) + 1;
			int date = c.get(Calendar.DATE);

			String homedir = saveFolder + "/" + year + "-" + month + "-" + date;

			File path1 = new File(homedir);
			if (!(path1.exists())) {
				path1.mkdir();
			}

			Random r = new Random();
			int random = r.nextInt(100000000);

			int index = UpFile1.getName().lastIndexOf(".");
			String fileExtension = UpFile1.getName().substring(index + 1);

			String refileName = "com" + year + month + date + random + "."
					+ fileExtension;

			String fileDBName = "/" + year + "-" + month + "-" + date + "/"
					+ refileName;
			UpFile1.renameTo(new File(homedir + "/" + refileName));

			bbsbean.setSub_file1(fileDBName);
		}
		if(UpFile2!=null){
			String fileName = UpFile2.getName();
			Calendar c = Calendar.getInstance();

			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH) + 1;
			int date = c.get(Calendar.DATE);

			String homedir = saveFolder + "/" + year + "-" + month + "-" + date;

			File path1 = new File(homedir);
			if (!(path1.exists())) {
				path1.mkdir();
			}

			Random r = new Random();
			int random = r.nextInt(100000000);

			int index = UpFile2.getName().lastIndexOf(".");
			String fileExtension = UpFile2.getName().substring(index + 1);

			String refileName = "com" + year + month + date + random + "."
					+ fileExtension;

			String fileDBName = "/" + year + "-" + month + "-" + date + "/"
					+ refileName;
			UpFile2.renameTo(new File(homedir + "/" + refileName));

			bbsbean.setSub_file2(fileDBName);
		}
		bbsbean.setNickname(nickname);
		bbsbean.setTitle(title);
		bbsbean.setCont(cont);
		bbsbean.setPwd(pwd);

		this.bbsService.insertcomXbox(bbsbean);
		response.sendRedirect("com_xbox_list.info");
		return null;
	}

	// 수정

	@RequestMapping(value = "/com_xbox_edit.info", method = RequestMethod.GET)
	public ModelAndView editGet(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		BbsBean bbsbean = new BbsBean();

		int no = Integer.parseInt(request.getParameter("no"));
		String pwd = request.getParameter("pwd");
		bbsbean = (BbsBean) this.bbsService.comXboxcheckpwd(no);
		String checkpwd = bbsbean.getPwd();
		
		if (session.getAttribute("userstate") == null) {	
			out.println("<script>");
			out.println("alert('로그인하여 주시기 바랍니다.')");
			out.println("history.back()");
			out.println("</script>");

		} else if (session.getAttribute("userstate") != null
				&& session.getAttribute("userstate").equals("admin")) {
			ModelAndView model = new ModelAndView();
			model.setViewName("community/com_xbox_edit");
			request.setAttribute("bbsbean", bbsbean);

			return model;
		} else if (checkpwd.equals(pwd)) {
			ModelAndView model = new ModelAndView();
			model.setViewName("community/com_xbox_edit");
			request.setAttribute("bbsbean", bbsbean);

			return model;

		} else {
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}

		return null;

	}

	@RequestMapping(value = "/com_xbox_edit.info", method = RequestMethod.POST)
	public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		BbsBean bbsbean = new BbsBean();
		String saveFolder = "C:/JavaDevProject/Portfolilo/GameInfo/comxboxupload";

		int fileSize = 5 * 1024 * 1024;

		MultipartRequest multi = null;

		multi = new MultipartRequest(request, saveFolder, fileSize, "UTF-8");

		int no = Integer.parseInt(multi.getParameter("no"));
		String nickname = multi.getParameter("nickname").trim();
		String title = multi.getParameter("title").trim();
		String cont = multi.getParameter("cont").trim();
		String pwd = multi.getParameter("pwd").trim();

		File UpFile1 = multi.getFile("admin_file1");
		File UpFile2 = multi.getFile("admin_file2");
		File UpFile3 = multi.getFile("admin_file3");
		File UpFile4 = multi.getFile("admin_file4");
		File UpFile5 = multi.getFile("admin_file5");
		if (UpFile1 != null) {

			List<File> file = new ArrayList<File>();
			file.add(UpFile1);
			file.add(UpFile2);
			file.add(UpFile3);
			file.add(UpFile4);
			file.add(UpFile5);

			// db에서 파일이름 얻어와 파일을 대체시켜야함
			if (file != null) {
				for (int i = 0; i < file.size(); i++) {
					String fileName = file.get(i).getName();

					Calendar c = Calendar.getInstance();

					int year = c.get(Calendar.YEAR);
					int month = c.get(Calendar.MONTH) + 1;
					// +1
					int date = c.get(Calendar.DATE);

					String homedir = saveFolder + "/" + year + "-" + month
							+ "-" + date;

					File path1 = new File(homedir);
					if (!(path1.exists())) {
						path1.mkdir();
					}

					Random r = new Random();
					int random = r.nextInt(100000000);

					int index = file.get(i).getName().lastIndexOf(".");
					String fileExtension = file.get(i).getName()
							.substring(index + 1);

					String refileName = "com" + year + month + date + random
							+ "." + fileExtension;

					String fileDBName = "/" + year + "-" + month + "-" + date
							+ "/" + refileName;
					file.get(i).renameTo(new File(homedir + "/" + refileName));

					bbsbean.setSub_file1(fileDBName);
				}
			}
		}
		bbsbean.setNo(no);
		bbsbean.setNickname(nickname);
		bbsbean.setTitle(title);
		bbsbean.setCont(cont);
		bbsbean.setPwd(pwd);

		this.bbsService.editcomXbox(bbsbean);
		response.sendRedirect("com_xbox_list.info");
		return null;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "com_xbox_list.info", method = RequestMethod.GET)
	public ModelAndView bbs_List(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		BbsDao bbsdao = new BbsDao();
		List bbslist = new ArrayList();

		int page = 1;
		int limit = 10;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));

		}

		int listcount = this.bbsService.getcomXboxListCount();

		bbslist = bbsdao.getcomXboxList(page, limit);

		int maxpage = (int) ((double) listcount / limit + 0.95);

		int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;

		int endpage = maxpage;
		if (endpage > startpage + 10 - 1)
			endpage = startpage + 10 - 1;

		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("bbslist", bbslist);
		request.setAttribute("limit", limit);

		ModelAndView model2 = new ModelAndView();
		model2.setViewName("../sub03_02");
		return model2;

	}

	@RequestMapping(value = "/com_xbox_find.info", method = RequestMethod.POST)
	public ModelAndView bbs_find(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<BbsBean> findList = new ArrayList();

		int page = 1;
		int limit = 10;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));

		}

		int listcount = this.bbsService.getcomXboxFindCount();

		int maxpage = (int) ((double) listcount / limit + 0.95);

		int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;

		int endpage = maxpage;
		if (endpage > startpage + 10 - 1)
			endpage = startpage + 10 - 1;

		String find_field = request.getParameter("find_field");
		String find_name = request.getParameter("find_name").trim();

		if (find_field.equals("nickname")) {
			findList = this.bbsService.comXboxFind(find_name, page, limit);
		} else {
			findList = this.bbsService.comXboxFind2(find_name, page, limit);
		}

		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("findList", findList);
		request.setAttribute("limit", limit);

		ModelAndView model = new ModelAndView();
		model.addObject("findList", findList);
		model.setViewName("community/com_xbox_find");
		return model;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/com_xbox_cont.info", method = RequestMethod.GET)
	public ModelAndView bbs_view(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BbsDao bbsdao = new BbsDao();
		BbsBean bbsbean = new BbsBean();

		CommentBean combean = new CommentBean();

		int no = 0;
		if (request.getParameter("no") != null) {
			no = Integer.parseInt(request.getParameter("no"));

		}
		// 댓글
		int listcount = this.bbsService.getcomXboxComCount(no);
		List comlist = new ArrayList();

		request.setAttribute("listcount", listcount);

		comlist = bbsdao.getcomXboxComList(no);

		request.setAttribute("comlist", comlist);
		// 댓글끝

		bbsdao.comXboxhit(no);

		bbsbean = (BbsBean) bbsdao.contcomXbox(no);

		request.setAttribute("bbsdata", bbsbean);
		request.setAttribute("comdata", combean);

		ModelAndView model2 = new ModelAndView();
		model2.setViewName("community/com_xbox_cont");
		return model2;
	}

	@RequestMapping(value = "/com_xbox_del.info", method = RequestMethod.GET)
	public ModelAndView bbs_del(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		BbsBean bbsbean = new BbsBean();

		int no = Integer.parseInt(request.getParameter("no"));
		String pwd = request.getParameter("pwd");
		bbsbean = (BbsBean) this.bbsService.comXboxcheckpwd(no);
		String checkpwd = bbsbean.getPwd();
		
		if (session.getAttribute("userstate") == null) {	
			out.println("<script>");
			out.println("alert('로그인하여 주시기 바랍니다.')");
			out.println("history.back()");
			out.println("</script>");

		} else if (session.getAttribute("userstate") != null
				&& session.getAttribute("userstate").equals("admin")) {
			this.bbsService.delcomXbox(no, checkpwd);
			this.bbsService.comXboxComDelAll(no);

			ModelAndView model = new ModelAndView();
			model.setViewName("redirect:/com_xbox_list.info");
			
			return model;
			
		} else if (checkpwd.equals(pwd)) {
			this.bbsService.delcomXbox(no, pwd);
			this.bbsService.comXboxComDelAll(no);

			ModelAndView model = new ModelAndView();
			model.setViewName("redirect:/com_xbox_list.info");
			
			return model;

		} else {
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
		return null;
	}

	@RequestMapping(value = "/com_xbox_com.info", method = RequestMethod.POST)
	public ModelAndView bbs_com(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		CommentBean combean = new CommentBean();

		String nickname = (String) session.getAttribute("nickname");

		int no = Integer.parseInt(request.getParameter("no"));

		String com = null;

		if (request.getParameter("com") != null) {
			com = request.getParameter("com");
		}
		if (nickname == null) {
			out.println("<script>");
			out.println("alert('로그인 후 작성해 주시기 바랍니다')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			combean.setBbsno(no);
			combean.setNickname(nickname);
			combean.setCom(com);
			combean.setPwd(null);

			this.bbsService.comXboxCom(combean);

			ModelAndView model = new ModelAndView();
			model.setViewName("redirect:/com_xbox_cont.info?no=" + no);
			return model;
		}
		return null;
	}

	@RequestMapping(value = "/com_xbox_comdel.info", method = RequestMethod.GET)
	public ModelAndView bbs_comdel(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		int bbsno = Integer.parseInt(request.getParameter("bbsno"));
		int comno = Integer.parseInt(request.getParameter("comno"));
		this.bbsService.comXboxComDel(bbsno, comno);

		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/com_xbox_cont.info?no=" + bbsno);
		return model;
	}

	@RequestMapping(value = "/com_xbox_recom.info", method = RequestMethod.GET)
	public ModelAndView bbs_recom(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		int no = 0;
		if (request.getParameter("no") != null) {
			no = Integer.parseInt(request.getParameter("no"));
		}

		this.bbsService.comXboxRecom(no);

		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/com_xbox_cont.info?no=" + no);
		return model;
	}
}

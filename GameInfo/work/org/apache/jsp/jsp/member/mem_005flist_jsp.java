package org.apache.jsp.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import logic.*;

public final class mem_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

List<UserBean> memlist=(ArrayList)request.getAttribute("memlist");
int memcount=((Integer)request.getAttribute("memcount")).intValue();
String grade = (String)session.getAttribute("userstate"); 

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>스프링3.0 회원목록</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("  <td align=\"right\" class=\"board_cont\">\r\n");
      out.write("  <input type=\"button\" value=\"메인이동\" onclick=\"location='");
      out.print(request.getContextPath());
      out.write("/main.info'\"></td>\r\n");
      out.write("  <table width=\"1300\">\r\n");
      out.write("   <tr height=\"30\">\r\n");
      out.write("    <th class=\"board_title\">번호</th> \r\n");
      out.write("    <th class=\"board_title\">아이디</th>\r\n");
      out.write("    <th class=\"board_title\">비밀번호</th> \r\n");
      out.write("    <th class=\"board_title\">이름</th>\r\n");
      out.write("    <th class=\"board_title\">닉네임</th>\r\n");
      out.write("    <th class=\"board_title\">우편번호1</th>\r\n");
      out.write("    <th class=\"board_title\">우편번호2</th>\r\n");
      out.write("    <th class=\"board_title\">주소1</th>\r\n");
      out.write("    <th class=\"board_title\">주소2</th>\r\n");
      out.write("    <th class=\"board_title\">이메일</th>\r\n");
      out.write("    <th class=\"board_title\">메일도메인</th>\r\n");
      out.write("    <th class=\"board_title\">생년월일</th>  \r\n");
      out.write("    <th class=\"board_title\">강제탈퇴</th>\r\n");
      out.write("   </tr>\r\n");
      out.write("   \r\n");
      out.write("   ");

   int v_no = memcount;
   for(int i=0;i<memlist.size();i++){
	   UserBean l=(UserBean)memlist.get(i);//컬렉션 요소값을 가져온다.
   
      out.write("\r\n");
      out.write("   \r\n");
      out.write("   <tr \r\n");
      out.write("   onmouseover=\"this.style.backgroundColor='#F8F8F8'\"\r\n");
      out.write("   onmouseout=\"this.style.backgroundColor=''\" class=\"board_cont\">\r\n");
      out.write("  \r\n");
      out.write("    <td align=\"center\" class=\"board_cont\">");
      out.print(v_no);
      out.write("</td>\r\n");
      out.write("    <td align=\"center\" class=\"board_cont\">");
      out.print(l.getUser_id());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\" class=\"board_cont\">");
      out.print(l.getUser_pass());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\" class=\"board_cont\">");
      out.print(l.getUser_name());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\" class=\"board_cont\">");
      out.print(l.getUser_nickname());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\" class=\"board_cont\">");
      out.print(l.getUser_zip1());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\" class=\"board_cont\">");
      out.print(l.getUser_zip2());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\" class=\"board_cont\">");
      out.print(l.getUser_addr1());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\" class=\"board_cont\">");
      out.print(l.getUser_addr2());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\" class=\"board_cont\">");
      out.print(l.getUser_mail());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\" class=\"board_cont\">");
      out.print(l.getUser_maildomain());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\" class=\"board_cont\">");
      out.print(l.getUser_birth());
      out.write("</td>\r\n");
      out.write("    ");
 if(grade != ("admin")) {
      out.write("\r\n");
      out.write("    <td align=\"center\" class=\"board_cont\"><input type=\"button\" value=\"회원탈퇴\" onclick=\"location='");
      out.print(request.getContextPath());
      out.write("/mem_kick.info?id=");
      out.print(l.getUser_id());
      out.write("'\"></tr>\r\n");
      out.write("    <!-- 0이상 10미만 사이의 문자 반환. 즉 시,분등은 빼고 년월일만 출력 -->\r\n");
      out.write("    ");
 } else { 
      out.write("\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("   ");
 v_no--; //1씩 감소
   } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("  </table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

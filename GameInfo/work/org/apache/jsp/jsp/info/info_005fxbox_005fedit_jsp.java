package org.apache.jsp.jsp.info;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import logic.BbsBean;

public final class info_005fxbox_005fedit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=utf-8");
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

BbsBean b = (BbsBean) request.getAttribute("bbsbean");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/GameInfo/modules/ckeditor/ckeditor.js\">\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/GameInfo/modules/ckfinder/ckfinder.js\">\r\n");
      out.write("</script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>수정</title>\r\n");
      out.write("<script src=\"/GameInfo/js/jquery.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction check() {\r\n");
      out.write("\t\tif ($.trim($(\"#title\").val()) == \"\") {\r\n");
      out.write("\t\t\talert(\"제목을 입력하세요!\");\r\n");
      out.write("\t\t\t$(\"#title\").val(\"\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif ($.trim($(\"#cont\").val()) == \"\") {\r\n");
      out.write("\t\t\talert(\"내용을 입력하세요\");\r\n");
      out.write("\t\t\t$(\"#cont\").val(\"\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif ($.trim($(\"#pwd\").val()) == \"\") {\r\n");
      out.write("\t\t\talert(\"비밀번호를 입력하세요\");\r\n");
      out.write("\t\t\t$(\"#pwd\").val(\"\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("\tmargin-left: 0px;\r\n");
      out.write("\tmargin-top: 0px;\r\n");
      out.write("\tmargin-right: 0px;\r\n");
      out.write("\tmargin-bottom: 0px;\r\n");
      out.write("}\r\n");
      out.write(".link_css {color:#999999; font-family: \"돋움체\"; text-decoration:none; font-size: 11px;}\r\n");
      out.write(".link_css:hover {color:#000000; font-family: \"돋움체\"; font-size:11px;}\r\n");
      out.write(".link01_css {color:#999999; font-family: \"돋움체\"; text-decoration:none; font-size: 11px; letter-spacing:-1px;}\r\n");
      out.write(".link01_css:hover {color:#000000; font-family: \"돋움체\"; text-decoration:none; font-size: 11px; letter-spacing:-1px;}\r\n");
      out.write(".serch_bt{width:50px; height:23px; background-color:#ccc; color:#FFFFFF; border:1px solid #cbcbcb;}\r\n");
      out.write(".serch_input {width:140px; height:18px; border:1px solid #ccc;}\r\n");
      out.write(".serch_board {width:200px; height:18px; border:1px solid #ccc;}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/Scripts/AC_RunActiveContent.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"50%\"></td>\r\n");
      out.write("    <td><table width=\"900\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"900\"><table width=\"900\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"700\" height=\"100\"><script type=\"text/javascript\">\r\n");
      out.write("AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0','width','700','height','100','src','");
      out.print(request.getContextPath());
      out.write("/media/navi/main_navi','quality','high','pluginspage','http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash','movie','");
      out.print(request.getContextPath());
      out.write("/media/navi/main_navi' ); //end AC code\r\n");
      out.write("</script><noscript><object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0\" width=\"700\" height=\"100\">\r\n");
      out.write("              <param name=\"movie\" value=\"media/navi/main_navi.swf\" />\r\n");
      out.write("              <param name=\"quality\" value=\"high\" />\r\n");
      out.write("              <embed src=\"");
      out.print(request.getContextPath());
      out.write("/media/navi/main_navi.swf\" quality=\"high\" pluginspage=\"http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash\" type=\"application/x-shockwave-flash\" width=\"700\" height=\"100\"></embed>\r\n");
      out.write("            </object></noscript></td>\r\n");
      out.write("            \r\n");
      out.write("\t\t\t<!-- 로그인 및 검색폼 영역-->\r\n");
      out.write("\t\t\t<td width=\"200\" height=\"100\">\r\n");
      out.write("\t\t\t\t<table width=\"200\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"200\" height=\"40\" align=\"right\" valign=\"bottom\">\r\n");
      out.write("\t\t\t\t\t");

					if(session.getAttribute("id") == null){
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"#\" class=\"link01_css\" onclick=\"window.open('jsp/member/mem_login.jsp','new','resizable=yes scrollbars=no width=450 height=250');return false\">로그인</a>\r\n");
      out.write("\t\t\t\t\t");

					}
					else if(session != null && session.getAttribute("id") != null){
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/mem_logout.info\" class=\"link01_css\" onclick=\"\">로그아웃</a>\r\n");
      out.write("\t\t\t\t\t");
}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t");
 if(session.getAttribute("userstate")!=null&&session.getAttribute("userstate").equals("admin")){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/mem_list.info\" class=\"link01_css\" >회원정보</a>\r\n");
      out.write("\t\t\t\t\t");

					 } 
					 if(session.getAttribute("userstate")==null) {
				     
      out.write("\r\n");
      out.write("\t\t\t\t    ");
} else {
      out.write("\r\n");
      out.write("\t\t\t\t    <a href=\"");
      out.print(request.getContextPath() );
      out.write("/mem_userinfo.info\" class=\"link01_css\" >내정보</a>\r\n");
      out.write("\t\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t");
 
					if(session.getAttribute("id") == null){
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/jsp/member/mem_join.jsp\" target=\"_self\" class=\"link01_css\">회원가입</a>\r\n");
      out.write("\t\t\t\t\t");

					} 
					else if(session.getAttribute("userstate")!=null&&session.getAttribute("userstate").equals("0") || equals("admin")) {
				    
      out.write("\r\n");
      out.write("\t\t\t\t    ");
} else {
      out.write("\r\n");
      out.write("\t\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/sitemap.jsp\" target=\"_self\" class=\"link01_css\">사이트맵</a>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"200\" height=\"60\" align=\"right\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" class=\"serch_input\" /> \r\n");
      out.write("\t\t\t\t\t<input type=\"image\" name=\"serch\"\r\n");
      out.write("\t\t\t\t\tid=\"serch\" src=\"");
      out.print(request.getContextPath() );
      out.write("/images/images/btn_search.gif\" align=\"absmiddle\"\r\n");
      out.write("\t\t\t\t\tonClick=\"\" style=\"border-width: 0px;\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<!-- 로그인 및 검색폼 영역끝-->\r\n");
      out.write("            \r\n");
      out.write("          </tr>\r\n");
      out.write("        </table></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td><table width=\"900\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td><table width=\"250\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"250\" height=\"200\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/images/sub03_02/03_sub_02_05.png\" width=\"250\" height=\"200\" /></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"250\" height=\"430\"><script type=\"text/javascript\">\r\n");
      out.write("AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0','width','250','height','430','src','");
      out.print(request.getContextPath());
      out.write("/media/navi/sub01_navi','quality','high','pluginspage','http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash','movie','");
      out.print(request.getContextPath());
      out.write("/media/navi/sub01_navi' ); //end AC code\r\n");
      out.write("</script><noscript><object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0\" width=\"250\" height=\"430\">\r\n");
      out.write("                  <param name=\"movie\" value=\"media/navi/sub01_navi.swf\" />\r\n");
      out.write("                  <param name=\"quality\" value=\"high\" />\r\n");
      out.write("                  <embed src=\"");
      out.print(request.getContextPath());
      out.write("/media/navi/sub01_navi.swf\" quality=\"high\" pluginspage=\"http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash\" type=\"application/x-shockwave-flash\" width=\"250\" height=\"430\"></embed>\r\n");
      out.write("                </object></noscript></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table></td>\r\n");
      out.write("            <td width=\"50\" height=\"630\" bgcolor=\"#FFFFFF\"></td>\r\n");
      out.write("            <td width=\"600\">\r\n");
      out.write("            <table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("              <tr>\r\n");
      out.write("              <td>\r\n");
      out.write("              \r\n");
      out.write("  <!-- 내용 작성 영역-->\r\n");
      out.write("\t<form action=\"info_xbox_edit.info\" method=\"post\" name=\"editform\" id=\"editform\"\r\n");
      out.write("\t\tonsubmit=\"return check()\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"no\" value=\"");
      out.print(b.getNo());
      out.write("\"/>\r\n");
      out.write("        <!-- 히든으로 no 파라미터에 value 글번호값을 post방식으로 넘김 -->\r\n");
      out.write("        \r\n");
      out.write("\t\t  <table border=\"1\" width=\"100%\" height=\"100%\" bordercolor=\"grey\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t    <th><font color=\"grey\" size=\"1\">작성자</font></th>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t<input name=\"nickname\" id=\"nickname\" size=\"20\" maxlength=\"20\"\r\n");
      out.write("\t\t\t\t           readonly value=\"");
      out.print(session.getAttribute("nickname") );
      out.write("\" style=\"background-color:#BBBBBB\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t    <th><font color=\"grey\" size=\"1\">제목</font></th>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"title\" id=\"title\" value=\"");
      out.print(b.getTitle() );
      out.write("\" style=\"width: 532px;\" maxlength=\"100\" ></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t    <th><font color=\"grey\" size=\"1\">내용</font></th>\r\n");
      out.write("\t\t\t\t<td><textarea name=\"cont\" id=\"cont\" style=\"width: 500px; height: 100%;\">");
      out.print(b.getCont() );
      out.write("</textarea>\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t    <script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\t    var editor = CKEDITOR.replace('cont',{width: 530, height: 200}); \r\n");
      out.write("\t\t\t\t    CKFinder.SetupCKEditor(editor, '");
      out.print(request.getContextPath());
      out.write("/modules/ckfinder/');\r\n");
      out.write("                 </script>\r\n");
      out.write("\t\t\t\t</td> \r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t      <tr>\r\n");
      out.write("\t           <th bordercolor=\"grey\">\r\n");
      out.write("\t           <font color=\"grey\" size=\"1\">첨부파일</font></th>\r\n");
      out.write("\t\t       <td bordercolor=\"grey\">\r\n");
      out.write("\t\t          <input type=\"file\" name=\"sub_file1\" id=\"sub_file1\" value=\"");
      out.print(b.getSub_file1());
      out.write("\" size=\"20\">\r\n");
      out.write("\t\t          &nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t          <input type=\"file\" name=\"sub_file2\" id=\"sub_file2\" value=\"");
      out.print(b.getSub_file2());
      out.write("\" size=\"20\">\r\n");
      out.write("\t          </td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          \r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<th><font color=\"grey\" size=\"1\">비밀번호</font></th>\r\n");
      out.write("\t\t\t\t<td><input type=\"password\" name=\"pwd\" id=\"pwd\" size=\"20\" maxlength=\"10\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\"><input type=\"submit\" value=\"완료\">&nbsp;&nbsp; \r\n");
      out.write("\t\t\t\t<input type=\"reset\" value=\"취소\" onclick=\"location='info_xbox_list.info'\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr> \r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("              \t<!-- 내용 작성 영역 끝-->\r\n");
      out.write("                </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"900\">\r\n");
      out.write("        <table width=\"900\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#3e3f3e\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"750\" ><img src=\"");
      out.print(request.getContextPath());
      out.write("/images/index/main_09.jpg\" width=\"750\" height=\"70\" border=\"0\" /></td>\r\n");
      out.write("            <td width=\"150\" align=\"center\" valign=\"middle\" bgcolor=\"#3e3f3e\">\r\n");
      out.write("            \t<table><tr>\r\n");
      out.write("              \t<!-- 패밀리사이트 영역 -->\r\n");
      out.write("          \t    <td width=\"150\" >\r\n");
      out.write("            \t<select id=\"fmsite\" name=\"fmsite\" class=\"jumpmenu\" onchange=\"window.open(value,'_blank');\" >\r\n");
      out.write("                \t<option selected >= 선택하세요 =</option>\r\n");
      out.write("                    <option value=\"http://www.playstation.co.kr/main.sce\">플레이스테이션</option>\r\n");
      out.write("                    <option value=\"http://www.xbox.com/ko-KR/\">X-BOX</option>\r\n");
      out.write("                    <option value=\"http://betagam.danawa.com/\">PC</option>\r\n");
      out.write("                </select>\r\n");
      out.write("                </td></tr></table>\r\n");
      out.write("                <!-- 패밀리사이트 영역 --> \r\n");
      out.write("           </td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("    <td width=\"50%\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
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

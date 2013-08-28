package org.apache.jsp.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class mem_005fzipcodecheck_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 
	String zipcode,addr,addr2;
	String dong = (String)request.getAttribute("dong"); 
	List zipcodeList = (ArrayList)request.getAttribute("zipcodelist");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>우편번호검색</title>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<SCRIPT LANGUAGE=\"JavaScript\">\r\n");
      out.write("<!--\r\n");
      out.write("function selectnow() {\r\n");
      out.write("\r\n");
      out.write("\tvar zip=document.postform.post_list.value;\r\n");
      out.write("\tvar zip1=zip.substring(0,3); // 첫번째 우편번호가 저장\r\n");
      out.write("\t// substring(0,3)은 0이상 3미만 사이의 문자를 반환\r\n");
      out.write("\tvar zip2=zip.substring(4,7); // 4이상 7미만 사이의 문자반환\r\n");
      out.write("\t// 두번째 우편번호가 저장\r\n");
      out.write("\tvar addr2=zip.substring(7, (zip.length));\r\n");
      out.write("\t// 우편번호를 뺀 나머지 주소값이 저장\r\n");
      out.write("\topener.document.f.join_zip01.value=zip1;\r\n");
      out.write("\t\r\n");
      out.write("\t/* 회원가입창에 첫번째 세자리 우편번호를 입력한다. */\r\n");
      out.write("\r\n");
      out.write("\topener.document.f.join_zip02.value=zip2;\r\n");
      out.write("\t\r\n");
      out.write("\t/* 회원가입창에 두번째 세자리 우편번호를 입력한다. */\r\n");
      out.write("\r\n");
      out.write("\topener.document.f.join_addr01.value=addr2;\r\n");
      out.write("\t\r\n");
      out.write("\t/* 회원가입창에 나머지 주소를  입력한다. */\r\n");
      out.write("\r\n");
      out.write("\twindow.close();\r\n");
      out.write("\r\n");
      out.write("\t/* 그리고 윈도우 창을 닫아준다.  */\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function check(){\r\n");
      out.write("\tif($.trim(jQuery(\"#dong\").val())==\"\"){\r\n");
      out.write("\t\talert(\"동을 입력해 주세요!\");\r\n");
      out.write("\t\t$(\"#dong\").val(\"\").focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//-->\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("<style>\r\n");
      out.write(".checkArea {\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tcolor: #999999;\r\n");
      out.write("\tfont-family: \"돋움체\";\r\n");
      out.write("}\r\n");
      out.write(".bold {\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tcolor: #ff5a5a;\r\n");
      out.write("\tfont-family: \"돋움체\";\r\n");
      out.write("}\r\n");
      out.write(".chk_input {\r\n");
      out.write("\tborder: 1px solid #dedede;\r\n");
      out.write("\tborder-radius: 3px;\r\n");
      out.write("\tpadding: 3px;\r\n");
      out.write("}\r\n");
      out.write(".chk_input:hover {\r\n");
      out.write("\tbackground-color: #eeeeee;\r\n");
      out.write("}\r\n");
      out.write(".notserch{\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\tcolor: red;\r\n");
      out.write("\tfont-family: \"돋움체\";\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"postform.dong.focus();\" topmargin=\"0\" leftmargin=\"0\">\r\n");
      out.write("<form method=\"post\" action=\"");
      out.print(request.getContextPath() );
      out.write("/mem_zipcodecheck.info\" name=\"postform\" onsubmit=\"return check()\">\r\n");
      out.write("<table border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write(" <tr> \r\n");
      out.write("  <td align=\"center\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/images/zipcodechk.png\"></td>\r\n");
      out.write(" </tr>\r\n");
      out.write("\r\n");
      out.write(" <tr> \r\n");
      out.write("  <td align=\"center\">\r\n");
      out.write("  <p></p>\r\n");
      out.write("  <span class=\"checkArea\">* 거주지의 면.동을 입력하고 <span class=\"bold\">'찾기'</span> 버튼을 누르세요. </span>\r\n");
      out.write("  <p></p>\r\n");
      out.write("  <input type=\"text\" name=\"dong\" id=\"dong\" size=\"20\" maxlength=\"10\" class=\"chk_input\" />&nbsp;\r\n");
      out.write("  <input type=\"submit\" value=\"찾기\" onfocus=\"this.blur()\" /><br>\r\n");
      out.write("  </td>\r\n");
      out.write(" </tr>\r\n");
      out.write("\r\n");
      out.write(" ");
if(dong != null){ 
      out.write('\r');
      out.write('\n');
      out.write(' ');
if(zipcodeList != null && zipcodeList.size() != 0){
      out.write("\r\n");
      out.write(" <tr height=\"10\"></tr>\r\n");
      out.write(" <tr> \r\n");
      out.write("  <td height=\"30\" align=\"center\">\r\n");
      out.write("   <SELECT NAME=\"post_list\" onchange=\"selectnow()\">\r\n");
      out.write("   <!-- onchange이벤트는 자바스크립트에서 목록을 바꿀때 발생 -->\r\n");
      out.write("   \r\n");
      out.write("    <option value=\"\">== 주소를 선택하세요 ==</option>\r\n");
      out.write("\t");
for(int i = 0; i < zipcodeList.size(); i++) {	
		String data=(String)zipcodeList.get(i);
		StringTokenizer st = new StringTokenizer(data,",");
		// ,를 기분으로 data변수에 저장된 주소값을 분리.
		zipcode = st.nextToken(); // 첫번째는 우편번호값이 저장 (ex.745-777)
		addr = st.nextToken(); // 번지값을 뺀 주소값이 저장 (ex.서울...)
		addr2 = st.nextToken(); // 번지를 포함한 주소값이 저장
		String totaladdr = zipcode + addr; // 우편번호와번지를 뺀 주소
	
      out.write("\r\n");
      out.write("\t<option value=\"");
      out.print(totaladdr);
      out.write('"');
      out.write('>');
      out.write('[');
      out.print(zipcode);
      out.write("]&nbsp;");
      out.print(addr);
      out.write("</option>\r\n");
      out.write("\t");
}
      out.write("\r\n");
      out.write("   </SELECT>\r\n");
      out.write("  </td>\r\n");
      out.write(" </tr>\r\n");
      out.write(" ");
}else{ 
      out.write("\r\n");
      out.write(" <tr height=\"10\"></tr>\r\n");
      out.write(" <tr>\r\n");
      out.write("  <td height=\"30\" align=\"center\"><span class=\"notserch\">＊검색 결과가 없습니다.</span></td>\r\n");
      out.write(" </tr>\r\n");
      out.write(" ");
}}
      out.write("\r\n");
      out.write(" <tr> \r\n");
      out.write("  <td colspan=\"3\" height=\"3\"></td>\r\n");
      out.write(" </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
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

package org.apache.jsp.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mem_005fnickcheck_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

	String nick = (String) request.getAttribute("nick");
	if (nick == null) {

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>닉네임 중복체크</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".checkArea {\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tcolor: #999999;\r\n");
      out.write("\tfont-family: \"돋움체\";\r\n");
      out.write("}\r\n");
      out.write(".chk_input {\r\n");
      out.write("\tborder: 1px solid #dedede;\r\n");
      out.write("\tborder-radius: 3px;\r\n");
      out.write("\tpadding: 3px;\r\n");
      out.write("}\r\n");
      out.write(".checkArea_edit {\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tcolor: #ff5252;\r\n");
      out.write("\tfont-family: \"돋움체\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".chk_input:hover {\r\n");
      out.write("\tbackground-color: #eeeeee;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/js/jquery.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script language=\"JavaScript\">\r\n");
      out.write("\tfunction checktype(s, spc) {\r\n");
      out.write("\t\tvar i;\r\n");
      out.write("\t\tfor (i = 0; i < s.length; i++) {\r\n");
      out.write("\t\t\tif (spc.indexOf(s.substring(i, i + 1)) < 0) {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction check(form) {\r\n");
      out.write("\t\tvar v = form.nickcheck.value;\r\n");
      out.write("\t\tvar s = v.substr(0, 1);\r\n");
      out.write("\r\n");
      out.write("\t\tif ($.trim($(\"#nickcheck\").val()) == \"\") {\r\n");
      out.write("\t\t\talert(\"닉네임을 입력하세요!\");\r\n");
      out.write("\t\t\t$(\"#nickcheck\").val(\"\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif ($.trim($(\"#nickcheck\").val()).length < 4) {\r\n");
      out.write("\t\t\talert(\"닉네임은 4자리 이상입니다.\");\r\n");
      out.write("\t\t\t$(\"#nickcheck\").val(\"\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if ($.trim($(\"#nickcheck\").val()).length > 12) {\r\n");
      out.write("\t\t\talert(\"닉네임은 12자 이하입니다.\")\r\n");
      out.write("\t\t\t$(\"#nickcheck\").val(\"\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if (v.length == 0) {\r\n");
      out.write("\t\t\talert(\"원하시는 닉네임을 입력해 주세요!\");\r\n");
      out.write("\t\t\t$(\"#nickcheck\").val(\"\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if (!checktype(v, alogin)) {\r\n");
      out.write("\t\t\talert(\"영문대소문자로 시작해서 \\n 숫자조합으로 입력해 주세요!\");\r\n");
      out.write("\t\t\t$(\"#nickcheck\").val(\"\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script language=\"JavaScript\">\r\n");
      out.write("\r\n");
      out.write("\tfunction nickname_close(nickname) {\r\n");
      out.write("\t\topener.document.f.join_nickname.value = nickname;\r\n");
      out.write("\t\tself.close();\r\n");
      out.write("\t}\r\n");
      out.write("\t//js에서 opener객체는 공지창에서 본 현재 부모창을 가리킴\r\n");
      out.write("\t//결국 member_join.jsp 회원가입창이 opener가 됨\r\n");
      out.write("\t//self는 자신의 공지창을 가리킴\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body leftmargin=\"0\" topmargin=\"0\" onload='f.nickcheck.focus();'>\r\n");
      out.write("\t<form id=\"form1\" method=post name='f' action=\"");
      out.print(request.getContextPath() );
      out.write("/mem_nickcheck.info\" onsubmit=\"return check(this)\">\r\n");
      out.write("\t\t<table width=\"350\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t<tr> \r\n");
      out.write("  \t\t<td align=\"center\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/images/nick_chktop.png\"></td>\r\n");
      out.write(" \t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<div align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"checkArea\">닉네임검색</span>&nbsp;&nbsp;</span> \r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"nickcheck\" id=\"nickcheck\" size=\"12\" len=\"4-12\" maxlength=\"12\" class=\"chk_input\" />&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" value=\"검색\" name=\"chkbutton\" id=\"chkbutton\" onclick=\"return nickchk()\" /><br> \r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"checkArea_edit\"><br>* 한글/영문대소문자로 시작해서 숫자조합 4자~12자 입력</span>\r\n");
      out.write("\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t</div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\" height=\"3\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td height=\"2\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");

	} else {

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script language=\"JavaScript\">\r\n");
      out.write("\tfunction id_close(id) {\r\n");
      out.write("\t\topener.document.f.mjjang_id.value = id;\r\n");
      out.write("\r\n");
      out.write("\t\tself.close();\r\n");
      out.write(" \r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body leftmargin=\"0\" topmargin=\"0\">\r\n");
      out.write("\t<table width=\"280\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=3>\r\n");
      out.write("\t\t\t<img src=\"images/Check_img01.gif\" width=\"414\" height=\"41\" border=\"0\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=3 ><img src=\"images/Check_img02.gif\"\r\n");
      out.write("\t\t\t\twidth=\"88\" height=\"15\" border=\"0\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td height=\"80\" colspan=\"3\" align=\"center\">입력하신\r\n");
      out.write("\t\t\t\t<b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nick}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</b>는 사용하실 수 있는 닉네임입니다.\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr height=\"30\">\r\n");
      out.write("\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"닫기\" onclick=\"id_close('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nick}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("');\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"3\" height=\"3\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td height=\"2\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");

	}

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

package org.apache.jsp.jsp.info;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import logic.BbsBean;
import logic.CommentBean;
import java.util.*;

public final class info_005fps_005fcont_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");

  List comList=(List)request.getAttribute("comlist");
  String nickname = (String)session.getAttribute("nickname");
  String grade = (String)session.getAttribute("userstate");

  int listcount=((Integer)request.getAttribute("listcount")).intValue();

  CommentBean c = (CommentBean) request.getAttribute("comdata");
  BbsBean b = (BbsBean) request.getAttribute("bbsdata");
  if (c != null && c.getCom() != null) {
	String com_cont = c.getCom().replace("\n", "<br>");
  }

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>PS의 게임</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("</script>\r\n");
      out.write("<script src=\"Scripts/AC_RunActiveContent.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("function edit(){\r\n");
      out.write("\tif ($.trim($(\"#pwd\").val()) == \"\") {\r\n");
      out.write("\t\talert(\"비밀번호를 입력하세요\");\r\n");
      out.write("\t\t$(\"#pwd\").val(\"\").focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\t$('#fed').attr('action','");
      out.print(request.getContextPath() );
      out.write("/info_ps_edit.info').submit();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function del(){\r\n");
      out.write("\tif ($.trim($(\"#pwd\").val()) == \"\") {\r\n");
      out.write("\t\talert(\"비밀번호를 입력하세요\");\r\n");
      out.write("\t\t$(\"#pwd\").val(\"\").focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\t$('#fed').attr('action','");
      out.print(request.getContextPath() );
      out.write("/info_ps_del.info').submit();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function recom(){\r\n");
      out.write("\t$('#fed').attr('action','");
      out.print(request.getContextPath() );
      out.write("/info_ps_recom.info').submit();\r\n");
      out.write("\treturn false;\r\n");
      out.write("}\r\n");
      out.write("function list(){\r\n");
      out.write("\t$('#fed').attr('action','");
      out.print(request.getContextPath() );
      out.write("/info_ps_list.info').submit();\r\n");
      out.write("\treturn false;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function check() {\r\n");
      out.write("\t\r\n");
      out.write("\tif ($.trim($(\"#com\").val()) == \"\") {\r\n");
      out.write("\t\talert(\"댓글을 입력하세요\");\r\n");
      out.write("\t\t$(\"#com\").val(\"\").focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\t$('#f').attr('action','");
      out.print(request.getContextPath() );
      out.write("/info_ps_com.info').submit();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
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
      out.write(".serch_input {width:140px; height:18px; border:1px solid #ccc;}\r\n");
      out.write(".serch_board {width:200px; height:18px; border:1px solid #ccc;}\r\n");
      out.write("\r\n");
      out.write("/* 게시판 영역 css */\r\n");
      out.write("#info_cont{\r\n");
      out.write("\tmagin-top:auto;\r\n");
      out.write("}\r\n");
      out.write(".cont_title {\r\n");
      out.write("\tcolor:#353535; font-family: \"돋움체\"; font-size: 13px; border-bottom: 1px solid #e5e5e5;\r\n");
      out.write("\tborder-top: 1px solid #e5e5e5; background-color: ivory; height:25px;\r\n");
      out.write("}\r\n");
      out.write(".cont_title02 {\r\n");
      out.write("\tcolor:#8C8C8C; font-family: \"돋움체\"; font-size: 12px; border-bottom: 1px solid #e5e5e5;\r\n");
      out.write("\tbackground-color: ivory; height:25px;\r\n");
      out.write("}\r\n");
      out.write(".cont_title03 {\r\n");
      out.write("\tcolor:#8C8C8C; font-family: \"돋움체\"; font-size: 12px; border-bottom: 1px solid #e5e5e5;\r\n");
      out.write("\tborder-top: 1px solid #e5e5e5; background-color: ivory; height:25px;\r\n");
      out.write("}\r\n");
      out.write(".cont_title04 {\r\n");
      out.write("\tcolor:#8C8C8C; font-family: \"돋움체\"; font-size: 12px; border-bottom: 1px solid #e5e5e5;\r\n");
      out.write("\tborder-top: 1px solid #e5e5e5; background-color: ivory; height:40px;\r\n");
      out.write("}\r\n");
      out.write(".cont_view {\r\n");
      out.write("\tcolor:#8C8C8C; font-family: \"돋움체\"; font-size: 12px; \r\n");
      out.write("}\r\n");
      out.write(".join_input {\r\n");
      out.write("\tborder:1px solid #dedede;\tborder-radius: 3px;\tpadding: 3px;\r\n");
      out.write("}\r\n");
      out.write(".re_input {\r\n");
      out.write("\tborder:1px solid #D5D5D5;\tborder-radius: 3px;\tpadding: 3px;\r\n");
      out.write("}\r\n");
      out.write(".rep_back {\r\n");
      out.write("\tbackground-color: ivory; padding:10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".join_input:hover {\r\n");
      out.write("\tbackground-color: #eeeeee;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* 댓글 영역 css */\r\n");
      out.write(".re_cont01 {\r\n");
      out.write("\tcolor:#353535; font-family: \"돋움체\"; font-size: 13px; border-bottom: 1px solid #e5e5e5; height:50px;\r\n");
      out.write("}\r\n");
      out.write(".re_cont02 {\r\n");
      out.write("\tcolor:#8C8C8C; font-family: \"돋움체\"; font-size: 12px; border-bottom: 1px solid #e5e5e5; height:50px;\r\n");
      out.write("}\r\n");
      out.write(".re_cont03 {\r\n");
      out.write("\tcolor:#8C8C8C; font-family: \"돋움체\"; font-size: 12px; height:50px;\r\n");
      out.write("}\r\n");
      out.write(".rep_span{\r\n");
      out.write("\tcolor:#8C8C8C; font-family: \"돋움체\"; font-size: 11px; letter-spacing:-1px;\r\n");
      out.write("}\r\n");
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
      out.write("        <td><table width=\"900\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"1000\" height=\"100\"><script type=\"text/javascript\">\r\n");
      out.write("AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0','width','700','height','100','src','");
      out.print(request.getContextPath());
      out.write("/media/navi/main_navi','quality','high','pluginspage','http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash','movie','");
      out.print(request.getContextPath());
      out.write("/media/navi/main_navi' ); //end AC code\r\n");
      out.write("</script><noscript><object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0\" width=\"700\" height=\"100\">\r\n");
      out.write("              <param name=\"movie\" value=\"");
      out.print(request.getContextPath());
      out.write("/media/navi/main_navi.swf\" />\r\n");
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
      out.write("/images/sub01_01/01_sub_01_05.png\" width=\"250\" height=\"200\" /></td>\r\n");
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
      out.write("            \r\n");
      out.write("  <!-- 댓글 영역 -->\r\n");
      out.write("\r\n");
      out.write("   <td width=\"600\" height=\"430\">\r\n");
      out.write("   <div id=\"info_cont\">\r\n");
      out.write("   <form action=\"get\" id=\"fed\" name=\"fed\" >\r\n");
      out.write("     <input type=\"hidden\" name=\"no\" value=\"");
      out.print(b.getNo());
      out.write("\">\r\n");
      out.write("   <table width=\"500\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("            <tr>\r\n");
      out.write("\t\t\t<td width=\"20%\" class=\"cont_title03\">제목</td>\r\n");
      out.write("\t\t\t<td width=\"80%\" colspan=\"5\" class=\"cont_title\">");
      out.print(b.getTitle());
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"20%\" class=\"cont_title02\">작성자</td>\r\n");
      out.write("\t\t\t<td width=\"10%\" class=\"cont_title02\">");
      out.print(b.getNickname());
      out.write("</td>\r\n");
      out.write("\t\t\t<td class=\"cont_title02\">등록일</td>\r\n");
      out.write("\t\t\t<td class=\"cont_title02\">");
      out.print(b.getRegdate().substring(0,10));
      out.write("</td>\r\n");
      out.write("\t\t\t<td class=\"cont_title02\">조회수</td>\r\n");
      out.write("\t\t\t<td class=\"cont_title02\">");
      out.print(b.getRead_count());
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"cont_title02\">파일</td>\r\n");
      out.write("\t\t\t<td class=\"cont_title02\">\r\n");
      out.write("\t\t\t");
 if(b.getSub_file1() != null) { 
      out.write("\r\n");
      out.write("\t\t\t<a href=\"/GameInfo/infopsupload");
      out.print(b.getSub_file1());
      out.write("\">첨부파일1</a></td>\r\n");
      out.write("\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t<td class=\"cont_title02\">\r\n");
      out.write("\t\t\t");
 if(b.getSub_file2() != null) { 
      out.write("\r\n");
      out.write("\t\t\t<a href=\"/GameInfo/infopsupload");
      out.print(b.getSub_file2());
      out.write("\">첨부파일2</a></td>\r\n");
      out.write("\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t<td class=\"cont_title02\"></td>\r\n");
      out.write("\t\t\t<td class=\"cont_title02\">추천</td>\r\n");
      out.write("\t\t\t<td class=\"cont_title02\">");
      out.print(b.getRecom());
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"6\" class=\"cont_view\" height=\"200\">");
      out.print(b.getCont());
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"cont_title04\">비밀번호</td>\r\n");
      out.write("\t\t\t<td class=\"cont_title04\">\r\n");
      out.write("\t\t\t<input type=\"password\" id=\"pwd\" name=\"pwd\" maxlength=\"5\" class=\"join_input\" />\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td class=\"cont_title04\"></td>\r\n");
      out.write("\t\t\t<td class=\"cont_title04\" ></td>\r\n");
      out.write("\t\t\t<td class=\"cont_title04\" ></td>\r\n");
      out.write("\t\t\t<td class=\"cont_title04\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"30\"></tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"6\" align=\"center\">\r\n");
      out.write("\t\t\t<input type=\"image\"  id=\"cont_edit\" name=\"cont_edit\" \r\n");
      out.write("\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/images/images/4.png\"\r\n");
      out.write("\t\t\talign=\"absmiddle\" onclick=\"return edit();\" /> &nbsp;\r\n");
      out.write("\t\t\t<input type=\"image\"  id=\"cont_del\" name=\"cont_del\" \r\n");
      out.write("\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/images/images/5.png\"\r\n");
      out.write("\t\t\talign=\"absmiddle\" onclick=\"return del();\" /> &nbsp;\r\n");
      out.write("\t\t\t<input type=\"image\"  id=\"cont_check\" name=\"cont_check\" \r\n");
      out.write("\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/images/images/1.png\"\r\n");
      out.write("\t\t\talign=\"absmiddle\" onclick=\"return recom();\" /> &nbsp;\r\n");
      out.write("\t\t\t<input type=\"image\"  id=\"cont_list\" name=\"cont_list\" \r\n");
      out.write("\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/images/images/3.png\"\r\n");
      out.write("\t\t\talign=\"absmiddle\" onclick=\"return list();\"/>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"30\"></tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("     <div align=\"center\" class=\"body\">\r\n");
      out.write("     <form method=\"post\" id=\"f\" name=\"f\" >\r\n");
      out.write("     <input type=\"hidden\" name=\"no\" value=\"");
      out.print(b.getNo());
      out.write("\">\r\n");
      out.write("     <table width=\"500\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" > \r\n");
      out.write("          <tr>\r\n");
      out.write("               <td colspan=\"3\" class=\"rep_back\">\r\n");
      out.write("                <textarea wrap=\"hard\" cols=\"20\" name=\"com\" id=\"com\" class=\"re_input\" style=\"overflow:hidden; width: 400px; height: 100%;\"></textarea></td>\r\n");
      out.write("                <td class=\"rep_back\">\r\n");
      out.write("                <input type=\"image\"  id=\"comsubmit\" name=\"comsubmit\" \r\n");
      out.write("\t\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/images/images/btn_reply.gif\" border=\"0\"\r\n");
      out.write("\t\t\t\talign=\"absmiddle\" onclick=\"return check();\" />\r\n");
      out.write("              </td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          \t\t  <tr>\r\n");
      out.write("\t\t  <td colspan=\"4\" class=\"rep_back\">\r\n");
      out.write("\t\t  <span class=\"rep_span\">* 짧은 댓글은 회원들의 활발한 의견교환의 장입니다. 서로에 대한 배려는 네티켓의 기본입니다.</span>\r\n");
      out.write("\t\t  </td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("          \r\n");
      out.write("\t\t  ");
int v_no = listcount;
            for(int i=0;i<comList.size();i++){
	        CommentBean com=(CommentBean)comList.get(i);//컬렉션 요소값을 가져온다.
   		  
      out.write("\r\n");
      out.write("    <tr>\r\n");
      out.write("    <td align=\"center\" class=\"re_cont01\">");
      out.print(com.getNickname());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\" class=\"re_cont02\">");
      out.print(com.getCom());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\" class=\"re_cont02\">");
      out.print(com.getRegdate().substring(0,10));
      out.write("</td>\r\n");

	if (nickname!=null){
    	if(nickname.equals(com.getNickname()) || grade.equals("admin")){ 

      out.write("\r\n");
      out.write("  \t    <td align=\"center\" class=\"re_cont03\">\r\n");
      out.write("    <input type=\"image\"  id=\"cont_del\" name=\"cont_del\" \r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/images/images/5.png\"\r\n");
      out.write("\talign=\"absmiddle\" onclick=\"location='");
      out.print(request.getContextPath());
      out.write("/info_ps_comdel.info?bbsno=");
      out.print(b.getNo());
      out.write("&comno=");
      out.print(com.getNo());
      out.write("'; return false;\" />\r\n");
      out.write("\t\r\n");
      out.write("    </td>\r\n");
      out.write("    \r\n");
      out.write("    \t");
 } 
      out.write("\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("   ");
 v_no--; //1씩 감소

   } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr height=\"30\"></tr>\r\n");
      out.write("\r\n");
      out.write("     </table>\r\n");
      out.write("     </form>\r\n");
      out.write("  </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  </td>\r\n");
      out.write(" \r\n");
      out.write(" <!-- 댓글 영역 끝 -->\r\n");
      out.write("          \r\n");
      out.write("          </tr>\r\n");
      out.write("        </table></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"900\" height=\"70\">\r\n");
      out.write("        <table width=\"900\" height=\"70\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#3e3f3e\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"750\" height=\"70\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/images/index/main_09.jpg\" width=\"750\" height=\"70\" border=\"0\" /></td>\r\n");
      out.write("            <td width=\"150\" height=\"70\" align=\"center\" valign=\"middle\" bgcolor=\"#3e3f3e\">\r\n");
      out.write("            \t\r\n");
      out.write("              \t<!-- 패밀리사이트 영역 -->\r\n");
      out.write("          \t    <td width=\"150\" height=\"70\">\r\n");
      out.write("            \t<select id=\"fmsite\" name=\"fmsite\" class=\"jumpmenu\" onchange=\"window.open(value,'_blank');\" >\r\n");
      out.write("                \t<option selected >= 선택하세요 =</option>\r\n");
      out.write("                    <option value=\"http://www.playstation.co.kr/main.sce\">플레이스테이션</option>\r\n");
      out.write("                    <option value=\"http://www.xbox.com/ko-KR/\">X-BOX</option>\r\n");
      out.write("                    <option value=\"http://betagam.danawa.com/\">PC</option>\r\n");
      out.write("                </select>\r\n");
      out.write("                </td>\r\n");
      out.write("                <!-- 패밀리사이트 영역 -->          \r\n");
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

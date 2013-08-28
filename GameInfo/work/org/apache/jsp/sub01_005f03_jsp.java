package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import logic.*;

public final class sub01_005f03_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 
  List bbsList=(List)request.getAttribute("bbslist");
  int listcount=((Integer)request.getAttribute("listcount")).intValue();
  //intValue()메서드에 의해서 정수형 숫자로 바꾼다.
  int nowpage=((Integer)request.getAttribute("page")).intValue();
  //현재페이지 번호
  int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
  int startpage=((Integer)request.getAttribute("startpage")).intValue();
  //시작페이지 번호
  int endpage=((Integer)request.getAttribute("endpage")).intValue();
  int limit=((Integer)request.getAttribute("limit")).intValue();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>PC 게임</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
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
      out.write("#list_wrap{\r\n");
      out.write("\twidth:600px; height:510px; margin-left:auto; margin-right:auto;\r\n");
      out.write("\tpadding:20px; margin-top:auto;\r\n");
      out.write("}\r\n");
      out.write("#list_wrap .list_title{\r\n");
      out.write("\twidth:600px; height:190px; margin-left:auto; margin-right:auto; margin-top:0;\r\n");
      out.write("}\r\n");
      out.write("#list_paging{\r\n");
      out.write("\twidth:100%; text-align:center; padding:0;\r\n");
      out.write("}\r\n");
      out.write("#list_menu{\r\n");
      out.write("\twidth:100%; margin:0 0 0 540px ; padding:0;\r\n");
      out.write("}\r\n");
      out.write(".board_title {\r\n");
      out.write("\tcolor:#4C4C4C; font-family: \"굴림체\"; font-size: 13px; border-bottom: 1px solid #e5e5e5;\r\n");
      out.write("\tborder-top: 1px solid #e5e5e5; background-color: ivory;\r\n");
      out.write("}\r\n");
      out.write(".board_cont {color:#5D5D5D; font-family: \"굴림체\"; text-decoration:none; font-size: 12px; padding:6px; border-bottom: 1px solid #e5e5e5;}\r\n");
      out.write(".board_cont01 {color:#5D5D5D; font-family: \"굴림체\"; text-decoration:none; font-size: 12px; padding:5px; }\r\n");
      out.write(".board_cont01:hover {\r\n");
      out.write("\tcolor:#5D5D5D; font-family: \"굴림체\"; text-decoration:underline; \r\n");
      out.write("\tfont-size: 12px; padding:5px; border-bottom: 1px solid #e5e5e5;\r\n");
      out.write("}\r\n");
      out.write("#list_paging .board_paging{\r\n");
      out.write("\tcolor:#999999; font-family: \"굴림체\"; text-decoration:none; \r\n");
      out.write("\tfont-size: 12px; padding:3px;\r\n");
      out.write("}\r\n");
      out.write("#list_find {\r\n");
      out.write("\twidth:100%; margin:0 0 0 140px; padding:0;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script src=\"Scripts/AC_RunActiveContent.js\" type=\"text/javascript\"></script>\r\n");
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
      out.write("            <td width=\"700\" height=\"100\"><script type=\"text/javascript\">\r\n");
      out.write("AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0','width','700','height','100','src','media/navi/main_navi','quality','high','pluginspage','http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash','movie','media/navi/main_navi' ); //end AC code\r\n");
      out.write("</script><noscript><object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0\" width=\"700\" height=\"100\">\r\n");
      out.write("              <param name=\"movie\" value=\"media/navi/main_navi.swf\" />\r\n");
      out.write("              <param name=\"quality\" value=\"high\" />\r\n");
      out.write("              <embed src=\"media/navi/main_navi.swf\" quality=\"high\" pluginspage=\"http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash\" type=\"application/x-shockwave-flash\" width=\"700\" height=\"100\"></embed>\r\n");
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
      out.write("                <td width=\"250\" height=\"200\"><img src=\"images/sub01_03/01_sub_03_05.png\" width=\"250\" height=\"200\" /></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"250\" height=\"430\"><script type=\"text/javascript\">\r\n");
      out.write("AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0','width','250','height','430','src','media/navi/sub01_navi','quality','high','pluginspage','http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash','movie','media/navi/sub01_navi' ); //end AC code\r\n");
      out.write("</script><noscript><object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0\" width=\"250\" height=\"430\">\r\n");
      out.write("                  <param name=\"movie\" value=\"media/navi/sub01_navi.swf\" />\r\n");
      out.write("                  <param name=\"quality\" value=\"high\" />\r\n");
      out.write("                  <embed src=\"media/navi/sub01_navi.swf\" quality=\"high\" pluginspage=\"http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash\" type=\"application/x-shockwave-flash\" width=\"250\" height=\"430\"></embed>\r\n");
      out.write("                </object></noscript></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table></td>\r\n");
      out.write("            <td width=\"50\" height=\"630\" bgcolor=\"#FFFFFF\"></td>\r\n");
      out.write("            \r\n");
      out.write("            <!-- 게시판 영역 -->\r\n");
      out.write("            <td width=\"600\" height=\"630\">\r\n");
      out.write(" <div id=\"list_wrap\">\r\n");
      out.write("  <h2 class=\"list_title\">\r\n");
      out.write("  <img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/images/board_top.jpg\" border=\"0\">\r\n");
      out.write("  </h2>\r\n");
      out.write("    \r\n");
      out.write("  <table width=\"600\">\r\n");
      out.write("   <tr height=\"30\">\r\n");
      out.write("    <th width=\"8%\" class=\"board_title\">번호</th> \r\n");
      out.write("    <th width=\"35%\" class=\"board_title\">제목</th>\r\n");
      out.write("    <th width=\"12%\" class=\"board_title\">작성자</th> \r\n");
      out.write("    <th width=\"17%\" class=\"board_title\">날짜</th>\r\n");
      out.write("    <th width=\"12%\" class=\"board_title\">조회수</th>   \r\n");
      out.write("   </tr>\r\n");
      out.write("   \r\n");
      out.write("   ");

    int v_no = listcount-(nowpage-1)*limit;
    int cnt = bbsList.size();
    for(int i=0;i<bbsList.size();i++){
	   BbsBean b=(BbsBean)bbsList.get(i);//컬렉션 요소값을 가져온다.
   
      out.write("\r\n");
      out.write("   <tr \r\n");
      out.write("   onmouseover=\"this.style.backgroundColor='#F8F8F8'\"\r\n");
      out.write("   onmouseout=\"this.style.backgroundColor=''\" class=\"board_cont\">\r\n");
      out.write("    <td align=\"center\" class=\"board_cont\">");
      out.print(cnt--);
      out.write("</td>\r\n");
      out.write("    <td class=\"board_cont\">\r\n");
      out.write("         <a class=\"board_cont01\"\r\n");
      out.write("          href=\"");
      out.print(request.getContextPath() );
      out.write("/info_pc_cont.info?no=");
      out.print(b.getNo());
      out.write("\">\r\n");
      out.write("          ");
      out.print(b.getTitle());
      out.write("\r\n");
      out.write("         </a>\r\n");
      out.write("    </td>\r\n");
      out.write("    <td align=\"center\" class=\"board_cont\">");
      out.print(b.getNickname());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\" class=\"board_cont\">");
      out.print(b.getRegdate().substring(0,10));
      out.write("</td>\r\n");
      out.write("    <td align=\"center\" class=\"board_cont\">");
      out.print(b.getRead_count());
      out.write("</td>\r\n");
      out.write("    <!-- 0이상 10미만 사이의 문자 반환. 즉 시,분등은 빼고 년월일만 출력 -->\r\n");
      out.write("   ");
 v_no--; //1씩 감소
   } 
      out.write("   \r\n");
      out.write("  </table>\r\n");
      out.write(" </div>\r\n");
      out.write(" \r\n");
      out.write("    <!-- 페이징 구현 부분 -->\r\n");
      out.write("    <div id=\"list_paging\">\r\n");
      out.write("    ");
 if(startpage != 1) {
      out.write("\r\n");
      out.write("    <img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/images/btnFirstPrev.gif\" alt=\"처음페이지\" align=\"absmiddle\" border=\"0\">\r\n");
      out.write("    ");
}else{ 
      out.write("\r\n");
      out.write("    <a href=\"info_pc_list.info?page=");
      out.print(startpage);
      out.write("\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/images/btnFirstPrev.gif\" alt=\"이전페이지\" align=\"absmiddle\" border=\"0\"></a>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("    ");
 if(nowpage <=1) {
      out.write("\r\n");
      out.write("    <img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/images/btnPrev.gif\" alt=\"이전페이지\" align=\"absmiddle\" border=\"0\">\r\n");
      out.write("    ");
}else{ 
      out.write("\r\n");
      out.write("    <a href=\"info_pc_list.info?page=");
      out.print(nowpage-1);
      out.write("\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/images/btnPrev.gif\" alt=\"이전페이지\" align=\"absmiddle\" border=\"0\"></a>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    ");
 for(int a=startpage;a<=endpage;a++){
    	 if(a==nowpage){
      out.write("\r\n");
      out.write("    \t ");
out.println("<font color=#5d5d5d size=2 face=굴림체><b>" + a + "&nbsp;</b></font>"); 
      out.write("\r\n");
      out.write("    \t ");
}else{ 
      out.write("\r\n");
      out.write("    \t <a class=\"board_paging\" href=\"info_pc_list.info?page=");
      out.print(a);
      out.write('"');
      out.write('>');
      out.print(a);
      out.write("&nbsp;</a>\r\n");
      out.write("    ");
 }} 
      out.write("\r\n");
      out.write("    \t \r\n");
      out.write("    ");
 if(nowpage>=maxpage){ 
      out.write("<img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/images/btnNext.gif\" alt=\"다음페이지\" align=\"absmiddle\" border=\"0\">\r\n");
      out.write("    ");
}else{ 
      out.write("\r\n");
      out.write("    <a href=\"info_pc_list.info?page=");
      out.print(nowpage+1);
      out.write("\">\r\n");
      out.write("    <img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/images/btnNext.gif\" alt=\"다음페이지\" align=\"absmiddle\" border=\"0\"></a>");
 } 
      out.write("\r\n");
      out.write("    ");
 if(maxpage != maxpage) {
      out.write("\r\n");
      out.write("    <img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/images/btnLastNext.gif\" alt=\"마지막페이지\" align=\"absmiddle\" border=\"0\">\r\n");
      out.write("    ");
}else{ 
      out.write("\r\n");
      out.write("    <a href=\"info_pc_list.info?page=");
      out.print(maxpage);
      out.write("\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/images/btnLastNext.gif\" alt=\"이전페이지\" align=\"absmiddle\" border=\"0\"></a>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("   </div> \r\n");
      out.write("   <!-- 페이징 구현 부분 -->\r\n");
      out.write("   \r\n");
      out.write("   <!-- 검색부분 -->\r\n");
      out.write("   <script src=\"./js/jquery.js\"></script>\r\n");
      out.write("   <script>\r\n");
      out.write("     function find_check(){\r\n");
      out.write("    \t if($.trim($(\"#find_field\").val())==\"\"){\r\n");
      out.write("    \t\t alert(\"검색필드를 선택하세요!!\");\r\n");
      out.write("    \t\t $(\"#find_field\").focus();\r\n");
      out.write("    \t\t return false;\r\n");
      out.write("    \t }\r\n");
      out.write("    \t if($.trim($(\"#find_name\").val())==\"\"){\r\n");
      out.write("    \t\t alert(\"검색명을 입력하세요!!\");\r\n");
      out.write("    \t\t $(\"#find_name\").val(\"\").focus();\r\n");
      out.write("    \t\t return false;\r\n");
      out.write("    \t }\r\n");
      out.write("     }\r\n");
      out.write("   </script>\r\n");
      out.write("   \t <div id=\"list_find\">\r\n");
      out.write("     <form name=\"find\" method=\"post\" action=\"info_pc_find.info\" onsubmit=\"return find_check()\">\r\n");
      out.write("       <table>\r\n");
      out.write("       <tr height=\"10\">\r\n");
      out.write("       \t<td></td>\r\n");
      out.write("       </tr>\r\n");
      out.write("         <tr>\r\n");
      out.write("           <th>\r\n");
      out.write("           <td class=\"list_input\">\r\n");
      out.write("             <select name=\"find_field\" id=\"find_field\" >\r\n");
      out.write("               <option value=\"\">선택</option>\r\n");
      out.write("               <option value=\"nickname\">작성자</option>\r\n");
      out.write("               <option value=\"title\">제목</option>\r\n");
      out.write("               <!-- option value=\"title\" 은 테이블 필드명 -->\r\n");
      out.write("             </select>&nbsp;&nbsp;\r\n");
      out.write("             </td>\r\n");
      out.write("             <td>\r\n");
      out.write("             <input name=\"find_name\" id=\"find_name\" class=\"serch_board\" /> &nbsp;\r\n");
      out.write("             <input type=\"image\" name=\"board_serch\" id=\"board_serch\"\r\n");
      out.write("             src=\"");
      out.print(request.getContextPath() );
      out.write("/images/images/btn_search.gif\" align=\"absmiddle\"\r\n");
      out.write("\t\t     onClick=\"\" style=\"border-width: 0px;\" />\r\n");
      out.write("             </td>\r\n");
      out.write("           </th>\r\n");
      out.write("         </tr>\r\n");
      out.write("       </table>\r\n");
      out.write("     </form>\r\n");
      out.write("   </div>\r\n");
      out.write("   <!-- 검색 끝 -->\r\n");
      out.write("   <div id=\"list_menu\">\r\n");
      out.write("   \t<p/>\r\n");
      out.write("   \t\r\n");
      out.write("   ");

	String grade = (String)session.getAttribute("userstate");
   if (grade!=null){
   if(grade.equals("admin")){
   
      out.write("\r\n");
      out.write("   \r\n");
      out.write("    <a href=\"info_pc_write.info\" onfocus=\"this.blur()\"><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/images/btn_write.gif\" alt=\"쓰기\" align=\"absmiddle\" border=\"0\"></a>\r\n");
      out.write(" \r\n");
      out.write("   ");
} 
      out.write("\r\n");
      out.write("   ");
} 
      out.write("\r\n");
      out.write("   </div>\r\n");
      out.write("            </td>\r\n");
      out.write("            <!-- 게시판 영역끝 -->\r\n");
      out.write("            \r\n");
      out.write("          </tr>\r\n");
      out.write("        </table></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"900\" height=\"70\">\r\n");
      out.write("        <table width=\"900\" height=\"70\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#3e3f3e\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"750\" height=\"70\"><img src=\"images/index/main_09.jpg\" width=\"750\" height=\"70\" border=\"0\" /></td>\r\n");
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
      out.write("                <!-- 패밀리사이트 영역 -->   \r\n");
      out.write("                          \r\n");
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
      out.write("</html>\r\n");
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

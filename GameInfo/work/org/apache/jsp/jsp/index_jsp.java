package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import logic.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 
  List noticeList=(List)request.getAttribute("noticeList");
  int noticelistcount=((Integer)request.getAttribute("noticelistcount")).intValue();
  //intValue()메서드에 의해서 정수형 숫자로 바꾼다.
  
  List eventList=(List)request.getAttribute("eventList");
  int eventlistcount=((Integer)request.getAttribute("eventlistcount")).intValue();
  //intValue()메서드에 의해서 정수형 숫자로 바꾼다.
  
  List qnaList=(List)request.getAttribute("qnaList");
  int qnalistcount=((Integer)request.getAttribute("qnalistcount")).intValue();
  //intValue()메서드에 의해서 정수형 숫자로 바꾼다.

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>게임정보사이트에 오신걸 환영합니다^^</title>\r\n");
      out.write("<style type=\"text/css\"> \r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("\tmargin-left: 0px;\r\n");
      out.write("\tmargin-top: 0px;\r\n");
      out.write("\tmargin-right: 0px;\r\n");
      out.write("\tmargin-bottom: 0px;\r\n");
      out.write("}\r\n");
      out.write(".link_css {color:#999999; font-family: \"돋움체\"; text-decoration:none; font-size: 11px;}\r\n");
      out.write(".link01_css {color:#999999; font-family: \"돋움체\"; text-decoration:none; font-size: 11px; letter-spacing:-1px;}\r\n");
      out.write(".link01_css:hover {color:#000000; font-family: \"돋움체\"; text-decoration:none; font-size: 11px; letter-spacing:-1px;}\r\n");
      out.write(".link_css:hover {color:#000000; font-family: \"돋움체\"; font-size:11px;}\r\n");
      out.write(".serch_input {width:140px; height:18px; border:1px solid #ccc;}\r\n");
      out.write("\r\n");
      out.write("/* 공지사항,파워리뷰,이벤트영역 */\r\n");
      out.write(".board_title {\r\n");
      out.write("\tcolor:#4C4C4C; font-family: \"굴림체\"; font-size: 11px; border-bottom: 1px solid #e5e5e5;\r\n");
      out.write("\tborder-top: 1px solid #e5e5e5; background-color: ivory; letter-spacing:-1px;\r\n");
      out.write("}\r\n");
      out.write(".board_cont {color:#8C8C8C; font-family: \"굴림체\"; text-decoration:none; font-size: 12px; padding:5px;}\r\n");
      out.write(".board_cont01 {color:#8C8C8C; font-family: \"굴림체\"; text-decoration:none; font-size: 12px; padding:5px;}\r\n");
      out.write(".board_cont01:hover {color:#5D5D5D; font-family: \"굴림체\"; text-decoration:underline; font-size: 12px; padding:5px;}\r\n");
      out.write(".mini_top{color:#4C4C4C; font-family: \"돋움체\"; font-size: 14px; font-weight:bold;}\r\n");
      out.write("</style>\r\n");
      out.write("<script src=\"Scripts/AC_RunActiveContent.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write(" \r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"50%\"></td>\r\n");
      out.write("    <td width=\"900\" height=\"800\" bgcolor=\"#FFFFFF\"><table width=\"900\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
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
      out.write("           \r\n");
      out.write(" \t\t\t<!-- 로그인 및 검색폼 영역-->\r\n");
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
      out.write("                    \r\n");
      out.write("          </tr>\r\n");
      out.write("        </table></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"900\" height=\"450\"><script type=\"text/javascript\">\r\n");
      out.write("AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0','width','900','height','450','src','media/main/main_event','quality','high','pluginspage','http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash','movie','media/main/main_event' ); //end AC code\r\n");
      out.write("</script><noscript><object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0\" width=\"900\" height=\"450\">\r\n");
      out.write("          <param name=\"movie\" value=\"media/main/main_event.swf\" />\r\n");
      out.write("          <param name=\"quality\" value=\"high\" />\r\n");
      out.write("          <embed src=\"media/main/main_event.swf\" quality=\"high\" pluginspage=\"http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash\" type=\"application/x-shockwave-flash\" width=\"900\" height=\"450\"></embed>\r\n");
      out.write("        </object></noscript></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td><table width=\"900\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("          \r\n");
      out.write("    \t<!-- 공지사항 영역 -->\r\n");
      out.write("    \t\r\n");
      out.write("        <td width=\"300\" height=\"180\">\r\n");
      out.write("        <div id=\"mini_notice\">\r\n");
      out.write("        <table width=\"280\">\r\n");
      out.write("        <tr height=\"30\">\r\n");
      out.write("        <td colspan=\"2\" class=\"mini_top\">공지사항</td>\r\n");
      out.write("        <td><a href=\"");
      out.print(request.getContextPath());
      out.write("/notice_list.info\">\r\n");
      out.write("            <img src=\"");
      out.print(request.getContextPath());
      out.write("/images/images/btn_more.gif\" alt=\"more\" class=\"more\" border=\"0\" align=\"right\" >\r\n");
      out.write("        \t</a>\t\r\n");
      out.write("        </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr height=\"20\">\r\n");
      out.write("        <th width=\"12%\" class=\"board_title\">번호</th>\r\n");
      out.write("    \t<th colspan=\"2\" width=\"30%\" class=\"board_title\">제목</th>\r\n");
      out.write("   \t\t<th width=\"23%\" class=\"board_title\">날짜</th> \r\n");
      out.write("        </tr>\r\n");
      out.write("  \t\t");

   		int v_no = noticelistcount;
        for(int i=0;i<noticeList.size();i++){
	    BbsBean nl=(BbsBean)noticeList.get(i);//컬렉션 요소값을 가져온다.
        
      out.write("\r\n");
      out.write("        \r\n");
      out.write("       <tr \r\n");
      out.write("        onmouseover=\"this.style.backgroundColor='#F8F8F8'\"\r\n");
      out.write("        onmouseout=\"this.style.backgroundColor=''\" class=\"board_cont\">\r\n");
      out.write("        <td align=\"center\" class=\"board_cont\">");
      out.print(nl.getNo());
      out.write("</td>\r\n");
      out.write("        <td colspan=\"2\" class=\"board_cont\">\r\n");
      out.write("        <a class=\"board_cont\" href=\"");
      out.print(request.getContextPath());
      out.write("/notice_cont.info?no=");
      out.print(nl.getNo());
      out.write('"');
      out.write('>');
      out.print(nl.getTitle().substring(0,10));
      out.write("\r\n");
      out.write("         </a></td>\r\n");
      out.write("        <td>");
      out.print(nl.getRegdate().substring(0,10));
      out.write("</td>\r\n");
      out.write("        ");
 v_no--; //1씩 감소
        }
      out.write(" \r\n");
      out.write("   \t\t</table>\r\n");
      out.write("   \t\t</div> \r\n");
      out.write("        </td>\r\n");
      out.write("\r\n");
      out.write("        <!-- 공지사항 영역끝 -->\r\n");
      out.write("        \r\n");
      out.write("              \r\n");
      out.write("  \t\t<!-- 이벤트 영역 -->\r\n");
      out.write("  \t\t\r\n");
      out.write("   \t\t<td width=\"300\" height=\"180\">\r\n");
      out.write("    \t\r\n");
      out.write("    \t<div id=\"mini_notice\">\r\n");
      out.write("        <table width=\"280\">\r\n");
      out.write("        <tr height=\"30\">\r\n");
      out.write("        <td colspan=\"3\" class=\"mini_top\">이벤트</td>\r\n");
      out.write("        <td><a href=\"");
      out.print(request.getContextPath());
      out.write("/event_list.info\">\r\n");
      out.write("        \t<img src=\"");
      out.print(request.getContextPath());
      out.write("/images/images/btn_more.gif\" alt=\"more\" class=\"more\" border=\"0\" align=\"right\" >\r\n");
      out.write("        \t</a>\t\r\n");
      out.write("        </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr height=\"20\">\r\n");
      out.write("        <th width=\"7%\" class=\"board_title\">번호</th>\r\n");
      out.write("    \t<th colspan=\"2\" width=\"33%\" class=\"board_title\">제목</th>\r\n");
      out.write("   \t\t<th width=\"12%\" class=\"board_title\">날짜</th> \r\n");
      out.write("        </tr>\r\n");
      out.write("   ");

    v_no = eventlistcount;
     for(int i=0;i<eventList.size();i++){
	   BbsBean el=(BbsBean)eventList.get(i);//컬렉션 요소값을 가져온다.
   
      out.write("\r\n");
      out.write("   \t\t<tr \r\n");
      out.write("   onmouseover=\"this.style.backgroundColor='#F8F8F8'\"\r\n");
      out.write("   onmouseout=\"this.style.backgroundColor=''\" class=\"board_cont\">\r\n");
      out.write("        <td align=\"center\" class=\"board_cont\">");
      out.print(el.getNo());
      out.write("</td>\r\n");
      out.write("            <td colspan=\"2\" class=\"board_cont\">\r\n");
      out.write("        \t<a class=\"board_cont\" href=\"");
      out.print(request.getContextPath());
      out.write("/event_cont.info?no=");
      out.print(el.getNo());
      out.write('"');
      out.write('>');
      out.print(el.getTitle());
      out.write("\r\n");
      out.write("           \t</a></td>\r\n");
      out.write("\t\t   <td>");
      out.print(el.getRegdate().substring(0,10));
      out.write("</td>\r\n");
      out.write("    \t   ");
 v_no--; //1씩 감소
    	   } 
    	   
      out.write(" \r\n");
      out.write("      \t</table> \r\n");
      out.write("   \t\t</div>  \r\n");
      out.write("        </td>\r\n");
      out.write("        \r\n");
      out.write("        <!-- 이벤트 영역 끝-->\r\n");
      out.write("            \r\n");
      out.write("        <!-- QNA 영역 -->\r\n");
      out.write("        \r\n");
      out.write("        <td width=\"300\" height=\"180\">\r\n");
      out.write("        <div id=\"mini_notice\">\r\n");
      out.write("        <table width=\"280\">\r\n");
      out.write("        <tr height=\"30\">\r\n");
      out.write("        <td colspan=\"2\" class=\"mini_top\">Q&A게시판</td>\r\n");
      out.write("        <td><a href=\"");
      out.print(request.getContextPath());
      out.write("/qna_list.info\">\r\n");
      out.write("        \t<img src=\"");
      out.print(request.getContextPath());
      out.write("/images/images/btn_more.gif\" alt=\"more\" class=\"more\" border=\"0\" align=\"right\" >\r\n");
      out.write("        \t</a>\t\r\n");
      out.write("        </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr height=\"20\">\r\n");
      out.write("        <th width=\"12%\" class=\"board_title\">번호</th>\r\n");
      out.write("    \t<th colspan=\"2\" width=\"30%\" class=\"board_title\">제목</th>\r\n");
      out.write("   \t\t<th width=\"23%\" class=\"board_title\">날짜</th> \r\n");
      out.write("        </tr>\r\n");
      out.write("   ");

    v_no = qnalistcount;
    for(int i=0;i<qnaList.size();i++){
	   BbsBean ql=(BbsBean)qnaList.get(i);//컬렉션 요소값을 가져온다.
   
      out.write("\r\n");
      out.write("   \t\t<tr \r\n");
      out.write("   onmouseover=\"this.style.backgroundColor='#F8F8F8'\"\r\n");
      out.write("   onmouseout=\"this.style.backgroundColor=''\" class=\"board_cont\">\r\n");
      out.write("        <td align=\"center\" class=\"board_cont\">");
      out.print(ql.getNo());
      out.write("</td>\r\n");
      out.write(" \t\t<td colspan=\"2\" class=\"board_cont\">\r\n");
      out.write("        \t<a class=\"board_cont01\"\r\n");
      out.write("        \thref=\"");
      out.print(request.getContextPath());
      out.write("/qna_cont.info?no=");
      out.print(ql.getNo());
      out.write('"');
      out.write('>');
      out.print(ql.getTitle());
      out.write("\r\n");
      out.write("           \t</a>\r\n");
      out.write("        </td>\r\n");
      out.write("\t\t<td>");
      out.print(ql.getRegdate().substring(0,10) );
      out.write("</td>   \r\n");
      out.write("           ");
v_no--; //1씩 감소
   }
      out.write("   \r\n");
      out.write("   \t\t</table>\r\n");
      out.write("   \t\t</div>\r\n");
      out.write("        </td>\r\n");
      out.write("        \r\n");
      out.write("        <!-- QNA 영역 끝-->\r\n");
      out.write("             \r\n");
      out.write("          </tr>\r\n");
      out.write("        </table></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("      \r\n");
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
      out.write("    </table>\r\n");
      out.write("    </td>\r\n");
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

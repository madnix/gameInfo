<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="logic.*" %>
<% 
  List findList=(List)request.getAttribute("findList");
  int listcount=((Integer)request.getAttribute("listcount")).intValue();
  //intValue()메서드에 의해서 정수형 숫자로 바꾼다.
  int nowpage=((Integer)request.getAttribute("page")).intValue();
  //현재페이지 번호
  int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
  int startpage=((Integer)request.getAttribute("startpage")).intValue();
  //시작페이지 번호
  int endpage=((Integer)request.getAttribute("endpage")).intValue();
  int limit=((Integer)request.getAttribute("limit")).intValue();
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>event의 게임</title>
<style type="text/css">

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.link_css {color:#999999; font-family: "돋움체"; text-decoration:none; font-size: 11px;}
.link_css:hover {color:#000000; font-family: "돋움체"; font-size:11px;}
.link01_css {color:#999999; font-family: "돋움체"; text-decoration:none; font-size: 11px; letter-spacing:-1px;}
.link01_css:hover {color:#000000; font-family: "돋움체"; text-decoration:none; font-size: 11px; letter-spacing:-1px;}
.serch_input {width:140px; height:18px; border:1px solid #ccc;}
.serch_board {width:200px; height:18px; border:1px solid #ccc;}

/* 게시판 영역 css */
#list_wrap{
	width:600px; height:510px; margin-left:auto; margin-right:auto;
	padding:20px; margin-top:auto;
}
#list_wrap .list_title{
	width:600px; height:190px; margin-left:auto; margin-right:auto; margin-top:0;
}
#list_paging{
	width:100%; text-align:center; padding:0;
}
#list_menu{
	width:100%; margin:0 0 0 540px ; padding:0;
}
.board_title {
	color:#4C4C4C; font-family: "굴림체"; font-size: 13px; border-bottom: 1px solid #e5e5e5;
	border-top: 1px solid #e5e5e5; background-color: ivory;
}
.board_cont {color:#5D5D5D; font-family: "굴림체"; text-decoration:none; font-size: 12px; padding:6px; border-bottom: 1px solid #e5e5e5;}
.board_cont01 {color:#5D5D5D; font-family: "굴림체"; text-decoration:none; font-size: 12px; padding:5px; }
.board_cont01:hover {
	color:#5D5D5D; font-family: "굴림체"; text-decoration:underline; 
	font-size: 12px; padding:5px; border-bottom: 1px solid #e5e5e5;
}
#list_paging .board_paging{
	color:#999999; font-family: "굴림체"; text-decoration:none; 
	font-size: 12px; padding:3px;
}
#list_find {
	width:100%; margin:0 0 0 140px; padding:0;
}
</style>
<script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<script type="text/javascript">

</script>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="50%"></td>
    <td><table width="900" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><table width="900" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="700" height="100"><script type="text/javascript">
AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0','width','700','height','100','src','media/navi/main_navi','quality','high','pluginspage','http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash','movie','media/navi/main_navi' ); //end AC code
</script><noscript><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0" width="700" height="100">
              <param name="movie" value="media/navi/main_navi.swf" />
              <param name="quality" value="high" />
              <embed src="media/navi/main_navi.swf" quality="high" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" width="700" height="100"></embed>
            </object></noscript></td>
            
			<!-- 로그인 및 검색폼 영역-->
			<td width="200" height="100">
				<table width="200" border="0" cellspacing="0" cellpadding="0">
					<tr>
					<td width="200" height="40" align="right" valign="bottom">
					<%
					if(session.getAttribute("id") == null){
					%>
					<a href="#" class="link01_css" onclick="window.open('jsp/member/mem_login.jsp','new','resizable=yes scrollbars=no width=450 height=250');return false">로그인</a>
					<%
					}
					else if(session != null && session.getAttribute("id") != null){
					%>
					<a href="<%=request.getContextPath()%>/mem_logout.info" class="link01_css" onclick="">로그아웃</a>
					<%}
					%>
					<% if(session.getAttribute("userstate")!=null&&session.getAttribute("userstate").equals("admin")){ %>
					<a href="<%=request.getContextPath() %>/mem_list.info" class="link01_css" >회원정보</a>
					<%
					 } 
					 if(session.getAttribute("userstate")==null) {
				     %>
				    <%} else {%>
				    <a href="<%=request.getContextPath() %>/mem_userinfo.info" class="link01_css" >내정보</a>
					<%}%>
					<% 
					if(session.getAttribute("id") == null){
					%>
					<a href="<%=request.getContextPath()%>/jsp/member/mem_join.jsp" target="_self" class="link01_css">회원가입</a>
					<%
					} 
					else if(session.getAttribute("userstate")!=null&&session.getAttribute("userstate").equals("0") || equals("admin")) {
				    %>
				    <%} else {%>
					<%}%>
					<a href="<%=request.getContextPath()%>/sitemap.jsp" target="_self" class="link01_css">사이트맵</a>
					</td>
					</tr>
					<tr>
					<td width="200" height="60" align="right" valign="middle">
					<input type="text" class="serch_input" /> 
					<input type="image" name="serch"
					id="serch" src="<%=request.getContextPath() %>/images/images/btn_search.gif" align="absmiddle"
					onClick="" style="border-width: 0px;" />
					</td>
					</tr>
				</table>
			</td>
			<!-- 로그인 및 검색폼 영역끝-->
            
          </tr>
        </table></td>
      </tr>
      <tr>
        <td><table width="900" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="250" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="250" height="150">
                <img src="images/sub02_02/02_sub_02_06.png" width="250" height="150" />
                </td>
              </tr>
              <tr>
                <td width="250" height="430"><script type="text/javascript">
AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0','width','250','height','430','src','media/navi/sub02_navi','quality','high','pluginspage','http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash','movie','media/navi/sub02_navi' ); //end AC code
</script><noscript><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0" width="250" height="430">
                  <param name="movie" value="media/navi/sub02_navi.swf" />
                  <param name="quality" value="high" />
                  <embed src="media/navi/sub02_navi.swf" quality="high" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" width="250" height="430"></embed>
                </object></noscript></td>
              </tr>
            </table></td>
            <td width="50" height="630" bgcolor="#FFFFFF"></td>
            
            <!-- 게시판영역 -->
             <td width="600" height="630">
 <div id="list_wrap">
      <h2 class="list_title">
  <img src="<%=request.getContextPath() %>/images/sub02_02/02_sub_02_08.png" border="0">
  </h2>
    
  <table width="600">
   <tr height="30">
    <th width="8%" class="board_title">번호</th> 
    <th width="35%" class="board_title">제목</th>
    <th width="12%" class="board_title">작성자</th> 
    <th width="17%" class="board_title">날짜</th>
    <th width="12%" class="board_title">조회수</th>   
   </tr>
   
   <%
    int v_no = listcount-(nowpage-1)*limit;
    int cnt = findList.size();
    for(int i=0;i<findList.size();i++){
	   BbsBean b=(BbsBean)findList.get(i);//컬렉션 요소값을 가져온다.
   %>
   <tr 
   onmouseover="this.style.backgroundColor='#F8F8F8'"
   onmouseout="this.style.backgroundColor=''" class="board_cont">
    <td align="center" class="board_cont"><%=cnt--%></td>
    <td class="board_cont">
         <a class="board_cont01"
          href="<%=request.getContextPath() %>/event_cont.info?no=<%=b.getNo()%>">
          <%=b.getTitle()%>
         </a>
    </td>
    <td align="center" class="board_cont"><%=b.getNickname()%></td>
    <td align="center" class="board_cont"><%=b.getRegdate().substring(0,10)%></td>
    <td align="center" class="board_cont"><%=b.getRead_count()%></td>
    <!-- 0이상 10미만 사이의 문자 반환. 즉 시,분등은 빼고 년월일만 출력 -->
   <% v_no--; //1씩 감소
   } %>   
  </table>
 </div>
 
    <!-- 페이징 구현 부분 -->
    <div id="list_paging">
    <% if(startpage != 1) {%>
    <img src="<%=request.getContextPath() %>/images/images/btnFirstPrev.gif" alt="처음페이지" align="absmiddle" border="0">
    <%}else{ %>
    <a href="event_list.info?page=<%=startpage%>"><img src="<%=request.getContextPath() %>/images/images/btnFirstPrev.gif" alt="이전페이지" align="absmiddle" border="0"></a>
    <% } %>
    <% if(nowpage <=1) {%>
    <img src="<%=request.getContextPath() %>/images/images/btnPrev.gif" alt="이전페이지" align="absmiddle" border="0">
    <%}else{ %>
    <a href="event_list.info?page=<%=nowpage-1%>"><img src="<%=request.getContextPath() %>/images/images/btnPrev.gif" alt="이전페이지" align="absmiddle" border="0"></a>
    <% } %>
    
    <% for(int a=startpage;a<=endpage;a++){
    	 if(a==nowpage){%>
    	 <%out.println("<font color=#5d5d5d size=2 face=굴림체><b>" + a + "&nbsp;</b></font>"); %>
    	 <%}else{ %>
    	 <a class="board_paging" href="event_list.info?page=<%=a%>"><%=a%>&nbsp;</a>
    <% }} %>
    	 
    <% if(nowpage>=maxpage){ %><img src="<%=request.getContextPath() %>/images/images/btnNext.gif" alt="다음페이지" align="absmiddle" border="0">
    <%}else{ %>
    <a href="event_list.info?page=<%=nowpage+1%>">
    <img src="<%=request.getContextPath() %>/images/images/btnNext.gif" alt="다음페이지" align="absmiddle" border="0"></a><% } %>
    <% if(maxpage != maxpage) {%>
    <img src="<%=request.getContextPath() %>/images/images/btnLastNext.gif" alt="마지막페이지" align="absmiddle" border="0">
    <%}else{ %>
    <a href="event_list.info?page=<%=maxpage%>"><img src="<%=request.getContextPath() %>/images/images/btnLastNext.gif" alt="이전페이지" align="absmiddle" border="0"></a>
    <% } %>    
   </div> 
   <!-- 페이징 구현 부분 -->
   
   <!-- 검색부분 -->
   <script src="./js/jquery.js"></script>
   <script>
     function find_check(){
    	 if($.trim($("#find_field").val())==""){
    		 alert("검색필드를 선택하세요!!");
    		 $("#find_field").focus();
    		 return false;
    	 }
    	 if($.trim($("#find_name").val())==""){
    		 alert("검색명을 입력하세요!!");
    		 $("#find_name").val("").focus();
    		 return false;
    	 }
     }
   </script>
   	 <div id="list_find">
     <form name="find" method="post" action="event_find.info" onsubmit="return find_check()">
       <table>
       <tr height="10">
       	<td></td>
       </tr>
         <tr>
           <th>
           <td class="list_input">
             <select name="find_field" id="find_field" >
               <option value="">선택</option>
               <option value="nickname">작성자</option>
               <option value="title">제목</option>
               <!-- option value="title" 은 테이블 필드명 -->
             </select>&nbsp;&nbsp;
             </td>
             <td>
             <input name="find_name" id="find_name" class="serch_board" /> &nbsp;
             <input type="image" name="board_serch" id="board_serch"
             src="<%=request.getContextPath() %>/images/images/btn_search.gif" align="absmiddle"
		     onClick="" style="border-width: 0px;" />
             </td>
           </th>
         </tr>
       </table>
     </form>
   </div>
   <!-- 검색 끝 -->
   
   <div id="list_menu">
   	<p/>
   <%
	String grade = (String)session.getAttribute("userstate");
   if(grade.equals("admin"))
   %>
    <a href="event_write.info" onfocus="this.blur()"><img src="<%=request.getContextPath() %>/images/images/btn_write.gif" alt="쓰기" align="absmiddle" border="0"></a>
   <%
   
   %>
   </div>
            </td>
            <!-- 게시판영역 끝-->
          
          </tr>
        </table></td>
      </tr>
      <tr>
        <td width="900" height="70">
        <table width="900" height="70" border="0" cellspacing="0" cellpadding="0" bgcolor="#3e3f3e">
          <tr>
            <td width="750" height="70"><img src="images/index/main_09.jpg" width="750" height="70" border="0" /></td>
            <td width="150" height="70" align="center" valign="middle" bgcolor="#3e3f3e">
            	
              	<!-- 패밀리사이트 영역 -->
          	    <td width="150" height="70">
            	<select id="fmsite" name="fmsite" class="jumpmenu" onchange="window.open(value,'_blank');" >
                	<option selected >= 선택하세요 =</option>
                    <option value="http://www.playstation.co.kr/main.sce">플레이스테이션</option>
                    <option value="http://www.xbox.com/ko-KR/">X-BOX</option>
                    <option value="http://betagam.danawa.com/">PC</option>
                </select>
                </td>
                <!-- 패밀리사이트 영역 -->   
                          
           </td>
          </tr>
        </table>
        </td>
      </tr>
    </table></td>
    <td width="50%"></td>
  </tr>
</table>
</body>
</html>
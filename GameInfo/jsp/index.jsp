<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="logic.*" %>
<% 
  List noticeList=(List)request.getAttribute("noticeList");
  int noticelistcount=((Integer)request.getAttribute("noticelistcount")).intValue();
  //intValue()메서드에 의해서 정수형 숫자로 바꾼다.
  
  List eventList=(List)request.getAttribute("eventList");
  int eventlistcount=((Integer)request.getAttribute("eventlistcount")).intValue();
  //intValue()메서드에 의해서 정수형 숫자로 바꾼다.
  
  List qnaList=(List)request.getAttribute("qnaList");
  int qnalistcount=((Integer)request.getAttribute("qnalistcount")).intValue();
  //intValue()메서드에 의해서 정수형 숫자로 바꾼다.
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>게임정보사이트에 오신걸 환영합니다^^</title>
<style type="text/css"> 

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.link_css {color:#999999; font-family: "돋움체"; text-decoration:none; font-size: 11px;}
.link01_css {color:#999999; font-family: "돋움체"; text-decoration:none; font-size: 11px; letter-spacing:-1px;}
.link01_css:hover {color:#000000; font-family: "돋움체"; text-decoration:none; font-size: 11px; letter-spacing:-1px;}
.link_css:hover {color:#000000; font-family: "돋움체"; font-size:11px;}
.serch_input {width:140px; height:18px; border:1px solid #ccc;}

/* 공지사항,파워리뷰,이벤트영역 */
.board_title {
	color:#4C4C4C; font-family: "굴림체"; font-size: 11px; border-bottom: 1px solid #e5e5e5;
	border-top: 1px solid #e5e5e5; background-color: ivory; letter-spacing:-1px;
}
.board_cont {color:#8C8C8C; font-family: "굴림체"; text-decoration:none; font-size: 12px; padding:5px;}
.board_cont01 {color:#8C8C8C; font-family: "굴림체"; text-decoration:none; font-size: 12px; padding:5px;}
.board_cont01:hover {color:#5D5D5D; font-family: "굴림체"; text-decoration:underline; font-size: 12px; padding:5px;}
.mini_top{color:#4C4C4C; font-family: "돋움체"; font-size: 14px; font-weight:bold;}
</style>
<script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<script type="text/javascript">
 
</script>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="50%"></td>
    <td width="900" height="800" bgcolor="#FFFFFF"><table width="900" border="0" cellspacing="0" cellpadding="0">
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
        <td width="900" height="450"><script type="text/javascript">
AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0','width','900','height','450','src','media/main/main_event','quality','high','pluginspage','http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash','movie','media/main/main_event' ); //end AC code
</script><noscript><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0" width="900" height="450">
          <param name="movie" value="media/main/main_event.swf" />
          <param name="quality" value="high" />
          <embed src="media/main/main_event.swf" quality="high" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" width="900" height="450"></embed>
        </object></noscript></td>
      </tr>
      <tr>
        <td><table width="900" border="0" cellspacing="0" cellpadding="0">
          <tr>
          
    	<!-- 공지사항 영역 -->
    	
        <td width="300" height="180">
        <div id="mini_notice">
        <table width="280">
        <tr height="30">
        <td colspan="2" class="mini_top">공지사항</td>
        <td><a href="<%=request.getContextPath()%>/notice_list.info">
            <img src="<%=request.getContextPath()%>/images/images/btn_more.gif" alt="more" class="more" border="0" align="right" >
        	</a>	
        </td>
        </tr>
        <tr height="20">
        <th width="12%" class="board_title">번호</th>
    	<th colspan="2" width="30%" class="board_title">제목</th>
   		<th width="23%" class="board_title">날짜</th> 
        </tr>
  		<%
   		int v_no = noticelistcount;
        for(int i=0;i<noticeList.size();i++){
	    BbsBean nl=(BbsBean)noticeList.get(i);//컬렉션 요소값을 가져온다.
        %>
        
       <tr 
        onmouseover="this.style.backgroundColor='#F8F8F8'"
        onmouseout="this.style.backgroundColor=''" class="board_cont">
        <td align="center" class="board_cont"><%=nl.getNo()%></td>
         <td colspan="2" class="board_cont"></td>
        <td colspan="2" class="board_cont">
        <a class="board_cont" href="<%=request.getContextPath()%>/notice_cont.info?no=<%=nl.getNo()%>"><%=nl.getTitle()%>
         </a></td>
        <td><%=nl.getRegdate().substring(0,10)%></td>
        <% v_no--; //1씩 감소
        }%> 
   		</table>
   		</div> 
        </td>

        <!-- 공지사항 영역끝 -->
        
              
  		<!-- 이벤트 영역 -->
  		
   		<td width="300" height="180">
    	
    	<div id="mini_notice">
        <table width="280">
        <tr height="30">
        <td colspan="3" class="mini_top">이벤트</td>
        <td><a href="<%=request.getContextPath()%>/event_list.info">
        	<img src="<%=request.getContextPath()%>/images/images/btn_more.gif" alt="more" class="more" border="0" align="right" >
        	</a>	
        </td>
        </tr>
        <tr height="20">
        <th width="7%" class="board_title">번호</th>
    	<th colspan="2" width="33%" class="board_title">제목</th>
   		<th width="12%" class="board_title">날짜</th> 
        </tr>
   <%
    v_no = eventlistcount;
     for(int i=0;i<eventList.size();i++){
	   BbsBean el=(BbsBean)eventList.get(i);//컬렉션 요소값을 가져온다.
   %>
   		<tr 
   onmouseover="this.style.backgroundColor='#F8F8F8'"
   onmouseout="this.style.backgroundColor=''" class="board_cont">
        <td align="center" class="board_cont"><%=el.getNo()%></td>
            <td colspan="2" class="board_cont">
        	<a class="board_cont" href="<%=request.getContextPath()%>/event_cont.info?no=<%=el.getNo()%>"><%=el.getTitle()%>
           	</a></td>
		   <td><%=el.getRegdate().substring(0,10)%></td>
    	   <% v_no--; //1씩 감소
    	   } 
    	   %> 
      	</table> 
   		</div>  
        </td>
        
        <!-- 이벤트 영역 끝-->
            
        <!-- QNA 영역 -->
        
        <td width="300" height="180">
        <div id="mini_notice">
        <table width="280">
        <tr height="30">
        <td colspan="2" class="mini_top">Q&A게시판</td>
        <td><a href="<%=request.getContextPath()%>/qna_list.info">
        	<img src="<%=request.getContextPath()%>/images/images/btn_more.gif" alt="more" class="more" border="0" align="right" >
        	</a>	
        </td>
        </tr>
        <tr height="20">
        <th width="12%" class="board_title">번호</th>
    	<th colspan="2" width="30%" class="board_title">제목</th>
   		<th width="23%" class="board_title">날짜</th> 
        </tr>
   <%
    v_no = qnalistcount;
    for(int i=0;i<qnaList.size();i++){
	   BbsBean ql=(BbsBean)qnaList.get(i);//컬렉션 요소값을 가져온다.
   %>
   		<tr 
   onmouseover="this.style.backgroundColor='#F8F8F8'"
   onmouseout="this.style.backgroundColor=''" class="board_cont">
        <td align="center" class="board_cont"><%=ql.getNo()%></td>
 		<td colspan="2" class="board_cont">
        	<a class="board_cont01"
        	href="<%=request.getContextPath()%>/qna_cont.info?no=<%=ql.getNo()%>"><%=ql.getTitle()%>
           	</a>
        </td>
		<td><%=ql.getRegdate().substring(0,10) %></td>   
           <%v_no--; //1씩 감소
   }%>   
   		</table>
   		</div>
        </td>
        
        <!-- QNA 영역 끝-->
             
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
    </table>
    </td>
    <td width="50%"></td>
  </tr>
</table>
</body>
</html>

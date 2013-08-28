<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="logic.BbsBean" %>
<%@ page import="logic.CommentBean" %>
<%@ page import="java.util.*" %>
<%
  List comList=(List)request.getAttribute("comlist");
  String nickname = (String)session.getAttribute("nickname");
  String grade = (String)session.getAttribute("userstate");

  int listcount=((Integer)request.getAttribute("listcount")).intValue();

  CommentBean c = (CommentBean) request.getAttribute("comdata");
  BbsBean b = (BbsBean) request.getAttribute("bbsdata");
  if (c != null && c.getCom() != null) {
	String com_cont = c.getCom().replace("\n", "<br>");
  }
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ps의 게임</title>
<script type="text/javascript">
</script>
<script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script>
function edit(){
	if ($.trim($("#pwd").val()) == "") {
		alert("비밀번호를 입력하세요");
		$("#pwd").val("").focus();
		return false;
	}else{
		$('#fed').attr('action','<%=request.getContextPath() %>/com_ps_edit.info').submit();
		return false;
	}
}
function del(){
	if ($.trim($("#pwd").val()) == "") {
		alert("비밀번호를 입력하세요");
		$("#pwd").val("").focus();
		return false;
	}else{
		$('#fed').attr('action','<%=request.getContextPath() %>/com_ps_del.info').submit();
		return false;
	}
}
function recom(){
	$('#fed').attr('action','<%=request.getContextPath() %>/com_ps_recom.info').submit();
	return false;
}
function list(){
	$('#fed').attr('action','<%=request.getContextPath() %>/com_ps_list.info').submit();
	return false;
}

function check() {
	
	if ($.trim($("#com").val()) == "") {
		alert("댓글을 입력하세요");
		$("#com").val("").focus();
		return false;
	}
	else{
		$('#f').attr('action','<%=request.getContextPath() %>/com_ps_com.info').submit();
		return false;
	}
}
</script>
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
#info_cont{
	magin-top:auto;
}
.cont_title {
	color:#353535; font-family: "돋움체"; font-size: 13px; border-bottom: 1px solid #e5e5e5;
	border-top: 1px solid #e5e5e5; background-color: ivory; height:25px;
}
.cont_title02 {
	color:#8C8C8C; font-family: "돋움체"; font-size: 12px; border-bottom: 1px solid #e5e5e5;
	background-color: ivory; height:25px;
}
.cont_title03 {
	color:#8C8C8C; font-family: "돋움체"; font-size: 12px; border-bottom: 1px solid #e5e5e5;
	border-top: 1px solid #e5e5e5; background-color: ivory; height:25px;
}
.cont_title04 {
	color:#8C8C8C; font-family: "돋움체"; font-size: 12px; border-bottom: 1px solid #e5e5e5;
	border-top: 1px solid #e5e5e5; background-color: ivory; height:40px;
}
.cont_view {
	color:#8C8C8C; font-family: "돋움체"; font-size: 12px; 
}
.join_input {
	border:1px solid #dedede;	border-radius: 3px;	padding: 3px;
}
.re_input {
	border:1px solid #D5D5D5;	border-radius: 3px;	padding: 3px;
}
.rep_back {
	background-color: ivory; padding:10px;
}

.join_input:hover {
	background-color: #eeeeee;
}

/* 댓글 영역 css */
.re_cont01 {
	color:#353535; font-family: "돋움체"; font-size: 13px; border-bottom: 1px solid #e5e5e5; height:50px;
}
.re_cont02 {
	color:#8C8C8C; font-family: "돋움체"; font-size: 12px; border-bottom: 1px solid #e5e5e5; height:50px;
}
.re_cont03 {
	color:#8C8C8C; font-family: "돋움체"; font-size: 12px; height:50px;
}
.rep_span{
	color:#8C8C8C; font-family: "돋움체"; font-size: 11px; letter-spacing:-1px;
}

</style>
<script src="<%=request.getContextPath()%>/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
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
            <td width="1000" height="100"><script type="text/javascript">
AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0','width','700','height','100','src','<%=request.getContextPath()%>/media/navi/main_navi','quality','high','pluginspage','http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash','movie','<%=request.getContextPath()%>/media/navi/main_navi' ); //end AC code
</script><noscript><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0" width="700" height="100">
              <param name="movie" value="<%=request.getContextPath()%>/media/navi/main_navi.swf" />
              <param name="quality" value="high" />
              <embed src="<%=request.getContextPath()%>/media/navi/main_navi.swf" quality="high" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" width="700" height="100"></embed>
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
                <td width="250" height="200">
                <img src="<%=request.getContextPath()%>/images/sub03_01/03_sub_01_05.png" width="250" height="200" />
                </td>
              </tr>
              <tr>
                <td width="250" height="430"><script type="text/javascript">
AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0','width','250','height','430','src','<%=request.getContextPath()%>/media/navi/sub03_navi','quality','high','pluginspage','http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash','movie','<%=request.getContextPath()%>/media/navi/sub03_navi' ); //end AC code
</script><noscript><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0" width="250" height="430">
                  <param name="movie" value="media/navi/sub03_navi.swf" />
                  <param name="quality" value="high" />
                  <embed src="<%=request.getContextPath()%>/media/navi/sub03_navi.swf" quality="high" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" width="250" height="430"></embed>
                </object></noscript></td>
              </tr>
            </table></td>
            <td width="50" height="630" bgcolor="#FFFFFF"></td>
            
  <!-- 댓글 영역 -->

   <td width="600" height="430">
   <div id="com_cont">
   <form action="get" id="fed" name="fed" >
     <input type="hidden" name="no" value="<%=b.getNo()%>">
   <table width="500" align="center" cellpadding="0" cellspacing="0">
            <tr>
			<td width="20%" class="cont_title03">제목</td>
			<td width="80%" colspan="5" class="cont_title"><%=b.getTitle()%></td>
			</tr>
			<tr>
			<td width="20%" class="cont_title02">작성자</td>
			<td width="10%" class="cont_title02"><%=b.getNickname()%></td>
			<td class="cont_title02">등록일</td>
			<td class="cont_title02"><%=b.getRegdate().substring(0,10)%></td>
			<td class="cont_title02">조회수</td>
			<td class="cont_title02"><%=b.getRead_count()%></td>
			</tr>
			<tr>
			<td class="cont_title02">파일</td>
			<td class="cont_title02">
			<% if(b.getSub_file1() != null) { %>
			<a href="/GameInfo/compsupload<%=b.getSub_file1()%>">첨부파일1</a></td>
			<% } else { %>
			<% } %>
			<td class="cont_title02">
			<% if(b.getSub_file2() != null) { %>
			<a href="/GameInfo/compsupload<%=b.getSub_file2()%>">첨부파일2</a></td>
			<% } else { %>
			<% } %>
			<td class="cont_title02"></td>
			<td class="cont_title02">추천</td>
			<td class="cont_title02"><%=b.getRecom()%></td>
			</tr>
			<tr>
			<td colspan="6" class="cont_view" height="200"><%=b.getCont()%></td>
			</tr>
			<tr>
			<td class="cont_title04">비밀번호</td>
			<td class="cont_title04">
			<input type="password" id="pwd" name="pwd" maxlength="5" class="join_input" />
			</td>
			<td class="cont_title04"></td>
			<td class="cont_title04" ></td>
			<td class="cont_title04" ></td>
			<td class="cont_title04"></td>
			</tr>
			<tr height="30"></tr>
			
			<tr>
			<td colspan="6" align="center">
			<input type="image"  id="cont_edit" name="cont_edit" 
			src="<%=request.getContextPath()%>/images/images/4.png"
			align="absmiddle" onclick="return edit();" /> &nbsp;
			<input type="image"  id="cont_del" name="cont_del" 
			src="<%=request.getContextPath()%>/images/images/5.png"
			align="absmiddle" onclick="return del();" /> &nbsp;
			<input type="image"  id="cont_check" name="cont_check" 
			src="<%=request.getContextPath()%>/images/images/1.png"
			align="absmiddle" onclick="return recom();" /> &nbsp;
			<input type="image"  id="cont_list" name="cont_list" 
			src="<%=request.getContextPath()%>/images/images/3.png"
			align="absmiddle" onclick="return list();"/>
<%-- 			"location='<%=request.getContextPath()%>/com_ps_list.info'" /> --%>
			</td>
			</tr>
			<tr height="30"></tr>
	</table>
	</form>
     <div align="center" class="body">
     <form method="post" id="f" name="f" >
     <input type="hidden" name="no" value="<%=b.getNo()%>">
     <table width="500" align="center" cellpadding="0" cellspacing="0" > 
          <tr>
               <td colspan="3" class="rep_back">
                <textarea wrap="hard" cols="20" name="com" id="com" class="re_input" style="overflow:hidden; width: 400px; height: 100%;"></textarea></td>
                <td class="rep_back">
                <input type="image"  id="comsubmit" name="comsubmit" 
				src="<%=request.getContextPath()%>/images/images/btn_reply.gif" border="0"
				align="absmiddle" onclick="return check();" />
              </td>
          </tr>
          
		  <tr>
		  <td colspan="4" class="rep_back">
		  <span class="rep_span">* 짧은 댓글은 회원들의 활발한 의견교환의 장입니다. 서로에 대한 배려는 네티켓의 기본입니다.</span>
		  </td>
		  </tr>
		
		  <%int v_no = listcount;
            for(int i=0;i<comList.size();i++){
	        CommentBean com=(CommentBean)comList.get(i);//컬렉션 요소값을 가져온다.
   		  %>
    <tr>
    <td align="center" class="re_cont01"><%=com.getNickname()%></td>
    <td align="center" class="re_cont02"><%=com.getCom()%></td>
    <td align="center" class="re_cont02"><%=com.getRegdate().substring(0,10)%></td>
<%
	if (nickname!=null){
    	if(nickname.equals(com.getNickname()) || grade.equals("admin")){ 
%>
  	    <td align="center" class="re_cont03">
    <input type="image"  id="cont_del" name="cont_del" 
	src="<%=request.getContextPath()%>/images/images/5.png"
	align="absmiddle" onclick="location='<%=request.getContextPath()%>/com_ps_comdel.info?bbsno=<%=b.getNo()%>&comno=<%=com.getNo()%>'; return false;" />
	
    </td>
    
    	<% } %>
    <% } %>
    

   <% v_no--; //1씩 감소

   } %>

      
    </tr>
    <tr height="30"></tr>

     </table>
     </form>
  </div>
  </div>
  </td>
 
 <!-- 댓글 영역 끝 -->
          
          </tr>
        </table></td>
      </tr>
      <tr>
        <td width="900" height="70">
        <table width="900" height="70" border="0" cellspacing="0" cellpadding="0" bgcolor="#3e3f3e">
          <tr>
            <td width="750" height="70"><img src="<%=request.getContextPath()%>/images/index/main_09.jpg" width="750" height="70" border="0" /></td>
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
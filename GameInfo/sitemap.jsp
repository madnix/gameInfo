<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>사이트의 모든 컨텐츠</title>
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
        <td width="900"><table width="900" border="0" cellspacing="0" cellpadding="0">
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
                <td width="250" height="200"><img src="images/sub04_01/04_sub_01_05.png" width="250" height="200" /></td>
              </tr>
              <tr>
                <td width="250" height="430"><img src="images/sitemap/site_map_08.png" width="250" height="430" /></td>
              </tr>
            </table></td>
            <td width="50" height="630"><img src="images/sub01_01/01_sub_01_06.png" width="50" height="630" /></td>
            <td width="600" height="630"><table width="600" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="600" height="200"><img src="images/sitemap/site_map_07.png" width="600" height="200" /></td>
              </tr>
              <tr>
                <td width="600" height="430"><img src="images/sitemap/site_map_09.png" width="600" height="430" border="0" usemap="#Map" /></td>
              </tr>
            </table></td>
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

<map name="Map" id="Map">
  <area shape="rect" coords="321,301,367,317" href="http://192.168.0.69:8282/GameInfo/sitemap.jsp" />
  <area shape="rect" coords="321,281,367,297" href="http://localhost:8282/GameInfo/jsp/member/mem_join.jsp" />
  <area shape="rect" coords="321,261,357,277" href="#" onclick="window.open('jsp/member//mem_login.jsp','new','resizable=yes scrollbars=no width=450 height=250');return false" />
  <area shape="rect" coords="114,302,152,318" href="http://192.168.0.69:8282/GameInfo/sub04_03.jsp" />
  <area shape="rect" coords="114,281,144,297" href="http://192.168.0.69:8282/GameInfo/sub04_02.jsp" />
  <area shape="rect" coords="114,261,144,277" href="http://192.168.0.69:8282/GameInfo/sub04_01.jsp" />
  <area shape="rect" coords="499,61,537,77" href="http://192.168.0.69:8282/GameInfo/sub03_02.jsp" />
  <area shape="rect" coords="499,81,561,97" href="http://192.168.0.69:8282/GameInfo/sub03_01.jsp" />
  <area shape="rect" coords="499,101,522,117" href="http://192.168.0.69:8282/GameInfo/sub03_03.jsp" />
  <area shape="rect" coords="319,81,356,97" href="http://192.168.0.69:8282/GameInfo/sub02_02.jsp" />
  <area shape="rect" coords="319,61,364,77" href="http://192.168.0.69:8282/GameInfo/sub02_01.jsp" />
  <area shape="rect" coords="114,101,137,117" href="http://192.168.0.69:8282/GameInfo/sub01_03.jsp" />
  <area shape="rect" coords="114,81,176,97" href="http://192.168.0.69:8282/GameInfo/sub01_01.jsp" />
<area shape="rect" coords="114,61,152,77" href="http://192.168.0.69:8282/GameInfo/sub01_02.jsp" />
</map>
</body>
</html>

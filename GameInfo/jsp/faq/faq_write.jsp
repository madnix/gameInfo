<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript" src="/GameInfo/modules/ckeditor/ckeditor.js">
</script>
<script type="text/javascript" src="/GameInfo/modules/ckfinder/ckfinder.js">
</script>
<script type="text/javascript" src="/GameInfo/modules/ckeditor/adapters/jquery.js">
</script> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>FAQ 글쓰기</title>
<script src="/GameInfo/js/jquery.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script>
$(document).ready(function() {
	var options = { 
	        beforeSubmit:  showRequest, 
	        success:       showResponse  
	     }; 
	 
	    $('#f').ajaxForm(options); 
    });

function showRequest(formData, jqForm, options) { 
 
    if ($.trim($("#title").val()) == "") {
		alert("제목을 입력하세요!");
		$("#title").val("").focus();
		return false;
   }
    var editorcontent = CKEDITOR.instances['cont'].getData().replace(/<[^>]*>/gi, '');
	if (!editorcontent.length){
		alert("내용을 입력하세요");
		$("#cont").val("").focus();
		return false;
	}
	  if ($.trim($("#pwd").val()) == "") {
			alert("비밀번호를 입력하세요");
			$("#pwd").val("").focus();
			return false;
	  }
    
    return true; 
   } 

	function showResponse(responseText, statusText, xhr, $form)  { 
	 
	    alert('저장 완료!');
	    location.href="<%=request.getContextPath()%>/faq_list.info";
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
        <td width="900"><table width="900" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="900" height="100"><script type="text/javascript">
AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0','width','700','height','100','src','<%=request.getContextPath()%>/media/navi/main_navi','quality','high','pluginspage','http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash','movie','<%=request.getContextPath()%>/media/navi/main_navi' ); //end AC code
</script><noscript><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0" width="700" height="100">
              <param name="movie" value="media/navi/main_navi.swf" />
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
            <td width="250"><table width="250" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="250" height="200">
                <img src="<%=request.getContextPath()%>/images/sub04_02/04_sub_02_05.png" width="250" height="200" />
                </td>
              </tr>
              <tr>
                <td width="250" height="430"><script type="text/javascript">
AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0','width','250','height','430','src','<%=request.getContextPath()%>/media/navi/sub04_navi','quality','high','pluginspage','http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash','movie','<%=request.getContextPath()%>/media/navi/sub04_navi' ); //end AC code
</script><noscript><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0" width="250" height="430">
                  <param name="movie" value="media/navi/sub04_navi.swf" />
                  <param name="quality" value="high" />
                  <embed src="<%=request.getContextPath()%>/media/navi/sub04_navi.swf" quality="high" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" width="250" height="430"></embed>
                </object></noscript></td>
              </tr>
            </table></td>
            <td width="50" height="580" bgcolor="#FFFFFF"></td>
            <td width="600"><table width="600" border="0" cellspacing="0" cellpadding="0">
              <tr>
              <td>
            
    <!-- 내용 작성 영역-->
	<form method="post" name="f" id="f"
		onsubmit="return check()" enctype="multipart/form-data">
		<table border="1" width="100%" height="100%" bordercolor="grey">
			<tr>
			    <th bordercolor="grey" width="50"><font color="grey" size="1">작성자</font></th>
				<td bordercolor="grey">
				<input name="nickname" id="nickname" size="20" maxlength="20"
				           readonly value="<%=session.getAttribute("nickname") %>" style="background-color:#BBBBBB"></td>
			</tr>
			      
			<tr>
			    <th bordercolor="grey"><font color="grey" size="1">제목</font></th>
				<td bordercolor="grey">
				<input type="text" name="title" id="title" style="width: 528px;" maxlength="100"></td>
			</tr>
			
			<tr>
			    <th bordercolor="grey"><font color="grey" size="1">내용</font></th>
				<td bordercolor="grey"><textarea name="cont" id="cont" style="width: 500px; height: 100%;"></textarea>
				  
			    <script type="text/javascript">
				    var editor = CKEDITOR.replace('cont',{width: 533, height: 200}); 
				    CKFinder.SetupCKEditor(editor, '<%=request.getContextPath()%>/modules/ckfinder/');
                 </script>
				</td> 
			</tr>
	      <tr>
	           <th bordercolor="grey"><font color="grey" size="1">첨부파일</font></th>
		       <td bordercolor="grey">
		          <input type="file" name="admin_file1" size="20">
		          &nbsp;&nbsp;&nbsp;&nbsp;
		          <input type="file" name="admin_file2" size="20">
	          </td>
          </tr>
			
			<tr>
			<th bordercolor="grey">
			<font color="grey" size="1">비밀번호</font></th>
				<td bordercolor="grey">
				<input type="password" name="pwd" id="pwd" size="21" maxlength="5"></td>
			</tr>
			
			<tr>
				<td colspan="2" bordercolor="grey">
				<input type="submit" value="완료"/>&nbsp;&nbsp; 
				<input type="reset" value="취소"/>&nbsp;&nbsp;
				<input type="button" value="목록" onclick="location='<%=request.getContextPath()%>/faq_list.info'"/>
				</td>
			</tr>
		</table>
	</form>
<!-- 내용 작성 영역 끝-->
                </td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td width="900">
        <table width="900" border="0" cellspacing="0" cellpadding="0" bgcolor="#3e3f3e">
          <tr>
            <td width="750" ><img src="<%=request.getContextPath()%>/images/index/main_09.jpg" width="750" height="70" border="0" /></td>
            <td width="150" align="center" valign="middle" bgcolor="#3e3f3e">
            	<table><tr>
              	<!-- 패밀리사이트 영역 -->
          	    <td width="150" >
            	<select id="fmsite" name="fmsite" class="jumpmenu" onchange="window.open(value,'_blank');" >
                	<option selected >= 선택하세요 =</option>
                    <option value="http://www.playstation.co.kr/main.sce">플레이스테이션</option>
                    <option value="http://www.xbox.com/ko-KR/">X-BOX</option>
                    <option value="http://betagam.danawa.com/">PC</option>
                </select>
                </td></tr></table>
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
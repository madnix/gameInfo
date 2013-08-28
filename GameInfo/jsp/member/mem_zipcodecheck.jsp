<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*" %>
<% 
	String zipcode,addr,addr2;
	String dong = (String)request.getAttribute("dong"); 
	List zipcodeList = (ArrayList)request.getAttribute("zipcodelist");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우편번호검색</title>
<script src="<%=request.getContextPath() %>/js/jquery.js"></script>
<SCRIPT LANGUAGE="JavaScript">
<!--
function selectnow() {

	var zip=document.postform.post_list.value;
	var zip1=zip.substring(0,3); // 첫번째 우편번호가 저장
	// substring(0,3)은 0이상 3미만 사이의 문자를 반환
	var zip2=zip.substring(4,7); // 4이상 7미만 사이의 문자반환
	// 두번째 우편번호가 저장
	var addr2=zip.substring(7, (zip.length));
	// 우편번호를 뺀 나머지 주소값이 저장
	opener.document.f.join_zip01.value=zip1;
	
	/* 회원가입창에 첫번째 세자리 우편번호를 입력한다. */

	opener.document.f.join_zip02.value=zip2;
	
	/* 회원가입창에 두번째 세자리 우편번호를 입력한다. */

	opener.document.f.join_addr01.value=addr2;
	
	/* 회원가입창에 나머지 주소를  입력한다. */

	window.close();

	/* 그리고 윈도우 창을 닫아준다.  */

}

function check(){
	if($.trim(jQuery("#dong").val())==""){
		alert("동을 입력해 주세요!");
		$("#dong").val("").focus();
		return false;
	}
}

//-->
</SCRIPT>
<style>
.checkArea {
	font-size: 12px;
	color: #999999;
	font-family: "돋움체";
}
.bold {
	font-size: 12px;
	font-weight: bold;
	color: #ff5a5a;
	font-family: "돋움체";
}
.chk_input {
	border: 1px solid #dedede;
	border-radius: 3px;
	padding: 3px;
}
.chk_input:hover {
	background-color: #eeeeee;
}
.notserch{
	font-size: 14px;
	color: red;
	font-family: "돋움체";
}
</style>
</head>
<body onload="postform.dong.focus();" topmargin="0" leftmargin="0">
<form method="post" action="<%=request.getContextPath() %>/mem_zipcodecheck.info" name="postform" onsubmit="return check()">
<table border="0" align="center" cellpadding="0" cellspacing="0">
 <tr> 
  <td align="center"><img src="<%=request.getContextPath() %>/images/images/zipcodechk.png"></td>
 </tr>

 <tr> 
  <td align="center">
  <p></p>
  <span class="checkArea">* 거주지의 면.동을 입력하고 <span class="bold">'찾기'</span> 버튼을 누르세요. </span>
  <p></p>
  <input type="text" name="dong" id="dong" size="20" maxlength="10" class="chk_input" />&nbsp;
  <input type="submit" value="찾기" onfocus="this.blur()" /><br>
  </td>
 </tr>

 <%if(dong != null){ %>
 <%if(zipcodeList != null && zipcodeList.size() != 0){%>
 <tr height="10"></tr>
 <tr> 
  <td height="30" align="center">
   <SELECT NAME="post_list" onchange="selectnow()">
   <!-- onchange이벤트는 자바스크립트에서 목록을 바꿀때 발생 -->
   
    <option value="">== 주소를 선택하세요 ==</option>
	<%for(int i = 0; i < zipcodeList.size(); i++) {	
		String data=(String)zipcodeList.get(i);
		StringTokenizer st = new StringTokenizer(data,",");
		// ,를 기분으로 data변수에 저장된 주소값을 분리.
		zipcode = st.nextToken(); // 첫번째는 우편번호값이 저장 (ex.745-777)
		addr = st.nextToken(); // 번지값을 뺀 주소값이 저장 (ex.서울...)
		addr2 = st.nextToken(); // 번지를 포함한 주소값이 저장
		String totaladdr = zipcode + addr; // 우편번호와번지를 뺀 주소
	%>
	<option value="<%=totaladdr%>">[<%=zipcode%>]&nbsp;<%=addr%></option>
	<%}%>
   </SELECT>
  </td>
 </tr>
 <%}else{ %>
 <tr height="10"></tr>
 <tr>
  <td height="30" align="center"><span class="notserch">＊검색 결과가 없습니다.</span></td>
 </tr>
 <%}}%>
 <tr> 
  <td colspan="3" height="3"></td>
 </tr>
</table>
</form>
</body>
</html>
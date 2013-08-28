<%@ page contentType="text/html; charset=utf-8"%>
<%
	String id = (String) request.getAttribute("id");
	if (id == null) {
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 아이디찾기</title>
<style type="text/css">
.checkArea {
	font-size: 12px;
	color: #999999;
	font-family: "돋움체";
}
.chk_input {
	border: 1px solid #dedede;
	border-radius: 3px;
	padding: 3px;
}
.checkArea_edit {
	font-size: 12px;
	color: #ff5252;
	font-family: "돋움체";
}
.chk_input:hover {
	background-color: #eeeeee;
}
</style>
<script src="<%=request.getContextPath() %>/js/jquery.js" type="text/javascript"></script>
<script language="JavaScript">

	var alogin = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";
	function checktype(s, spc) {
		var i;
		for (i = 0; i < s.length; i++) {
			if (spc.indexOf(s.substring(i, i + 1)) < 0) {
				return false;
			}
		}
		return true;
	}

	function check(form) {
		var v = form.idcheck.value;
		var s = v.substr(0, 1);

		if ($.trim($("#idcheck").val()) == "") {
			alert("이름을 입력하세요!");
			$("#idcheck").val("").focus();
			return false;
		}
	}
</script>

<script language="JavaScript">

	function id_close(id) {
		opener.document.f.join_id.value = id;
		self.close();
	}
	//js에서 opener객체는 공지창에서 본 현재 부모창을 가리킴
	//결국 member_join.jsp 회원가입창이 opener가 됨
	//self는 자신의 공지창을 가리킴

</script>
</head>
<body leftmargin="0" topmargin="0" onload='f.idcheck.focus();'>
	<form id="form1" method=post name='f' action="<%=request.getContextPath() %>/mem_findid.info" onsubmit="return check(this)">
		<table width="350" cellpadding="0" cellspacing="0">
		<tr> 
  		<td align="center"><img src="<%=request.getContextPath() %>/images/images/findid_top.png"></td>
 		</tr>
 			<tr height="40">
 			<td></td>
 			</tr>
			<tr>
				<td>
					<div align="center">
						<p>
							<span class="checkArea">이름 검색</span>&nbsp;&nbsp;</span> 
							<input type="text" name="idcheck" id="idcheck" size="20" len="4-12" maxlength="12" class="chk_input" />&nbsp;
							<input type="submit" value="검색" name="chkbutton" id="chkbutton" onclick="return idchk()" /><br> <br>
							<span class="checkArea_edit"><br>* 가입하신 회원님의 이름으로 검색해주세요.</span>
						</p>
					</div></td>
			</tr>
			<tr>
				<td colspan="3" height="3"></td>
			</tr>
			<tr>
				<td height="2"></td>
			</tr>
		</table>
	</form>
</body>
</html>

<%
	} else {
%>
<html>
<head>
<script language="JavaScript">
	function id_close(id) {
		opener.document.f.mjjang_id.value = id;

		self.close();
 
	}
</script>
</head>
<body leftmargin="0" topmargin="0">
	<table width="280" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan=3>
			<img src="images/Check_img01.gif" width="414" height="41" border="0"></td>
		</tr>
		<tr>
			<td colspan=3 ><img src="images/Check_img02.gif"
				width="88" height="15" border="0"></td>
		</tr>
		<tr>
			<td height="80" colspan="3" align="center">입력하신
				<b>${id}</b>는 사용하실 수 있는 아이디입니다.
			</td>
		</tr>
		<tr height="30">
			<td colspan="3" align="center">
			<input type="button" value="닫기" onclick="id_close('${id}');"></td>
		</tr>
		<tr>
			<td colspan="3" height="3"></td>
		</tr>
		<tr>
			<td height="2"></td>
		</tr>
	</table>
</body>
</html>
<%
	}
%>
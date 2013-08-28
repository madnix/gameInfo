<%@ page contentType="text/html; charset=utf-8"%>
<%
	String nick = (String) request.getAttribute("nick");
	if (nick == null) {
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>닉네임 중복체크</title>
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
		var v = form.nickcheck.value;
		var s = v.substr(0, 1);

		if ($.trim($("#nickcheck").val()) == "") {
			alert("닉네임을 입력하세요!");
			$("#nickcheck").val("").focus();
			return false;
		}
		if ($.trim($("#nickcheck").val()).length < 4) {
			alert("닉네임은 4자리 이상입니다.");
			$("#nickcheck").val("").focus();
			return false;
		} else if ($.trim($("#nickcheck").val()).length > 12) {
			alert("닉네임은 12자 이하입니다.")
			$("#nickcheck").val("").focus();
			return false;
		} else if (v.length == 0) {
			alert("원하시는 닉네임을 입력해 주세요!");
			$("#nickcheck").val("").focus();
			return false;
		} else if (!checktype(v, alogin)) {
			alert("영문대소문자로 시작해서 \n 숫자조합으로 입력해 주세요!");
			$("#nickcheck").val("").focus();
			return false;
		}
	}
</script>

<script language="JavaScript">

	function nickname_close(nickname) {
		opener.document.f.join_nickname.value = nickname;
		self.close();
	}
	//js에서 opener객체는 공지창에서 본 현재 부모창을 가리킴
	//결국 member_join.jsp 회원가입창이 opener가 됨
	//self는 자신의 공지창을 가리킴

</script>
</head>
<body leftmargin="0" topmargin="0" onload='f.nickcheck.focus();'>
	<form id="form1" method=post name='f' action="<%=request.getContextPath() %>/mem_nickcheck.info" onsubmit="return check(this)">
		<table width="350" cellpadding="0" cellspacing="0">
		<tr> 
  		<td align="center"><img src="<%=request.getContextPath() %>/images/images/nick_chktop.png"></td>
 		</tr>
			<tr>
				<td>
					<div align="center">
						<p>
							<span class="checkArea">닉네임검색</span>&nbsp;&nbsp;</span> 
							<input type="text" name="nickcheck" id="nickcheck" size="12" len="4-12" maxlength="12" class="chk_input" />&nbsp;
							<input type="submit" value="검색" name="chkbutton" id="chkbutton" onclick="return nickchk()" /><br> 
							<span class="checkArea_edit"><br>* 한글/영문대소문자로 시작해서 숫자조합 4자~12자 입력</span>
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
				<b>${nick}</b>는 사용하실 수 있는 닉네임입니다.
			</td>
		</tr>
		<tr height="30">
			<td colspan="3" align="center">
			<input type="button" value="닫기" onclick="id_close('${nick}');"></td>
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
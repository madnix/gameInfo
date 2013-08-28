<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>로그인페이지</title>
<script src="./js/jquery.js"></script>
<script>
 
</script>
<style>
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.checkArea{font-size:12px; color:#999999; font-family:"돋움체";}
.login_input{border:1px solid #dedede; border-radius:3px; padding:3px;}
.login_input:hover{background-color:#eeeeee;}
.login_td{font-size:12px; color:#999999; font-family:"돋움체"; }
.login_table{border:1px solid #ccc;}
.login_title{margin:0 0 0 0; align:center;}
.checkArea_edit {
	font-size: 12px;
	color: #ff5252;
	font-family: "돋움체";
	text-align:center;
}

</style>
</head>
<body leftmargin="0" topmargin="0" onload='f.idcheck.focus();'>
<div id="loginWrap">
	<tr>
	<img src="<%=request.getContextPath() %>/images/images/findpwd_top.png" alt="Member Login" align="MIDDLE" class="login_title" />
	</tr>

	<tr height="50"></tr>
	<div id="login_input">
		<form name="f" method="post" action="<%=request.getContextPath() %>/mem_findpwd.info" onsubmit="return check(this)" >
		<table width="300" border="0" cellspacing="0" cellpadding="0" align="center">
  			<tr>
   			<td width="100" class="login_td"><span class="checkArea">이름</span></td>&nbsp;
    		<td>
			<input type="text" id="nameCheck" maxlength="12" name="nameCheck" class="login_input" style="width:150px" />
			</td>
    		<td rowspan="2">&nbsp;&nbsp;
    		<input type="image" name="login_button" id="login_button" src="<%=request.getContextPath() %>/images/images/findpwd_btn.png" alt="login" align="absmiddle" onclick="" />
  			</tr>
  			<tr>
    		<td width="100" class="login_td"><span class="checkArea">아이디</span></td>&nbsp;
   			<td>
   			<input type="text" id="idCheck" maxlength="10" name="idCheck" class="login_input" style="width:150px" />
   			
   			</td>
   			
  			</tr>
  			<tr height="10">
  			</tr>
  			<tr>
  			<td colspan="3" align="center"><span class="checkArea_edit"><br>* 가입하신 회원님의 이름/아이디로 검색해주세요.</span></td>
  			</tr>
		</table>
		
		</form>
	</div>
          
</div>
</body>
</html>

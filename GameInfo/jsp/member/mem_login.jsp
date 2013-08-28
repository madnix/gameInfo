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

</style>
</head>
<body leftmargin="0" topmargin="0" onload='f.idcheck.focus();'>
<div id="loginWrap">
	<tr>
	<img src="<%=request.getContextPath() %>/images/images/login_top.png" alt="Member Login" align="MIDDLE" class="login_title" />
	</tr>

	<tr height="50"></tr>
	<div id="login_input">
		<form name="f" method="post" action="<%=request.getContextPath() %>/mem_Login.info" onsubmit="return check(this)" >
		<table width="300" border="0" cellspacing="0" cellpadding="0" align="center">
  			<tr>
   			<td width="100" class="login_td"><span class="checkArea">아이디</span></td>&nbsp;
    		<td>
			<input type="text" id="login_id" maxlength="12" name="login_id" class="login_input" style="width:150px" tabindex=1 />
			</td>
    		<td rowspan="2">&nbsp;&nbsp;
    		<input type="image" name="login_button" id="login_button" src="<%=request.getContextPath() %>/images/images/btn_login.gif" alt="login" align="absmiddle" onclick="" />
  			</tr>
  			<tr>
    		<td width="100" class="login_td"><span class="checkArea">비밀번호</span></td>&nbsp;
   			<td>
   			<input type="password" id="login_pwd" maxlength="10" name="login_pwd" class="login_input" style="width:150px" tabindex=2 />
   			</td>
  			</tr>
  			<tr height="10"></tr>
		</table>
		</form>
	</div>
		</p>
		<div id="mem_login_serch">
				<table align="center" cellpadding="0" cellspacing="0">
				<tr>
				<td><img src="<%=request.getContextPath() %>/images/images/login_serch.png" alt="이메일 혹은 비밀번호를 잊어버리셨나요??" />&nbsp;&nbsp;</td>
				<td><a href="<%=request.getContextPath()%>/jsp/member/mem_findid.jsp" ><img src="<%=request.getContextPath() %>/images/images/login_serchid.gif" align="absmiddle" border="0" alt="아이디찾기" /></a>&nbsp;&nbsp;</td>
			    <td><a href="<%=request.getContextPath()%>/jsp/member/mem_findpwd.jsp" ><img src="<%=request.getContextPath() %>/images/images/login_serchpw.gif" align="absmiddle" border="0" alt="비밀번호찾기" /></a></td>
		        </tr>	
		        </table>
		</div>
          
</div>
</body>
</html>

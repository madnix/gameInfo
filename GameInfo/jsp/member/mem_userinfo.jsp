<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>내 정보확인/수정</title>
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
.mem_join_txt {
	width: 900px;
	height: 150px;
}

.checkArea {
	font-size: 12px;
	color: #999999;
	font-family: "돋움체";
}

.checkArea_edit {
	font-size: 12px;
	color: #ff5252;
	font-family: "돋움체";
}

.join_input {
	border: 1px solid #dedede;
	border-radius: 3px;
	padding: 3px;
}

.join_input:hover {
	background-color: #eeeeee;
}

.join_th {
	background-color: #f3f3f3;
	font-size: 12px;
	color: #999999;
	font-family: "돋움체";
}
</style>
<script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript">

// 이메일
	
	function domain_list(){
	var num=f.mail_list.selectedIndex;
	if(num==-1){
		return true;
	}
	if(f.mail_list.value=="0"){
		f.email_domain.value=""
		f.email_domain.readOnly=false;
		f.email_domain.focus();
	}
	else {
		f.email_domain.value=f.mail_list.options[num].value;
		f.email_domain.readOnly=true;
	}
}
// 이메일끝 

</script>
<script type="text/javascript">

function del(){

	if ($.trim($("#join_pwd").val()) == "") {
		alert("비밀번호를 입력하세요");
		$("#join_pwd").val("").focus();
		return false;
	}
	if ($.trim($("#join_pwd2").val()) == "") {
		alert("비밀번호 확인을 입력하세요");
		$("#join_pwd2").val("").focus();
		return false;
	}
	if ($.trim($("#join_pwd").val()) != $.trim($("#join_pwd2").val())) {
		alert("비밀번호를 확인해주세요");
		$("#join_pwd").val("");
		$("#join_pwd2").val("");
		$("#join_pwd").focus();
		return false;
	}
	if(!confirm("정말로 회원탈퇴하시겠습니까?")){
		history.go(-1);
		return false;
    }else{
		$('#f').attr('action','<%=request.getContextPath()%>/mem_del.info').submit();
		alert("회원탈퇴하셨습니다.");
		}
	}


function check() {
	
	if ($.trim($("#join_name").val()) == "") {
		alert("이름을 입력하세요");
		$("#join_name").val("").focus();
		return false;
	}
	if ($.trim($("#join_pwd").val()) == "") {
		alert("비밀번호를 입력하세요");
		$("#join_pwd").val("").focus();
		return false;
	}
	if ($.trim($("#join_pwd").val()).length < 5) {
		alert("비밀번호는 5자리 이상입니다.");
		$("#join_pwd").val("").focus();
		return false;
	} else if ($.trim($("#join_pwd").val()).length > 10) {
		alert("비밀번호는 10자 이하입니다.")
		$("#join_pwd").val("").focus();
		return false;
	}
	if ($.trim($("#join_pwd2").val()) == "") {
		alert("비밀번호 확인을 입력하세요");
		$("#join_pwd2").val("").focus();
		return false;
	}
	if ($.trim($("#join_pwd").val()) != $.trim($("#join_pwd2").val())) {
		alert("비밀번호를 확인해주세요");
		$("#join_pwd").val("");
		$("#join_pwd2").val("");
		$("#join_pwd").focus();
		return false;
	}
	
	if ($.trim($("#join_nickname").val()) == "") {
		alert("닉네임을 입력하세요");
		$("#join_nickname").val("").focus();
		return false;
	}
	if ($.trim($("#join_birth").val()).length < 8) {
		alert("생년월일을 8자리로 정확히 입력해주세요!");
		$("#join_birth").val("").focus();
		return false;
	}
	if ($.trim($("#join_mail").val())=="") {
		alert("이메일을 정확히 입력해 주세요!");
		$("#join_mail").val("").focus();
		return false;
	}
	if ($.trim($("#join_maildomain").val())=="") {
		alert("이메일 도메인명을 입력해 주세요!");
		$("#join_maildomain").val("").focus();
		return false;
	}
	if ($.trim($("#join_phone01").val()) == "") {
		alert("휴대전화번호 앞자리를 입력하세요");
		$("#join_phone01").val("").focus();
		return false;
	}
	if ($.trim($("#join_phone02").val()) == "") {
		alert("휴대전화번호 가운데자리를 입력하세요");
		$("#join_phone02").val("").focus();
		return false;
	}
	if ($.trim($("#join_phone03").val()) == "") {
		alert("휴대전화번호 마지막자리를 입력하세요");
		$("#join_phone03").val("").focus();
		return false;
	}
	if ($.trim($("#join_addr01").val()) == "") {
		alert("주소를 입력하세요");
		$("#join_addr01").val("").focus();
		return false;
	}
	if ($.trim($("#join_addr02").val()) == "") {
		alert("주소를 입력하세요");
		$("#join_addr02").val("").focus();
		return false;
	}
	else{
		$('#f').attr('action','<%=request.getContextPath()%>/mem_edit.info').submit();
		}
	}
</script>
</head>

<body>
	<form name="f" method="post" id="f">
	<input type="hidden" name="id" value="${id}"/>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="50%"></td>
				<td><table width="900" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td><table width="900" border="0" cellspacing="0"
									cellpadding="0">
									<tr>
										<td width="700" height="100"><script type="text/javascript">
AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0','width','700','height','100','src','<%=request.getContextPath()%>/media/navi/main_navi','quality','high','pluginspage','http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash','movie','<%=request.getContextPath()%>/media/navi/main_navi' ); //end AC code
</script><noscript><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0" width="700" height="100">
                                          <param name="movie" value="<%=request.getContextPath()%>/../media/navi/main_navi.swf">
                                          <param name="quality" value="high">
                                          <embed src="<%=request.getContextPath()%>/../media/navi/main_navi.swf" quality="high" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" width="700" height="100"></embed>
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
							<td width="900" height="50"></td>
						</tr>
						<tr>

							<!-- 회원수정폼 영역-->
							<td width="900">

								<table width="900" border="0" cellspacing="0" cellpadding="0">
									<div id="mem_join">
										<h2 class="conTitle">
											<img
												src="<%=request.getContextPath()%>/images/images/mem_userinfo_top.png">
										</h2>
										<h2 class="conTitle">
											<img
												src="<%=request.getContextPath()%>/images/images/edit_top01.png">
										</h2>
										<div></div>
										<div class="join_form">

											<tr>
												<th width="150" class="join_th">아이디</th>
												<td><input name="join_id" type="text" id="join_id"
													value="${id}" maxlength="12" len="4-12" size="20"
													class="join_input" readonly="readonly" /> <span
													class="checkArea_edit">&nbsp; * 아이디는 수정할 수 없습니다.</span></td>
											</tr>

											<tr width="900" height="5">
												<td></td>
											</tr>

											<tr>
												<th width="150" class="join_th">이름</th>
												<td><input name="join_name" type="text" id="join_name" readonly="readonly"
													size="20" class="join_input" value="${mem_user.user_name }" /></td>
											</tr>

											<tr width="900" height="5">
												<td></td>
											</tr>

											<tr>
												<th width="150" class="join_th">비밀번호</th>
												<td><input type="password" name="join_pwd"
													id="join_pwd" class="join_input" maxlength="10" /> <span
													class="checkArea" />&nbsp; * 띄어쓰기 없는 영문 대소문자, 모든 문자, 숫자로
													5~10자</span></td>
											</tr>

											<tr width="900" height="5">
												<td></td>
											</tr>

											<tr>
												<th width="150" class="join_th">비밀번호 확인</th>
												<td><input type="password" name="join_pwd2"
													id="join_pwd2" class="join_input" maxlength="10" /> <span
													class="checkArea">&nbsp; * 비밀번호를 한번 더 입력해 주세요</span></td>
											</tr>

											<tr width="900" height="5">
												<td></td>
											</tr>

											<tr>
												<th width="150" class="join_th">닉네임</th>
												<td><input name="join_nickname" type="text"
													id="join_nickname" size="20" class="join_input"
													readonly="readonly" value="${mem_user.user_nickname }" />
													<input type="image" name="nick_check" id="nick_check"
													src="<%=request.getContextPath()%>/images/images/nick_serch.png"
													align="absmiddle"
													onClick="window.open('<%=request.getContextPath()%>/jsp/member/mem_nickcheck.jsp','new','resizable=yes scrollbars=no width=350 height=160');return false"
													style="border-width: 0px;" /> <span class="checkArea">&nbsp;*
														한글/영문/숫자로 4~12자, 대소문자 구별 안함</span></td>
											</tr>

											<tr width="900" height="5">
												<td></td>
											</tr>

											<tr>
												<th width="150" class="join_th">생년월일</th>
												<td><input name="join_birth" type="text"
													id="join_birth" size="20" maxlength="8" class="join_input"
													value="${mem_user.user_birth }" /> <span class="checkArea">&nbsp;
														* 생년월일을 - 을 제외하고 입력해주세요. ex)19861212</span></td>
											</tr>

											<tr width="900" height="5">
												<td></td>
											</tr>

											<tr>
												<th width="150" class="join_th">이메일</th>
												<td><input name="join_mail" id="join_mail" maxlength="20" class="join_input" value="${mem_user.user_mail }" /> 
													<span class="checkArea">&nbsp;@&nbsp;</span> 
													<input name="email_domain" id="email_domain" value="${mem_user.user_maildomain}" class="join_input" />&nbsp;

													<select name="mail_list" id="mail_list"	onchange="domain_list()"  >
														<option value="" selected>== 선택 ==</option>
														<option value="hanmail.net">hanmail.net</option>
														<option value="hotmail.com">hotmail.com</option>
														<option value="nate.com">nate.com</option>
														<option value="naver.com">naver.com</option>
														<option value="paran.com">paran.com</option>
														<option value="yahoo.co.kr">yahoo.co.kr</option>
														<option value='0'>직접입력</option>
												</select></td>
											</tr>

											<tr width="900" height="5">
												<td></td>
											</tr>

											<tr>
												<th width="150" class="join_th">핸드폰</th>
												<td><select name="join_phone01" id="join_phone01">
														<option value="010">010</option>
														<option value="011">011</option>
														<option value="016">016</option>
														<option value="017">017</option>
														<option value="018">018</option>
														<option value="019">019</option>
												</select> <span class="checkArea">&nbsp;-&nbsp;</span> <input
													name="join_phone02" size="6" type="text" id="join_phone02"
													class="join_input" maxlength="4"
													value="${mem_user.user_phone2 }" /> <span
													class="checkArea">&nbsp;-&nbsp;</span> <input
													name="join_phone03" size="6" type="text" id="join_phone03"
													class="join_input" maxlength="4"
													value="${mem_user.user_phone3 }" /> <span
													class="checkArea">&nbsp;* 긴급연락이 가능한 번호를 입력해 주세요</span></td>
											</tr>

											<tr width="900" height="5">
												<td></td>
											</tr>

											<tr>
												<th width="150" class="join_th">우편번호</th>
												<td><input name="join_zip01" type="text"
													id="join_zip01" maxlength="12" size="6" readonly="readonly"
													class="join_input" value="${mem_user.user_zip1 }" /> <span
													class="checkArea">&nbsp;-&nbsp;</span> <input
													name="join_zip02" type="text" id="join_zip02"
													maxlength="12" size="6" readonly="readonly"
													class="join_input" value="${mem_user.user_zip2 }" /> <input
													type="image" name="zip_check" id="zip_check"
													src="<%=request.getContextPath()%>/images/images/zip_serch.png"
													align="absmiddle"
													onClick="window.open('<%=request.getContextPath()%>/jsp/member/mem_zipcodecheck.jsp','new','resizable=yes scrollbars=no width=350 height=200');return false" /></td>
											</tr>

											<tr width="900" height="5">
												<td></td>
											</tr>

											<tr>
												<th width="150" class="join_th">주소</th>
												<td style="line-height: 190%"><input name="join_addr01"
													type="text" size="50" id="join_addr01" class="join_input"
													readonly="readonly" value="${mem_user.user_addr1 }" /><br />
													<input name="join_addr02" type="text" size="50"
													id="join_addr02" class="join_input"
													value="${mem_user.user_addr2 }" /></td>
											</tr>

											<tr width="900" height="5">
												<td></td>
											</tr>

					<tr>
					<th width="150" class="join_th">회원탈퇴여부</th>
					<td>
					<input type="image"  id="del_mem" name="del_mem" 
					src="<%=request.getContextPath()%>/images/images/user_del.png"
					align="absmiddle" onClick="return del()" /> 
					<span class="checkArea_edit">&nbsp; * 다시 한번 확인하시고 탈퇴여부를 결정해주세요.</span></td>
					</tr>

										</div>
									</div>
								</table>
								<div id="join_menu">
									<tr>
										<td width="900" height="150" align="center"><input
											type="image" name="join_ok"
											src="<%=request.getContextPath()%>/images/images/join_ok.png"
											alt="확인" onClick="return check();" id="confirm" />
											&nbsp;&nbsp;&nbsp;&nbsp; <a href="#"><img
												src="<%=request.getContextPath()%>/images/images/join_reset.png"
												alt="재작성" border="0" onClick="document.f.reset();" /></a></td>
									</tr>
								</div>

							</td>

							<!-- 회원수정폼 영역 끝 -->

						</tr>
						<tr>
							<td width="900" height="70">
								<table width="900" height="70" border="0" cellspacing="0"
									cellpadding="0" bgcolor="#3e3f3e">
									<tr>
										<td width="750" height="70"><img
											src="<%=request.getContextPath()%>/images/index/main_09.jpg"
											width="750" height="70" border="0" /></td>
										<td width="150" height="70" align="center" valign="middle"
											bgcolor="#3e3f3e">
											<!-- 패밀리사이트 영역 -->
										<td width="150" height="70"><select id="fmsite"
											name="fmsite" class="jumpmenu" 
											onchange="window.open(value,'_blank');">
												<option selected>= 선택하세요 =</option>
												<option value="http://www.playstation.co.kr/main.sce">플레이스테이션</option>
												<option value="http://www.xbox.com/ko-KR/">X-BOX</option>
												<option value="http://betagam.danawa.com/">PC</option>
										</select></td>
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
	</form>
</body>
</html>

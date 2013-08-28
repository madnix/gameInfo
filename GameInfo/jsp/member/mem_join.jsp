<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>회원가입</title>
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
		f.join_maildomain.value=""
		f.join_maildomain.readOnly=false;
		f.join_maildomain.focus();
	}
	else {
		f.join_maildomain.value=f.mail_list.options[num].value;
		f.join_maildomain.readOnly=true;
	}
}
// 이메일끝 

</script>
<script type="text/javascript">



function check() {
	
	if(document.f.chkBox.checked == false){
		alert("이용약관에 동의를 하셔야만 가입이 가능합니다."); 
		document.f.chkBox.focus();
		return false;
		}
	
	if ($.trim($("#join_id").val()) == "") {
		alert("아이디를 입력하세요");
		$("#join_id").val("").focus();
		return false;
	}
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
		alert("별명을 입력하세요");
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
		$("#email_id").val("").focus();
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
	}/*
	if ($.trim($("#join_zip01").val()) == ""|| $.trim($("#join_zip02").val())) {
		alert("우편번호를 입력하세요");
		$("#join_zip01").val("");
		$("#join_zip02").val("");
		$("#join_zip01").focus();
		return false;
	}*/
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
		$('#f').attr('action','<%=request.getContextPath() %>/mem_join.info').submit();
		return false;
	}
}
</script>
</head>

<body>
	<form name="f" method="post" id="f">
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
AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0','width','700','height','100','src','../../media/navi/main_navi','quality','high','pluginspage','http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash','movie','../../media/navi/main_navi' ); //end AC code
</script><noscript><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0" width="700" height="100">
                                          <param name="movie" value="../../media/navi/main_navi.swf">
                                          <param name="quality" value="high">
                                          <embed src="../../media/navi/main_navi.swf" quality="high" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" width="700" height="100"></embed>
									    </object></noscript></td>

			<!-- 로그인 및 검색폼 영역-->
			<td width="200" height="100">
				<table width="200" border="0" cellspacing="0" cellpadding="0">
					<tr>
					<td width="200" height="40" align="right" valign="bottom">
					<%
					if(session.getAttribute("id") == null){
					%>
					<a href="#" class="link01_css" onclick="window.open('mem_login.jsp','new','resizable=yes scrollbars=no width=450 height=250');return false">로그인</a>
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

							<!-- 회원가입폼 영역-->
							<td width="900">

								<table width="900" border="0" cellspacing="0" cellpadding="0">
									<div id="mem_join">
										<h2 class="conTitle">
											<img src="<%=request.getContextPath() %>/images/images/mem_join_top.png">
										</h2>
										<h2 class="conTitle">
											<img src="<%=request.getContextPath() %>/images/images/join_top01.png">
										</h2>
										<div>
											<textarea rows="" cols="" name="name" class="mem_join_txt">
 
게임사이트 이용약관
			 
제 1조 (목적)
이 약관은 (주)게임사이트(이하 [회사]라 함)가 운영하는 웹사이트(이하 웹사이트라 함)에서 제공하는 제품 및 인터넷 
관련 서비스(이하 합하여 [서비스]라 함)를 회원에 가입하여 이용하거나 가입 없이 이용함에 있어서 회사와 이용자의 권리, 
의무 및 책임사항을 규정함을 목적으로 합니다.
PC통신 등을 이용하는 전자거래에 대해서도 그 성질에 반하지 않는 한 이 약관을 준용 합니다.」
 
제 2조 (정의)
1. 웹사이트란 [회사]가 재화 또는 용역을 이용자에게 제공하기 위하여 컴퓨터 등 정보통신 설비를 이용하여 재화 또는 용역을
 거래할 수 있도록 설정한 가상의 영업장을 말하며 아울러 웹사이트를 운영하는 사업자의 의미로도 사용합니다.
2. [이용자]란 웹사이트에 접속하여 이 약관에 따라 웹사이트가 제공하는 서비스를 받는 회원을 말합니다.
3. [회원]이라 함은 웹사이트에 개인정보를 제공하여 회원등록을 한 자로서 웹사이트의 정보를 지속적으로 제공 받으며
 웹사이트가 제공하는 서비스를 계속적으로 이용할 수 있는 자를 말합니다.
4. [비회원]이라 함은 회원에 가입하지 않고 웹사이트가 제공하는 서비스를 이용하는 자를 말합니다.
 
제 3조 (약관의 명시와 개정)
1. 웹사이트는 이 약관의 내용과 상호, 영업소 소재지, 대표자의 성명, 사업자등록 번호, 연락처(전화, 팩스, 전자우편 주소 등)
 등을 이용자가 알 수 있도록 웹사이트의 서비스 화면에 설치하고 이용 약관은 링크를 통하여 회원이 볼 수 있도록 게시합니다.
2. 웹사이트는 약관의 규제 등에 관한 법률, 전자거래 기본법, 전자서명법, 정보 통신망 이용 촉진 등에 관한 법률, 방문 판매
 등에 관한 법률, 소비자 보호법 등 관련 법을 위배 하지 않는 범위 에서 이 약관을 개정할 수 있습니다.
3. 웹사이트가 약관을 개정할 경우에는 적용일자 및 개정사유를 명시하여 현행 약관과 함께 웹사이트 화면에 그 적용일자 전부터
 적용일자 전일까지 공지합니다.
4. 웹사이트가 약관을 개정할 경우에는 그 개정약관은 그 적용일자 이후에 체결되는 계약에만 적용되고 그 이전에 이미 체결된
 계약에 대해서는 개정전의 약관 조항이 그대로 적용됩니다. 
 다만 이미 계약을 체결한 이용자가 개정약관 조항의 적용을 받기를 원하는 뜻을 제 3항에 의한 개정약관의 공지기간 내에
 웹사이트에 송신하여 웹사이트의 동의를 받은 경우에는 개정약관 조항이 적용됩니다.
 
제 4조 (서비스의 제공 및 변경)
1. 웹사이트는 다음과 같은 업무를 수행합니다. 
1) 재화 또는 용역에 대한 정보 제공 및 구매 계약의 체결
2) 구매계약이 체결된 재화 또는 용역의 배송 
3) 기타 웹사이트가 정하는 업무 
2. 웹사이트는 재화의 품절 또는 기술적 사양의 변경 등의 경우에는 장차 체결되는 계약에 의해 제공할 재화, 용역의 내용을
 변경할 수 있습니다.이 경우에는 변경된 재화, 용역의 내용 및 제공일자를 명시하여 현재의 재화, 용역의 내용을 게시한 곳에
  그 제공일자 이전 7일부터 공지합니다.
3. 웹사이트는 회원이 서비스 이용 중 필요하다고 인정되는 다양한 정보에 대해서 전자메일이나 서신우편 등의 방법으로 
회원에게 제공할 수 있으며, 회원은 원하지 않을 경우 가입신청 메뉴와 회원정보수정 메뉴에서 정보수신거부를 할 수 있습니다.
4. 이 약관에서 정하지 아니한 사항과 이 약관의 해석에 관하여는 정부가 제정한 전자거래 소비자 보호지침 및 관계 법령 또는
 상 관례에 따릅니다.웹사이트는 회원의 메일, SMS 등의 내용에 대해 감시하지 않으며 다음의 경우에 해당 될 경우 책임지지
 않습니다. 
1) 웹사이트는 회원의 메일 및 SMS 내용을 편집하거나 감시하지 않습니다.
2) 그 내용에 대한 책임은 각 회원에게 있습니다.
3) 회원은 허가를 받지 않고서는 음란물이나 불온한 내용, 정크 메일(junk mail), 스팸 메일(spam mail) 및 타인에게 피해를
 주거나 미풍양속을 해치는 메일을 보내서는 안됩니다.
4) 전기통신사업법 제 53조와 전기통신사업법 시행령 제 16조(불온통신)에 의거, 음란물이나 불온한 내용을 전송 함으로써
 발생하는 모든 법적인 책임은 회원에게 있으며 회사는 책임지지 않습니다.
5) 본 서비스를 이용하여 타인에게 피해를 주거나 미풍양속을 해치는 행위를 하신 회원의 아이디와 메일은 보호 받을
 수 없습니다.
 
제 5조 (서비스의 중단)
웹사이트는 컴퓨터 등 정보통신설비의 보수 점검, 교체 및 고장, 통신의 두절 등의 사유가 발생한 경우에는 서비스의 제공을
 일시적으로 중단할 수 있으며, 아래와 같은 이유로 서비스를 중단시킬 수 있습니다. 
1. 이용고객의 의무를 이행하지 아니한 경우 
2. 서비스의 안정적인 운영을 방해하는 경우 
3. 정보통신 설비의 오 동작이나 정보 등의 파괴를 유발시키는 컴퓨터 바이러스 프로그램 등을 유포하는 경우 
4. 타인의 지적재산권을 침해하는 내용을 게시, 게재, 전자메일 또는 기타의 방법으로 전송하는 경우 
5. 정보통신윤리위원회의 시정요구가 있거나 불법선거운동과 관련하여 선거관리 위원회의 유권해석을 받은 경우 
6. 타인의 아이디(ID) 와 비밀번호(PASSWORD)를 사용하는 경우 
7. 웹사이트를 이용하여 얻은 정보를 회사의 사전 승낙 없이 복제 또는 유통시키거나 상업적으로 이용하는 경우 
8. 전기통신 관련법령 등에 위배되는 경우 
9. 다른 사용자의 개인정보를 수집 또는 저장하는 경우 
10. 제3자의 권리를 침해하거나 타인을 비방하는 경우 
 
제 6조 (회원가입)
1. 이용자는 웹사이트가 정한 가입 양식에 따라 회원정보를 기입한 후 이 약관에 동의한다는 의사표시를 함으로서 회원가입을
 신청합니다.
2. 웹사이트는 제 1항과 같이 회원으로 가입할 것을 신청한 이용자 중 다음 각 호에 해당하지 않는 한 회원으로 등록합니다. 
1) 가입신청자가 이 약관 제 7조 제 3항에 의하여 이전에 회원자격을 상실한 적이 있는 경우. 
다만 제 8조 제 3항에 의한 회원자격 상실 후 3년이 경과한 자로서 웹사이트의 회원 재가입 승낙을 얻은 경우에는 예외로 한다.
2) 등록내용에 허위, 기재누락, 오기가 있는 경우. 
3) 기타 회원으로 등록하는 것이 웹사이트의 기술상 현저히 지장이 있다고 판단되는 경우. 
3. 회원가입 계약의 성립시기는 웹사이트의 승낙이 회원에게 도달한 시점으로 합니다. 
4. 회원은 제 17조 제 1항에 의한 등록사항에 변경이 있는 경우 즉시 전자우편 및 기타 방법으로 웹사이트에 대하여
 그 변경사항을 알려야 합니다. 
 
제7조 (통합 아이리버 회원제)
1) 2010년 10월 14일부로 시행된 통합 아이리버 회원제 실시이후 가입한 아이리버, 아이리버뮤직 신규회원에 대해서는 별도의
 동의과정없이 아이리버뮤직과 아이리버 사이트 회원제 이용이 가능합니다. 
2) 2010년 10월 14일 이전에 가입한 아이리버 기존회원은 회원동의를 거쳐 회원제 이용이 기능하며, 
아이디 생성, 정보 이관 등을 위해 회원 정보 연동을 합니다.
 
 
제 8조 (회원 탈퇴 및 자격 상실 등)
1. 회원은 웹사이트에 언제든지 탈퇴를 요청할 수 있으며 회사는 즉시 회원 탈퇴를 처리합니다. 
2. 회원이 다음 각 호의 사유에 해당하는 경우 웹사이트는 회원자격을 제한 및 정지 시킬 수 있습니다. 
1) 가입 신청 시에 허위 내용을 등록한 경우 
2) 웹사이트를 이용하여 구입한 재화, 용역 등의 대금, 기타 웹사이트 이용에 관련하여 회원이 부담하는 채무를 기일에
 지급하지 않는 경우 
3) 다른 사람의 웹사이트 이용을 방해하거나 그 정보를 도용 하는 등 전자거래 질서를 위협하는 경우 
4) 웹사이트를 이용하여 법령과 이 약관이 금지하거나 동서양속(공공의 질서와 선량한 풍속, 법률 사상의 지도적 이념으로
 법률행위를 판단하는 기준이 되는 사회적 타당성)에 반하는 행위를 하는 경우 
3. 웹사이트가 회원 자격을 제한, 정지시킨 후 동일한 행위가 2회 이상 반복되거나 30일 이내에 그 사유가 시정되지 아니하는
 경우 웹사이트는 회원자격을 상실 시킬 수 있습니다. 
4. 웹사이트가 회원 자격을 상실시키는 경우에는 회원등록을 말소할 수 있습니다. 
이 경우 회원에게 이를 통지하고 회원 등록 말소 전에 소명할 기회를 부여합니다. 
단, 회원에게 이 통지가 도달한 날로부터 7일 이내에 전자우편 등을 통해 웹사이트에 소명해야 합니다.
 
제 9조 (회원에 대한 통지)
1. 웹사이트가 회원에 대한 통지를 하는 경우 회원이 웹사이트에 제출한 전자우편 주소로 할 수 있습니다. 
2. 웹사이트는 불특정 다수 회원에 대한 통지의 경우 1주일 이상 웹사이트 게시판에 게시함으로써 개별통지에 갈음할 수 있습니다. 
 
제 10조 (구매신청)
웹사이트의 이용자는 웹사이트상에서 이하의 방법에 의하여 구매를 신청합니다. 
1. 성명, 주소, 또는 전화번호 입력 
2. 재화 또는 용역의 선택 
3. 결제 방법의 선택 
4. 배달처 
5. 이 약관에 동의한다는 표시 (예- 마우스클릭) 
 
제 11조 (계약의 성립) 
1. 웹사이트는 제 9조와 같은 구매신청에 대하여 다음 각 호에 해당하지 않는 한 승낙합니다. 
1) 신청 내용에 허위, 기재누락, 오기가 있는 경우 
2) 미성년자가 청소년 보호법에서 금지하는 재화 및 용역을 구매하는 경우 
3) 상품 및 가격 정보 오기, 상품재고 소진 또는 상품의 시장 가격이 급격한 변동이 있는 경우 
4) 기타 구매 신청에 승낙하는 것이 웹사이트 기술상 현저히 지장이 있다고 판단 되는 경우 
2. 웹사이트의 승낙이 제 12조 제 1항의 수신 확인 통지형태로 이용자에게 도달한 시점에 계약이 성립한 것으로 봅니다. 
 
제 12조 (지급방법)
웹사이트에서 구매한 재화 또는 용역에 대한 대금 지급 방법은 다음 각 호의 하나로 할 수 있습니다.
1. 계좌 이체 
2. 신용카드 결제 
3. 온라인 무통장 입금 
4. 전자화폐에 의한 결제
5. 적립금 
6. 수령 시 대금지급 등
 
제 13조 (수신확인 통지, 구매신청 변경 및 취소) 
1. 웹사이트는 이용자의 구매신청이 있는 경우 이용자에게 수신 확인 통지를 합니다. 
2. 수신 확인 통지를 받은 이용자는 의사 표시의 불일치 등이 있는 경우에는 수신 확인 통지를 받은 후 즉시 구매신청
 변경 및 취소를 요청할 수 있습니다. 
3. 웹사이트는 배송 전 이용자의 구매신청 변경 및 취소 요청이 있는 때에는 지체 없이 그 요청에 따라 처리합니다. 
 
제 14조 (배송) 
1. 당 웹사이트에서 구입하신 제품의 배송기간은 수신확인 통지 시에 알려드립니다. 
2. 배송 비용은 제품별로 별도 표기가 없을 경우는 제품 가격에 포함합니다. 
3. 당 웹사이트의 제품 재고 상황, 원격지 배송, 공휴일에 따라 지연될 수 있으나 웹사이트의 고의 과실로 약정 배송기간을 
초과한 경우에는 그로 인한 이용자의 손해는 웹사이트가 제품 가격 
한도 내에서 배상합니다. 단, 천재지변 등 불가항력에 의한 것은 예외로 합니다. 
4. 웹사이트에서 대한민국 외의 국가에는 배송하지 않습니다. 만약 대한민국 외의 국가로 배송할 때는 별도의 공지가 제공될
 것이며, 대한민국 외의 국가에 배송할 경우 배송료가 부가됩니다. 
 
제 15조 (적립금 제도 운영)
1. 회사는 특정 상품이나 용역을 구입하거나 특정 결제 수단으로 구입하는 고객에게 적립금을 부여할 수 있습니다. 
이러한 적립금의 부여는 다음 각 호의 방법에 따르되, 그 구체적인 운영방법은 회사의 운영정책에 의합니다. 
1) 회사는 적립금 부여를 안내한 상품이나 용역의 판매가에 대해 특정한 비율만큼 적립금을 부여 
2) 회사는 제1호와는 달리 적립금 부여를 안내한 상품이나 용역에 대해 당해 판매가에 상관없이 일정한 금액을 부여 
2. 적립금은 회사의 서비스제도로서 상품 구매 시 현금가액과 동일하게 사용할 수 있으나 
(단 상품권 등 사용불가 사전고지품목 제외), 현금으로 환불되지는 않습니다. 
또한 타인에게 양도할 수 없습니다.
3. 적립금의 사용기한은 적립금 부여일로부터 2년이며, 동 기한 내 사용하지 않은 적립금은 소멸됩니다. 
단일상품의 구매로 인하여 일시에 부여된 적립금에 대해서 그 중 일부 적립금만을 사용한 경우에도 동일합니다.
4. 제2항의 적립금의 사용은 고객의 의사와 관계없이 먼저 부여된 적립금이 먼저 소멸됩니다.
 
제 16조 (환급, 반품 및 교환)
1. 웹사이트는 이용자가 구매 신청한 재화 또는 용역이 품절 등의 사유로 재화의 인도 또는 용역의 제공을 할 수 없을 때에는
 지체 없이 그 사유를 이용자에게 통지하고 계약해제 및 환급절차를 취합니다. 
2. 다음 각 호의 경우에는 웹사이트는 배송 된 재화일지라도 재화를 반품 받은 다음 영업일 이내에 이용자의 요구에 따라
 즉시 환급, 반품 및 교환 조치를 합니다. 다만 그 요구 기한은 배송 된 날로부터 20일 이내로 합니다. 
1) 배송 된 재화가 주문내용과 상이하거나 웹사이트가 제공한 정보와 상이할 경우 
2) 배송 된 재화가 파손, 손상되었거나 오염되었을 경우 
3) 재화가 광고에 표시된 배송기간보다 늦게 배송 된 경우 
4) 방문 판매 등에 관한 법률 제 18조에 의하여 광고에 표시하여야 할 사항을 표시하지 아니한 상태에서 이용자의
 청약이 이루어진 경우
3. 계약 해제 및 환급 절차 
1) 현금으로 구매하신 [회원]께서 반품요청을 고객센터(T. 1577-5557)로 하시면 상품대금을 현금으로 입금한 고객께는,
 상품제공 후일 경우에는 웹사이트에서 상품을 수거한 후 상품 수거일 기준으로 3일 내에, 상품 제공 전일 경우에는
  취소요청과 관련 증빙 서류(입금하신 분의 신분증
 사본 및 통장사본 등)를 고객센터가 접수한 날 기준으로 3일 내에 환불 조치하여 드립니다.
2) 신용카드로 구매하신 [회원]께서 반품요청을 고객센터(T. 1577-5557)로 하시면 상품 제공 후일 경우에는 웹사이트에서
 상품을 수거한 후 카드 대금 청구 취소 조치를 해드리며 상품 제공 전일 경우에는 주문을 취소하고 카드 대금 청구 취소
 조치를 해 드립니다. 
 
제 17조 (개인 정보 보호) 
1. 웹사이트는 이용자의 정보수집 시 구매 계약 이행에 필요한 최소한의 정보를 수집합니다. 
다음 사항을 필수 사항으로 하며, 그 필수 사항은 추가될 수 있습니다. 그 외 사항은 선택 사항으로 합니다. 
1) 성명 
2) 주민등록번호 (회원의 경우)
3) 주소 
4) 전화번호 
5) 희망 ID (회원의 경우)
6) 비밀번호 (회원의 경우)
7) 전자우편 주소 (E-Mail 주소)
8) 추가될 수 있는 필수의 사항 
2. 웹사이트가 이용자의 개인식별이 가능한 개인정보를 수집하는 때에는 반드시 당해 이용자의 동의를 받습니다. 
3. 제공된 개인정보는 당해 이용자의 동의 없이 목적 외의 이용이나 제 3자에게 제공 할 수 없으며 이에 대한 모든 책임은
 웹사이트가 집니다.다만, 다음의 경우에는 예외로 합니다. 
1) 배송 업무상 배송업체에게 배송에 필요한 최소한의 이용자의 정보 (성명, 주소, 전화번호)를 알려주는 경우 
2) 관계법령에 의하여 수사상의 목적으로 관계기관으로부터의 요구가 있을 경우 
3) 통계작성, 학술연구 또는 시장조사를 위하여 필요한 경우로서 특정 개인을 식별할 수 없는 형태로 제공되는 경우 
4) 기타 웹사이트가 필요하다고 인정한 경우로 회원의 동의를 얻은 경우 
4. 웹사이트가 제 2항과 제 3항에 의해 이용자의 동의를 받아야 하는 경우에는 개인 정보 관리
 책임자의 신원 (소속, 성명 및 전화번호 기타 연락처), 정보의 수집목적 및 이용목적, 제 3자에 대한 정보 제공 
 관련사항(제공 받는 자, 제공 목적 및 제공할 정보의 내용)등 정보통신망 이용촉진 등에 관한 법률 제 16조 제 3항이
  규정한 사항을 미리 명시하거나 고지해야 하며 이용자는 언제든지 이 동의를 철회할 수 있습니다. 
5. 이용자는 언제든지 웹사이트가 가지고 있는 자신의 개인정보에 대해 열람 및 오류정정을 요구할 수 있으며 웹사이트는
 특별한 사고가 없는 한 이에 대해 지체 없이 필요한 조치를 취할 의무를 집니다.
  이용자가 오류의 정정을 요구한 경우에는 웹사이트는 그 오류를 정정할 때까지 당해 개인정보를 이용하지 않습니다. 
6. 웹사이트는 개인정보 보호를 위하여 관리자를 한정하여 그 수를 최소화하며, 신용카드, 은행계좌 등을 포함한
 이용자의 개인정보의 분실, 도난, 유출, 변조 등으로 인한 이용자의 손해에 대하여 웹사이트 측의 분명한 잘못 
 또는 원인이 있을 때 이에 대한 책임을 집니다. 
7. 웹사이트 또는 그로부터 개인정보를 제공 받은 제 3자는 개인 정보의 수집목적 또는 제공 받은 목적을 달성한
 때에는 당해 개인정보를 지체 없이 파기합니다. 
 
제 18조 (회사의 의무) 
1. 웹사이트는 법령과 이 약관이 금지하거나 동서양속에 반하는 행위를 하지 않으며 이 약관이 정하는 바에 따라
 지속적이고 안정적으로 재화, 용역을 제공하는데 최선을 다하여야 합니다. 
2. 웹사이트가 상품이나 용역에 대하여 [표시, 광고의 공정화에 관한 법률] 제 3조 소정의 부당한 표시, 광고 행위를
 함으로써 이용자가 손해를 입은 때에는 이를 배상할 책임을 집니다. 
3. 웹사이트는 이용자가 원하지 않을 경우 영리 목적의 광고성 전자 우편을 발송하지 않습니다.
 다만, 긴급한 공지내용 안내나 기타 회사가 필요로 하다고 인정한 부분에 대해서 전자 우편 발송을 할 수 있습니다.
4. 웹사이트는 고객이 회사의 서비스 제공으로부터 기대되는 이익을 얻지 못하였거나 서비스 자료에 대한 취사선택
 또는 이용으로 발생하는 손해 등에 대해서는 책임이 면제됩니다 .
5. 웹사이트는 이용고객의 귀책사유로 인하여 서비스 이용의 장애가 발생한 경우에는 책임이 면제됩니다. 
6. 웹사이트는 이용자가 게시 또는 전송한 글 또는 자료의 내용에 대해서는 책임이 면제됩니다.
7. 웹사이트는 이용자 상호간 또는 이용자와 제3자 상호간에 서비스를 매개로 하여 물품거래 등을 한 경우에는 책임이 면제됩니다.
8. 웹사이트는 모든 서비스의 자료 보관 및 전송에 관한 책임이 없으며 자료의 손실이 있는 경우에도 책임이 면제됩니다.
 
제 19조 (회원의 ID 및 비밀번호에 대한 의무) 
1. 제 15조의 경우를 제외한 ID와 비밀번호에 관한 관리 책임은 회원에게 있습니다. 
2. 회원은 자신의 ID 및 비밀번호를 제 3자에게 이용하게 해서는 안됩니다. 
3. 회원이 자신의 ID 및 비밀번호를 도난 당하거나 제 3자가 사용하고 있음을 인지한 경우에는
 바로 웹사이트 에 통보하고 웹사이트의 안내가 있는 경우에는 그에 따라야 합니다.
 
제 20조 (이용자의 의무) 
이용자는 다음 행위를 하여서는 안됩니다. 
1. 신청 또는 변경 시 허위내용의 등록 
2. 웹사이트 에 게시된 정보의 변경 
3. 웹사이트가 정한 정보 이외의 정보 (컴퓨터 프로그램 등)의 송신 또는 게시 
4. 웹사이트 기타 제 3자의 저작권 등 지적재산권에 대한 침해
5. 웹사이트 기타 제 3자의 명예를 손상시키거나 업무를 방해하는 행위
6. 외설 또는 폭력적인 메시지, 화상, 음성 기타 동서양속에 반하는 정보를 웹사이트에 공개 또는 게시하는 행위
 
제 21조 (연결 웹사이트와 피 연결 웹사이트 간의 관계) 
1. 상위 웹사이트와 하위 웹사이트가 하이퍼 링크 (예 - 하이퍼 링크의 대상에는 문자, 그림
 및 동화상 등이 포함됨) 방식 등으로 연결된 경우, 전자를 연결 웹사이트(웹사이트)이라고
 하고 후자를 피 연결 웹사이트(웹사이트)이라고 합니다. 
2. 연결 웹사이트는 피 연결 웹사이트가 독자적으로 제공하는 재화, 용역에 의하여 이용자와 행하는 거래에 대해서
 보증책임을 지지 않습니다.
 
제 22조 (저작권의 귀속 및 이용제한)
1. 웹사이트가 작성한 저작물에 대한 저작권 기타 지적 재산권은 웹사이트에 귀속합니다. 
2. 이용자는 웹사이트를 이용함으로써 얻은 정보를 웹사이트의 사전 승낙 없이 복제, 송신,
 출판, 배포, 방송 기타 방법에 의하여 영리 목적으로 이용하거나 제 3자에게 이용하게 하여서는
 안됩니다.
 
제 23조 (분쟁해결) 
1. 웹사이트는 이용자가 제기하는 정당한 의견이나 불만을 반영하고 그 피해를 보상처리 하기 위하여 
고객센터(T.1577-5557)를 설치, 운영합니다. 
2. 웹사이트는 이용자로부터 제출되는 불만사항 및 의견은 우선적으로 그 사항을 처리합니다.
 다만 신속한 처리가 곤란한 경우에는 이용자에게 그 사유와 처리일정을 즉시 통보해 줍니다. 
3. 웹사이트와 이용자간에 발생한 분쟁은 전자거래 기본법 제 28조 및 동시행령 제 15조에 의하여 설치된 전자거래 분쟁
 조정 위원회의 조정에 따를 수 있습니다. 
 
제 24조 (재판권 및 준거법) 
1. 웹사이트와 이용자간에 발생한 전자거래 분쟁에 관한 소송은 민사소송법 상의 관할법원으로 정합니다. 
2. 웹사이트와 이용자간에 제기된 전자거래 소송에는 한국 법을 적용합니다.
이 약관은 2010년 10월 14일부터 시행합니다.
  
				</textarea>
											<p class="checkArea" align="right">
												이용약관에 동의 : 
												<input type="checkbox" name="chkBox" id="chkBox" onClick="fncConfirmChecked();" />동의함 
											</p>
											<br />
										</div>
										<div class="join_form">

											<tr>
												<th width="150" class="join_th">아이디</th>
												<td><input name="join_id" type="text" id="join_id" value="${id}"
													maxlength="12" len="4-12" size="20" class="join_input"
													readonly="readonly" /> 
													<input type="image" name="id_check"
													id="id_check" src="<%=request.getContextPath() %>/images/images/id_serch.png" align="absmiddle"
													onClick="window.open('<%=request.getContextPath()%>/jsp/member/mem_idcheck.jsp','new','resizable=yes scrollbars=no width=350 height=160');return false"
													style="border-width: 0px;" /> <span class="checkArea">&nbsp;*
														영문/숫자로 4~12자, 대소문자 구별 안함</span></td>
											</tr>

											<tr width="900" height="5">
												<td></td>
											</tr>

											<tr>
												<th width="150" class="join_th">이름</th>
												<td><input name="join_name" type="text" id="join_name"
													size="20" class="join_input" /></td>
											</tr>

											<tr width="900" height="5">
												<td></td>
											</tr>

											<tr>
												<th width="150" class="join_th">비밀번호</th>
												<td><input type="password" name="join_pwd"
													id="join_pwd" class="join_input" maxlength="10" /> <span
													class="checkArea">&nbsp; * 띄어쓰기 없는 영문 대소문자, 모든 문자,
														숫자로 5~10자</span></td>
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
												<td><input name="join_nickname" type="text"	id="join_nickname" size="20" class="join_input" readonly="readonly" value="${nick}" />
													<input type="image" name="nick_check"
													id="nick_check" src="<%=request.getContextPath() %>/images/images/nick_serch.png" align="absmiddle"
													onClick="window.open('<%=request.getContextPath()%>/jsp/member/mem_nickcheck.jsp','new','resizable=yes scrollbars=no width=350 height=160');return false"
													style="border-width: 0px;" />
													<span class="checkArea">&nbsp;*
														한글/영문/숫자로 4~12자, 대소문자 구별 안함</span>
												</td>
											</tr>

											<tr width="900" height="5">
												<td></td>
											</tr>

											<tr>
												<th width="150" class="join_th">생년월일</th>
												<td><input name="join_birth" type="text"
													id="join_birth" size="20" maxlength="8" class="join_input" />
													<span class="checkArea">&nbsp; * 생년월일을 - 을 제외하고
														입력해주세요. ex)19861212</span></td>
											</tr>

											<tr width="900" height="5">
												<td></td>
											</tr>

											<tr>
												<th width="150" class="join_th">이메일</th>
												<td><input name="join_mail" id="join_mail" maxlength="20" class="join_input" />
													<span class="checkArea">&nbsp;@&nbsp;</span>
													<input name="join_maildomain" id="join_maildomain" class="join_input" />&nbsp;
													
													<select name="mail_list" id="mail_list" onchange="domain_list()">
														<option value="" selected>== 선택 ==</option>
														<option value="hanmail.net">hanmail.net</option>
														<option value="hotmail.com">hotmail.com</option>
														<option value="nate.com">nate.com</option>
														<option value="naver.com">naver.com</option>
														<option value="paran.com">paran.com</option>
														<option value="yahoo.co.kr">yahoo.co.kr</option>
														<option value='0'>직접입력</option>
													</select>
												</td>
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
													class="join_input" maxlength="4" /> <span
													class="checkArea">&nbsp;-&nbsp;</span> <input
													name="join_phone03" size="6" type="text" id="join_phone03"
													class="join_input" maxlength="4" /> <span
													class="checkArea">&nbsp;* 긴급연락이 가능한 번호를 입력해 주세요</span></td>
											</tr>

											<tr width="900" height="5">
												<td></td>
											</tr>

											<tr>
												<th width="150" class="join_th">우편번호</th>
												<td><input name="join_zip01" type="text"
													id="join_zip01" maxlength="12" size="6"
													readonly="readonly" class="join_input" /> 
													<span class="checkArea">&nbsp;-&nbsp;</span> 
													<input name="join_zip02" type="text" id="join_zip02"
													maxlength="12" size="6" readonly="readonly"
													class="join_input" /> 
													<input type="image" name="zip_check"
													id="zip_check" src="<%=request.getContextPath() %>/images/images/zip_serch.png" align="absmiddle"
													onClick="window.open('mem_zipcodecheck.jsp','new','resizable=yes scrollbars=no width=350 height=200');return false" /></td>
											</tr>

											<tr width="900" height="5">
												<td></td>
											</tr>

											<tr>
												<th width="150" class="join_th">주소</th>
												<td style="line-height: 190%"><input name="join_addr01"
													type="text" size="50" id="join_addr01" class="join_input"
													readonly="readonly" /><br /> <input name="join_addr02"
													type="text" size="50" id="join_addr02" class="join_input" />
												</td>
											</tr>

										</div>
									</div>
								</table>
								<div id="join_menu">
									<tr>
										<td width="900" height="150" align="center">
										<input type="image" name="join_ok" src="<%=request.getContextPath() %>/images/images/join_ok.png"
										alt="확인" onClick="return check();" id="confirm" />
											&nbsp;&nbsp;&nbsp;&nbsp; 
										<a href="#"><img src="<%=request.getContextPath() %>/images/images/join_reset.png" alt="재작성" border="0"
												onclick="document.f.reset();" /></a></td>
									</tr>
								</div>
						<tr>
							<td width="900" height="100"></td>
						</tr>
						</td>

						<!-- 회원가입폼 영역 끝 -->

						</tr>
						<tr>
							<td width="900" height="70">
								<table width="900" height="70" border="0" cellspacing="0"
									cellpadding="0" bgcolor="#3e3f3e">
									<tr>
										<td width="750" height="70"><img
											src="<%=request.getContextPath() %>/images/index/main_09.jpg" width="750" height="70"
											border="0" /></td>
										<td width="150" height="70" align="center" valign="middle"
											bgcolor="#3e3f3e">
											
											<!-- 패밀리사이트 영역 -->
										<td width="150" height="70">
										<select id="fmsite" name="fmsite" class="jumpmenu" onchange="window.open(value,'_blank');" >
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

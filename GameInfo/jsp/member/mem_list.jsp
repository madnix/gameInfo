<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="logic.*" %>
<%
List<UserBean> memlist=(ArrayList)request.getAttribute("memlist");
int memcount=((Integer)request.getAttribute("memcount")).intValue();
String grade = (String)session.getAttribute("userstate"); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링3.0 회원목록</title>
</head>
<body>

  <td align="right" class="board_cont">
  <input type="button" value="메인이동" onclick="location='<%=request.getContextPath()%>/main.info'"></td>
  <table width="1300">
   <tr height="30">
    <th class="board_title">번호</th> 
    <th class="board_title">아이디</th>
    <th class="board_title">비밀번호</th> 
    <th class="board_title">이름</th>
    <th class="board_title">닉네임</th>
    <th class="board_title">우편번호1</th>
    <th class="board_title">우편번호2</th>
    <th class="board_title">주소1</th>
    <th class="board_title">주소2</th>
    <th class="board_title">이메일</th>
    <th class="board_title">메일도메인</th>
    <th class="board_title">생년월일</th>  
    <th class="board_title">강제탈퇴</th>
   </tr>
   
   <%
   int v_no = memcount;
   for(int i=0;i<memlist.size();i++){
	   UserBean l=(UserBean)memlist.get(i);//컬렉션 요소값을 가져온다.
   %>
   
   <tr 
   onmouseover="this.style.backgroundColor='#F8F8F8'"
   onmouseout="this.style.backgroundColor=''" class="board_cont">
  
    <td align="center" class="board_cont"><%=v_no%></td>
    <td align="center" class="board_cont"><%=l.getUser_id()%></td>
    <td align="center" class="board_cont"><%=l.getUser_pass()%></td>
    <td align="center" class="board_cont"><%=l.getUser_name()%></td>
    <td align="center" class="board_cont"><%=l.getUser_nickname()%></td>
    <td align="center" class="board_cont"><%=l.getUser_zip1()%></td>
    <td align="center" class="board_cont"><%=l.getUser_zip2()%></td>
    <td align="center" class="board_cont"><%=l.getUser_addr1()%></td>
    <td align="center" class="board_cont"><%=l.getUser_addr2()%></td>
    <td align="center" class="board_cont"><%=l.getUser_mail()%></td>
    <td align="center" class="board_cont"><%=l.getUser_maildomain()%></td>
    <td align="center" class="board_cont"><%=l.getUser_birth()%></td>
    <% if(grade != ("admin")) {%>
    <td align="center" class="board_cont"><input type="button" value="회원탈퇴" onclick="location='<%=request.getContextPath()%>/mem_kick.info?id=<%=l.getUser_id()%>'"></tr>
    <!-- 0이상 10미만 사이의 문자 반환. 즉 시,분등은 빼고 년월일만 출력 -->
    <% } else { %>
    <% } %>
   <% v_no--; //1씩 감소
   } %>

  </table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String headerData="header 선언데이터";
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.7.0.mn.js"></script>
<style>
	header>nav>ul{
		display:flex;
		list-style:none;
		justify-content: space-between;
	}
	li>a{
		font-size:30px;
		font-weight:bolder;
		text-decoration:none;
		color:black;
	}
	section{
		height:500px;
		width:100%;
	}
</style>
</head>
<body>
</head>
<header>
		<h1>sample header</h1>
		<nav>
			<ul>
				<li><a href="<%=request.getContextPath()%>">메인화면</a></li>
				<li><a href="">공지사항</a></li>
				<li><a href="<%=request.getContextPath()%>/views/board.jsp">게시판</a></li>
				<li><a href="">자료실</a></li>
				<li><a href="">추가메뉴</a></li>
			</ul>
		</nav>
	</header>
</body>
</html>
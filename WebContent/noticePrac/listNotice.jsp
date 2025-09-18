<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<style>
.cls1 {
	font-size: 40px;
	text-align: center;
}
.cls2 {
	font-size: 20px;
	text-align: center;
}
</style>
</head>
<body>
	<p class="cls1">공지사항</p>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>No</b></td>
			<td width="20%"><b>제목</b></td>
			<td width="7%"><b>게시일</b></td>
		</tr>

		<c:choose>
			<c:when test="${ empty noticesList }">
				<tr>
					<td colspan=5><b>등록된 공지가 없습니다.</b></td>
				</tr>
			</c:when>
			<c:when test="${!empty noticesList }">
				<c:forEach var="notice" items="${noticesList }">
					<tr align="center">
						<td>${notice.no }</td>
						<td>${notice.title }</td>
						<td>${notice.postDate }</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<a href="#">
		<p class="cls2">공지 작성</p>
	</a>
</body>
</html>
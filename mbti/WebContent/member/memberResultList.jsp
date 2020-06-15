<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>검사결과</title>
	<link rel="stylesheet" type="text/css" href="/mbti/css/common.css">
</head>
<body>
	<!-- contents -->
	<h2>검사결과</h2>
	<table>
		<tr>
			<th>결과</th>
			<th>검사날짜</th>
		</tr>
		<c:forEach items="${list}" var="vo">
		<tr>
			<td>${vo.result}</td>
			<td>${vo.regdt}</td>
		</tr>
		</c:forEach>
	</table>
	<!-- contents -->
</body>
</html>
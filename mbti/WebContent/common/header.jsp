<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/mbti/css/common.css">
</head>
<body>
<section>
	<div>
		<h3 style="text-align:center"><a href="./">성격 테스트 한 번 하고 가셔요.</a></h3>
	</div>
	<div class="navi">
		<ul>
			<c:if test="${loginId == null}">
		  		<li><a class="active" href="MemberLogin.do">로그인</a></li>
		 		 <li><a href="MemberInsert.do">회원가입</a></li>
		 	</c:if>
		 	<c:if test="${loginId != null}">
		 		<li><a href="MemberLogout.do">로그아웃</a></li>
		  		<li><a href="MemberUpdate.do">마이페이지</a></li>
		  	</c:if>
		  <li><a href="TestInsert.do">MBTI TEST</a></li>
		  <li><a href="BoardList.do">다양한 결과 보기</a></li>
		</ul>
	</div>
	<article>

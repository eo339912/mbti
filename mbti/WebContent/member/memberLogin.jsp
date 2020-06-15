<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/common/header.jsp"/>
	<!-- contents -->
	<h2>로그인</h2>
	<form action="/mbti/MemberLogin.do" method="post" id="login">
		<p>${errorMsg}</p>
		<input type="text" name="id" placeholder="id" value="${param.id}"><br>
		<input type="password" name="pwd" placeholder="pwd"><br>
		<button class="btn">로그인</button>
		<p class="form_p"><a href="/mbti/MemberInsert.do">회원가입하기</a></p>
	</form>
<%@include file="/common/footer.jsp" %>
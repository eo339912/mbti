<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/common/header.jsp"/>
	<!-- contents -->
	<h2>MBTI TEST 하러가기</h2>
	<img src="/mbti/main/main.jpg" width="30%" style="margin-bottom:10px"/>
	
		<c:if test="${loginId != null}">
			<div class="btn"><a href="TestInsert.do">go!</a></div>
		</c:if>
		<c:if test="${loginId == null}">
			<div class="btn"><a href="MemberLogin.do">go!</a></div>
		</c:if>
	
<%@include file="/common/footer.jsp" %>
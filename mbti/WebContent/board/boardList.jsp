<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<jsp:include page="/common/header.jsp"/>
	<!-- contents -->
	<h2>MBTI 결과 게시판</h2>
	
	<form name="searchfrm" class="searchfrm">
	<input name="p" value="1" type="hidden">
		이름
		<input name="id"/>
		<button>검색</button>
	</form>
	
	<table border="1">
		<tr>
			<th>작성자</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${list}" var="vo">
		<tr>
			<td>${vo.id}</td>
			<td><a href="BoardView.do?seq=${vo.seq}">${vo.title}</a></td>
			<td>${vo.regdt}</td>

		</tr>
		</c:forEach>
	</table>
	<div class="btn"><a href="BoardInsert.do">MBTI결과 추가하기</a></div>
	
	<script>
		function gopage(p){
			document.searchfrm.p.value = p;
			document.searchfrm.submit();
		}
	</script>
	<my:paging paging="${paging}" jsfunc="gopage"></my:paging>
	
<%@include file="/common/footer.jsp" %>
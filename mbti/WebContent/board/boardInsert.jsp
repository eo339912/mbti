<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/common/header.jsp"/>
	<!-- contents -->
	<h2>MBTI 결과 추가하기</h2>
	<form action="/mbti/BoardInsert.do" method="post" id="insert">
		<div><span class="tit">작성자 : </span><input type="text" name="id" placeholder="id" readonly="readonly" value="${loginId}"></div><br>
		<div><span class="tit">제목 : </span><input type="text" name="title" placeholder="title"></div><br>
		<div style="position:relative"><span class="tit" style="position:absolute; top:0">내용 : </span>
		<textarea  rows="10" name="contents" id="contents" ></textarea>
		</div>
		
		<button class="btn">저장하기</button>
	</form>

	
<%@include file="/common/footer.jsp" %>
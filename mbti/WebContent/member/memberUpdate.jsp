<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="/common/header.jsp"/>
	<!-- contents -->
	<h2>마이페이지</h2>
	<form action="/mbti/MemberUpdate.do" method="post" id="insert">
		<div><span class="tit">아이디 : </span><input type="text" name="id" placeholder="id" readonly="readonly" value="${member.id}"></div><br>
		<div><span class="tit">비밀번호 : </span><input type="password" name="pwd" placeholder="pwd" value="${member.pwd}"></div><br>
		<div><span class="tit">이름 : </span><input type="text" name="name" placeholder="이름" value="${member.name}"></div><br>
		<div><span class="tit">생년월일 : </span>
            <fmt:parseDate value="${member.birth}" var="sdate" pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
            <fmt:formatDate pattern="yyyy-MM-dd" value="${sdate}" var="bd"/>
			<input type="text" name="birth" placeholder="생년월일" value="${bd}"></div><br>
		<div><span class="tit">성별 : </span>
			<div class="result">
				<input type="radio" value ="m" name="gender"
					<c:if test="${fn: contains(member.gender ,'m')}">
						checked="checked"
					</c:if>
				/> 남자
				<input type="radio" value ="f" name="gender"
					<c:if test="${fn: contains(member.gender ,'f')}">
						checked="checked"
					</c:if>
				/> 여자
			</div>
		</div>
		
		<div><span class="tit">나의 MBTI : </span><div class="result"><span class="mbti_result">${member2.result}&nbsp;</span><a onclick="OpenWindow()" class="fr">기존 결과보러가기></a></div></div>
		<div>
			<span class="tit">내가 쓴 글 보러가기 : </span>
			<div class="result">			
				<div class="btn2"><a href="BoardOneList.do">바로가기</a></div>
			</div>
		</div>
		<button class="btn">회원정보수정</button>
	</form>
	
<script>
function OpenWindow() {  
      window.open("/mbti/MemberResultList.do","_blank","top=50,left=50,width=816,height=340,resizable=1,scrollbars=no");
}

</script>

<%@include file="/common/footer.jsp" %>
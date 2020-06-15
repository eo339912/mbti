<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/common/header.jsp"/>
<script>
	function validCheck(){
		//필수입력체크
		//textfield
		if(insert.id.value == ""){
			alert("id 입력");
			frm.id.focus();
			return;
		}
		if(insert.pwd.value == ""){
			alert("pwd 입력");
			frm.pwd.focus();
			return;
		}
		//select
		if(insert.religion.selectedIndex < 1){
			alert("종교 선택");
			return;
		}
		insert.submit();
	}
</script>
	<!-- contents -->
	<h2>회원가입</h2>
	<form action="/mbti/MemberInsert.do" method="post" id="insert">
		<input type="text" name="id" placeholder="id" required><br>
		<input type="password" name="pwd" placeholder="pwd" required><br>
		<input type="text" name="name" placeholder="이름"><br>
		<input type="text" name="birth" placeholder="생년월일"><br>
		<div>
			<input type="radio" value ="m" name="gender"/> 남자
			<input type="radio" value ="f" name="gender"/> 여자
		</div>
		<button class="btn" onclick="validCheck()">회원가입</button>
	</form>
<%@include file="/common/footer.jsp" %>
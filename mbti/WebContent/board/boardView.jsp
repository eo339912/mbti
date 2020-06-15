<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<jsp:include page="/common/header.jsp"/>
	<!-- contents -->
	<h2>MBTI 결과</h2>
	<table border="1" class="v_tb">
		<tr>
			<td colspan="2"><span class="tit">작성자 : </span><span>${board.id}</span></td>
			<td><span class="tit">별점 : </span>
				<span>
					<c:choose>
						<c:when test="${commend.avgStar == 1}">
							★☆☆☆☆
						</c:when>
						<c:when test="${commend.avgStar == 2}">
							★★☆☆☆
						</c:when>
						<c:when test="${commend.avgStar == 3}">
							★★★☆☆
						</c:when>    
						<c:when test="${commend.avgStar == 4}">
							★★★★☆
						</c:when>    
						<c:when test="${commend.avgStar == 5}">
							★★★★★
						</c:when>    
						<c:otherwise>
							☆☆☆☆☆
						</c:otherwise>
					</c:choose>
				</span>
			</td>
		</tr>
		<tr>
			<td colspan="3"><span class="tit">Title : </span><span>${board.title}</span></td>
		</tr>
		<tr>
			<td colspan="3">${board.contents}</td>
		</tr>
	</table>
	
	<table>
		<tr>
			<td>별점주기</td>
		</tr>
		<tr>
			<td>
				<form action="/mbti/BoardView.do?seq=${board.seq}" method="post" >
					<input type="hidden" name="starC" id="starC">
					<div class="starRev">
					  <span class="starR on">별1</span>
					  <span class="starR">별2</span>
					  <span class="starR">별3</span>
					  <span class="starR">별4</span>
					  <span class="starR">별5</span>
					</div>
					<button class="btn2 starBtn" style="margin-top:20px">저장</button>				
				</form>
			</td>
		</tr>
	</table>
	
	<script>
	$('.starRev span').click(function(){
		  $(this).parent().children('span').removeClass('on');
		  $(this).addClass('on').prevAll('span').addClass('on');
		  return false;
		});
	$('.starBtn').click(function(){
		var onClass = $('.on').length;
		 $('#starC').val(onClass);
	})
	

	
	</script>
	<div class="btn_wrap">
		<c:if test="${loginId == board.id}">
			<div class="btn fl" onclick="fc()"><a>삭제</a></div>
			<div class="btn fr"><a href="BoardUpdate.do?seq=${board.seq}">수정</a></div>
		</c:if>
	</div>
	
	<script>

		function fc(){

			var result = confirm("정말? 삭제하신다구요?");
			if(result){
				location.href = "BoardDelete.do?seq=${board.seq}";
			}else{
			    
			}

		}

	</script>


	
<%@include file="/common/footer.jsp" %>
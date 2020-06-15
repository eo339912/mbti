<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/common/header.jsp"/>
	<!-- contents -->
	<h2>MBTI TEST</h2>
	<form action="/mbti/TestInsert.do" method="post" id="insert">
		<div class="t_insert_wrap">
			<p class='count'></p>
			<input type="radio" value ="e" name="ei0" required/>처음보는 사람과 쉽게 이야기하거나 친해지는 편이다.
			<br><input type="radio" value ="i" name="ei0"/>친한 사람이나 친구가 없는 모임에 가면 매우 불편하다.
			<hr>
			<p class='count'></p>
			<input type="radio" value ="e" name="ei1" required/>모르는 사람들이 많이 모여있는 곳에서도 비교적 활발하게 행동하는 편이다.
			<br><input type="radio" value ="i" name="ei1"/>친구를 쉽게 사귀는 편이 아니며 친한 몇명의 친구들과 아주 친하게 지낸다.
			<hr>
			<p class='count'></p>
			<input type="radio" value ="e" name="ei2" required/>여러 모임에 아는 사람들이 많다.
			<br><input type="radio" value ="i" name="ei2"/>평소에 침착하고 조용하다는 말을 자주 듣는다.
			<hr>
			<!-- <input type="radio" value ="e" name="ei3"/>모임에서 다른 사람보다 말을 많이 하는 편이며 적극적으로 행동한다.
			<br><input type="radio" value ="i" name="ei3"/>혼자 놀거나 조용히 책을 읽는 모습이 자주 있다.
			<hr>
			<input type="radio" value ="e" name="ei4"/>슬프거나 기쁜 일이 생기면 즉시 주변사람에게 이야기하는 편이다.
			<br><input type="radio" value ="i" name="ei4"/>먼저 여러번 생각해 다음에 행동하는 편이다.
			<hr>
			<input type="radio" value ="e" name="ei5"/>활발하고 적극적이라는 말을 많이 듣는 편이다.
			<br><input type="radio" value ="i" name="ei5"/>부끄러움을 쉽게 타는 편이다.
			<hr>
			<input type="radio" value ="e" name="ei6"/>시간이 걸리는 일, 놀이는 싫증을 빨리내고 새로운 놀이, 활동을 원한다.
			<br><input type="radio" value ="i" name="ei6"/>자신의 의견이나 감정을 표현하는데 재빠르지 않은 편이다.
			<hr>
			<input type="radio" value ="e" name="ei7"/>혼자 조용히 있거나 책을 읽는 것보다 사람들과 어울리는 것이 좋다.
			<br><input type="radio" value ="i" name="ei7"/>누가 물어보았을 때에야 대답하는 편이다.
			<hr>
			<input type="radio" value ="e" name="ei8"/>새로운 유행이 시작되면 다른 사람들보다 먼저 시도해보는 편이다.
			<br><input type="radio" value ="i" name="ei8"/>낮선 곳에 혼자 가는 것은 좀 불편하다. --> 
	<!-- 	</div>
		<div class="t_insert_wrap"> -->
			<p class='count'></p>
			<input type="radio" value ="s" name="sn0" required/>‘이불처럼 폭신한 구름’이란 꾸밈어보다 ‘흰구름’처럼 단순한 말이 더 좋다
			<br><input type="radio" value ="n" name="sn0"/>상상 속의 이야기를 잘 만들어 내는 편이다
			<hr>
			<p class='count'></p>
			<input type="radio" value ="s" name="sn1" required/>주변 사람들의 얼굴, 키나 다른 특징들을 잘 기억한다
			<br><input type="radio" value ="n" name="sn1"/>종종 물건을 잃어버리거나 어디에 두었는지 기억을 못할 때가 있다.
			<hr>
			<p class='count'></p>
			<input type="radio" value ="s" name="sn2" required/>꾸준하고 참을성 있다는 말을 자주 듣는 편이다.
			<br><input type="radio" value ="n" name="sn2"/>독특하고 창의력, 상상력이 풍부하다는 말을 듣는 편이다.
			<hr>
			<!-- <input type="radio" value ="s" name="sn3"/>공부할 때 세세하고 자세한 내용을 잘 암기하는 편이다.
			<br><input type="radio" value ="n" name="sn3"/>다른 사람들이 생각하지도 않은 엉뚱한 행동이나 상상을할 때가 종종 있다
			<hr>
			<input type="radio" value ="s" name="sn4"/>손으로 직접 만지거나 하나하나 조작하는 활동을 좋아한다
			<br><input type="radio" value ="n" name="sn4"/>질문을 많이 하는 편이다.
			<hr>
			<input type="radio" value ="s" name="sn5"/>꼼꼼하다는 말을 자주 듣는 편이다.
			<br><input type="radio" value ="n" name="sn5"/>가끔 내 상상 속에서만 있는 친구를 만들기도 한다.
			<hr>
			<input type="radio" value ="s" name="sn6"/>새로운 일이나 활동보다는 늘상 하는 일이 편안하다.
			<br><input type="radio" value ="n" name="sn6"/>신기한 것에 호기심이 많다.
			<hr>
			<input type="radio" value ="s" name="sn7"/>‘그게 정말이야?’라는 식의 질문을 많이 한다.
			<br><input type="radio" value ="n" name="sn7"/>장난감을 분해하고 살펴보는 것을 좋아한다.
			<hr>
			<input type="radio" value ="s" name="sn8"/>새로운 방법을 써보기보다는 친구들이 하는 대로 따라서 하는게 더 편하다
			<br><input type="radio" value ="n" name="sn8"/>‘하고 싶다, 되고 싶다’ 꿈이 여러 가지로 많다. -->
<!-- 		</div>

		<div class="t_insert_wrap"> -->
			<p class='count'></p>
			<input type="radio" value ="t" name="tf0" required/>'왜‘라는 질문을 자주 하는 편이다.
			<br><input type="radio" value ="f" name="tf0"/>부모님이나 선생님의 말을 잘 듣는 편이다.
			<hr>
			<p class='count'></p>
			<input type="radio" value ="t" name="tf1" required/>끝까지 해내는 의지와 끈기가 강한 편이다.
			<br><input type="radio" value ="f" name="tf1"/>기뻐하고 슬픈 감정이 풍부하고 인정이 많다는 말을 듣는다.
			<hr>
			<p class='count'></p>
			<input type="radio" value ="t" name="tf2" required/>궁금한 게 있으면 꼬치꼬치 따져서 궁금증을 풀고 싶어한다.
			<br><input type="radio" value ="f" name="tf2"/>정이 많고 순하다는 말을 자주 듣는다.
			<hr>
			<!-- <input type="radio" value ="t" name="tf3"/>참을성이 있다는 말을 자주 듣는다.
			<br><input type="radio" value ="f" name="tf3"/>주위에 불쌍한 사람이나 친구가 있으면 마음이 아프고 도와주고 싶다
			<hr>
			<input type="radio" value ="t" name="tf4"/>야단을 맞거나 벌을 받아도 눈물을 잘 보이지 않는 편이다
			<br><input type="radio" value ="f" name="tf4"/>야단을 맞거나 벌을 받으면 눈물부터 나온다
			<hr>
			<input type="radio" value ="t" name="tf5"/>한 번 마음 먹은 일은 꾸준히 밀어나가 꼭 이뤄내는 편이다
			<br><input type="radio" value ="f" name="tf5"/>다른 친구들이나 어른들이 내 행동을 어떻게 생각할지 신경이 쓰인다.
			<hr>
			<input type="radio" value ="t" name="tf6"/>주변 어른들이 귀엽다고 쓰다듬어 주면 어색하다
			<br><input type="radio" value ="f" name="tf6"/>매를 맞으면 쉽게 잘못했다고 하는 편이다.
			<hr>
			<input type="radio" value ="t" name="tf7"/>성적이 올랐거나 잘했을 때 직접적인 칭찬을 받는 게 좋다
			<br><input type="radio" value ="f" name="tf7"/>친구들 사이에서 성격이 부드럽다 싹싹하다 순하다고 한다
			<hr>
			<input type="radio" value ="t" name="tf8"/>부모님, 친구들에게 논리적이고 구체적인 설명으로 설득하는 편이다
			<br><input type="radio" value ="f" name="tf8"/>음식, 장난감, 옷을 선택할 때 쉽게 결정을 내리지 못한다. -->
<!-- 		</div>

		<div class="t_insert_wrap"> -->
			<p class='count'></p>
			<input type="radio" value ="j" name="jp0" required/>대체로 공부나 할일을 미리 해놓고 노는 편이다
			<br><input type="radio" value ="p" name="jp0"/>계획보다는 어떤 일이 닥치면 그때그때 처리하는 편이다
			<hr>
			<p class='count'></p>
			<input type="radio" value ="j" name="jp1" required/>시험보기 전에 미리 여유있게 공부계획을 짜 놓고 실천한다
			<br><input type="radio" value ="p" name="jp1"/>숙제를 미루다가 마지막 순간에 해서 시간에 쫓길 때가 종종 있다.
			<hr>
			<p class='count'></p>
			<input type="radio" value ="j" name="jp2" required/>미리 하는 게 편하고 마지막 순간에 쫓기면서 일하는 걸 싫어한다
			<br><input type="radio" value ="p" name="jp2"/>방이 어수선하게 지저분해도 크게 신경쓰이지 않고 관심대상에 바로 집중하는편이다
			<hr>
			<!-- <input type="radio" value ="j" name="jp3"/>계획에 따라 규칙적인 생활을 하는 편이다
			<br><input type="radio" value ="p" name="jp3"/>주변일에 호기심이 많고 새로운 일이 생겨도 잘 적응한다
			<hr>
			<input type="radio" value ="j" name="jp4"/>목표가 뚜렷하고 자신의 의견을 분명히 표현하는 편이다
			<br><input type="radio" value ="p" name="jp4"/>남의 지시에 따르기보다는 자신의 마음에 따라 행동하는 것이 좋다
			<hr>
			<input type="radio" value ="j" name="jp5"/>계획에 없는 일이 생기면 짜증이 나고 힘이 든다
			<br><input type="radio" value ="p" name="jp5"/>공책이나 책가방을 미리 챙기고 준비하는 편은 아니다
			<hr>
			<input type="radio" value ="j" name="jp6"/>학교나 친구들 모임에서 책임있는 일을 맡고 싶다
			<br><input type="radio" value ="p" name="jp6"/>자신의 생각, 의견을 크게 주장하지는 않는다
			<hr>
			<input type="radio" value ="j" name="jp7"/>예정에 없던 일로 계획을 바꾸게 되면 힘들어 한다
			<br><input type="radio" value ="p" name="jp7"/>신발이나 옷이 떨어져도 무관심한 편이다
			<hr>
			<input type="radio" value ="j" name="jp8"/>깨끗이 정돈된 상태를 좋아한다
			<br><input type="radio" value ="p" name="jp8"/>자기 것을 친구나 형제들한테 비교적 잘 나누어주는 편이다 -->
		</div>

		

		<button class="btn">결과보기</button>
	</form>
<%@include file="/common/footer.jsp" %>
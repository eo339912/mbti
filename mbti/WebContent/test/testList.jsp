<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/common/header.jsp"/>

	<!-- contents -->
	<h2>나의 MBTI는?</h2>
	<p class="t_result">${fn:toUpperCase(test.result)}</p>


	<br>
	<div class="t_contents">
	<c:if test="${test.result eq 'ISTJ'}">
		<br><!-- * -->부끄럼을 많이 탄다.
		<br><!-- * -->성실하고 책임감이 강하고 정리정돈을 잘한다
		<br><!-- * -->예정에 없던 일을 몹시 힘들어한다
		<br><!-- * -->자발성이 부족한 편이다
		<br><!-- * -->표현이 적으며 표정변화가 없다.
		<br><!-- * -->절약과 준비정신이 철저하다.
		<br><!-- * -->양처럼 순하고 순종적이다
		<br><!-- * -->외유내강의 느낌을 준다.
		<br><!-- * -->자세가 바르며 계획을 세워 공부한다.
		<br><!-- * -->자세한 설명을 선호한다.
		<br><!-- * -->창의적인 면와 융통성이 부족한 편이다.
	</c:if>
	<c:if test="${test.result eq 'ISFJ'}">
		<br><!-- * -->온순하다. 성실하고 책임감이 강하다.
		<br><!-- * -->말을 참고 삭이는 경우가 많다.
		<br><!-- * -->봉사적이며 착하다
		<br><!-- * -->소수와 깊게 사귄다. 친한 친구와 논다.
		<br><!-- * -->인내심이 있으며 꾸준하다.
		<br><!-- * -->준비물을 잘 챙긴다. 깔끔 단정
		<br><!-- * -->규칙을 준수하며 계획적이다.
		<br><!-- * -->행동력이 부족하다.
		<br><!-- * -->신뢰감이 간다.
		<br><!-- * -->변화를 싫어한다.
		<br><!-- * -->다른사람에게 도움이 되고자 하는 욕구
	</c:if>
	<c:if test="${test.result eq 'ISTP'}">
		<br><!-- * -->말수가 적고 표정변화가 거의 없다.
		<br><!-- * -->의욕적이며 고집이 세다.
		<br><!-- * -->앞에 나서지는 않지만 소집단에서는 리더 역할을 하려고 한다.
		<br><!-- * -->여러 가지에 관심이 많다.
		<br><!-- * -->왠지 강한 구석이 있다.
		<br><!-- * -->뒷마무리가 부족하다. 끈기가 부족하다.
		<br><!-- * -->타인에 대한 배려가 적다.
		<br><!-- * -->손재주가 있다.
		<br><!-- * -->친구와 잘 다투고 잘 따진다.
		<br><!-- * -->조용하다가도 일은 성급하게 한다.
	</c:if>
	<c:if test="${test.result eq 'ISFP'}">
		<br><!-- * -->마음이 너그럽고 순하다.
		<br><!-- * -->낙천적, 천하태평 행동이 느리다
		<br><!-- * -->놀 줄 알며 무대 체질, 예술적 매체를 통해 자신을 드러내는 것을 좋아함. 충동적 정력
		<br><!-- * -->성급한 결론을 잘 내린다.
		<br><!-- * -->끈기가 부족하다.
		<br><!-- * -->부끄럼을 많이 탄다. 외모에 관심이 많다.
		<br><!-- * -->동식물 사육이나 재배를 좋아하다.
		<br><!-- * -->권위적인 분위기에서는 눈치를 살핌
		<br><!-- * -->잔잔하게 산만한 편이다.
		<br><!-- * -->주변의 요구를 뿌리치지 못하다.
	</c:if>
	<c:if test="${test.result eq 'ESTP'}">
		<br><!-- * -->개방적, 활동적, 적극적, 진취적이다.
		<br><!-- * -->항상 즐겁다. 재치꾼
		<br><!-- * -->모든 일에 관심을 갖고 지나치게 참견
		<br><!-- * -->끝마무리가 부족, 말과 행동의 불일치
		<br><!-- * -->복잡한 것을 싫어한다.
		<br><!-- * -->욕심이 많다. 은근히 승부근성이 강하다.
		<br><!-- * -->대중앞에 강하다. 과행동적, 목소리 크다.
		<br><!-- * -->말이 많고 잘 따지며 꾸중을 해도 자신의 입장을 끝까지 말한다.
		<br><!-- * -->임기응변이 뛰어나고 호탕하다.
		<br><!-- * -->어떤 권위나 강압에 굴하지 않는다.
	</c:if>
	<c:if test="${test.result eq 'ESFP'}">
		<br><!-- * -->활발하다. 천방지축, 과잉행동 먹보, 감정적
		<br><!-- * -->표정이 밝다. 목소리가 크고 말이 않다.
		<br><!-- * -->언제나 놀고 싶다. 단순하다. 솔직하다.
		<br><!-- * -->장난이 심하다. 붙임성이 있다.
		<br><!-- * -->지적을 많이 받아 자신을 착하다고 생각하지 않음
		<br><!-- * -->뭐든지 급하게 해치운다.
		<br><!-- * -->적응력이 뛰어나다. (학원을 빼먹진 않음)
		<br><!-- * -->진지함이 부족하다.(실전에 불안해함)
		<br><!-- * -->group study가 효과적, 선의의 경쟁
		<br><!-- * -->인정받고 싶은 욕구가 강하다.
		<br><!-- * -->명랑쾌활, 감정이 풍부하다. 
	</c:if>
	<c:if test="${test.result eq 'ESTJ'}">
		<br><!-- * -->모범적이고 솔선수범한다.
		<br><!-- * -->정리정돈을 잘하고 책임감이 강하다.
		<br><!-- * -->웃어른을 공경하고 예의가 바르다.
		<br><!-- * -->합리적으로 생각하고 공정한 것을 선호한다
		<br><!-- * -->경쟁에서는 이겨야 한다.
		<br><!-- * -->친구나 주변사람을 배려하는 리더타입
		<br><!-- * -->질서와 사회적인 관습을 중시한다.
		<br><!-- * -->여러 친구들과 두루 잘 지낸다.
		<br><!-- * -->친절하다. 중재 타협, 분배를 잘함.
		<br><!-- * -->불평이 없다. 활발하다.
	</c:if>
	<c:if test="${test.result eq 'ESFJ'}">
		<br><!-- * -->타인의 무관심에 쉽게 좌절,
		<br><!-- * -->남 앞에 나서기를 좋아한다.
		<br><!-- * -->교실을 꾸미는 일을 잘한다.
		<br><!-- * -->미리 걱정하는 경향이 있다.
		<br><!-- * -->왕성한 발표력, 언어계열을 선호
		<br><!-- * -->표현력과 리더쉽이 뛰어나다.
		<br><!-- * -->일기를 잘 쓴다. 운동을 좋아함
		<br><!-- * -->이야기 중심의 소설류를 많이 읽는다.
		<br><!-- * -->분명한 과제와 자세한 설명을 좋아한다.
		<br><!-- * -->말이 많다.
	</c:if>
	<c:if test="${test.result eq 'INFJ'}">
		<br><!-- * -->조용하고 침착하고 책임감이 강하다.
		<br><!-- * -->내면적인 욕심이 많고 잔걱정이 많다.
		<br><!-- * -->또래에 비해 성숙한 사고력을 지님
		<br><!-- * -->민감하고 복잡한 정서를 가짐 비유를 잘함
		<br><!-- * -->교사의 의도를 잘 알아챈다.
		<br><!-- * -->개인적인 칭찬을 해주면 크게 향상된다.
		<br><!-- * -->시끄럽고 복잡한 것, 나서기를 싫어함.
		<br><!-- * -->학급일에 적극적으로 임하지 않는다.
		<br><!-- * -->완벽성 추구, 소외받는 아동에 관심이 많음
		<br><!-- * -->좋아하는 것과 좋아하지 않는 것 차이가 심하
		다. 교사와의관계가 좋으면 열심히 공부함
	</c:if>
	<c:if test="${test.result eq 'INTJ'}">
		<br><!-- * -->“애늙은이” 소수와 깊게 사귄다.
		<br><!-- * -->외모에 무관심, 독립적, 독창적, 효율성 강조
		<br><!-- * -->고집이 아주 세다. 대단히 강하다.
		<br><!-- * -->충분한 시간을 주는 것이 필요한 타입
		<br><!-- * -->이유가 타당하지 않으면 끝까지 승복하지
		않는다. 모든 일에 이유가 많다.
		<br><!-- * -->이론적으로 논리적으로 따진다.
		<br><!-- * -->감정표현은 없으나 상처를 쉽게 받는다.
		<br><!-- * -->칭찬이나 벌에 무관심. 매우 많은 칭찬필요
		<br><!-- * -->승부욕이 강하고 이길 때까지 한다.
		<br><!-- * -->사소한 옷, 먹는 이야기하면 속상해한다.
	</c:if>
	<c:if test="${test.result eq 'INFP'}">
		<br><!-- * -->조용하고 말이 없으나 마음이 깊고 따뜻하다
		<br><!-- * -->친구나 주변상황에 민감하고 영향 많이 받음
		<br><!-- * -->민감한 정서세계, 동정심이 많다. 사려깊다.
		<br><!-- * -->약간 느리며 꾸준하지 못하다.
		<br><!-- * -->실천력이 부족하다. 낮잠을 좋아함
		<br><!-- * -->좋아하는 것과 그렇지 않은 것 사이에 차이가 많이 난다.
		<br><!-- * -->온화하고 부드럽다. 자신의 가치를 중시한다.
		<br><!-- * -->학교 생활 패턴에 따라가지 못하다.
		<br><!-- * -->상징에 대한 해석이 뛰어나다.
		<br><!-- * -->교사입장: 기다림이 필요한 아이다.
	</c:if>
	<c:if test="${test.result eq 'INTP'}">
		<br><!-- * -->만물박사, 논리적, 호기심이 많다.
		<br><!-- * -->주관이 강하고 고집이 세다. 솔직함
		<br><!-- * -->자기중심적, 간섭이나 잔소리를 싫어함
		<br><!-- * -->주별의 상황에 영향을 받지 않는다.
		<br><!-- * -->정리정돈을 잘 하지 못한다. 감정이 단순함
		<br><!-- * -->잘못된 일은 꼭 지적한다. 학급에서 외통이
		<br><!-- * -->과학영역에 관심이 많다. 운동을 싫어함
		<br><!-- * -->잘난척하는 경향이 있다.
		<br><!-- * -->못하는 친구를 무시하지 경향이 있다.
		<br><!-- * -->관심이 없는 영역은 하지 않는다.
		<br><!-- * -->앎을 나누지 못하는 고독, 교사의 믿음이 중요
	</c:if>
	<c:if test="${test.result eq 'ENFP'}">
		<br><!-- * -->순진하고 순수하다.
		<br><!-- * -->변덕쟁이, 기발하다.
		<br><!-- * -->분위기만 맞으면 과잉행동
		<br><!-- * -->좋아하는 것과 그렇지 않은 것 사이에 집중력의
		차이가 난다.
		<br><!-- * -->딴 생각을 잘한다.
		<br><!-- * -->칭찬에 민감하다.
	</c:if>
	<c:if test="${test.result eq 'ENTP'}">
		<br><!-- * -->활발하며 독창적이다.
		<br><!-- * -->상상력과 표현력이 뛰어나다.
		<br><!-- * -->친구들과 잘 어울린다.
		<br><!-- * -->게으르다. 정리정돈이 안된다.
		<br><!-- * -->개인주의적 경향, 고집이 강하다.
		<br><!-- * -->다방면에 관심을 가진 분야가 많다.
		<br><!-- * -->반복 설명은 질색 자기논리에 빠지기 쉽다
		<br><!-- * -->용돈이 헤프다.
		<br><!-- * -->사람을 좋아한다.
		<br><!-- * -->반복 훈련 연습을 싫어한다.
		<br><!-- * -->정리정돈이 안된다.
		<br><!-- * -->쉽게 포기하는 편이다. 마무리가 약함
		<br><!-- * -->친구를 리더하려고 한다.
		<br><!-- * -->교사의 권위에 대해 인정하지 못한다.
		<br><!-- * -->교사가 자기를 인정하는 걸 좋아함.
	</c:if>
	<c:if test="${test.result eq 'ENFJ'}">
		<br><!-- * -->온순하고 착하다.
		<br><!-- * -->책임감이 강하고 신뢰감을 준다.
		<br><!-- * -->주변상황에 영향을 많이 받는다.
		<br><!-- * -->정리정돈을 잘한다.
		<br><!-- * -->딴 세계에 빠져있을 때가 종종 있다.
		<br><!-- * -->예능적인 분야를 좋아한다.
		<br><!-- * -->특정 분야는 지나칠 정도로 진지하다.
		<br><!-- * -->참을성이 많다.
		<br><!-- * -->친구들과 잘 어울린다.
		<br><!-- * -->뜻밖의 행동으로 주변을 놀라게 한다.
		<br><!-- * -->터질 것 같은 화산을 마음에 품고 사는 아이
	</c:if>
	<c:if test="${test.result eq 'ENTJ'}">
		<br><!-- * -->원리원칙주의자 (자기 주관이 강함)
		<br><!-- * -->활발하다.
		<br><!-- * -->논리적인 언어표현
		<br><!-- * -->고집이 강하다.
		<br><!-- * -->간섭을 싫어함
		<br><!-- * -->잘못된 것, 부당한 것은 꼭 바로 잡고 넘어감
		<br><!-- * -->철저한 준비자세
		<br><!-- * -->통솔력
		<br><!-- * -->계획하고 마음 먹은 것은 해낸다.
		<br><!-- * -->교사가 인정해주는 것이 필요하다.
	</c:if>
	</div>
	

	<br>

	<div class="btn"><a  href="BoardList.do">다른 결과 보러가기</a></div>
<%@include file="/common/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
body * {
	font-family: 'Jua';
}
</style>
</head>
<body>
	<h5 class="alert alert-success">비트캠프 사원 목록</h5>
	<!-- table을 이용해서 사원목록 출력하기 -->
	<!-- 번호 / 사진 / 사원명 / 부서명 / 나이 / 입사일 순서로 출력하세요-->
	<fmt:requestEncoding value="utf-8" />
	<form action="./sawon" method="post">
		<b>부서명 입력</b> <input type="text" name="search" style="width: 120px"
			value="${param.search}">
		<!-- value가 있으면 입력 값 남아있음 -->
		<button type="submit">검색</button>
	</form>
	<hr>
	<h2>${param.search}부서 직원 검색 결과</h2>
	<table class="table table-bordered" style="width: 90%">
		<tr class="table-success">
			<th>번호</th>
			<th>사원번호</th>
			<th>사진</th>
			<th>사원명</th>
			<th>부서명</th>
			<th>나이</th>
			<th>입사일</th>
		</tr>
		<c:forEach var="dto" items="${list}" varStatus="i">
			<!-- 부서명을 적은 경우 --><!-- empty param.search는 첫 실행에 아무것도 안적혀 있을 경우에도 전부 출력할 수 있게 함 -->
			<c:if test="${dto.buseo == param.search || empty param.search || param.search == ''}">
				<tr>
					<td>
						<!-- 번호 --> 
						${i.count}
					</td>
					<td>
						<!-- 번호 --> 
						${dto.num}
					</td>
					<td>
						<!-- 사진 --> 
						<c:if test="${dto.photo =='no'}">
							<img alt="" src="../image/noimage1.png"style="width: 40px; height: 40px; border: 1px solid gray;">
						</c:if> 
						<c:if test="${dto.photo !='no'}">
							<img alt="" src="${dto.photo}" style="width: 40px; height: 40px; border: 1px solid gray;">
						</c:if>
					</td>
					<td>
						<!-- 사원명 --> 
						${dto.name}
					</td>
					<td>
						<!-- 부서명 --> 
						${dto.buseo}
					</td>
					<td>
						<!-- 나이 --> 
						${dto.age}세
					</td>
					<td>
						<!-- 입사일 --> 
						${dto.birthday}
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<!-- NCP사용을 위해 새로 추가 -->
<c:set var="stpath" value="https://kr.object.ncloudstorage.com/bitcamp-bucket-56/photocommon"></c:set>

<body>
	<h2 class="alert alert-danger" style="width: 500px;">
		총 ${totalCount }명의 회원이 있습니다. <span style="float: right;">
			<button type="button" class="btn btn-sm btn-success"
				onclick="location.href='./form'">멤버등록</button>
		</span>
	</h2>
	<div>
		<!-- admin이 아닌 계정으로 로그인을 했거나 로그인 상태가 아닐 경우 보여질 메시지 -->
		<%-- 
		<c:if test="${sessionScope.loginok == null or sessionScope.loginid != 'admin'}">
			<h2>
				<b>
					전체 회원 명단은 관리자만 확인 가능합니다.
				</b>
			</h2>
		</c:if> 
		--%>

		<!-- admin계정으로 로그인 시에만 전체 명단 확인 가능 -->
		<%-- <c:if test="${sessionScope.loginok != null and sessionScope.loginid == 'admin'}"> --%>
			<table class="table table-striped" style="width: 500px;">
				<caption align="top">
					<h3><b>쌤이 만든 회원명단</b></h3>
				</caption>
				<tr class="table-danger">
					<td width="50">번호</td>
					<td width="120">회원명</td>
					<td width="100">아이디</td>
					<td width="120">핸드폰</td>
					<td>상세보기</td>
				</tr>
				<c:forEach var="dto" items="${list}" varStatus="i">
					<tr>
						<td align="center">${i.count}</td>
						<!-- ==========================../save를 ${stpath}로 수정했음======================= -->
						<td>
							<!-- <img src="../save/${dto.photo}" class="rounded-circle"
							style="width: 40px; height: 40px;"
							onerror="this.src='../image/noimage1.png'"> ${dto.name} -->
							<img src="${stpath}/${dto.photo}" class="rounded-circle"
							style="width: 40px; height: 40px;"
							onerror="this.src='../image/noimage1.png'"> ${dto.name}
						</td>
						<td>${dto.myid}</td>
						<td>${dto.hp}</td>
						<td align="center">
							<!-- 여기 detail?num이어야 함 -->
							<button type="button" class="btn btn-sm btn-info"
								onclick="location.href='./detail?num=${dto.num}'">Detail</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		<%-- </c:if> --%>
	</div>
	<!-- 
<div>
	<h2 align="center">내가 만든 회원명단</h2>
		<table class="table table-bordered">
			<tr align="center" class="table-danger">
				<td>번호</td>
				<td>회원명</td>
				<td>아이디</td>
				<td>핸드폰</td>
				<td>상세보기</td>
			</tr>
			<c:forEach var="dto" items="${list}">
				<tr align="center">
					<td>${item.num}</td>
					<td>
						<img src="../save/${dto.photo}" style="width:40px; height:40px; border-radius: 50%; border: 1px solid black;"
						onerror="this.src='../image/noimage1.png'">
						&nbsp;
						${dto.name}
					</td>
					<td>${dto.myid}</td>
					<td>${dto.hp}</td>
					<td>
						<button type="button" class="btn btn-sm btn-success" onclick="location.href='./detail?num=${dto.num}'">Detail</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
-->
</body>
</html>
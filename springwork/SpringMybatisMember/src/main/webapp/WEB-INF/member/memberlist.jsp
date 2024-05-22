<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
   <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
   <style>
       body *{
           font-family: 'Jua';
       }
   </style>
</head>
<body>
<!-- <h1>MemberList</h1> -->
<h2 class="alert alert-danger">
	총 ${totalCount }명의 회원이 있습니다.
	<span style="float: right;">
		<button type="button" class="btn btn-sm btn-success" onclick="location.href='./form'">멤버등록</button>
	</span>
</h2>
<div>
	<table class="table table-striped" style="width:500px;">
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
				<td>
					<img src="../image/${dto.photo}" class="rounded-circle" style="width: 40px; height:40px;">
					${dto.name}
				</td>
				<td>${dto.myid}</td>
				<td>${dto.hp}</td>
				<td align="center">
				<!-- 여기 detail?num이어야 함 -->
					<button type="button" class="btn btn-sm btn-info" onclick="location.href='./detail?num=${dto.num}'">Detail</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
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
			<c:forEach var="item" items="${list}">
				<tr align="center">
					<td>${item.num}</td>
					<td>
						<img src="../image/${item.photo}" style="width:40px; height:40px; border-radius: 50%; border: 1px solid black;">
						&nbsp;
						${item.name}
					</td>
					<td>${item.myid}</td>
					<td>${item.hp}</td>
					<td>
					<!-- 여기 detail?num이어야 함 -->
						<button type="button" class="btn btn-sm btn-success" onclick="location.href='./detail?num=${item.num}'">Detail</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
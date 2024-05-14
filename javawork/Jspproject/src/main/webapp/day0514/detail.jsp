<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
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
	<table>
		<tr>
			<td><h2>${dto.subject}</h2></td>
		</tr>
		<tr>
			<td>
				<b>${dto.writer}</b>
			</td>
			<td>
				<font color="gray">${dto.writeday}</font>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<font color="gray">조회 : ${dto.readcount}</font>
				<hr>
			</td>
		</tr>
		<tr>
			<td>
				<img src="../image/s${dto.avata}.JPG" width="100" height="100" border="1">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<pre style="font-size: 20px">${dto.content}</pre>
				<!-- DB에 저장되는 형태도 \n으로 저장은 되지만, <br>이 아니라 줄넘김이 발생하지 않음! -->
				<!-- pre 태그 사용하면 자동 줄넘김 제공 -->
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<hr>
				<button class="btn btn-sm btn-success">글쓰기</button>
				<button class="btn btn-sm btn-success">수정</button>
				<button class="btn btn-sm btn-success">삭제</button>
				<button class="btn btn-sm btn-success" onclick="location.href='../board/list'">목록</button>
				<hr>
			</td>
		</tr>
	</table>
</body>
</html>
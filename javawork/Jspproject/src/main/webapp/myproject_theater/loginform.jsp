<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div style="position: relative; height: 100vh;">
		<form action="./loginaction.jsp" method="post">
			<table class="table table-bordered"
				style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); width: 400px">
				<tr>
					<td colspan="2" align="center">사용자 로그인</td>
				</tr>
				<tr>
					<td align="center" style="width: 200px">아이디</td>
					<td style="width: 200px"><input type="text" name="username"
						required="required"></td>
				</tr>
				<tr>
					<td align="center" style="width: 200px">비밀번호</td>
					<td style="width: 200px"><input type="password"
						name="password" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button style="width: 100%;">로그인</button>
					</td>
				</tr>
				<tr>
					<td style="width: 200px">
						<button style="width: 100%;"
							onclick="location.href='signupform.jsp'">회원가입</button>
					</td>
					<td style="width: 200px">
						<button style="width: 100%;"
							onclick="location.href='findidpwform.jsp'">아이디/비밀번호 찾기</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
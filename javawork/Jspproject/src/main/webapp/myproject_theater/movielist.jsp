<%@page import="data.dto.MovieDto"%>
<%@page import="data.dao.MovieDao"%>
<%@page import="java.util.List"%>
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
	/*font-family: 'Jua';*/
	
}

.container {
	width: 100%; /* 각 요소의 너비 설정 */
	overflow-x: hidden; /* 가로 스크롤 추가 + 숨기기*/
	white-space: nowrap; /* 요소들이 줄 바꿈되지 않고 한 줄에 표시되도록 설정 */
}

.list {
	display: inline-block; /* 요소들을 가로로 나열 */
	margin-right: 10px; /* 각 요소 사이의 간격 설정 */
}

.dark {
	filter: brightness(50%);
	transition: filter 0.3s;
}
</style>
<script>
	// 왼쪽 오른쪽 자동으로 스크롤 이동 함수
	var right_direction = true;
	function autoScroll() {
		var scrollContainer = document.querySelector('.container');
		if (right_direction == true) {
			scrollContainer.scrollLeft += 2; // 스크롤 속도 조절 가능
			// 스크롤이 오른쪽 끝에 도달하면 왼쪽 끝으로 이동
			if (scrollContainer.scrollLeft >= (scrollContainer.scrollWidth
					- scrollContainer.clientWidth - 2)) {
				right_direction = false;
			}
		} 
		else//right_direction == false;
		{
			scrollContainer.scrollLeft -= 1; // 스크롤 속도 조절 가능//오른쪽 스크롤이 왼쪽 스크롤보다 더 빠르게 느껴짐//그래서 속도 조절
			// 스크롤이 왼쪽 끝에 도달하면 오른쪽 끝으로 이동
			if (scrollContainer.scrollLeft < 2) {
				right_direction = true;
			}
		}
	}
	// Nms마다 autoScroll 함수 호출하여 자동으로 스크롤 이동
	setInterval(autoScroll, 20);

	function darkenImage(img) {
		img.classList.add('dark');
	}

	function normalizeImage(img) {
		img.classList.remove('dark');
	}
</script>
</head>
<body>
	<div>
		<br>
		<h1 style="text-align: center;">개봉, 상영 중인 영화 소개</h1>
		<br>
	</div>
	<div style="text-align: right;">
		<button type="button" onclick="location.href='insertform.jsp'">영화추가</button>
		<button type="button" onclick="location.href='loginform.jsp'">로그인</button>
		<!-- 사용자 : manager1 -->
		<!-- 이후 추가기능 -->
		&nbsp;&nbsp;&nbsp;
	</div>
	<div style="background-color: black">
		<br> <br>
		<div class="container">
			<!-- 가로 스크롤을 감싸는 컨테이너 -->
			<%
			//dao 선언
			MovieDao dao = new MovieDao();
			//list 가져오기
			List<MovieDto> list = dao.getAllMovies();
			%>
			<div>
				<%
				for (MovieDto dto : list) {
				%>
				<div class="list">
					<label type="button"
						onclick="location.href='moviedetail.jsp?num=<%=dto.getNum()%>'"
						onmouseover="darkenImage(this)" onmouseout="normalizeImage(this)">
						<img src='../save/<%=dto.getPoster()%>'
						style="width: 200px; height: 300px;">
						<div class="title" align="center" style="color: white">
							<b><%=dto.getTitle()%></b>
						</div>
						<div class="genre" align="center" style="color: white">
							<%=dto.getGenre()%>
						</div>
					</label>
				</div>
				<%}
				%>
			</div>
		</div>
	</div>

	<script>
	//마우스 휠 이벤트 추가
		document.querySelector(".container").addEventListener("wheel",function(event) 
		{
			if (event.deltaY !== 0) 
			{
				event.preventDefault();
				this.scrollLeft += event.deltaY;
			}
		});
	</script>
</body>
</html>

<%@page import="data.dto.MovieDto"%>
<%@page import="data.dao.MovieDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
//num
int num = Integer.parseInt(request.getParameter("num"));
//dao
MovieDao dao = new MovieDao();
//dto
MovieDto dto = dao.getData(num);
%>

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
body {
	/*font-family: 'Jua';*/
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
</script>
</head>

<body>
	<div
		style="display: flex; justify-content: center; align-items: center;">
		<!-- 예고편 자동재생 -->
		<iframe width="90%" height="400px"
			src="<%=dto.getAnnouncementyoutube()%>?autoplay=1&mute=1"
			title="YouTube video player" frameborder="0"
			allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
			referrerpolicy="strict-origin-when-cross-origin" allowfullscreen>
		</iframe>
	</div>

	<div style="position: fixed; bottom: 10px; right: 10px;">
		<!-- 정보 조작 버튼 -->
		<button onclick="history.back()">전체보기</button>
		<button onclick="location.href='updateform.jsp?num=<%=dto.getNum()%>'">영화
			정보 수정</button>
		<button onclick="location.href='updateform.jsp?num=<%=dto.getNum()%>'">영화
			스틸컷 추가</button>
		<!-- <button onclick="location.href='deleteaction.jsp?num=<%=dto.getNum()%>'">영화 내용 삭제</button> -->
		<button onclick="confirmDelete()">영화 내용 삭제</button>
		<!-- 삭제 누르면 alert 발생 -->
	</div>

	<div style="">
	<br>
		<table class="table table-bordered" style="height: 150px;">
			<tr>
				<h3>
					<i >
						<b style="font-size:40px">
							<%=dto.getTitle() %><nbsp><nbsp>
						</b>
					</i>
					영화정보
				</h3>
			</tr>
			<tr>
				<td style="width: 50px"><b>장르</b>
				</td>
				<td style="width: 100px"><b><%=dto.getGenre()%></b><br>클릭시 동일 장르 영화 탐색 기능 추가</td>
				<td rowspan='3' style="width: 200px">
					<div>
						<%=dto.getIntroduce()%>
					</div>
				</td>
			</tr>
			<tr>
				<td><b>감독</b>
				</td>
				<td><b><%=dto.getDirector()%></b><br>클릭시 동일 감독 영화 탐색 기능 추가</td>
			</tr>
			<tr>
				<td><b>출연</b>
				</td>
				<td><b><%=dto.getActors()%></b><br>클릭시 동일 출연진 영화 탐색 기능 추가</td>
			</tr>
		</table>
	</div>
	<div style="background-color: black">
	<div class="container" style="overflow-x: auto; white-space: nowrap; background-color: black">
		<%
		for (int i = 1; i <= 9; i++) {
		%>
		<img
			style="width: 200px; height: 300px; display: inline-block; margin-right: 10px;"
			alt="" src="../save/crimecity (<%=i%>).jpg">
		<%
		}
		%>
	</div>
	</div>

	<script>
    function confirmDelete() {
    // 확인 메시지 표시
        if (confirm("영화 내용을 삭제하시겠습니까?")) 
        {
        // 확인 버튼 클릭 시 삭제 진행
        	location.href = 'deleteaction.jsp?num=<%=dto.getNum()%>';
			}
		};
	</script>
	<script>
	//마우스 휠 이벤트 추가
		document.querySelector(".container").addEventListener("wheel",
				function(event) {
					if (event.deltaY !== 0) {
						event.preventDefault();
						this.scrollLeft += event.deltaY;
					}
				});
	</script>
</body>
</html>
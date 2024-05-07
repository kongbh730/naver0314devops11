<%@page import="data.dto.MovieDto"%>
<%@page import="data.dao.MovieDao"%>
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

#showimg {
	position: absolute;
	top: 100px;
	left: 450px;
	width: 200px;
}
</style>

<script type="text/javascript">
    function preview(tag)
    {
    	//파일 업로드 미리보기 함수
        if(tag.files[0])
        {
            let f = tag.files[0];
            if(!f.type.match("image.*"))
            {
                alert("이미지 파일만 가능합니다.");
                return;
            }
            if(f)
            {
                let reader = new FileReader();
                reader.onload = function(e){
                    $("#showimg").attr("src", e.target.result);
                }
                reader.readAsDataURL(tag.files[0]);
            }
        }
    }
    </script>
</head>
<%
	//num 읽기
	int num=Integer.parseInt(request.getParameter("num"));
	//dao 선언
	MovieDao dao=new MovieDao();
	//dto 얻기
	MovieDto dto=dao.getData(num);
%>
<body>
	<!-- 영화 포스터 업로드 -->
	<div style="margin: 20px; width: 400px">
		<!-- 파일 업로드 시 enctype="multipart/form-data" 필수!!!! -->
		<form action="updateaction.jsp" method="post"
			enctype="multipart/form-data">
			<input type="hidden" name="num" value="<%=num%>">
			<table class="table table-bordered">
				<caption align="top">
					<b>개봉한 영화 정보 수정</b>
				</caption>
				<tr>
					<th width="100">제목</th>
					<td><input type="text" name="title" required="required" value="<%=dto.getTitle() %>">
					</td>
				</tr>
				<tr>
					<th width="100">포스터 업로드</th>
					<td><input type="file" name="poster" onchange="preview(this)"
						style="width: 200px;" required="required"></td>
				</tr>
				<tr>
					<th>광고 주소</th>
					<td colspan="2"><input type="text" name="announcementyoutube"
						required="required" value="<%=dto.getAnnouncementyoutube()%>"></td>
				</tr>
				<tr>
					<th>장르</th>
					<td colspan="2">
						<select name="genre" multiple>
							<option hidden="hidden">장르 선택</option>
							<option>액션</option>
							<option>전쟁</option>
							<option>SF</option>
							<option>판타지</option>
							<option>로맨스</option>
							<option>드라마</option>
							<option>공포/오컬트</option>
							<option>코미디</option>
							<option>애니메이션</option>
							<option>스릴러</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>소개</th>
					<td colspan="2"><input type="text" name="introduce"
						required="required" value="<%=dto.getIntroduce()%>"></td>
				</tr>
				<tr>
					<th>감독</th>
					<td colspan="2"><input type="text" name="director"
						required="required" value="<%=dto.getDirector()%>"></td>
				</tr>
				<tr>
					<th>출연배우</th>
					<td colspan="2"><input type="text" name="actors"
						required="required" value="<%=dto.getActors()%>"></td>
				</tr>
				<!-- 
				<tr>
					<th>개봉일</th>
					<td colspan="2"><input type="date" name="releaseday"
						required="required"></td>
				</tr>
				 -->
				<tr>
					<td colspan="2" align="center">
						<button type="submit">내용 수정</button>
						<button onclick="history.back()">취소</button>
					</td>
				</tr>
			</table>
		</form>
		<img id="showimg" src="" onerror="this.src='../save/<%=dto.getPoster()%>'">
		<!-- 미리보기용 없으면 무한 로딩됨! -->
	</div>
</body>
</html>
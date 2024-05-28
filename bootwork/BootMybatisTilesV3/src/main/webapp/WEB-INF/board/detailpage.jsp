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
<body>
	<div style="width:70%;">
	<h1>내가 만든거</h1>
		<!-- 제목 + 프로필 이미지 + 이름 + 작성일 + 조회수 -->
		<div>
			<h3>${dto.subject}</h3>
			<table class="table table-bordered"><!-- 나중에 처리 -->
				<tr>
					<td rowspan="2" style="width:60px;">
						<img id="profile_photo" src="../save/${profile_photo}" 
						style="width:50px; heigth:50px; border: 1px solid gray" class="rounded-circle">
					</td>
					<td>
						<b>${dto.writer}</b>
					</td>
				</tr>
				<tr>
					<td style="color: gray">
						<fmt:formatDate value="${dto.writeday}" pattern="yyyy.MM.dd. HH:mm" />
						&nbsp;&nbsp;조회&nbsp;${dto.readcount}
					</td>
				</tr>
			</table>
		</div>
		<hr>
		<!-- 내용 + 사진 -->
		<div>
			<img alt="" src="../save/${dto.uploadphoto}" onerror="this.src='../image/noimage2.png'"><!-- onerror 이게 출력한다는 뜻은 아님! -->
			<pre>${dto.content}</pre>
		</div>

		<!-- 댓글 -->
		<div>
			<textarea name="content" required="required" 
			style="width:100%; height:100px; border: 2px solid gray; border-radius: 10px;" 
			placeholder="댓글을 남겨보세요."></textarea>
		</div>

		<!-- 버튼 -->
		<div>
			<!-- 새 글쓰기 -->
			<button type="button" class="btn btn-sm btn-success" onclick="location.href='.from'">
				<i class="bi bi-pencil"></i>&nbsp;글쓰기
			</button>
			
			<!-- 답글 -->
			<button type="button" class="btn btn-sm btn-secondary" 
			onclick="location.href='./form?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}&currentPage=${currentPage}'">
			답글</button>
			<!-- 로그인 본인일 경우에만 수정, 삭제 버튼 보이게 -->
			<c:if test="${sessionScope.loginok != null and sessionScope.loginid == dto.myid}">
				<!-- 수정 -->
				<button type="button" class="btn btn-sm btn-secondary" onclick="location.href='./updateform?num=${dto.num}&currentPage=${currentPage}'">수정</button>
				
				<!-- 삭제 -->
				<button type="button" class="btn btn-sm btn-secondary" onclick="del()">삭제</button>
			</c:if>
			<button type="button" class="btn btn-sm btn-secondary" onclick="location.href='./list?currentPage=${currentPage}'">목록</button>
		</div>
	</div>
<hr>
	<div>
	<h1>쌤이 만든거</h1>
		<table class="table" style="width: 500px;">
	<tr>
		<td>
			<h2><b>${dto.subject}</b></h2>
			<!-- 프로필 사진 -->
			<img src="../save/${profile_photo}"
			  onerror="this.src='../image/noimage2.png'"
			  style="width: 45px;height: 45px;margin-right:5px;"
			  class="rounded-circle" align="left">
			  <b>${dto.writer}</b><br>
			  <span style="color: gray;font-size: 13px;">
			  	<fmt:formatDate value="${dto.writeday}"
			  	pattern="yyyy.MM.dd HH:mm"/>
			  	 &nbsp; &nbsp;
			  	 조회 &nbsp;${dto.readcount}
			  </span>
			  <span style="float: right;color: gray;">
			  	<i class="bi bi-chat-dots"></i>
			  	&nbsp;
			  	댓글 0
			  </span>
		</td>
	</tr>
	<tr>
		<td>
			<c:if test="${dto.uploadphoto != 'no'}"><!-- uploadphoto가 'no'가 아니면 해당 photo 출력 -->
				<img src="../save/${dto.uploadphoto}"
				onerror="this.src='../image/noimage2.png'"
				style="max-width: 300px;">
				<br><br> <!-- onerror 이게 출력한다는 뜻은 아님! -->
			</c:if>
			<pre style="font-size: 17px;">${dto.content}</pre>
		</td>
	</tr>
	<tr>
		<td class="buttons">
		    <!-- 새글 -->
			<button type="button" class="btn btn-sm btn-outline-success"
			onclick="location.href='./form'">
			<i class="bi bi-pencil-fill"></i>
			글쓰기</button>
			
			<!-- 답글 -->
			<button type="button" class="btn btn-sm btn-outline-secondary"
			onclick="location.href='./form?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}&currentPage=${currentPage}'">			
			답글</button>
			
			<!-- 수정,삭제는 로그인중이며 자기가ㅏ 쓴글에만 나타나게 하기 -->
			<c:if 
			test="${sessionScope.loginok!=null and sessionScope.loginid==dto.myid}">
				<button type="button" class="btn btn-sm btn-outline-secondary"
					onclick="location.href='./updateform?num=${dto.num}&currentPage=${currentPage}'">			
					수정</button>
					
				<button type="button" class="btn btn-sm btn-outline-secondary"
					onclick="del()">			
					삭제</button>
			</c:if>
			
			<button type="button" class="btn btn-sm btn-outline-secondary"
					onclick="location.href='./list?currentPage=${currentPage}'">			
					목록</button>
		</td>
	</tr>
</table>
	</div>
	<script type="text/javascript">
		function del()
		{
			let num = ${dto.num};
			let currentPage = ${currentPage};
			
			let a = confirm("정말 삭제하시겠습니까?");
			if(a)
			{
				location.href="./delete?num=" + num + "&currentPage=" + currentPage;
			}
		}
	</script>
</body>
</html>

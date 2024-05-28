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
<div class="input-group" style="width: 600px;margin-bottom: 20px;">
	<h5>총 ${totalCount} 개의 글이 있습니다.</h5>
	<!-- 글쓰기 버튼은 로그인을 해야만 보임 -->
	<c:if test="${sessionScope.loginok != null}">
		<button type="button" class="btn btn-outline-success"
			style="width: 100px; margin-left: 100px"
			onclick="location.href='./form'">글쓰기</button>
	</c:if>
</div>
	<table class="table table-striped" style="width: 600px;">
		<tr>
			<th width="50">번호</th>
			<th width="270">제목</th>
			<th width="100">작성자</th>
			<th width="120">작성일</th>
			<th>조회</th>
		</tr>
		<!-- 글이 없는 경우 -->
		<c:if test="${totalCount == 0}">
			<tr height="60">
				<td colspan="5" align="center" valign="middle"><b
					style="font-size: 22px;"> 등록된 글이 없습니다. </b></td>
			</tr>
		</c:if>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>
					<!-- 번호 --> ${no } <c:set var="no" value="${no-1 }" />
				</td>
				<td>
					<!-- 제목 --> 
					<a href="./detail?num=${dto.num}&currentPage=${currentPage}"> <!-- relevel 한개당 두칸 띄우기 -->
						<c:forEach begin="1" end="${dto.relevel}">
							&nbsp;&nbsp;
						</c:forEach>
						<!-- 답글일 경우 답글 이미지 --> 
						<c:if test="${dto.restep>0}">
						<img src="../image/re.png">
						</c:if> 
						${dto.subject}
						<!-- 사진이 있으면 photo아이콘 제목 끝에 회색으로 출력되도록 -->
						<c:if test="${dto.uploadphoto != 'no'}">
							<i class="bi bi-image" style="color : gray;"></i>
						</c:if>
					</a>
				</td>
				<td>
					<!-- 작성자 --> 
					${dto.writer }
				</td>
				<td>
					<!-- 작성일 --> <!--${dto.writeday}--> 
					<fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd" />
				</td>
				<td>
					<!-- 조회 --> 
					${dto.readcount }
				</td>
			</tr>
		</c:forEach>
	</table>

	<!-- 작성자, 작성일, 조회수, 서블릿 페이징 처리 -->
	<div style="width: 600px; text-align: center; font-size: 22px;">
		<!-- 이전 : startPage가 1보다 클 경우 이전이 보이도록 설정  -->
		<!-- 이전을 클릭할 경우 전 블럭의 마지막 페이지가 현재페이지가 되어야 한다. -->
		<c:if test="${startPage > 1}">
			<a href="./list?currentPage=${startPage - 1}"
				style="text-decoration: none; color: black;">( &lt; == <) 이전</a>
		</c:if>

		<!-- 페이지 번호 출력 -->
		<c:forEach var="pp" begin="${startPage}" end="${endPage}">
			<a href="./list?currentPage=${pp}"
				style="text-decoration: none; color:${currentPage == pp ? 'red' : 'black'}">
				${pp} </a>&nbsp;
		</c:forEach>

		<!-- 다음 : endPage가 totalPage보다 작다면 다음이 필요하다. -->
		<!-- 다음을 누를경우 다음블럭의 첫페이지가 현재 페이지가 되어야만 한다. -->
		<c:if test="${endPage < totalPage}">
			<a href="./list?currentPage=${endPage + 1}"
				style="text-decoration: none; color: black;">다음 ( &gt; == >)</a>
		</c:if>
	</div>
</body>
</html>

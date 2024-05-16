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
	<!-- 내가 만든 detail -->
	<div>
		<h2>내가 만든 detail</h2>
		<table>
			<tr>
				<td><h2>${dto.subject}</h2></td>
			</tr>
			<tr>
				<td><b>${dto.writer}</b></td>
				<td><font color="gray">${dto.writeday}</font></td>
			</tr>
			<tr>
				<td>
				<font color="gray">조회 : ${dto.readcount}</font> 
				<span>추천 : </span>
				<span class="chu">${dto.chu}</span><i class="bi bi-hand-thumbs-up mychu" style="font-size: 20px; cursor: pointer;"></i>
				<hr>
				</td>
			</tr>
			<tr>
				<td><img src="../image/s${dto.avata}.JPG" width="100"
					height="100" border="1"></td>
			</tr>
			<tr>
				<td colspan="2"><pre style="font-size: 20px">${dto.content}</pre>
					<!-- DB에 저장되는 형태도 \n으로 저장은 되지만, <br>이 아니라 줄넘김이 발생하지 않음! --> <!-- pre 태그 사용하면 자동 줄넘김 제공 -->
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<hr>
					<button type="button" class="btn btn-sm btn-success"
						onclick="location.href='./form'">글쓰기</button>

					<button type="button" class="btn btn-sm btn-success"
						onclick="location.href='./updateform?num=${dto.num}&currentPage=${currentPage}'">수정</button>

					<button type="button" class="btn btn-sm btn-success"
						onclick="del()">삭제</button>

					<button type="button" class="btn btn-sm btn-success"
						onclick="location.href='../board/list'">내가 만든 목록</button>

					<button type="button" class="btn btn-sm btn-success"
						onclick="location.href='./list?currentPage=${currentPage}'">목록</button>
					<hr>
				</td>
			</tr>
		</table>
	</div>

	<!-- 쌤이 만든 detail -->
	<div style="margin: 30px;">
	<h2>쌤이 만든 detail</h2>
		<table class="table" style="width: 400px;">
			<tr>
				<td>
					<h2>
						<b>${dto.subject}</b>
					</h2>
					<div>
						<b>${dto.writer}</b> <span
							style="color: gray; font-size: 16px; float: right"> <fmt:formatDate
								value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm" />
						</span>
					</div> <b style="color: gray; clear: both;">조회 : ${dto.readcount}</b> <b
					style="margin-left: 10px; color: gray;">추천 &nbsp;<span
						class="chu">${dto.chu}</span></b> &nbsp; <i
					class="bi bi-hand-thumbs-up mychu"
					style="font-size: 20px; cursor: pointer;"></i> <br>
				</td>
			</tr>
			<tr>
				<td><img src="../image/s${dto.avata}.JPG"> <br> <pre
						style="font-size: 22px;">${dto.content}</pre></td>
			</tr>
			<tr>
				<td align="center">
					<button type="button" class="btn btn-sm btn-success"
						style="width: 80px;" onclick="location.href='./form'">글쓰기</button>

					<button type="button" class="btn btn-sm btn-success"
						style="width: 80px;"
						onclick="location.href='./updateform?num=${dto.num}&currentPage=${currentPage}'">수정</button>

					<button type="button" class="btn btn-sm btn-success"
						style="width: 80px;" onclick="del()">삭제</button>

					<button type="button" class="btn btn-sm btn-success"
						style="width: 80px;"
						onclick="location.href='./list?currentPage=${currentPage}'">목록</button>
				</td>
			</tr>
		</table>
	</div>

	<script type="text/javascript">
		function del()
		{
			let num = ${dto.num};
			let cp = ${currentPage};
			console.log(num, cp);
			
			let a = confirm("해당 게시글을 삭제하시겠습니까?");
			if(a)
			{
				location.href=`./delete?num=\${num}&currentPage=\${cp}`;// '\'를 쓰는 이유 정리!		
			}
		}
		
		//추천클릭시 숫자 증가
		$(".mychu").click(function(){
			let num = ${dto.num};
			$.ajax({
				type:"get",
				dataType:"json",
				data:{"num":num},
				url:"./updatechu",
				success:function(data){
					$("span.chu").text(data.chu);
				}
			});
		});
	
	</script>
</body>
</html>
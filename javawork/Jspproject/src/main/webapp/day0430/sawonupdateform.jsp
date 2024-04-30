<%@page import="data.dto.SawonDto"%>
<%@page import="data.dao.SawonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        
        img.photo{
        	position: absolute;
        	left: 340px;
        	top: 250px;
        	width: 150px;
        	border: 2px solid gray;
        }
        
    </style>
</head>
<%
	//shopidx int 타입으로 읽기
	int num = Integer.parseInt(request.getParameter("num"));
	//dao 선언
	SawonDao dao = new SawonDao();
	//dto 가져오기
	SawonDto dto = dao.getData(num);
%>
<body>
	<div style="margin: 20px; width: 300px;">
		<form action="./sawoninsert.jsp" method="post">
		
		<!-- hidden : 서버 전송시 각 상품에 대한 인덱스 값이 같이 보내져야 한다. -->
		<input type="hidden" name="num" value="<%=num %>">
		
			<table class="table table-bordered">
				<caption align="top">
					<h5 class="alert alert-warning">사원정보수정</h5>
				</caption>
				<tr>
					<th width="100" class="table-danger">사원명</th>
					<td>
						<input type="text" name="name" class="form-control" required="required" value="<%=dto.getName()%>">
					</td>
				</tr>
				<tr>
					<th width="100" class="table-danger">나이</th>
					<td>
						<input type="number" name="age" class="form-control" required="required" min="1" max="100" step="1" value="<%=dto.getAge() %>"><!-- 초기값은 0 -->
					</td>
				</tr>
				<tr>
					<th width="100" class="table-danger">주소</th>
					<td>
						<input type="text" name="addr" class="form-control" required="required" value="<%=dto.getAddr() %>">
					</td>
				</tr>
				<tr>
					<th width="100" class="table-danger">부서</th>
					<td>
						<select class="form-select" name="buseo" value="<%=dto.getBuseo() %>">
							<option>교육부</option>
							<option>인사부</option>
							<option>홍보부</option>
							<option>해외파견부</option>							
						</select>						
					</td>
				</tr>
				<tr>
					<th width="100" class="table-danger">성별</th>
					<td>
						<label>
							<input type="radio" name="gender" value="남자" <%=(dto.getGender().equals("남자") ? "checked = 'checked'" : "" )%>>남자
						</label>
						<label>
							<input type="radio" name="gender" value="여자" <%=(dto.getGender().equals("여자") ? "checked = 'checked'" : "" )%>>여자
						</label>										
					</td>
				</tr>
				
				<tr>
					<th width="100" class="table-danger">프로필사진</th>
					<td>
						<select class="form-select" name="photo" id="photo">
							<option value="no">프로필사진없음</option>
							<%
								for(int i = 1; i <= 20; i++)
								{
									String photoname = "../image/" + i + ".jpg";
									if(photoname.equals(dto.getPhoto()))
									{%>
										<option value="../image/<%=i%>.jpg" selected>프로필사진#<%=i%></option>	
									<%}
									else
									{%>
										<option value="../image/<%=i%>.jpg">프로필사진#<%=i%></option>	
									<%}
								}
							%>
						</select>
						<img alt="" src="<%=dto.getPhoto() %>" class="photo" onerror="this.src='../image/noimage1.png'">
						<script>
							$("#photo").change(function(){
								let src=$(this).val();
								$(".photo").attr("src", src);
							});
						</script>
					</td>
				</tr>
				<tr>
					<th width="100" class="table-danger">입사일</th>
					<td>
						<input type="date" class="form-control" name="birthday" value="<%=dto.getBirthday() %>">										
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-outline-secondary btn-sm" style="width: 80px;">정보수정</button>
						<button type="submit" class="btn btn-outline-secondary btn-sm" style="width: 80px;" onclick="location.href='sawonlist.jsp'">사원목록</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
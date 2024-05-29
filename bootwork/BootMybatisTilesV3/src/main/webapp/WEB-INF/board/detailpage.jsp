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

pre.adata{
	margin-left: 10px;
	color: gray;
}

span.aday{
	margin-left:100px;
	color: gray;
	font-size: 0.9em;
}

</style>
<script type="text/javascript">
$(function(){
	//처음 로딩시 댓글 목록 출력
	answer_list();
	
	//댓글 추가 버튼//....버튼은 몰라도, content는 id로 다르게 받아야함...
	//$("#btnansweradd").click(function()
	$(".btnansweradd").click(function() //클래스로 바꿔봄
	{
		let num = ${dto.num};
		let content = $("#acontent").val(); //여기 id를 ""안에 안 넣어줌
		let my_content = $("#my_acontent").val();
		//let content = $(".acontent").val(); //클래스로 바꿔봄//.....두개 동시 수행이 안됨....//두개를 따로 저장해야 할듯...
		if(content == '' && my_content == '')//쌤이 만든것과 내가 만든거 모두 처리할 수 있게
		{
			alert("댓글을 입력 후 등록해주세요");
			return;
		}
		/*
		if(content == '')
		{
			alert("댓글을 입력 후 등록해주세요");
			return;
		}
		*/
		$.ajax({
			type:'post',
			dataType:'text',
			url:"./ainsert",
			data:{"num":num, "content": (content != '' ? content : my_content)},
			//data:{"num":num, "content":content},
			success:function(){
				//댓글 목록 다시 출력
				answer_list();
				//초기화
				//$("#acontent").val("");
				$(".acontent").val("");//클래스로 바꿔봄//초기화는 class로도 가능하지 않나?
			}
		});
	});
	
	//댓글 삭제 이벤트
	$(document).on("click", ".adel", function(){
		let aidx = $(this).attr("aidx");
		let a = confirm("해당 댓글을 삭제할까요?");
		
		if(a)
		{
			$.ajax({
				type:"get",
				dataType: "text", //json은 map이나 list를 보내야함. text는 안그래도 됨!...
				//...그래서 dataType를 json으로 하면 삭제 실행은 되지만 success가 반환되지 않아 success 함수가 실행되지 않음!
				data: {"aidx": aidx},
				url:"./adelete",
				success:function(){
					answer_list();
				}
			});	
		}
	});
});//end of function

//댓글 목록 출력
function answer_list(){
	let num = ${dto.num};
	
	//로그인 중인지, 로그인 중일 경우 로그인 아이디 얻기
	let loginok = '${sessionScope.loginok}';
	let loginid = '${sessionScope.loginid}';
	//alert(loginok + "\n" + loginid);
	//console.log(loginok + "\n" + loginid);
	
	$.ajax({
		type:"get",
		dataType:"json",
		data:{"num":num},
		url:"./alist",
		success:function(data){
			//댓글 갯수 출력
			$(".answercount").text(data.length);
			
			//목록 출력
			let s = "";
			$.each(data, function(idx, ele){
				s +=
					`
						\${ele.writer}(\${ele.myid})
						<span class="aday">\${ele.writeday}</span>
					`;
					//로그인 중이면서 댓글 아이디와 로그인 아이디가 같을 경우 삭제 아이콘 추가
				if(loginok == 'yes' && loginid == ele.myid)
				{
					s += 
						`
						<i class="bi bi-trash adel" aidx="\${ele.aidx}" style="cursor:pointer;"></i>
						`
				}
				s += 
					`	
						<br>
						<pre class="adata">\${ele.content}</pre>
						<br>
					`;
			});	
			$(".answerlist").html(s);
		}
	})
}

</script>
</head>
   	
<!-- NCP사용을 위해 새로 추가 -->
<c:set var="stpath" value="https://kr.object.ncloudstorage.com/bitcamp-bucket-56/photocommon"></c:set>
	
<body>
	<div style="width:70%;">
	<h1>내가 만든거</h1>
		<!-- 제목 + 프로필 이미지 + 이름 + 작성일 + 조회수 -->
		<div>
			<h3>${dto.subject}</h3>
			<table class="table table-bordered"><!-- 나중에 처리 -->
				<tr>
					<td rowspan="2" style="width:60px;">
						<!-- <img id="profile_photo" src="../save/${profile_photo}" 
						style="width:50px; heigth:50px; border: 1px solid gray" class="rounded-circle"> -->
						<img id="profile_photo" src="${stpath}/${profile_photo}" 
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
					<td>
						<span style="float: right;color: gray;">
			  			<i class="bi bi-chat-dots"></i>
			  			&nbsp;
			  			댓글 <span class="answercount">0</span>
						</span>
					</td>
				</tr>
			</table>
		</div>
		<hr>
		<!-- 내용 + 사진 -->
		<div>
			<!-- <img alt="" src="../save/${dto.uploadphoto}" onerror="this.src='../image/noimage2.png'"> -->
			<img alt="" src="${stpath}/${dto.uploadphoto}" onerror="this.src='../image/noimage2.png'"><!-- onerror 이게 출력한다는 뜻은 아님! -->
			<pre>${dto.content}</pre>
		</div>

		<!-- ####################### 내가 만든 댓글 ############################ -->
		<hr>
		<div>
			<div class="answerlist"></div>
			<c:if test="${sessionScope.loginok != null }">
				<b>댓글</b><br>
				<textarea name="content" required="required" 
				style="width:80%; height:100px; border: 2px solid gray; border-radius: 10px;" 
				placeholder="댓글을 남겨보세요." id="my_acontent" class="acontent"></textarea>
				<button type="button" class="btn btn-outline-success btnansweradd" 
				style="height: 65px; position: relative; top:-50px;"
				id = "btnansweradd">등록</button>
			</c:if>
		</div>

		<!-- 버튼 -->
		<div>
			<!-- 새 글쓰기 -->
			<button type="button" class="btn btn-sm btn-success" onclick="location.href='./form'">
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
			<!-- <img src="../save/${profile_photo}"
			  onerror="this.src='../image/noimage2.png'"
			  style="width: 45px;height: 45px;margin-right:5px;"
			  class="rounded-circle" align="left"> -->
			  <img src="${stpath}/${profile_photo}"
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
			  	댓글 <span class="answercount">0</span>
			  </span>
		</td>
	</tr>
	<tr>
		<td>
			<c:if test="${dto.uploadphoto != 'no'}"><!-- uploadphoto가 'no'가 아니면 해당 photo 출력 -->
				<!-- <img src="../save/${dto.uploadphoto}"
				onerror="this.src='../image/noimage2.png'"
				style="max-width: 300px;"> -->
				<img src="${stpath}/${dto.uploadphoto}"
				onerror="this.src='../image/noimage2.png'"
				style="max-width: 300px;">
				<br><br> <!-- onerror 이게 출력한다는 뜻은 아님! -->
			</c:if>
			<pre style="font-size: 17px;">${dto.content}</pre>
		</td>
	</tr>
	<tr>
		<td>
			<!-- 댓글 출력할 영역 -->
			<div class="answerlist"></div>
		</td>
	</tr>
	<!-- ####################### 쌤이 만든 댓글 ############################ -->
	<c:if test="${sessionScope.loginok != null }">
		<tr>
			<td>
				<b>댓글</b><br>
				<textarea style="width: 80%; height: 60px;" id="acontent" class="acontent"></textarea>
				<button type="button" class="btn btn-outline-success btnansweradd" 
				style="height: 65px; position: relative; top:-25px;"
				id = "btnansweradd">등록</button>
			</td>
		</tr>
	</c:if>
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
			<c:if test="${sessionScope.loginok!=null and sessionScope.loginid==dto.myid}">
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

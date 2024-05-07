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
    </style>
</head>
<%
	//amho라는 쿠키가 있으면 true, 없으면 false
	boolean findAmho = false;
	Cookie []cookies = request.getCookies();
	if(cookies != null)
	{
		for(Cookie ck : cookies)
		{
			String name = ck.getName();
			if(name.equals("amho"))
			{
				findAmho = true;
				break;
			}
		}
	}
%>
<body>
<%
if(findAmho){%>
	<pre>
	이달 말 입주를 앞둔 한 신축 아파트에서 건물 외벽이 휘고, 콘크리트 골조가 휘어지거나 계단 타일 이곳저곳이 파손된 채 사전점검을 진행해 논란이 일고 있다.

지난 6일 다수의 온라인 커뮤니티에는 ‘역대급 하자 나온 신축 아파트’라는 제목의 글이 올라와 화제가 됐다. 글쓴이는 사진들과 함께 “한눈에 봐도 보이는 건물 외벽이 휜 모습”이라며 “지진 나면 전부 다 죽는 거 아닌지 (모르겠다)”라고 우려를 표했다.

그가 올린 사진상에서 실제로 건물 외벽은 휜 듯 보였다. 글쓴이는 외벽뿐만 아니라 내부에도 수평이 맞지 않는 부분이 추가로 발견됐다고 지적했다.
창과 바닥에 틈새가 생긴 사진도 누리꾼들을 놀라게 했다. 신축 아파트임에도 엘리베이터의 층수를 표시해주는 위치표시기는 이미 떨어질 듯 말듯 위태롭게 달려 있었다.

아파트 공용공간 벽면에는 공사 중 인부가 쓴 것으로 추정되는 낙서가 고스란히 남아 있었다. 계단에는 곳곳에서 파손된 타일들도 발견됐다.

글쓴이는 “집마다 하자가 평균 150개, 많게는 200개 이상 나오고 공용하자가 판을 친다”며 황당함을 표했다. 해당 지방자치단체는 이 사안에 대해 “입주 예정자들이 제기하는 하자는 경미한 사항이 대부분이며 중대한 하자는 보이지 않는다”는 취지로 해명한 것으로 알려졌다.

이를 본 누리꾼들은 “이젠 신축분양은 1군 업체라도 도저히 믿을 수 없다”, “원청에서 관리를 잘 못한 책임이 크다”, “저런 걸 보고도 완공 승인을 내주는 구청도 문제다”, “시대가 가면 갈수록 더 좋아져야지 더 안 좋아지면 어떡하냐” 등의 반응을 보였다.
	</pre>
<%}
else
{%>
	<script type="text/javascript">
		alert("먼저 암호를 입력해 주세요.");
		history.back();
	</script>
<%}
%>
</body>
</html>
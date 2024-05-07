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
	반으로 가르자 새빨간 수박의 속살이 드러났다. 방금 인공지능(AI)의 검수를 통해 브릭스(Brix) 13.5의 황금 당도를 인정 받은 수박. AI의 검수는 틀리지 않았다. 인공지능의 도움으로 올해 처음 입에 넣은 수박의 맛은 그 어느 때보다 ‘달콤’했다.

지난달 30일 롯데마트와 함께 찾은 한국 수박의 수도 함안. 기차역 근처에 위치한 파트너사 탐스팜의 오후는 분주했다. 상품의 수박을 박스에 담는 직원들 너머로 성인 남성 서너명 크기의 AI 기기 한 쌍이 빠른 속도로 제품을 판별. 레일 위에서 차례로 투입되는 수박의 무게와 당도가 즉각 화면에 표시되고 하품과 상품이 자동으로 분리됐다. 하나의 AI 기기가 빛을 투과시켜 당도를 확인하고 다른 AI는 8장의 외면 사진을 촬영해 빅데이터 분석을 거쳐 파악한 밀도로 품질을 선별했다. 기기를 통과한 수박을 최종 점검해 포장하는 직원들도 AI 덕분에 더 빨리 손쉽게 상품을 탁송할 수 있다. 실제 이날 오전에만 이미 수박 5000통을 검수했고 풀가동하면 하루에 2만 통도 가능하다는 설명이다.
	
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
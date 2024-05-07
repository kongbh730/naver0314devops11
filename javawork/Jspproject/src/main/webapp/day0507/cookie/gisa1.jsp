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
올해 1분기(1~3월) 국내 지방은행의 가계대출 잔액이 주택담보대출을 중심으로 가파른 증가세를 기록했다. 지난해 금융당국 조치로 둔화했던 가계대출 증가세가 다시 기세를 전환할 조짐을 보인 것이다.
6일 금융권에 따르면 올해 1분기 대구·부산·경남·전북·광주 등 5개 지방은행의 원화대출금 중 가계대출 잔액은 67조2천364억원으로 집계됐다. 이는 지난해 4분기(66조6천860억원)보다 5천504억원, 지난해 1분기(62조6천809억원)보다는 4조5천555억원 불어난 수준이다.
전 분기 대비 증가 폭은 지난해 3분기 2조4천209억원에서 4분기 2천700억원으로 급감했다가 올해 1분기 다시 5천504억원으로 확대됐다.
주택담보대출이 가계대출 증가를 견인한 것으로 풀이된다. 올해 1분기 이들 지방은행의 주담대 잔액은 43조3천527억원으로 나왔다. 전 분기(42조365억원)보다 1조3천162억원, 1년 전(38조9천282억원)보다는 4조4천245억원 급등한 규모다.
대구은행 상황만 보면 가계대출은 지난해 1분기 17조4천655억원에서 올해 1분기 20조4천489억원으로 늘었고, 같은 기간 주담대는 8조9천349억원에서 11조8천33억원으로 뛰었다.
대출 갈아타기 서비스 확대, 신생아특례대출 공급으로 금융 지원을 확대한 점 등이 가계대출 규모를 키운 배경으로 꼽힌다. 신생아특례대출 신청 자금은 지난 1월 29일 출시한 뒤 3달 만에 5조1천843억원(2만986건)을 기록했다.
금융권은 당분간 가계대출 증가세가 이어질 것으로 보고 있다. 문제는 가계대출 증가와 함께 취약 차주도 덩치를 키울 수 있다는 점이다. 실제로 대구은행 가계대출 가운데 고정이하(NPL) 금액은 작년 1분기 399억원(0.23%)에서 올해 1분기 676억원(0.33%)으로 급증했다.
금융당국은 장기적 관점에서 가계대출이 안정되도록 주택시장·금리 동향을 주시한다는 방침이다. 금융감독원은 금리 변동에 따른 차주 위험을 줄이기 위해 고정금리 대출 비중을 확대할 필요가 있다고 보고, 올해 행정지도를 통해 가계대출 질적 구조 개선을 추진할 예정이다.	
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
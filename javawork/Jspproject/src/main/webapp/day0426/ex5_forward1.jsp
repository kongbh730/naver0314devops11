<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
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
<body>
	<h1>여기는 ex5_forward1 파일입니다.</h1>
	<!--
	redirect: 1. url주소 바뀜 2.response, request 새로 생성(request를 통해서 데이터를 못 보냄)
	 forward : 1. url주소 안 바뀜 2.response, request 새로 생성 안됨(request를 통해서 데이터를 보냄)
	 -->
	 <%
	 	//request에 List 데이터를 저장해보지
	 	List<String> list=Arrays.asList("벤츠", "아우디", "BMW", "현대");//틀린거 없음... 1에서 실행해야 했음...
	 	request.setAttribute("list", list);
	 %>
	<jsp:forward page="./ex5_forward2.jsp"/><!-- 실행결과 주소는 1인데 결과는 2임 -->
</body>
</html>
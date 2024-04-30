<%@page import="data.dao.SawonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");

	//num int 타입으로 읽기
	int num = Integer.parseInt(request.getParameter("num"));

	//dao 선언
	SawonDao dao = new SawonDao();
	
	//delete 메서드 호출
	dao.deleteSawon(num);
	
	//목록 sawonlist.jsp로 이동
    response.sendRedirect("sawonlist.jsp");//url주소 바뀜
%>
<%@page import="data.dao.BitcampUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//한글 엔코딩
	request.setCharacterEncoding("utf-8");
	
	//id, password 읽기
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	//dao 선언
	BitcampUserDao dao=new BitcampUserDao();
	
	dao.loginBitcampUser(id, password);
	
	//목록 sawonlist.jsp로 이동
    //response.sendRedirect("bitcampform.jsp");//url주소 바뀜
%>
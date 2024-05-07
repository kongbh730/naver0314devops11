<%@page import="data.dao.BitcampUserDao"%>
<%@page import="data.dto.BitcampUserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글 엔코딩
	request.setCharacterEncoding("utf-8");

	//데이타 읽기
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	//dto 선언후 데이타 넣기
	BitcampUserDto dto=new BitcampUserDto();
	dto.setId(id);
	dto.setPassword(password);
	dto.setName(name);
	dto.setEmail(email);
	
	//dao선언후 메서드 호출
	BitcampUserDao dao=new BitcampUserDao();
	dao.insertBitcampUser(dto);
	
	//목록으로 이동
	response.sendRedirect("loginform.jsp");
%>
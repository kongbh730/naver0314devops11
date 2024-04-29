<%@page import="data.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

	//shopidx int 타입으로 읽기
	//String shopidx = request.getParameter("shopidx");
	int shopidx = Integer.parseInt(request.getParameter("shopidx"));

	//dao 선언
	ShopDao dao = new ShopDao();
	
	//delete 메서드 호출
	dao.deleteShop(shopidx);
	
	//목록 shoplist.jsp로 이동
    response.sendRedirect("shoplist.jsp");//url주소 바뀜
%>
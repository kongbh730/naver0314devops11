<%@page import="data.dao.ShopDao"%>
<%@page import="data.dto.ShopDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	//1. 엔코딩
    	request.setCharacterEncoding("utf-8");
    
    	//2. 5개의 상품데이터 읽기
    	String sname=request.getParameter("sname");
    	String scolor=request.getParameter("scolor");
    	String sphoto=request.getParameter("sphoto");
    	int sprice = Integer.parseInt(request.getParameter("sprice"));
    	int scount = Integer.parseInt(request.getParameter("scount"));
    	
    	//3. dto에 넣기 -setter로 넣기 (총 6개);
    	//ShopDto dto = new ShopDto(sname, sprice, scount, scolor, sphoto);
    	
    	//4. dao 선언
    	ShopDao dao = new ShopDao();
    	
    	
    	
    	
    	//6. shoplist.jsp로 이동
    	response.sendRedirect("shoplist.jsp");//url주소 바뀜
    %>
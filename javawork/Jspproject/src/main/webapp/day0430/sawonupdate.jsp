<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    	//1. 엔코딩
    	request.setCharacterEncoding("utf-8");
    
    	//2. 5개의 상품데이터 읽기
    	int age = Integer.parseInt(request.getParameter("age"));
    	String name=request.getParameter("name");
    	

    	//3. dto에 넣기 -setter로 넣기 (총 6개), insert랑 다르게 값 지정
    	ShopDto dto = new ShopDto();

    	dto.setShopidx(shopidx);
    	dto.setSname(sname);
    	dto.setScolor(scolor);
    	dto.setSphoto(sphoto);
    	dto.setSprice(sprice);
    	dto.setScount(scount);
    	
    	//4. dao 선언
    	ShopDao dao = new ShopDao();
    	
    	//5. update 메서드 호출
    	dao.updateShop(dto);
    	
    	//6. shoplist.jsp로 이동
    	//response.sendRedirect("shoplist.jsp");//url주소 바뀜
    	
    	//6. shopdetail 페이지로 이동하고 싶어//이때 shopidx를 주어 수정된 데이터가 있는 페이지로 이동 가능하다
    	response.sendRedirect("shopdetail.jsp?shopidx="+shopidx);
    	
    %>
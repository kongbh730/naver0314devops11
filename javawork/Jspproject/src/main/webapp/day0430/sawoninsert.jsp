<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!-- jsp의 자바빈즈 사용 -->
    <%
    	//한글 엔코딩
    	request.setCharacterEncoding("utf-8");
  
    %>
    <!-- jsp 액션태그를 이용해서 dto, dao를 선언해보자 -->
    <jsp:useBean id="dto" class="data.dto.SawonDto"/>
    <jsp:useBean id="dao" class="data.dao.SawonDao"/>    
    <!-- 자동으로 데이터 읽어서 dto에 넣기 -->
    <!-- 자동으로 데이터 읽어서 dto에 넣기 : property에 dto의 변수명으로 쓰면 해당데이터만 읽어온다. *를 쓰면 모든 데이터를 읽어온다.-->
	<jsp:setProperty name="dto" property="*"/>
	<%
		//insert 메서드 호출
		dao.insertSawon(dto);
		//사원목록으로 이동
		response.sendRedirect("sawonlist.jsp");
	%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String myid=request.getParameter("myid");
	String mypass=request.getParameter("mypass");
	String save=request.getParameter("save");
	
	//비번이 1234면 무조건 맞다고 하고 세션 저장하겠음
	if(mypass.equals("1234"))
	{
		//세션에 저장
		session.setAttribute("myid", myid);
		session.setAttribute("loginok", "yes");
		session.setAttribute("saveok", save==null?"no":"yes");
		//세션유효시간 지정(기본 30분)
		session.setMaxInactiveInterval(60*60*3);//3시간 유지
		//메인으로 이동
		response.sendRedirect("sessionmain.jsp");
	}
	else
	{%>
		<script>
			alert("비밀번호가 맞지 않습니다.");
			history.back();
		</script>
	<%}
%>
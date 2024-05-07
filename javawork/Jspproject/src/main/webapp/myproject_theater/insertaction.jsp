<%@page import="data.dao.MovieDao"%>
<%@page import="data.dto.MovieDto"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int uploadSize= 1024*1024*5;//5mb
	//실제 업로드 되는 경로 구하기
	//코드가 있는 프로젝트로 업로드 되는 것이 아니라
	//톰켓 서버에 배포된 프로젝트 안의 save 폴더에 업로드가 된다.
	
	ServletContext context=getServletContext();
	String realFolder=context.getRealPath("/save");
	System.out.println("realFolder="+realFolder);//실제 업로드 되는 save폴더의 경로
	
	MultipartRequest multi = null;
	
	try
	{
		multi = new MultipartRequest(request, realFolder, uploadSize, "utf-8", new DefaultFileRenamePolicy());
		//ㄴ마지막 인자 (DefaultFileRenamePolicy()): 같은 이름이 업로드 될 경우 이름 변경!!!
		
		//데이터 읽기
		String title = multi.getParameter("title");
		String poster = multi.getFilesystemName("poster");//파일은 실제 업로드된 파일명을 얻는다.
		String announcementyoutube = multi.getParameter("announcementyoutube");
		String genre = multi.getParameter("genre");
		String introduce = multi.getParameter("introduce");
		String director = multi.getParameter("director");
		String actors = multi.getParameter("actors");
		//Timestamp releaseday = Timestamp.valueOf(multi.getParameter("releaseday"));
		
		//dto 선언 후 데이터 넣기
		MovieDto dto = new MovieDto();
		dto.setTitle(title);
		dto.setPoster(poster);
		dto.setAnnouncementyoutube(announcementyoutube);
		dto.setGenre(genre);
		dto.setIntroduce(introduce);
		dto.setDirector(director);
		dto.setActors(actors);
		//dto.setReleaseday(releaseday);
		
		//dao 선언
		MovieDao dao = new MovieDao();
		
		//insert 후 목록으로 이동
		dao.insertMovie(dto);
		response.sendRedirect("movielist.jsp");
	}
	catch(Exception e){%>
<script type="text/javascript">
			alert("파일 업로드 오류 : " + e.getMessage());
		</script>
	<%}
%>
package board.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.SimpleBoardDao;
import data.dto.SimpleBoardDto;

@WebServlet("/board/update")
public class UpdateServlet extends HttpServlet {
	SimpleBoardDao dao = new SimpleBoardDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//dopost로부터 호출됐으므로 encoding을 해줘야 한다.
		request.setCharacterEncoding("utf-8");
		
		//데이터 읽어서 dto에 담기
		int num = Integer.parseInt(request.getParameter("num"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		/*여기서 오류 발생했었음! 선언만 하고 num을 전달하지 않았었음*/
		//SimpleBoardDto dto = new SimpleBoardDto(num);
		SimpleBoardDto dto = new SimpleBoardDto();
		dto.setNum(num);
		
		dto.setWriter(request.getParameter("writer"));
		dto.setSubject(request.getParameter("subject"));
		dto.setAvata(request.getParameter("avata"));
		dto.setContent(request.getParameter("content"));
		
		//수정 메서드 호출
		dao.updateBoard(dto);
		
		//detail로 리다이렉트
		response.sendRedirect("./detail?num=" + num + "&currentPage=" + currentPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

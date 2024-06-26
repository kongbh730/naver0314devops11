package board.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.SimpleBoardDao;
import data.dto.SimpleBoardDto;

@WebServlet("/board/delete")
public class DeleteServlet extends HttpServlet {
	SimpleBoardDao dao = new SimpleBoardDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//num, currentPage를 읽는다.
		int num = Integer.parseInt(request.getParameter("num"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));

		//삭제
		dao.deleteBoard(num);
		
		//목록으로 리다이렉트
		response.sendRedirect("./list?currentPage=" + currentPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

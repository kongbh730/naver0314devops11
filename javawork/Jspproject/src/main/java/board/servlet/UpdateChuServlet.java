package board.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.SimpleBoardDao;

@WebServlet("/board/updatechu")
public class UpdateChuServlet extends HttpServlet 
{
	SimpleBoardDao dao = new SimpleBoardDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//num읽기
		int num = Integer.parseInt(request.getParameter("num"));
		
		//dao의 chu값 업데이트
		dao.updateChu(num);
		
		//update된 chu값 얻기
		int chu=dao.getData(num).getChu();
		
		//json 형식으로 문자열을 만듦 //{"chu" : 5}형태
		String s = "{\"chu\" : " + chu + "}";
				
		//request에 담기;
		request.setAttribute("s", s);
		
		//jsonchu.jsp로 포워드
		RequestDispatcher rd = request.getRequestDispatcher("../day0514/jsonchu.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

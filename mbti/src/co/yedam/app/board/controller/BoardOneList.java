package co.yedam.app.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.app.board.model.BoardDAO;
import co.yedam.app.board.model.BoardVO;


/**
 * Servlet implementation class Login
 */
@WebServlet("/BoardOneList.do")
public class BoardOneList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//list처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	//list페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getSession().getAttribute("loginId");
		
		//1. 파라미터
		//2. 서비스 (DAO 목록조회)
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = dao.getBoardOneList(id);
		
		//view page에 forward
		request.setAttribute("list", list);
		request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
	}

}

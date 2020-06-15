package co.yedam.app.board.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import co.yedam.app.board.model.BoardDAO;
import co.yedam.app.board.model.BoardVO;


/**
 * Servlet implementation class BoardInsert
 */
@WebServlet("/BoardInsert.do")
public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/board/boardInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청정보 인코딩
		request.setCharacterEncoding("utf-8");

		// 1 파라미터 받기
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String id = request.getParameter("id");
		
		// 2. 서비스 로직 처리(DAO)
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = new BoardVO();
		board.setContents(contents);
		board.setTitle(title);
		board.setId(id);
	
		boardDAO.boardInsert(board);
		
		response.sendRedirect(request.getContextPath() + "/BoardList.do");
	}

}

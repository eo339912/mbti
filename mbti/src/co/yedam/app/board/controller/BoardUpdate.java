package co.yedam.app.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.board.model.BoardDAO;
import co.yedam.app.board.model.BoardVO;

/**
 * Servlet implementation class BoardUpdate
 */
@WebServlet("/BoardUpdate.do")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답결과 인코당
    	response.setContentType("text/html; charset=UTF-8");
    	//요청정보 인코딩
    	request.setCharacterEncoding("utf-8");
    	
    	// 1 파라미터 받기		
    	String id = request.getParameter("id");
    	String contents = request.getParameter("contents");
    	String title = request.getParameter("title");
    	String seq = request.getParameter("seq");
    	String star = request.getParameter("star");
    			
    	//2. 서비스 로직 처리(DAO)
    	BoardDAO boardDAO = new BoardDAO();
    	BoardVO board = new BoardVO();
    	board.setContents(contents);
    	board.setTitle(title);
    	board.setId(id);
    	board.setSeq(seq);
    	board.setStar(star);
    	boardDAO.boardUpdate(board);
    			
    	response.sendRedirect(request.getContextPath() +"/BoardList.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 -> 세션에서 seq가져오기
		String seq = request.getParameter("seq");

		//서비스 로직 처리
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoard(seq);
		
		//결과저장
		request.setAttribute("board", vo);
		
		//뷰페이지로 이동
		request.getRequestDispatcher("/board/boardUpdate.jsp")
				.forward(request, response);
	}

}

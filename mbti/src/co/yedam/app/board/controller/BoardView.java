package co.yedam.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.board.model.BoardDAO;
import co.yedam.app.board.model.BoardVO;
import co.yedam.app.board.model.CommendDAO;
import co.yedam.app.board.model.CommendVO;
import co.yedam.app.test.model.TestDAO;
import co.yedam.app.test.model.TestVO;

/**
 * Servlet implementation class BoardView
 */
@WebServlet("/BoardView.do")
public class BoardView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 -> 세션에서 seq가져오기
		String seq = request.getParameter("seq");
		String id = (String) request.getSession().getAttribute("loginId");
		if(id == null) {
			response.sendRedirect(request.getContextPath() +"/MemberLogin.do");
			return;
		}
		
		//2. 서비스 로직 처리(DAO) -> seq에 해당하는 commend 평균 한건조회
		CommendDAO commendDAO2 = new CommendDAO();
		CommendVO commendVO2 = commendDAO2.getCommendSeq(seq);
		
		//결과저장
		request.setAttribute("commend", commendVO2);
		
		//2. 서비스 로직 처리 -> seq에 해당하는 board한건조회
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoard(seq);
		
		//결과저장
		request.setAttribute("board", vo);
		
		//뷰페이지로 이동
		request.getRequestDispatcher("/board/boardView.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// 1 파라미터 받기		
		String id = (String) request.getSession().getAttribute("loginId");
		String onClass= request.getParameter("starC");
		String seq = request.getParameter("seq");
		
		//2. 서비스 로직 처리(DAO) -> commend 저장
		CommendDAO commendDAO = new CommendDAO();
		CommendVO commendVO = new CommendVO();
		commendVO.setB_seq(seq);
		commendVO.setStar(onClass);
		commendVO.setId(id);
		commendDAO.commendInsert(commendVO);
		
		//2. 서비스 로직 처리(DAO) -> seq에 해당하는 commend 평균 한건조회
		CommendDAO commendDAO2 = new CommendDAO();
		CommendVO commendVO2 = commendDAO2.getCommendSeq(seq);
		
		//결과저장
		request.setAttribute("commend", commendVO2);
		String avgStar = commendVO2.getAvgStar();
		
    	//2. 서비스 로직 처리(DAO)
    	CommendDAO commendDAO3 = new CommendDAO();
    	BoardVO boardVO3 = new BoardVO();
    	boardVO3.setSeq(seq);
    	boardVO3.setStar(avgStar);
    	int r = commendDAO3.boardStarUpdate(boardVO3);    		

    	
    	System.out.println(avgStar);
    	System.out.println(r + "되었다");

		//2. 서비스 로직 처리(DAO) -> seq에 해당하는 board 한건조회
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoard(seq);
		
		//결과저장
		request.setAttribute("board", vo);
				
		//뷰페이지로 이동
		request.getRequestDispatcher("/board/boardView.jsp")
				.forward(request, response);
	}

}

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
import co.yedam.app.common.Paging;


/**
 * Servlet implementation class Login
 */
@WebServlet("/BoardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//list처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	//list페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		String id = (String) request.getSession().getAttribute("loginId");
		String id2 = request.getParameter("id");
		if(id == null) {
			response.sendRedirect("/mbti/member/memberLogin.jsp");
			return;
		}
		
		
		//페이징처리
		//현재 페이지 파라미터 받기
		String strPage = request.getParameter("p");
		int p = 1;
		if(strPage != null && !strPage.isEmpty()) {
			p = Integer.parseInt(strPage);
		}
		//페이징 객체를  생성
		Paging paging = new Paging();
		paging.setPageUnit(5); //한페이지에 출력할 레코드 건수/ default = 10
		paging.setPageSize(3); //한페이지에 출력할 페이지 번호 수
		paging.setPage(p); //현재페이지
		paging.setTotalRecord(dao.getCount(id2)); //전체 레코드 건수 조회
		request.setAttribute("paging", paging);
		
		int start = paging.getFirst();
		int end = paging.getLast();
		
		//1. 파라미터
		//2. 서비스 (DAO 목록조회)
		//ArrayList<BoardVO> list = dao.getBoardList();
		List<BoardVO> list = dao.getBoardList(start, end, id2);
		
		//view page에 forward
		request.setAttribute("list", list);
		request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
	}

}

package co.yedam.app.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.member.model.MemberDAO;
import co.yedam.app.test.model.TestVO;

/**
 * Servlet implementation class memberResultList
 */
@WebServlet("/MemberResultList.do")
public class MemberResultList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파라미터
		String id = (String) request.getSession().getAttribute("loginId");
		//2. 서비스 (DAO 목록조회)
		MemberDAO dao = new MemberDAO();
		ArrayList<TestVO> list = dao.getResultList(id);
		
		//view page에 forward
		request.setAttribute("list", list);
		request.getRequestDispatcher("/member/memberResultList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package co.yedam.app.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.app.member.model.MemberDAO;
import co.yedam.app.member.model.MemberVO;
import co.yedam.app.test.model.TestDAO;
import co.yedam.app.test.model.TestVO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/TestList.do")
public class TestList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//List 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	//List페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");
		
		//2. 서비스 로직 처리(DAO)
		TestDAO testDAO = new TestDAO();
		TestVO test = testDAO.getTest(seq);		
		
		//결과저장
		request.setAttribute("test", test);
		
		//List페이지로 포워드
		request.getRequestDispatcher("/test/testList.jsp").forward(request, response);
	}

}

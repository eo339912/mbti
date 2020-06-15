package co.yedam.app.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.app.member.model.MemberDAO;
import co.yedam.app.member.model.MemberVO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/MemberInsert.do")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Insert 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답결과 인코딩
		response.setContentType("text/html; charset=UTF-8");
		//요청정보 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 1 파라미터 받기		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String birth = request.getParameter("birth");

		//2. 서비스 로직 처리(DAO)
		MemberDAO memberDAO = new MemberDAO();
		MemberVO member = new MemberVO();
		member.setPwd(pwd);
		member.setName(name);
		member.setId(id);
		member.setGender(gender);
		member.setBirth(birth);
		memberDAO.memberInsert(member);
		
		//3. 회원목록으로 이동 forward, sendRedirect
		
		String contextPath = getServletContext().getContextPath();
		response.sendRedirect(contextPath +"/MemberLogin.do");
		//request.getRequestDispatcher(contextPath +"/MemberList.do").forward(request, response);
		
	}

	//Insert페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Insert페이지로 포워드
		request.getRequestDispatcher("/member/memberInsert.jsp").forward(request, response);
	}

}

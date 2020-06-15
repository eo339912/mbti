package co.yedam.app.member.controller;

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

/**
 * Servlet implementation class Login
 */
@WebServlet("/MemberUpdate.do")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//update 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 -> 세션에서 id가져오기
		String id = (String) request.getSession().getAttribute("loginId");
		if(id == null) {
			response.sendRedirect(request.getContextPath() +"/MemberLogin.do");
			return;
		}
    	//응답결과 인코당
    	response.setContentType("text/html; charset=UTF-8");
    	//요청정보 인코딩
    	request.setCharacterEncoding("utf-8");
    	
    	// 1 파라미터 받기		
    	String name = request.getParameter("name");
    	String pwd = request.getParameter("pwd");
    	String birth = request.getParameter("birth");
    	String gender = request.getParameter("gender");
    			
    	//2. 서비스 로직 처리(DAO)
    	MemberDAO memberDAO = new MemberDAO();
    	MemberVO member = new MemberVO();
    	member.setBirth(birth);
    	member.setName(name);
    	member.setPwd(pwd);
    	member.setId(id);
    	member.setGender(gender);
    	memberDAO.memberUpdate(member);
    	MemberVO vo = memberDAO.getMember(id);
		//결과저장
		request.setAttribute("member", vo);
		
		MemberDAO memberDAO2 = new MemberDAO();
		MemberVO member2 = new MemberVO();
		member2.setId(id);
		MemberVO vo2 = memberDAO2.getMemberOne(id);
		request.setAttribute("member2", vo2);
		
		//뷰페이지로 이동
		request.getRequestDispatcher("/member/memberUpdate.jsp")
				.forward(request, response);
	}

	//update페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 -> 세션에서 id가져오기
		String id = (String) request.getSession().getAttribute("loginId");
		if(id == null) {
			String getContextPath = request.getContextPath();
			response.sendRedirect(getContextPath + "/MemberLogin.do");
			return;
		}
		//서비스 로직 처리
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getMember(id);
		
		MemberDAO dao2 = new MemberDAO();
		MemberVO vo2 = dao2.getMemberOne(id);
		
		//결과저장
		request.setAttribute("member", vo);
		request.setAttribute("member2", vo2);
		
		//뷰페이지로 이동
		request.getRequestDispatcher("/member/memberUpdate.jsp")
				.forward(request, response);
	}

}

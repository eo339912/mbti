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
@WebServlet("/MemberLogin.do")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//로그인 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idnull = "";
		//1. 파라미터 받기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//2. 서비스 로직 
		//단건조회
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getMember(id);
		
		//id.조회 결과없으면 id가 없다.
		//id.조회 결과있으면 pwd가 맞는지 검사 후 로그인 -> 틀리면 오류 
		if(vo.getId() == null) { //id오류
			request.setAttribute("errorMsg", "id오류");
			request.getRequestDispatcher("/member/memberLogin.jsp").forward(request, response);
		}else if(!vo.getPwd().equals(pwd)) { //pwd오류
			request.setAttribute("errorMsg", "pwd오류");
			request.getRequestDispatcher("/member/memberLogin.jsp").forward(request, response);
		}else { //login ok
			//세션에 로그인 여부를 저장
			HttpSession session = request.getSession();
			session.setAttribute("loginId", id);
			session.setAttribute("loginMember", vo);
			
			String ContextPath= request.getContextPath();
			response.sendRedirect(ContextPath + "/");
		}
		//3. 결과저장
		
		//4. 뷰페이지로 포워드
	}

	//로그인페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인페이지로 포워드
		request.getRequestDispatcher("/member/memberLogin.jsp").forward(request, response);
	}

}

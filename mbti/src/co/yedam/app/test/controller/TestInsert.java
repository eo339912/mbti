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
@WebServlet("/TestInsert.do")
public class TestInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//버튼 클릭시 Insert 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1 파라미터 받기		
		int eT=0, iT=0, sT=0, nT=0, tT=0, fT=0, jT=0, pT=0;
		String result ="";
		String [] ans = {"e","i","s","n","t","f","j","p"};
		String [] res = new String[3];

		for(int i=0; i<3; i++){
			res[i] = request.getParameter("ei" + i);
			if(ans[0].equals(res[i])){eT++;}
			else if(ans[1].equals(res[i])){iT++;}
		}
		for(int i=0; i<3; i++){
			res[i] = request.getParameter("sn" + i);
			if(ans[2].equals(res[i])){sT++;}
			else if(ans[3].equals(res[i])){nT++;}
		}
		for(int i=0; i<3; i++){
			res[i] = request.getParameter("tf" + i);
			if(ans[4].equals(res[i])){tT++;}
			else if(ans[5].equals(res[i])){fT++;}
		}
		for(int i=0; i<3; i++){
			res[i] = request.getParameter("jp" + i);
			if(ans[6].equals(res[i])){jT++;}
			else if(ans[7].equals(res[i])){pT++;}
		}
		
		if(eT > iT) {
			result += "E";
		}else if(eT < iT) {
			result += "I";			
		}
		
		if(sT > nT) {
			result += "S";			
		}else if(sT < nT) {
			result += "N";		
		}
		if(tT > fT) {
			result += "T";		
		}else if(tT < fT) {
			result += "F";			
		}
		if(jT > pT) {
			result += "J";		
		}else if(jT < pT) {
			result += "P";		
		}
		
		String id = (String) request.getSession().getAttribute("loginId");
		if(id == null) {
			String getContextPath = request.getContextPath();
			response.sendRedirect(getContextPath + "/MemberLogin.do");
			return;
		}
		
		//2. 서비스 로직 처리(DAO)
		TestDAO testDAO = new TestDAO();
		TestVO test = new TestVO();
		test.setId(id);
		test.setResult(result);
		testDAO.testInsert(test);
		
		
		//Result페이지로 포워드
		String contextPath = getServletContext().getContextPath();
		response.sendRedirect(contextPath +"/TestList.do?seq=" + test.getSeq());
	}

	//Insert페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Insert페이지로 포워드
		request.getRequestDispatcher("/test/testInsert.jsp").forward(request, response);
	}

}

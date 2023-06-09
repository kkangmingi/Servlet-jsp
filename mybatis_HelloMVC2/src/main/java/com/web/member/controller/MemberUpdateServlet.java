package com.web.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.common.AESEncryptor;
import com.web.member.dto.MemberDto;
import com.web.member.service.MemberService;

/**
 * Servlet implementation class MemberUpdateEndServlet
 */
@WebServlet("/member/updateEndMember.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberUpdateServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원정보를 수정하는 서비스
		//1. 클라이언트가 보낸 데이터를 받아오기

		MemberDto m=MemberDto.builder()
				.userId(request.getParameter("userId"))
				.userName(request.getParameter("userName"))
				.age(Integer.parseInt(request.getParameter("age")))
				.gender(request.getParameter("gender").charAt(0))
				.email(request.getParameter("email"))
				.phone(request.getParameter("phone"))
				.address(request.getParameter("address"))
				.hobby(request.getParameterValues("hobby"))
				.build();
		try {
			m.setEmail(AESEncryptor.encryptData(m.getEmail()));
		}catch(Exception e) {
			
		}
		try {
			m.setPhone(AESEncryptor.encryptData(m.getPhone()));
		}catch(Exception e) {
			
		}
		
		//2. 회원정보를 수정해줌(DB에 있는 데이터를...)
		int result=new MemberService().updateMember(m);
		//3. 결과를 전송하기
		String msg="",loc="";
		if(result>0) {
			//변경 성공
			msg="회원정보가 수정되었습니다.";
			loc="/";
			HttpSession session=request.getSession();
			session.setAttribute("loginMember",new MemberService().selectByUserId(m.getUserId()));
		}else {
			//변경 실패
			msg="회원정보 수정실패하였습니다. 다시시도하세요";
			loc="/member/memberView.do?userId="+m.getUserId();
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

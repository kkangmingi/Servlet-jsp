package com.cookie.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextDataServlet
 */
//@WebServlet("/contextdata.do") web.xml에 직접 서블릿 등록해줘서 주석처리함!
public class ContextDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//context-param으로 등록된 데이터 가져오기
		ServletContext context=getServletContext();
		String contextdata=context.getInitParameter("admin");
		System.out.println(contextdata);
		
		//서블릿 초기화 데이터 이용하기(web.xml에 init-param으로 초기화 데이터를 적어줘서 데이터를 불러온다.)
		String servletdata=getInitParameter("servletdata");
		System.out.println(servletdata);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

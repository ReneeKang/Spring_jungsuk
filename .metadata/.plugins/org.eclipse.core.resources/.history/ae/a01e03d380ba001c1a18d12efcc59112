package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//서블릿이 초기화될때 자동 호출되는 메서드
		//1.서블릿의 초기화작업을 담당
		System.out.println("init()");
//		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.service(req, resp);
//		1.입력
//		2.처리
//		3.호출
		System.out.println("service()");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
//		super.destroy();
		//3. 뒷정리 //
		
		System.out.println("destroy");
		System.out.println("last");
	}


}

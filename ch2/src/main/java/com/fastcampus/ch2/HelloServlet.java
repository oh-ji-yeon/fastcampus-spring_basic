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
	public void init() throws ServletException { // 처음 한번만 호출됨
		// 서블릿이 초기화될 때 자동 호출되는 메소드
		// 1. 서블릿의 초기화 작업 담당
		System.out.println("[HelloServlet] init() is called.");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { // 요청이 올 때마다 반복 호출되며 처리됨
		// 1. 입력
		// 2. 처리
		// 3. 출력
		System.out.println("[HelloServlet] service() is called.");
	}

	@Override
	public void destroy() { // 메모리에서 내려올 때 서블릿이 새로 갱신되서 리로딩 되거나 웹 애플리케이션이 종료될 때, 서블릿과 관련된 뒷마무리 작업을 하기 위해 호출됨
		// 3. 뒷정리 - 서블릿이 메모리에서 제거될 때 서블릿 컨터이너에 의해서 자동 호출
		System.out.println("[HelloServlet] destroy() is called.");
	}
}

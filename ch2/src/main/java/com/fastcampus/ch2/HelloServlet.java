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
	public void init() throws ServletException { // ó�� �ѹ��� ȣ���
		// ������ �ʱ�ȭ�� �� �ڵ� ȣ��Ǵ� �޼ҵ�
		// 1. ������ �ʱ�ȭ �۾� ���
		System.out.println("[HelloServlet] init() is called.");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { // ��û�� �� ������ �ݺ� ȣ��Ǹ� ó����
		// 1. �Է�
		// 2. ó��
		// 3. ���
		System.out.println("[HelloServlet] service() is called.");
	}

	@Override
	public void destroy() { // �޸𸮿��� ������ �� ������ ���� ���ŵǼ� ���ε� �ǰų� �� ���ø����̼��� ����� ��, ������ ���õ� �޸����� �۾��� �ϱ� ���� ȣ���
		// 3. ������ - ������ �޸𸮿��� ���ŵ� �� ���� �����̳ʿ� ���ؼ� �ڵ� ȣ��
		System.out.println("[HelloServlet] destroy() is called.");
	}
}

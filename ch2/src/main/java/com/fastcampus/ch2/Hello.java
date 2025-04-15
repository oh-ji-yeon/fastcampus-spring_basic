package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. ���� ȣ�� ������ ���α׷����� ���
@Controller
public class Hello {
	int iv = 10; // �ν��Ͻ� ����
	static int cv = 20; // static ����
	
	// 2. url�� �޼ҵ带 ����
	@RequestMapping("/hello") // ���������� ������� �ܺο��� ȣ���ϰڴٴ� ��
	// static method�� �ƴѵ� ��� ȣ��� �� �־���?
	// instance method -> ��ü ���� �� ȣ�� ����, iv/cv �� �� ��� ����
//	public void main() {
	private void main() {
//		System.out.println("Hello");
		System.out.println("Hello - private");
		
		System.out.println(cv);
		System.out.println(iv);
	}
	
	// static method -> cv�� ��� ����
	public static void main2() {
		System.out.println(cv); // ok
//		System.out.println(iv); // error
	}
}

// ��ü�� �������� �ʾҴµ� �ν��Ͻ� �޼ҵ� ȣ���� �����ϴ�? -> ��Ĺ�� ��ü ����
package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. 원격 호출 가능한 프로그램으로 등록
@Controller
public class Hello {
	int iv = 10; // 인스턴스 변수
	static int cv = 20; // static 변수
	
	// 2. url과 메소드를 연결
	@RequestMapping("/hello") // 접근제어자 상관없이 외부에서 호출하겠다는 뜻
	// static method가 아닌데 어떻게 호출될 수 있었지?
	// instance method -> 객체 생성 후 호출 가능, iv/cv 둘 다 사용 가능
//	public void main() {
	private void main() {
//		System.out.println("Hello");
		System.out.println("Hello - private");
		
		System.out.println(cv);
		System.out.println(iv);
	}
	
	// static method -> cv만 사용 가능
	public static void main2() {
		System.out.println(cv); // ok
//		System.out.println(iv); // error
	}
}

// 객체를 생성하지 않았는데 인스턴스 메소드 호출이 가능하다? -> 톰캣이 객체 생성
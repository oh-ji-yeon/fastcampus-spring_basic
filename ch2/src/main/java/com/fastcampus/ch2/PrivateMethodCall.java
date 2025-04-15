package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception {
//		Hello hello = new Hello();
//		hello.main(); // private이라 외부 호출 불가

		// Reflection API를 사용 -> 클래스 정보를 얻고 다룰 수 있는 강력한 기능 제공
		// java.lang.reflect package를 제공

		// Hello class의 Class 객체(클래스의 정보를 담고 있는 객체)를 얻어온다
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello) helloClass.newInstance(); // Class객체가 가진 정보로 객체 생성
								// 반환 타입 object -> 형 전환 필요
		Method main = helloClass.getDeclaredMethod("main"); // main() 정보를 가지고 옴
		main.setAccessible(true); // private인 main()을 호출 가능하게 함
		
		main.invoke(hello); // hello.main() 호출
	}
}

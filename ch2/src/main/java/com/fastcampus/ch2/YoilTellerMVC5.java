package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVC5 { // http://localhost/ch2/getYoilMVC5?year=2021&month=1&day=1
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, BindingResult result) {
		System.out.println("result= " + result);
		
		FieldError error = result.getFieldError();
		System.out.println("code= " + error.getCode());
		System.out.println("field= " + error.getField());
		System.out.println("msg= " + error.getDefaultMessage());
		
		ex.printStackTrace();
		
		return "yoilError";
	}

	@RequestMapping("/getYoilMVC5")
	public String main(MyDate date, BindingResult result) throws IOException {
		System.out.println("result= " + result);

		// 1. 유효성 검사
		if (!isValid(date))
			return "yoilError";
		
		return "yoil"; // WEB-INF/views/yoil.jsp
	}

	private boolean isValid(MyDate date) {
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

	private @ModelAttribute("yoil") char getYoil(MyDate date) {
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
	}

	private char getYoil(int year, int month, int day) {
		// 날짜 setting
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:일요일, 2:월요일, ...
		return " 일월화수목금토".charAt(dayOfWeek);
	}

	private boolean isValid(int year, int month, int day) {
		if (year == -1 || month == -1 || day == -1)
			return false;

		return (1 <= month && month <= 12) && (1 <= day && day <= 31); // 간단히 체크
	}
}

package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVC3 { // http://localhost/ch2/getYoilMVC3?year=2021&month=1&day=1
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}

	@RequestMapping("/getYoilMVC3")
	public String main(MyDate date, Model model) throws IOException {

		// 1. 유효성 검사
		if (!isValid(date))
			return "yoilError";

		// 2. 요일 계산
		char yoil = getYoil(date);

		// 3. 계산한 결과를 model에 저장
		model.addAttribute("myDate", date);
		model.addAttribute("yoil", yoil);

		return "yoil"; // WEB-INF/views/yoil.jsp
	}

	private boolean isValid(MyDate date) {
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

	private char getYoil(MyDate date) {
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

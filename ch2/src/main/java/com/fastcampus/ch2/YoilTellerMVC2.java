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
public class YoilTellerMVC2 { // http://localhost/ch2/getYoilMVC2?year=2021&month=1&day=1
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}

	@RequestMapping("/getYoilMVC2")
	public String main(@RequestParam(required = true) int year, @RequestParam(required = true) int month,
			@RequestParam(required = true) int day, Model model) throws IOException {
//	public String main(int year, int month, int day, Model model) throws IOException {
//	public void main(int year, int month, int day, Model model) throws IOException { // 반환 타입을 void로 하면 view의 이름은 mapping된 url에 의해 결정됨
//	public ModelAndView main(int year, int month, int day) throws IOException { // Model + View
//		ModelAndView mv = new ModelAndView();
		// 1. 유효성 검사
		if (!isValid(year, month, day))
			return "yoilError";

		// 2. 요일 계산
		char yoil = getYoil(year, month, day);

		// 3. 계산한 결과를 model에 저장
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
//		mv.addObject("year", year);
//		mv.addObject("month", month);
//		mv.addObject("day", day);
//		mv.addObject("yoil", yoil);

		// 4. 결과를 보여줄 view를 지정
//		mv.setViewName("yoil");
//		
//		return mv;

		return "yoil"; // WEB-INF/views/yoil.jsp
	}

	private boolean isValid(int year, int month, int day) {
		return true;
	}

	private char getYoil(int year, int month, int day) {
		// 날짜 setting
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:일요일, 2:월요일, ...
		return " 일월화수목금토".charAt(dayOfWeek);
	}
}

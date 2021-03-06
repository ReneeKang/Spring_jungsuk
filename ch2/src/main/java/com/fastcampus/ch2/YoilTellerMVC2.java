package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


//년원일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVC2 {// http://localhost:8080/ch2/getYoilMVC2.java?year=2021&month=10&day=1
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC2") // http://localhost:8080/ch2/getYoilMVC2
	public String main(@RequestParam(required=true)int year, 
						@RequestParam(required=true)int month, 
						@RequestParam(required=true)int day, Model model) throws IOException {

		// 1. 유효성 검사
		if (!isValid(year, month, day))
			return "yoilError";

		//2. 요일 계산
		char yoil = getYoil(year, month, day);

		
		// 3. 계산한 결과를 model에 저장
		model.addAttribute("year",year);
		model.addAttribute("month",month);
		model.addAttribute("day",day);
		model.addAttribute("yoil",yoil);
		
		return "yoil"; // WEB-INF/views/yoil.jsp
		
		
//		response.setContentType("text/html");//텍스트 보낸다고 알려주고
//		response.setCharacterEncoding("utf-8");//인코딩 알려주고
//		
//		PrintWriter out = response.getWriter(); //response객체에서 브라우저로의 출력 스트림을 얻는다.
//		
//		out.println(year + "년"+month+"월"+day+"일은");
//		out.println(yoil+"요일입니다.");
////		System.out.println(year + "년"+month+"월"+day+"일은");
////		System.out.println(yoil+"요일입니다.");

	}

	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);// 1:일요일,2:월요일...
		return " 일월화수목금토".charAt(dayOfWeek);
	}
}

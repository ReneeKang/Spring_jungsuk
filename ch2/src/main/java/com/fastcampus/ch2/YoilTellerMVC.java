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
public class YoilTellerMVC { //  http://localhost:8080/ch2/getYoilMVC?year=2021&month=10&day=1
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC")
	public static String main(@RequestParam(required=true)int year,
							@RequestParam(required=true)int month, 
							@RequestParam(required=true)int day, 
							Model model) throws IOException{
	
		
		//2.작업 (요일계산)
		// 1) 유효성검사
		if(!isValid(year,month,day))
			return "yoilError";
		
		// 2) 요일 계산
		char yoil = getYoil(year, month, day);
		
		// 3) 계산한 결과를 model에 저장
		model.addAttribute("year",year);
		model.addAttribute("month",month);
		model.addAttribute("day",day);
		model.addAttribute("yoil",yoil);
		
		
		return "yoil"; //   /WEB-INF/views/yoil.jsp
		
	}
	
	private static boolean isValid(int year, int month, int day) {
		
		return true;
	}

	private static char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1 ,day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);//1:일요일,2:월요일...
		return " 일월화수목금토".charAt(dayOfWeek);
	}
	

	
}









package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;


//������� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTellerMVC6 {
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex,BindingResult result) {
		System.out.println("result="+result);
		FieldError error = result.getFieldError();
		
		System.out.println("cdoe="+error.getCode());
		System.out.println("field="+error.getField());
		System.out.println("msg="+error.getDefaultMessage());
		ex.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC6")// http://localhost:8080/ch2/getYoilMVC6
	public String main(MyDate date, BindingResult result) {
		System.out.println("result: "+result);
		// 1. ��ȿ�� �˻�
		if (!isValid(date))
			return "yoilError";

//		//2. ���� ���
//		char yoil = getYoil(date);
//
//		
//		// 3. ����� ����� model�� ����
//		model.addAttribute("myDate",date);
//		model.addAttribute("yoil",yoil);
//		
		return "yoil"; // WEB-INF/views/yoil.jsp

	}

	
	private boolean isValid(MyDate date) {
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

	private char getYoil(MyDate date) {
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
	}

	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);// 1:�Ͽ���,2:������...
		return " �Ͽ�ȭ�������".charAt(dayOfWeek);
	}
}

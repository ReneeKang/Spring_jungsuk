package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

////������� �Է��ϸ� ������ �˷��ִ� ���α׷�
//public class YoilTeller {
//	public static void main(String[] args) {
//		
//		//1.�Է�
//		String year = args[0];
//		String month = args[0];
//		String day = args[2];
//		
//		int yyyy= Integer.parseInt(year);
//		int mm= Integer.parseInt(month);
//		int dd= Integer.parseInt(day);
//		
//		//2.�۾�
//		Calendar cal = Calendar.getInstance();
//		cal.set(yyyy, mm-1,dd);
//		
//		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);//1:�Ͽ���,2:������...
//		char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek);
//		
//		//3. ���
//		System.out.println(year + "��"+month+"��"+day+"����");
//		System.out.println(yoil+"�����Դϴ�.");
//		
//		
//	}
//}

//������� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTellerMVC {// http://localhost:8080/ch2/getYoilMVC.java?year=2021&month=10&day=1
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC")
//	public void main(HttpServletRequest request,HttpServletResponse response) throws IOException{
//		public void main(String year, String month, String day,HttpServletResponse response) throws IOException{
	public String main(@RequestParam(required=true)int year, 
						@RequestParam(required=true)int month, 
						@RequestParam(required=true)int day, Model model) throws IOException {

		// 1. ��ȿ�� �˻�
		if (!isValid(year, month, day))
			return "yoilError";

		//2. ���� ���
		char yoil = getYoil(year, month, day);

		
		// 3. ����� ����� model�� ����
		model.addAttribute("year",year);
		model.addAttribute("month",month);
		model.addAttribute("day",day);
		model.addAttribute("yoil",yoil);
		
		return "yoil"; // WEB-INF/views/yoil.jsp
		
		
//		response.setContentType("text/html");//�ؽ�Ʈ �����ٰ� �˷��ְ�
//		response.setCharacterEncoding("utf-8");//���ڵ� �˷��ְ�
//		
//		PrintWriter out = response.getWriter(); //response��ü���� ���������� ��� ��Ʈ���� ��´�.
//		
//		out.println(year + "��"+month+"��"+day+"����");
//		out.println(yoil+"�����Դϴ�.");
////		System.out.println(year + "��"+month+"��"+day+"����");
////		System.out.println(yoil+"�����Դϴ�.");

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
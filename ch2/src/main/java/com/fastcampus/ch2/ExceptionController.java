package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
//	//ExceptionHandler�޼������ ��Ʈ�ѷ� �������� �����ִ�.
//	@ExceptionHandler(Exception.class)
//	public String catcher(Exception ex, Model m) {//�޼������� �ڵ����� �޼���� ��������..���ܰ�ü�� �Ѿ��.
//		m.addAttribute("ex",ex);
//		return "error";
//	}//try catch�� ���� ���൵ ������ �̿Ͱ���
//	//������ ����ó�� �޼��带 �߰��ϰ� �ű⿡ @ExceptionHandler(�޼��尡 ó���� ��������)
//	
//	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class}) //�迭�� �����ָ� �ȴ�.
//	public String catcher2(Exception ex, Model m) {
//		m.addAttribute("ex",ex);
//		return "error";
//	}           // -------> GlobalCatcher�� ���ش�. ����Ʈ�ѷ������ۿ� ����������ϴ����� �ذ��Ҽ��ִ�.
	
	@RequestMapping("/ex")
	String main() throws Exception{
			throw new Exception("���ܰ� �߻��߽��ϴ�.");
	}
	
	@RequestMapping("/ex2")
	String main2() throws Exception{
			//throw new NullPointerException("���ܰ� �߻��߽��ϴ�.");
		throw new FileNotFoundException("���ܰ� �߻��߽��ϴ�.");
	}
}
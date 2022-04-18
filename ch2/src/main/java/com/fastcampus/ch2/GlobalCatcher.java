package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalCatcher {

	
		@ExceptionHandler(Exception.class)
		public String catcher(Exception ex, Model m) {//�޼������� �ڵ����� �޼���� ��������..���ܰ�ü�� �Ѿ��.
			m.addAttribute("ex",ex);
			return "error";
		}//try catch�� ���� ���൵ ������ �̿Ͱ���
		//������ ����ó�� �޼��带 �߰��ϰ� �ű⿡ @ExceptionHandler(�޼��尡 ó���� ��������)
		
		@ExceptionHandler({NullPointerException.class, FileNotFoundException.class}) //�迭�� �����ָ� �ȴ�.
		public String catcher2(Exception ex, Model m) {
			m.addAttribute("ex",ex);
			return "error";
		}
}
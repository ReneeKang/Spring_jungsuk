package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController2 {
	
		
	@RequestMapping("/ex3")
	String main() throws Exception{
			throw new Exception("���ܰ� �߻��߽��ϴ�.");
	}
	
	@RequestMapping("/ex4")
	String main2() throws Exception{
			//throw new NullPointerException("���ܰ� �߻��߽��ϴ�.");
		throw new FileNotFoundException("���ܰ� �߻��߽��ϴ�.");
	}
}

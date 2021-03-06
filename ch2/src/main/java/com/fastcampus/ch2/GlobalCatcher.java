package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.fastcampus.ch2") // 지정된 패키지에서 발생한 예외만 처리
//@ControllerAdvice //모든 패키지에 적용
public class GlobalCatcher {
		@ExceptionHandler(Exception.class)
		public String catcher(Exception ex, Model m) {//메서드한테 자동으로 메서드로 예외정보..예외객체가 넘어간다.
			m.addAttribute("ex",ex);
			return "error";
		}//try catch로 직접 해줘도 되지만 이와같이
		//별도의 예외처리 메서드를 추가하고 거기에 @ExceptionHandler(메서드가 처리할 예외종류)
		
		@ExceptionHandler({NullPointerException.class, FileNotFoundException.class}) //배열로 적어주며 된다.
		public String catcher2(Exception ex, Model m) {
			m.addAttribute("ex",ex);
			return "error";
		}
}

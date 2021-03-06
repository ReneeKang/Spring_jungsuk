package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
//	//ExceptionHandler메서드들은 컨트롤러 내에서만 쓸수있다.
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {//메서드한테 자동으로 메서드로 예외정보..예외객체가 넘어간다.
		System.out.println("catcher() in ExceptionController");
		System.out.println("m="+m);
		m.addAttribute("ex",ex);
		return "error";
	}//try catch로 직접 해줘도 되지만 이와같이
	//별도의 예외처리 메서드를 추가하고 거기에 @ExceptionHandler(메서드가 처리할 예외종류)
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class}) //배열로 적어주며 된다.
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex",ex);
		return "error";
	}           // -------> GlobalCatcher로 빼준다. 한컨트롤러에서밖에 사용하지못하는점을 해결할수있다.
	
	@RequestMapping("/ex")
	String main(Model m) throws Exception{
		m.addAttribute("msg","message from ExceptionController.main()");
			throw new Exception("예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex2")
	String main2() throws Exception{
			//throw new NullPointerException("예외가 발생했습니다.");
		throw new FileNotFoundException("예외가 발생했습니다.");
	}
}

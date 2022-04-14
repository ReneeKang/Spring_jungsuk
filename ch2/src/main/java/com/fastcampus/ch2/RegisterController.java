package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class RegisterController {
	@RequestMapping(value="/register/add", method= {RequestMethod.GET, RequestMethod.POST})
//	@RequestMapping("/register/add") //신규회원 가입 화면
//	@GetMapping("/register/add")
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}//이 메서드가 하는일은 registerForm.jsp와 url을 연결해줄 뿐 하는일이 없다. => view 컨트롤러로 변경가능.
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST )
	@PostMapping("/register/save") // spring 4.3버전부터     //get방식으로 요청하면 405에러 발생.
	public String save(User user, Model m) throws Exception{
		
		//1. 유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.","utf-8");
			
			m.addAttribute("msg",msg);
			return "forward:/register/add"; //URL재작성(rewriting)
//			return "redirect:/register/add?msg="+msg; //URL재작성(rewriting)
			
		
		}
		//2. DB에 신규회원 정보를 저장
		
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
//		return false;
		return false;
	}

}

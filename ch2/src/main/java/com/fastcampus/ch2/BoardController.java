package com.fastcampus.ch2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/list")
	public String iist(HttpServletRequest request) {
		if(!loginCheck(request)) {
			
			return "redirect:/login/login?toURL="+request.getRequestURL();// 로그인 체크해서 로그인 안 했으면 로그인화면으로 이동
		}
		return "boardList";// 로그인을 한 상태이면, 게시판 화면으로 이동
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) { //세션객체를 얻어와도 되고 직접써줘도 된다.
		// 1.세션을 종료
		session.invalidate();
		// 2.홈으로 이동
		return "redirect:/";
	}
	
	
	private boolean loginCheck(HttpServletRequest request) {
		// 1.세션을 얻어서
		HttpSession session = request.getSession();
		
		// 2.세션에 id가 있는지 확인, 있으면 true를 반환
//		if(session.getAttribute("id")!=null)
//			return true;
//		else 
//			return false;
		
		return session.getAttribute("id")!=null;
	}
}

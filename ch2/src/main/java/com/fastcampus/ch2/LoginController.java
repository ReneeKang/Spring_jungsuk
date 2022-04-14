package com.fastcampus.ch2;

import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, String rememberId) throws IOException{
		// 1.id�� pwdȮ��
		if(!loginCheck(id,pwd)){
			// 2-1. ��ġ���� ������, loginForm���� �̵�
			String msg = URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.","utf-8");
			return "redirect:/login/login?msg="+msg;
		}
		// 2-2. id�� pwd�� ��ġ�ϸ�, Ȩ���� �̵�
		return "redirect:/";
	}

	private boolean loginCheck(String id, String pwd) {
		
		return false;
	}


}
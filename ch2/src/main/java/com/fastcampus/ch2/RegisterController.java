package com.fastcampus.ch2;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
@RequestMapping("/register")
public class RegisterController {
	
	
	@InitBinder
	public void toData(WebDataBinder binder) {
		ConversionService conversionService = binder.getConversionService();
		System.out.println("conversionService = "+conversionService);
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
		binder.setValidator(new UserValidator()); // UserValidator를 WebdataBinder의 로컬 validator로 등록
	}
	
	
	
	@RequestMapping(value="/add", method= {RequestMethod.GET, RequestMethod.POST})
//	@RequestMapping("/register/add") //신규회원 가입 화면
//	@GetMapping("/register/add")
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}//이 메서드가 하는일은 registerForm.jsp와 url을 연결해줄 뿐 하는일이 없다. => view 컨트롤러로 변경가능.
	
	
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST )
	@PostMapping("/save") // spring 4.3버전부터     //get방식으로 요청하면 405에러 발생.
	public String save(@Valid User user,BindingResult result, Model m) throws Exception{
		System.out.println("result = "+result);
		System.out.println("User = "+user);
		
		
		//수동 검증 - Validator를 직접 생성하고, validate()를 직접 호출.
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user,result);//BindingResult 는 Errors의 자손
		
		//User객체를 검증한 결과가 에러 있으면, registerForm을 이용해서 에러를 보여줘야 함.
		if(result.hasErrors()) {
			return "registerForm";
		}
		
		
//		//1. 유효성 검사
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.","utf-8");
//			
//			m.addAttribute("msg",msg);
//			return "forward:/register/add"; //URL재작성(rewriting)
////			return "redirect:/register/add?msg="+msg; //URL재작성(rewriting)
//		}
		//2. DB에 신규회원 정보를 저장
		
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
//		return false;
		return true;
	}

}

package kr.co.spring_project.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import kr.co.spring_project.member.dto.ReqLoginDTO;
import kr.co.spring_project.member.dto.ReqsignupDTO;
import kr.co.spring_project.member.dto.ResLoginDTO;
import kr.co.spring_project.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("/signup/form") 
	public String signupForm() {
		return "/signup";
	}
	
	@PostMapping("/signup")
	public String signup(ReqsignupDTO request){
		memberService.signup(request);
		return "redirect:/member/login/form";
	}
	
	@GetMapping("/login/form")
	public String loginForm() {
	    return "/login"; 
	    }
	
	@PostMapping("/login")
	public String login(ReqLoginDTO request,
					    HttpSession session) {
		ResLoginDTO response = memberService.login(request);
		
		if(response == null) {
			return"redirect:/member/login/form";
		}
		
		session.setAttribute("LOGIN_USER", response);
		return "redirect:/"; 
	}

	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); 
		return "redirect:/";
	}
}
	

	


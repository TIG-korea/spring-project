package kr.co.spring_project.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.spring_project.member.service.MemberService;
import lombok.RequiredArgsConstructor;




@Controller
@RequestMapping("/partials")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("/signup/form")
	public String signupFrom() {
		return "partials/signup";
	}
	
	
	
	

}

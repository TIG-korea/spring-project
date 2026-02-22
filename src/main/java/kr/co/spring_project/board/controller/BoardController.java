package kr.co.spring_project.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import kr.co.spring_project.board.dto.ReqBoardDTO;
import kr.co.spring_project.board.service.BoardService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/question/form")
	public String questionForm() {
		return "/form";
	}
	
	@PostMapping("/create")
	public String create(ReqBoardDTO request, HttpSession session) {
		
		ResLoginDTO loginUser = (ResLoginDTO)session.getAttribute("LOGIN_USER");
		
		if(loginUser == null) {
			return "redirect:/member/login/form";
		}
		
		
		boardService.write(request, loginUser.getId());
		
		
		return "redirect:/";
	}

}

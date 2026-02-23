package kr.co.spring_project.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import kr.co.spring_project.board.dto.AnswerRequestDTO;
import kr.co.spring_project.board.service.AnswerService;
import kr.co.spring_project.member.dto.ResLoginDTO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping()



// 일단 임의로 지정
public class AnswerController {   
	private final AnswerService answerService;
	
	@PostMapping("/create/{boardId}")
	public String create(@PathVariable Long boardId, AnswerRequestDTO request) {
		
		answerService.createanswer(boardId, request);
		
		return "redirect:/board/detail/" + boardId;
	}
	

	@GetMapping("/delete/{boardId}/{answerId}")
	public String delete(@PathVariable Long boardId, @PathVariable Long answerId, HttpSession session) {
		
		ResLoginDTO loginUser = (ResLoginDTO) session.getAttribute("LOGIN_USER");
        if (loginUser == null) {
            return "redirect:/member/login/form";
}
    
        answerService.deleteAnswer(answerId);
    
        return "redirect:/board/detail/" + boardId;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	}
    
}

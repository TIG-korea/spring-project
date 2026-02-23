package kr.co.spring_project.board.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import kr.co.spring_project.board.dto.ReqBoardDTO;
import kr.co.spring_project.board.dto.ResBoardDTO;
import kr.co.spring_project.board.service.BoardService;
import kr.co.spring_project.member.dto.ResLoginDTO;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping
	public String home(@RequestParam(name="page", defaultValue = "1") int page, Model model) {
		
		Page<ResBoardDTO> list = boardService.getBoardList(page - 1);
		
		int currentPage = list.getNumber() + 1;
		int totalPages = list.getTotalPages();
		
		int blockSize = 3;
		
		int startPage = ((currentPage - 1 / blockSize) * blockSize + 1);
		
		int endPage = startPage + blockSize - 1;
		
		if(endPage > totalPages) {
			endPage = totalPages;
		}
		
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		
		return "/home";
	}
	
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

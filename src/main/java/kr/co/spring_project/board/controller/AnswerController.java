package kr.co.spring_project.board.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.spring_project.board.dto.AnswerRequestDTO;
import kr.co.spring_project.board.service.AnswerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class AnswerController {
	private final AnswerService answerService;
	
	// 특정 게시물(boardId)에 답변 등록하는 API
    @PostMapping("/{boardId}/answers")
    public String createAnswer(@PathVariable Long boardId, @RequestBody AnswerRequestDTO dto) {
        answerService.createAnswer(boardId, dto);
        return "답변 등록 완료!";
}
}

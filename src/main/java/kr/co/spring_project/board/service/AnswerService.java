package kr.co.spring_project.board.service;

import kr.co.spring_project.board.dto.AnswerRequestDTO;

public interface AnswerService {

    void createanswer(Long boardId, AnswerRequestDTO request);
    
}

package kr.co.spring_project.board.service.impl;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kr.co.spring_project.board.dto.AnswerRequestDTO;
import kr.co.spring_project.board.entity.Board;
import kr.co.spring_project.board.entity.BoardAnswer;
import kr.co.spring_project.board.repository.AnswerRepository;
import kr.co.spring_project.board.repository.BoardRepository;
import kr.co.spring_project.board.service.AnswerService;
import lombok.RequiredArgsConstructor;





@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService{
	private final AnswerRepository answerRepository;
    private final BoardRepository boardRepository;
	
    @Override
    @Transactional
	public void createanswer(Long boardId, AnswerRequestDTO request){
		
	    	// 1. 답변을 달 게시글(Board) 조회
	    	Board board = boardRepository.findById(boardId)
	    			.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + boardId));
	    	
	    	// 답변 엔티티 생성 및 데이터 세팅
	        BoardAnswer answer = new BoardAnswer();
	        answer.setContent(request.getContent());
	        answer.setBoard(board);

	        // DB에 저장
	        answerRepository.save(answer); 
}
	
}

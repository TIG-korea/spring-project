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
		
	    	// 1. 답변을 달 게시글(Board) 조회    .orElseThrow(...) 사용해서 작성해보기
	    	Board board = boardRepository.findById(boardId)
	    			.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + boardId));
	    	
	        BoardAnswer answer = new BoardAnswer();
	        			answer.setContent(request.getContent());
	        			answer.setBoard(board);
	        			
//	        Board board = boardRepository.findById(boardId).orElse(null);	(Build 패턴 사용)
//	        
//	        if (board == null) {
//	            System.out.println("게시글을 찾을 수 없습니다.");
//	            return; // 메서드 종료
//	        }		
//	        
//	        BoardAnswer answer = BoardAnswer.builder()
//	                .content(request.getContent())
//	                .board(board)
//	                .build();
//	        			
	        			
	        			

	        // DB에 저장
	        answerRepository.save(answer); 
}
    
    @Override
    @Transactional
    public void deleteAnswer(Long answerId) {
    	// 1. 지우려는 답변이 실제로 존재하는지 확인 (없으면 에러 발생)
        BoardAnswer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new IllegalArgumentException("해당 답변이 존재하지 않습니다. id=" + answerId));
        
        answerRepository.delete(answer);
    }
	
//     배운대로 if문 사용할때
//    public void deleteAnswer(Long answerId) {
//    	BoardAnswer answer = answerRepository.findById(answerId).orElse(null);
//    	
//    	if (answer == null) {
//    		System.out.println("유효하지 않은 답변입니다."); // 콘솔 메세지 출력
//    		return;
//    	}
//    	
//    	answerRepository.delete(answer);
//    }
   
    
    
    
    
}

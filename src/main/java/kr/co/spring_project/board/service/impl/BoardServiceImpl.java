package kr.co.spring_project.board.service.impl;

import org.springframework.stereotype.Service;

import kr.co.spring_project.board.dto.ReqBoardDTO;
import kr.co.spring_project.board.entity.Board;
import kr.co.spring_project.board.repository.BoardRepository;
import kr.co.spring_project.board.service.BoardService;
import kr.co.spring_project.member.entity.Member;
import kr.co.spring_project.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardRepository boardRepository;
	private final MemberRepository memberRepository;
	
	public void write(ReqBoardDTO request, Long id) {
		
		Member writer = memberRepository.findById(id).orElse(null);
		
		if(writer == null) {
			System.out.println("유효하지 않은 사용자입니다.");
		}
		
		Board board = Board.builder()
					  .id(writer.getId())
					  .title(request.getTitle())
					  .content(request.getContent())
					  .writerId(writer)
					  .viewCount(0)
					  .build();
		
		boardRepository.save(board);
					  
		
	}

}

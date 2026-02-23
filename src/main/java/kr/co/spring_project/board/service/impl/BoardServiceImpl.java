package kr.co.spring_project.board.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kr.co.spring_project.board.dto.ReqBoardDTO;
import kr.co.spring_project.board.dto.ResBoardDTO;
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
	
	public Page<ResBoardDTO> getBoardList(int page) { 
		
		Pageable pageable = PageRequest.of(page, 5, Sort.by("id").descending());
		
		Page<Board> boardList = boardRepository.findAllByOrderByIdDesc(pageable);
		
		List<ResBoardDTO> list = new ArrayList<>();
		
		for (Board b : boardList) {
			ResBoardDTO response = ResBoardDTO.builder()
								   .id(b.getId())
								   .title(b.getTitle())
								   .content(b.getContent())
								   .createdAt(b.getCreatedAt())
								   .writerName(b.getWriterId().getNickname()) // Member 엔티티의 nickname
								   .viewCount(b.getViewCount())
								   .build();
			
			list.add(response);
		}
		
		return new PageImpl<>(list, pageable, boardList.getTotalElements());
	}

}

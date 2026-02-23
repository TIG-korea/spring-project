package kr.co.spring_project.board.service;

import org.springframework.data.domain.Page;

import kr.co.spring_project.board.dto.ReqBoardDTO;
import kr.co.spring_project.board.dto.ResBoardDTO;

public interface BoardService {
	
	void write(ReqBoardDTO request, Long id);
	
	Page<ResBoardDTO> getBoardList(int page);
	
	
	

}

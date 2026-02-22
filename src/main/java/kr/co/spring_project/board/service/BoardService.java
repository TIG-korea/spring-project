package kr.co.spring_project.board.service;

import kr.co.spring_project.board.dto.ReqBoardDTO;

public interface BoardService {
	
	void write(ReqBoardDTO request, Long id);
	
	
	

}

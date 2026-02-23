package kr.co.spring_project.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReqBoardDTO {
	
	private String title;
	private String content;
	private String nickname; // 로그인한 아이디에 닉네임이 바로 들어가게 구현 할 예정

}

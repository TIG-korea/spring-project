package kr.co.spring_project.board.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ResBoardDTO {
	
	private Long id;
	private String title;
	private String content;
	private String writerName; // nickName
	private LocalDateTime createdAt;
	private int viewCount;
	
	
	

}

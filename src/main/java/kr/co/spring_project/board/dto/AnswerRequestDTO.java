package kr.co.spring_project.board.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerRequestDTO {
	@NotEmpty(message = "답변 내용은 필수입니다.")
    private String content;

}

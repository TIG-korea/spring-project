package kr.co.spring_project.board.entity;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class BoardAnswer extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 번호를 자동으로 생성해줍니다.
    private Long id;
	
	@Column(columnDefinition = "TEXT", nullable = false)
    private String content;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private User user; // user_id 컬럼과 자동 매핑됨

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;
	
	
}

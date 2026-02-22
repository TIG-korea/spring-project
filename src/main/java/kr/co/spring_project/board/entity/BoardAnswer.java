package kr.co.spring_project.board.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BoardAnswer extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 번호를 자동으로 생성해줍니다.
    private Long id;
	
	@Column(columnDefinition = "TEXT", nullable = false)
    private String content;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private User user; // user_id 컬럼과 자동 매핑됨

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id") // DB에 생성될 외래키(FK) 컬럼명 지정
    private Board board;
	
	
}

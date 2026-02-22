package kr.co.spring_project.board.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import kr.co.spring_project.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@Lob
	private String content;
	
//	@ManyToOne
//	@JoinColumn(name = "writer_id")
//	private Member writerId; 나중에 합치고 다시 생성
	
	// 임시 엔티티
	@Column(name = "writer_id", nullable = false)
    private Long writerId;
	
	private int viewCount;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	

}

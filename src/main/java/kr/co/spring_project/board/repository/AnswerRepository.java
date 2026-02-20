package kr.co.spring_project.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.spring_project.board.entity.BoardAnswer;

public interface AnswerRepository extends JpaRepository<BoardAnswer, Long> {

}

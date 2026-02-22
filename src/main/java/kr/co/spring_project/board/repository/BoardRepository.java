package kr.co.spring_project.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.spring_project.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}

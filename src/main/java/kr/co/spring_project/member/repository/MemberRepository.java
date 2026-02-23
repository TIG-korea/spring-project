package kr.co.spring_project.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.spring_project.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	
	 Optional<Member> findByUserId(String userId);
	 boolean existsByUserId(String userId);
	 boolean existsByEmail(String email);
}
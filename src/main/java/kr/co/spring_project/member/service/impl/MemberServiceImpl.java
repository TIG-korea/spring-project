package kr.co.spring_project.member.service.impl;

import org.springframework.stereotype.Service;

import kr.co.spring_project.member.dto.ResignupDTO;
import kr.co.spring_project.member.entity.Member;
import kr.co.spring_project.member.repository.MemberRepository;
import kr.co.spring_project.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void signup(ResignupDTO dto) {

        if (!dto.getPassword().equals(dto.getPasswordConfirm())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        Member member = new Member();
        member.setUsername(dto.getUsername());
        member.setName(dto.getName());
        member.setEmail(dto.getEmail());
        member.setPhone(dto.getPhone());
        member.setPassword(dto.getPassword()); // ⚠ 나중에 암호화
        member.setNickname(dto.getNickname());

        memberRepository.save(member);
    }

    @Override
    public boolean login(String username, String password) {
        return memberRepository.findByUsername(username)
                .map(m -> m.getPassword().equals(password))
                .orElse(false);
    }
}
package kr.co.spring_project.member.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import kr.co.spring_project.member.dto.ReqLoginDTO;
import kr.co.spring_project.member.dto.ReqsignupDTO;
import kr.co.spring_project.member.dto.ResLoginDTO;
import kr.co.spring_project.member.entity.Member;
import kr.co.spring_project.member.repository.MemberRepository;
import kr.co.spring_project.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    
    @Override
    public void signup(ReqsignupDTO request) {

    
        if (memberRepository.existsByUserId(request.getUserId())) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }

       
        if (memberRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

      
        if (!request.getPassword().equals(request.getPasswordConfirm())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

      
        Member member = new Member();
        member.setUserId(request.getUserId());
        member.setUserName(request.getUserName());
        member.setEmail(request.getEmail());
        member.setNumber(request.getNumber());
        member.setPassword(request.getPassword());
        member.setNickname(request.getNickname());

       
        memberRepository.save(member);
    }

    
   @Override
   public ResLoginDTO login(ReqLoginDTO request) {

        Optional<Member> optionalMember =
                memberRepository.findByUserId(request.getUserId());

        if (optionalMember.isEmpty()) {
            return null;
        }

        Member member = optionalMember.get();

        if (!member.getPassword().equals(request.getPassword())) {
            return null;
        }

        ResLoginDTO response = new ResLoginDTO();
        response.setId(member.getId());
        response.setUserId(member.getUserId());
        response.setUserName(member.getUserName());
        response.setNickname(member.getNickname());

        return response;
    }
}
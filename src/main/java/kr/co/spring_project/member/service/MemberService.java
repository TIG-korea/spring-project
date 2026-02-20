package kr.co.spring_project.member.service;

import kr.co.spring_project.member.dto.ReLoginDTO;
import kr.co.spring_project.member.dto.ResLoginDTO;
import kr.co.spring_project.member.dto.ResignupDTO;

public interface MemberService {
	void signup(ResignupDTO request);
	ResLoginDTO login(ReLoginDTO request);
	
	

}

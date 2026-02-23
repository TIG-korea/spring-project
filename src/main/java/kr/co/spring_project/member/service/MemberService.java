package kr.co.spring_project.member.service;

import kr.co.spring_project.member.dto.ReqLoginDTO;
import kr.co.spring_project.member.dto.ResLoginDTO;
import kr.co.spring_project.member.dto.ReqsignupDTO;

public interface MemberService {
	void signup(ReqsignupDTO request);
	ResLoginDTO login(ReqLoginDTO request);
	
	

}

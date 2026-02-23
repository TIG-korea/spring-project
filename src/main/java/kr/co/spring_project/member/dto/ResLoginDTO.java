package kr.co.spring_project.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResLoginDTO {
    private Long memberId;
    private String userId;
    private String userName;
}
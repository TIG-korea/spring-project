package kr.co.spring_project.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ResLoginDTO {
    private Long id;
    private String userId;
    private String userName;
    private String nickname;
}
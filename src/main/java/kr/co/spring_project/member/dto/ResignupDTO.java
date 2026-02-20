package kr.co.spring_project.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResignupDTO {
	private String userId;
	private String username;
	private String email;
	private String number;
	private String password;
	private String checkPassword;
	private String nickName;
	
	

}

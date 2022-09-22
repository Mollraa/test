package co.micol.hee.member.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {  //DTO
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberTel;
	private String memberAuthor;
}

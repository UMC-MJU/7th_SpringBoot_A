package umc.spring.service.Member;


import umc.spring.domain.Member;
import umc.spring.web.dto.member.MemberRequestDTO;

public interface MemberCommandService  {

    Member joinMember(MemberRequestDTO.JoinDTO request);
}

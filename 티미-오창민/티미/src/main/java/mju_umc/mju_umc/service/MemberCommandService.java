package mju_umc.mju_umc.service;

import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.web.dto.member.MemberRequestDTO;

public interface MemberCommandService {
    //회원을 등록하고, 회원을 반환하는 메소드 + DB에 저장까지
    Member joinMember(MemberRequestDTO.JoinDto request);
}

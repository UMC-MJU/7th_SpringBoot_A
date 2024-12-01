package umc.spring.repository.memberRepository;

import umc.spring.dto.MemberDTO;

public interface MemberRepositoryCustom {
    MemberDTO findMemberById(Long memberId);
}

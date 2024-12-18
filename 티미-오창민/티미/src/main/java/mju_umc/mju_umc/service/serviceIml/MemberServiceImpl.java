package mju_umc.mju_umc.service.serviceIml;

import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.repository.MemberRepository;
import mju_umc.mju_umc.response.code.status.ErrorStatus;
import mju_umc.mju_umc.response.exception.handler.MemberHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl {
    private final MemberRepository memberRepository;

    public Member saveMember(Member member) {
        Member savedMember = memberRepository.save(member);
        return savedMember;

    }

    public Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
    }
}

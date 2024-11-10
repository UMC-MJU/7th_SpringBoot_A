package mju_umc.mju_umc.service.serviceIml;

import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl {
    private final MemberRepository memberRepository;

    public void saveMember(Member member) {
        memberRepository.save(member);
    }
}

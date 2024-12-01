package umc.spring.service.MemberMissionService;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.api.dto.MemberRequestDTO;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.repository.MemberRepository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionServiceImpl implements MemberMissionService {

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<MemberMission> getMissionList(Long memberId, Integer page) {
        // 멤버 존재 확인
        Member member = memberRepository.findById(memberId).get();
        Page<MemberMission> pages = memberMissionRepository.findAllByMember(member, PageRequest.of(page, 10));
        // 멤버 기준 미션 조회
        return pages;
    }
}
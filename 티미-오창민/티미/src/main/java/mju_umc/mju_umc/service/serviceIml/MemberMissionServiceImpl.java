package mju_umc.mju_umc.service.serviceIml;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.Mission;
import mju_umc.mju_umc.domain.Region;
import mju_umc.mju_umc.domain.mapping.MemberMission;
import mju_umc.mju_umc.repository.MemberMissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberMissionServiceImpl {
    private final MemberMissionRepository memberMissionRepository;
    @Transactional
    public void saveMemberMission(MemberMission memberMission, Member member) {
        member.setMission(memberMission);

        log.info("Saving member mission: {}", memberMission); // 로그 추가
        memberMissionRepository.save(memberMission);
        log.info("Member mission saved successfully");

        //연관관계 매핑

    }

    public List<MemberMission> getAbleMissionsInRegionByMember(Region region, Member member) {
        List<MemberMission> memberMissions = memberMissionRepository.getAbleMissionsInRegionByMember(region, member);
        return memberMissions;
    }


}

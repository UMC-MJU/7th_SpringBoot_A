package mju_umc.mju_umc.service.serviceIml;

import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.Region;
import mju_umc.mju_umc.domain.mapping.MemberMission;
import mju_umc.mju_umc.repository.MemberMissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberMissionServiceImpl {
    private final MemberMissionRepository memberMissionRepository;

    public void saveMemberMission(MemberMission mission) {
        memberMissionRepository.save(mission);
    }

    public List<MemberMission> getAbleMissionsInRegionByMember(Region region, Member member) {
        List<MemberMission> memberMissions = memberMissionRepository.getAbleMissionsInRegionByMember(region, member);
        return memberMissions;
    }


}

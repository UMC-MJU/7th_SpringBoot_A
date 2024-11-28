package mju_umc.mju_umc.service.serviceIml;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mju_umc.mju_umc.converter.MemberMissionConverter;
import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.Mission;
import mju_umc.mju_umc.domain.Region;
import mju_umc.mju_umc.domain.mapping.MemberMission;
import mju_umc.mju_umc.repository.MemberMissionRepository;
import mju_umc.mju_umc.repository.MemberRepository;
import mju_umc.mju_umc.repository.MissionRepository;
import mju_umc.mju_umc.service.MemberMissionService;
import mju_umc.mju_umc.web.dto.memberMission.MemberMissionRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberMissionServiceImpl implements MemberMissionService {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;



    public List<MemberMission> getAbleMissionsInRegionByMember(Region region, Member member) {
        List<MemberMission> memberMissions = memberMissionRepository.getAbleMissionsInRegionByMember(region, member);
        return memberMissions;
    }


    @Override
    public MemberMission addMemberMission(MemberMissionRequestDto.addMemberMission request) {
        //리턴되는 미션에는, 멤버, 미션 모두 없다.
        MemberMission memberMission = MemberMissionConverter.toMemberMission(request);
        //아이디로 객체 조회
        Member member = memberRepository.findById(request.getMemberId()).get();
        Mission mission = missionRepository.findById(request.getMissionId()).get();
        //연관관계 매핑
        memberMission.setMember(member);
        memberMission.setMission(mission);
        //저장 및 반환
        return memberMissionRepository.save(memberMission);
    }

}

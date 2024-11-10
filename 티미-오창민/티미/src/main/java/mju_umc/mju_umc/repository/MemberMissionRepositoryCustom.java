package mju_umc.mju_umc.repository;

import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.Region;
import mju_umc.mju_umc.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMission> getAbleMissionsInRegionByMember(Region region, Member member);

}



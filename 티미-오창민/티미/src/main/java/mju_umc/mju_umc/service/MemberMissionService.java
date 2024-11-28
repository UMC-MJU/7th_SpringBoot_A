package mju_umc.mju_umc.service;

import mju_umc.mju_umc.domain.mapping.MemberMission;
import mju_umc.mju_umc.web.dto.memberMission.MemberMissionRequestDto;

public interface MemberMissionService {
    public MemberMission addMemberMission(MemberMissionRequestDto.addMemberMission request);
}

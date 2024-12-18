package mju_umc.mju_umc.service;

import mju_umc.mju_umc.domain.mapping.MemberMission;
import mju_umc.mju_umc.web.dto.memberMission.MemberMissionRequestDto;
import mju_umc.mju_umc.web.dto.memberMission.MemberMissionResponseDto;

public interface MemberMissionService {
    public MemberMission addMemberMission(MemberMissionRequestDto.addMemberMission request);

    public MemberMission toComplete(MemberMissionRequestDto.toComplete request);
}

package mju_umc.mju_umc.service;

import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.Mission;
import mju_umc.mju_umc.domain.enums.MissionStatus;

import java.util.List;

public interface MissionQueryService {
    List<Mission> getClearOrProgressMissionByMember(MissionStatus status, Member member);

}

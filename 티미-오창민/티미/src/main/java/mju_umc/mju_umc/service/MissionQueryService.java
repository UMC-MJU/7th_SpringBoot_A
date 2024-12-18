package mju_umc.mju_umc.service;

import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.Mission;
import mju_umc.mju_umc.domain.enums.MissionStatus;
import mju_umc.mju_umc.web.dto.mission.MissionRequestDto;

import java.util.List;

public interface MissionQueryService {
    List<Mission> getMissionsByMemberAndStatus(MissionStatus status, Member member, Integer page);
    List<Mission> getMissionByStore(Long storeId, Integer page);
    Mission addMission(MissionRequestDto.addMission request);
}

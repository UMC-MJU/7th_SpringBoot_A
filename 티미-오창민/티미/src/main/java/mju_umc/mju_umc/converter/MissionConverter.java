package mju_umc.mju_umc.converter;

import mju_umc.mju_umc.domain.Mission;
import mju_umc.mju_umc.web.dto.mission.MissionRequestDto;
import mju_umc.mju_umc.web.dto.mission.MissionResponseDto;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDto.addMissionResult toAddMissionResult(Mission mission) {
        return MissionResponseDto.addMissionResult.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    //요청을 받아 객체로 반환
    public static Mission toMission(MissionRequestDto.addMission request) {
        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .build();
    }
}

package mju_umc.mju_umc.converter;

import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.Mission;
import mju_umc.mju_umc.domain.enums.MissionStatus;
import mju_umc.mju_umc.domain.mapping.MemberMission;
import mju_umc.mju_umc.web.dto.memberMission.MemberMissionRequestDto;
import mju_umc.mju_umc.web.dto.mission.MissionResponseDto;
import mju_umc.mju_umc.web.dto.memberMission.MemberMissionResponseDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static MemberMissionResponseDto.addMissionResult toAddMemberMissionResult(MemberMission memberMission) {
        return MemberMissionResponseDto.addMissionResult
                .builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now()).build();
    }






    public static MemberMission toMemberMission(MemberMissionRequestDto.addMemberMission request) {
        return MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .build();
    }
}

package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.api.dto.MemberMissionDTO;
import umc.spring.api.dto.MissionResponseDTO;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    // Page<MemberMission>를 MissionPreviewListDTO로 변환
    public static MemberMissionDTO.MissionPreviewListDTO toMissionPreviewListDTO(Page<MemberMission> memberMissions) {
        List<MemberMissionDTO.MissionPreviewDTO> missionPreviewDTOList = memberMissions.getContent().stream()
                .map(MemberMissionConverter::toMissionPreviewDTO)
                .collect(Collectors.toList());

        return MemberMissionDTO.MissionPreviewListDTO.builder()
                .missions(missionPreviewDTOList)
                .isFirst(memberMissions.isFirst())
                .isLast(memberMissions.isLast())
                .totalElements(memberMissions.getTotalElements())
                .totalPages(memberMissions.getTotalPages())
                .build();
    }

    // MemberMission을 MissionPreviewDTO로 변환
    private static MemberMissionDTO.MissionPreviewDTO toMissionPreviewDTO(MemberMission memberMission) {
        Mission mission = memberMission.getMission();
        return MemberMissionDTO.MissionPreviewDTO.builder()
                .missionId(mission.getId())
                .status(memberMission.getStatus().name())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .build();
    }
}


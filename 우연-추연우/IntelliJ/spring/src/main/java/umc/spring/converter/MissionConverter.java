package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.mission.MissionRequestDTO;
import umc.spring.web.dto.mission.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MissionConverter {

    public static MissionResponseDTO.addResultDTO toJoinResultDTO(Mission mission) {
        return MissionResponseDTO.addResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(Store store, MissionRequestDTO.addMissionResultDTO request) {

        return Mission.builder()
                .memberMissionList(new ArrayList<>())
                .reward(request.getReward())
                .missionSpec(request.getMissionSpec())
                .store(store)
                .build();
    }
}

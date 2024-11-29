package umc.spring.service.Mission;

import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.MissionDTO;
import umc.spring.dto.MissionRegionDTO;
import umc.spring.web.dto.mission.MissionRequestDTO;

import java.util.List;

public interface MissionQueryService {
    List<MissionDTO> getOngoingMissions(Long memberId, Long cursor);
    List<MissionDTO> getFinishedMissions(Long memberId, Long cursor);
    List<MissionRegionDTO> getMissionsInRegion(String regionName, Long cursor, Long memberId);

    Mission addMission(Long storeId, MissionRequestDTO.addMissionResultDTO request);

    MemberMission changeMissionToOnGoing(Long missionId);
}

package umc.spring.service.Mission;

import umc.spring.dto.MissionDTO;
import umc.spring.dto.MissionRegionDTO;

import java.util.List;

public interface MissionQueryService {
    List<MissionDTO> getOngoingMissions(Long memberId, Long cursor);
    List<MissionDTO> getFinishedMissions(Long memberId, Long cursor);
    List<MissionRegionDTO> getMissionsInRegion(String regionName, Long cursor, Long memberId);
}

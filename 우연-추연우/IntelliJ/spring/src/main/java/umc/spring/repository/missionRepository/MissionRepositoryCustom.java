package umc.spring.repository.missionRepository;

import umc.spring.dto.MissionDTO;
import umc.spring.dto.MissionRegionDTO;

import java.util.List;

public interface MissionRepositoryCustom {
    List<MissionDTO> findIsOnGoingMissions(Long memberId, Long cursor);
    List<MissionDTO> findIsFinishedMissions(Long memberId, Long cursor);
    List<MissionRegionDTO> findMissionsInRegion(String regionName, Long cursor, Long memberId);
}

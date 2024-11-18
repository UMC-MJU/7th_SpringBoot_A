package umc.spring.service.Mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.dto.MissionDTO;
import umc.spring.dto.MissionRegionDTO;
import umc.spring.repository.missionRepository.MissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;

    @Override
    public List<MissionDTO> getOngoingMissions(Long memberId, Long cursor) {
        return missionRepository.findIsOnGoingMissions(memberId, cursor);
    }

    @Override
    public List<MissionDTO> getFinishedMissions(Long memberId, Long cursor) {
        return missionRepository.findIsFinishedMissions(memberId, cursor);
    }

    @Override
    public List<MissionRegionDTO> getMissionsInRegion(String regionName, Long cursor, Long memberId) {
        return missionRepository.findMissionsInRegion(regionName, cursor, memberId);
    }
}

package umc.spring.repository.MissionHomeRepository;

import umc.spring.domain.MissionHomeDTO;

import java.util.List;

public interface MissionHomeRepositoryCustom {
    List<MissionHomeDTO> findChallengingMissionAtHome(Long memberId, String regionName);
}

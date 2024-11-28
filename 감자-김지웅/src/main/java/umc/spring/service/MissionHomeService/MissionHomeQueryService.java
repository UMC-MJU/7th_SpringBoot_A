package umc.spring.service.MissionHomeService;

import umc.spring.domain.Mission;
import umc.spring.domain.MissionHomeDTO;
import umc.spring.domain.enums.MissionStatus;

import java.util.List;
import java.util.Optional;

public interface MissionHomeQueryService {
    List<MissionHomeDTO> getChallengingMissions(Long memberId, String regionName);
}

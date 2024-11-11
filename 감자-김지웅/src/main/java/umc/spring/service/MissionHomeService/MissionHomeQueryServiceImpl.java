package umc.spring.service.MissionHomeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.MissionHomeDTO;
import umc.spring.repository.MissionHomeRepository.MissionHomeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionHomeQueryServiceImpl implements MissionHomeQueryService {

    private final MissionHomeRepository missionHomeRepository;

    public List<MissionHomeDTO> getChallengingMissions(Long memberId, String regionName) {
        return missionHomeRepository.findChallengingMissionAtHome(memberId, regionName);
    }
}

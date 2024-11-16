package mju_umc.mju_umc.service.serviceIml;

import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.Mission;
import mju_umc.mju_umc.domain.Region;
import mju_umc.mju_umc.domain.enums.MissionStatus;
import mju_umc.mju_umc.repository.MissionRepository;
import mju_umc.mju_umc.service.MissionQueryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository; //jpa 기본 리포지토리와 커스텀한 메소드까지 가져오기

    @Override
    public List<Mission> getMissionsByMemberAndStatus(MissionStatus status, Member member) {
        List<Mission> missions = missionRepository.getMissionsByMemberAndStatus(status, member);
        return missions;
    }



    public List<Mission> getAllMission() {
        return missionRepository.findAll();
    }

}

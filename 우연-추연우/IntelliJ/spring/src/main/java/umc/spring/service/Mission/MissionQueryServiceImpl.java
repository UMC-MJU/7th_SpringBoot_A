package umc.spring.service.Mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.MissionDTO;
import umc.spring.dto.MissionRegionDTO;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.repository.memberMissionRepository.MemberMissionRepository;
import umc.spring.repository.memberRepository.MemberRepository;
import umc.spring.repository.missionRepository.MissionRepository;
import umc.spring.web.dto.mission.MissionRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

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

    @Override
    public Mission addMission(Long storeId, MissionRequestDTO.addMissionResultDTO request) {

        Store store = storeRepository.getReferenceById(storeId);

        Mission newMission = MissionConverter.toMission(store, request);

        return missionRepository.save(newMission);
    }

    @Override
    public MemberMission changeMissionToOnGoing(Long missionId) {

        Member member = memberRepository.getReferenceById(1L);

        Mission mission = missionRepository.getReferenceById(missionId);

        MemberMission memberMission = MemberMissionConverter.toMemberMission(member, mission);

        return memberMissionRepository.save(memberMission);
    }
}

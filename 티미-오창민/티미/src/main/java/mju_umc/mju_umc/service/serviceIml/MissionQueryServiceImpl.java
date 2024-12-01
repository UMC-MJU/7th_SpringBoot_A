package mju_umc.mju_umc.service.serviceIml;

import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.converter.MissionConverter;
import mju_umc.mju_umc.domain.*;
import mju_umc.mju_umc.domain.enums.MissionStatus;
import mju_umc.mju_umc.repository.MissionRepository;
import mju_umc.mju_umc.repository.ReviewRepository;
import mju_umc.mju_umc.repository.StoreRepository;
import mju_umc.mju_umc.response.code.status.ErrorStatus;
import mju_umc.mju_umc.response.exception.handler.StoreHandler;
import mju_umc.mju_umc.service.MissionQueryService;
import mju_umc.mju_umc.web.dto.mission.MissionRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository; //jpa 기본 리포지토리와 커스텀한 메소드까지 가져오기
    private final StoreRepository storeRepository;
    @Override
    public List<Mission> getMissionsByMemberAndStatus(MissionStatus status, Member member, Integer page) {
        List<Mission> missions = missionRepository.getMissionsByMemberAndStatus(status, member, page);
        return missions;
    }

    @Override
    public List<Mission> getMissionByStore(Long storeId, Integer page) {
        //가게 조회
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        return missionRepository.findAllByStore(store, PageRequest.of(page, 10)).stream().toList();

    }

    @Override
    public Mission addMission(MissionRequestDto.addMission request) {
        //미션 생성 -> 아직 상점은 할당 안됨
        Mission mission = MissionConverter.toMission(request);
        //상점 조회
        Store store = storeRepository.findById(request.getStoreId()).get();
        //연관관계 매핑
        mission.setStore(store);
        //저장 및 반환
        return missionRepository.save(mission);
    }


    public List<Mission> getAllMission() {
        return missionRepository.findAll();
    }

}

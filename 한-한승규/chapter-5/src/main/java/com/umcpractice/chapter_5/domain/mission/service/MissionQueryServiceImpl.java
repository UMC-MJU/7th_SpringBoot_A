package com.umcpractice.chapter_5.domain.mission.service;

import com.querydsl.core.Tuple;
import com.umcpractice.chapter_5.domain.mission.entity.Mission;
import com.umcpractice.chapter_5.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public List<Mission> findMissionByStatus(Long memberId, String status) {
        return missionRepository.dynamicQueryWithBooleanBuilder(memberId, status, 1L, 5L);
    }

    @Override
    public List<Tuple> findMissionsByRegionAndDeadline(String regionName, Long cursor, Long memberId) {
        return missionRepository.findMissionsByRegionAndDeadline(regionName, cursor, memberId);
    }
}
package com.umcpractice.chapter_5.domain.mission.service;

import com.umcpractice.chapter_5.domain.mission.entity.Mission;

import java.util.List;

public interface MissionQueryService {

    List<Mission> findMissionByStatus(Long memberId, String status);
}
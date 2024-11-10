package com.umcpractice.chapter_5.domain.mission.repository;

import com.umcpractice.chapter_5.domain.mission.entity.Mission;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> dynamicQueryWithBooleanBuilder(Long memberId, String status, Long page, Long size);
}

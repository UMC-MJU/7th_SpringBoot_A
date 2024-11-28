package com.umcpractice.chapter_5.domain.mission.repository;


import com.umcpractice.chapter_5.domain.mission.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
}
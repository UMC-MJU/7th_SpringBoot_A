package mju_umc.mju_umc.repository;

import mju_umc.mju_umc.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {

}

package umc.spring.repository.MissionHomeRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;

public interface MissionHomeRepository extends JpaRepository<MemberMission, Long>, MissionHomeRepositoryCustom {
}

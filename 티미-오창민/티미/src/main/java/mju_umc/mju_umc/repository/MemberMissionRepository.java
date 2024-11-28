package mju_umc.mju_umc.repository;

import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.Region;
import mju_umc.mju_umc.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom{
}

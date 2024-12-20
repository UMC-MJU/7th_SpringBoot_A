package umc.spring.repository.memberMissionRepository;

import umc.spring.domain.mapping.MemberMission;

public interface MemberMissionRepositoryCustom {
    MemberMission findMemberMissionByMissionId(Long missionId);
}

package umc.spring.repository.MissionHomeRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.MissionHomeDTO;
import umc.spring.domain.QMission;
import umc.spring.domain.QRegion;
import umc.spring.domain.QStore;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.QMemberMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionHomeRepositoryImpl implements MissionHomeRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;
    private final QRegion region = QRegion.region;


    @Override
    public List<MissionHomeDTO> findChallengingMissionAtHome(Long memberId, String regionName) {

        return jpaQueryFactory
                .select(Projections.constructor(MissionHomeDTO.class,
                        store.name,
                        mission.missionSpec,
                        mission.reward,
                        region.name))
                .from(memberMission)
                .join(memberMission.mission, mission)
                .join(mission.store, store)
                .join(store.region, region)
                .where(memberMission.member.id.eq(memberId)
                        .and(memberMission.status.eq(MissionStatus.CHALLENGING))
                        .and(region.name.eq(regionName)))
                .fetch();
    }
}


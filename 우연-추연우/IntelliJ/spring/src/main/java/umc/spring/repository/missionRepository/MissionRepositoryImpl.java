package umc.spring.repository.missionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QMember;
import umc.spring.domain.QMission;
import umc.spring.domain.QRegion;
import umc.spring.domain.QStore;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.QMemberMission;
import umc.spring.dto.MissionDTO;
import umc.spring.dto.MissionRegionDTO;
import umc.spring.dto.QMissionDTO;
import umc.spring.dto.QMissionRegionDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;

    @Override
    public List<MissionDTO> findIsOnGoingMissions(Long memberId, Long cursor) {
        return findMissionsByStatus(memberId, cursor, MissionStatus.valueOf("진행중"));
    }

    @Override
    public List<MissionDTO> findIsFinishedMissions(Long memberId, Long cursor) {
        return findMissionsByStatus(memberId, cursor, MissionStatus.valueOf("진행완료"));
    }

    private List<MissionDTO> findMissionsByStatus(Long memberId, Long cursor, MissionStatus status) {
        BooleanBuilder predicate = new BooleanBuilder();

        predicate.and(member.id.eq(memberId))
                .and(memberMission.status.eq(status));

        if (cursor != null) {
            predicate.and(mission.id.lt(cursor));
        }

        return jpaQueryFactory
                .select(new QMissionDTO(
                        mission.id,
                        store.name,
                        mission.reward,
                        mission.missionSpec,
                        memberMission.status.stringValue()))
                .from(member)
                .join(memberMission).on(member.id.eq(memberMission.member.id))
                .join(mission).on(mission.id.eq(memberMission.mission.id))
                .join(store).on(mission.store.id.eq(store.id))
                .where(predicate)
                .orderBy(mission.id.desc())
                .limit(10)
                .fetch();
    }

    @Override
    public List<MissionRegionDTO> findMissionsInRegion(String regionName, Long cursor, Long memberId) {
        QMission mission = QMission.mission;
        QStore store = QStore.store;
        QRegion region = QRegion.region;
        QMemberMission memberMission = QMemberMission.memberMission;
        BooleanBuilder predicate = new BooleanBuilder();

        if (cursor != null) {
            predicate.and(mission.id.lt(cursor));
        }

        return jpaQueryFactory
                .select(new QMissionRegionDTO(
                        mission.id,
                        store.name,
                        mission.reward,
                        mission.missionSpec,
                        Expressions.numberTemplate(Integer.class,
                                "datediff({0}, {1})",
                                mission.deadline, LocalDateTime.now()).as("daysLeft")
                ))
                .from(mission)
                .join(mission.store, store)
                .join(store.region, region)
                .where(
                        region.name.eq(regionName),
                        mission.deadline.after(LocalDate.from(LocalDateTime.now())),
                        mission.id.lt(cursor),
                        mission.id.notIn(
                                JPAExpressions.select(memberMission.mission.id)
                                        .from(memberMission)
                                        .where(memberMission.member.id.eq(memberId))
                        )
                )
                .orderBy(mission.id.desc())
                .limit(10)
                .fetch();
    }
}
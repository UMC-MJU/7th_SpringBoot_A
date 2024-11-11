package com.umcpractice.chapter_5.domain.mission.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umcpractice.chapter_5.domain.member_mission.entity.QMemberMission;
import com.umcpractice.chapter_5.domain.mission.entity.Mission;
import com.umcpractice.chapter_5.domain.mission.entity.QMission;
import com.umcpractice.chapter_5.domain.region.entity.QRegion;
import com.umcpractice.chapter_5.domain.store.entity.QStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import java.util.List;

import static com.querydsl.core.types.dsl.DateTimeExpression.currentDate;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QMemberMission memberMission = QMemberMission.memberMission;


    @Override
    public List<Mission> dynamicQueryWithBooleanBuilder(Long memberId, String status, Long page, Long size) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (memberId != null) {
            predicate.and(memberMission.member.id.eq(memberId));
        }

        if ("active".equalsIgnoreCase(status)) {
            predicate.and(memberMission.status.eq("진행중"));
        } else if ("inactive".equalsIgnoreCase(status)) {
            predicate.and(memberMission.status.eq("진행완료"));
        }

        return jpaQueryFactory
                .select(mission)
                .from(memberMission)
                .join(memberMission.mission, mission)
                .where(predicate)
                .offset(page * size)
                .limit(size)
                .fetch();
    }

    @Override
    public List<Tuple> findMissionsByRegionAndDeadline(String regionName, Long cursor, Long memberId) {
        QMission mission = QMission.mission;
        QStore store = QStore.store;
        QRegion region = QRegion.region;
        QMemberMission memberMission = QMemberMission.memberMission;

        return jpaQueryFactory
                .select(mission.id, store.name, mission.reward, mission.missionSpec,
                        mission.deadline.getRoot())
                .from(mission)
                .join(mission.store, store)
                .join(store.region, region)
                .where(
                        region.name.eq(regionName),
                        mission.deadline.gt(currentDate()),
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
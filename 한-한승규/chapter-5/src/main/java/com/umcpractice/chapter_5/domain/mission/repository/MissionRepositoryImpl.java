package com.umcpractice.chapter_5.domain.mission.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umcpractice.chapter_5.domain.member_mission.entity.QMemberMission;
import com.umcpractice.chapter_5.domain.mission.entity.Mission;
import com.umcpractice.chapter_5.domain.mission.entity.QMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import java.util.List;

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
                .offset(page * size) // 페이지 번호에 따른 시작 위치 설정
                .limit(size)
                .fetch();
    }
}
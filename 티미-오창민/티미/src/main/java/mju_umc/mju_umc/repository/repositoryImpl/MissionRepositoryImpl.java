package mju_umc.mju_umc.repository.repositoryImpl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.domain.*;
import mju_umc.mju_umc.domain.enums.MissionStatus;
import mju_umc.mju_umc.repository.MissionRepositoryCustom;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //리포지토리 명시
@RequiredArgsConstructor //생성자 주입 자동화 에노테이션
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;//쿼리 자동 생성
    private final QMission mission = QMission.mission;//미션 Q객체
    private final QStore store = QStore.store;//상점 Q객체
    private final QRegion qRegion = QRegion.region;//지역 Q객체


    //구현 시작
    @Override
    public List<Mission> getClearOrProgressMissionByMember(MissionStatus status, Member member) {
        List<Mission> missions = jpaQueryFactory
                .selectFrom(mission)
                .where(mission.missionSpec.eq(status)) //상태가 같은 미션만 조회
                .offset(0) //시작페이지
                .limit(3) //페이지당 최대 3건 조회
                .fetch();

        return missions;
    }


}

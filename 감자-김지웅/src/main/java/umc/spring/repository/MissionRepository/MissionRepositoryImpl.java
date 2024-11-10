package umc.spring.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.QMemberMission;
import umc.spring.domain.QMission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MissionRepository.MissionRepositoryCustom;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    private final QMission mission = QMission.mission;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public List<Mission> dynamicQueryWithBooleanBuilder(MissionStatus status) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (status != null) {
            predicate.and(memberMission.status.eq(status));
        }

        return jpaQueryFactory
                .selectFrom(mission)
                .join(mission.memberMissionList, memberMission) // Mission과 MemberMission 관계 조인
                .where(predicate)
                .fetch();
    }
}

package umc.spring.repository.memberMissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QMember;
import umc.spring.domain.QStore;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.QMemberMission;
import umc.spring.dto.MemberDTO;
import umc.spring.dto.QMemberDTO;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public MemberMission findMemberMissionByMissionId(Long missionId) {
        BooleanBuilder predicate = new BooleanBuilder();
        if(missionId != null) {
            predicate.and(memberMission.mission.id.eq(missionId));
        }

        return jpaQueryFactory
                .select(memberMission)
                .from(memberMission)
                .where(predicate)
                .fetchOne();
    }
}
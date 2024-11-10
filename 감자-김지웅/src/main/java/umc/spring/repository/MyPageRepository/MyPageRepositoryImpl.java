package umc.spring.repository.MyPageRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Member;
import umc.spring.domain.MyPageDTO;
import umc.spring.domain.QMember;

@Repository
@RequiredArgsConstructor
public class MyPageRepositoryImpl implements MyPageRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    private final QMember member = QMember.member;

    @Override
    public MyPageDTO findMemberInfo(){

        return jpaQueryFactory
                .select(Projections.constructor(MyPageDTO.class,
                        member.name,member.point,member.email))
                .from(member)
                .fetchOne();
    }
}

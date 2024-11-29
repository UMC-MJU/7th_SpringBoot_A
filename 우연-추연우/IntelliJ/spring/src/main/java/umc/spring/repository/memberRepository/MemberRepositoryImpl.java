package umc.spring.repository.memberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import umc.spring.domain.QMember;
import umc.spring.dto.MemberDTO;
import umc.spring.dto.QMemberDTO;


@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public MemberDTO findMemberById(Long memberId) {
        QMember member = QMember.member;

        return queryFactory.select(new QMemberDTO(
                        member.id,
                        member.name,
                        member.email,
                        member.point
                ))
                .from(member)
                .where(member.id.eq(memberId))
                .fetchOne();

    }


}

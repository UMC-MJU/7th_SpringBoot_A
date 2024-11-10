package com.umcpractice.chapter_5.domain.member.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umcpractice.chapter_5.domain.member.dto.ResponseMemberDto;
import com.umcpractice.chapter_5.domain.member.entity.QMember;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public ResponseMemberDto findMemberProfile(Long memberId) {
        QMember member = QMember.member;

        Tuple result = jpaQueryFactory
                .select(member.id, member.name, member.email, member.point)
                .from(member)
                .where(member.id.eq(memberId))
                .fetchOne();

        if (result != null) {
            return ResponseMemberDto.of(
                    result.get(member.id),
                    result.get(member.name),
                    result.get(member.email),
                    result.get(member.point)
            );
        } else {
            return null;
        }
    }
}
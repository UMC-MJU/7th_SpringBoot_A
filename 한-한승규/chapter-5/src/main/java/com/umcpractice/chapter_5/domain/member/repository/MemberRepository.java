package com.umcpractice.chapter_5.domain.member.repository;

import com.umcpractice.chapter_5.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}
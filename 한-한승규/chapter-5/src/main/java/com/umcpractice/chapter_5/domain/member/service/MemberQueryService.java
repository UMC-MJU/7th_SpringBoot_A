package com.umcpractice.chapter_5.domain.member.service;

import com.umcpractice.chapter_5.domain.member.entity.Member;

import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> getMemberData(Long memberId);
}
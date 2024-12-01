package com.umcpractice.chapter_5.domain.member.repository;

import com.umcpractice.chapter_5.domain.member.dto.ResponseMemberDto;

public interface MemberRepositoryCustom {

    ResponseMemberDto findMemberProfile(Long memberId);
}
package com.umcpractice.chapter_5.domain.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseMemberDto {
    private final Long id;
    private final String name;
    private final String email;
    private final String point;

    @Builder
    private ResponseMemberDto(Long id, String name, String email, String point) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.point = point;
    }

    public static ResponseMemberDto of(Long id, String name, String email, String point) {
        return ResponseMemberDto.builder()
                .id(id)
                .name(name)
                .email(email)
                .point(point).build();
    }
}
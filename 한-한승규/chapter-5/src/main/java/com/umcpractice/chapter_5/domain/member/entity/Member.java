package com.umcpractice.chapter_5.domain.member.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String age;

    @Column(nullable = false)
    private String address;

    @Column(unique = true, name = "spec_address")
    private String specAddress;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false, name = "inactive_date")
    private String inactiveAt;

    @Column(nullable = false, name = "social_type")
    private String socialType;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String point;
}
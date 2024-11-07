package com.umcpractice.chapter_5.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private Date birth;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String email;

    @Column(unique = true, name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false)
    private String status;

    @Column(name = "inactive_date", nullable = false)
    private LocalDateTime inactiveAt;
}
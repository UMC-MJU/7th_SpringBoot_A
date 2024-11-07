package com.umcpractice.chapter_5.domain.mission.entity;

import com.umcpractice.chapter_5.common.BaseEntity;
import com.umcpractice.chapter_5.domain.restaurant.entity.Restaurant;
import com.umcpractice.chapter_5.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_verified")
    private boolean isVerified;

    @Column(name = "complete_at")
    private LocalDateTime completeAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
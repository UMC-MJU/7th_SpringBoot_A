package com.umcpractice.chapter_5.domain.review.entity;

import com.umcpractice.chapter_5.common.BaseEntity;
import com.umcpractice.chapter_5.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(name = "star_rating", nullable = false)
    private int starRating;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;
}
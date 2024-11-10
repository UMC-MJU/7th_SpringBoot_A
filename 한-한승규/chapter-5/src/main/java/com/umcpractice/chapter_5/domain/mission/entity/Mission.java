package com.umcpractice.chapter_5.domain.mission.entity;

import com.umcpractice.chapter_5.common.BaseEntity;
import com.umcpractice.chapter_5.domain.store.entity.Store;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int reward;

    @Column(nullable = false)
    private Date deadline;

    @Column(nullable = false, name = "misssion_spec")
    private String missionSpec;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id")
    private Store store;
}
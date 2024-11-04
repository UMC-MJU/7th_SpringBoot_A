package mju_umc.mju_umc.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import mju_umc.mju_umc.domain.FoodCategory;
import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.base.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory;


}



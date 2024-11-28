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


    //연관관계 편의 메서드
    //멤버를 지정해준다.
    //멤버 입장에서는 리스트에 넣으므로서 연관 짓기
    //본인 입장에서는 member에 세팅함으로서 연관 짓기
    public void setMember(Member member) {
        if (this.member != null) { //이미 다른 사람과 연관되어있을 때,
            member.getMemberPreferList().remove(this); //해당 사람의 목록에서 제외
        }
        this.member = member; // 입력된 사람과 연관짓는다.
        member.getMemberPreferList().add(this); //입력된 사람의 목록에 추가한다.
    }

}



package umc.spring_week5.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.spring_week5.domain.Member;
import umc.spring_week5.domain.Terms;
import umc.spring_week5.domain.common.BaseEntity;




@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberAgree extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "terms_id")
    private Terms terms;
}


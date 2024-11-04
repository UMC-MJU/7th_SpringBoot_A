package umc.spring_week5.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.spring_week5.domain.common.BaseEntity;
import umc.spring_week5.domain.enums.MissionStatus;
import umc.spring_week5.domain.Member;
import umc.spring_week5.domain.Mission;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;
}
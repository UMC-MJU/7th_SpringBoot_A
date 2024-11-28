package mju_umc.mju_umc.domain;


import jakarta.persistence.*;
import lombok.*;
import mju_umc.mju_umc.domain.base.BaseEntity;
import mju_umc.mju_umc.domain.enums.Gender;
import mju_umc.mju_umc.domain.enums.MemberStatus;
import mju_umc.mju_umc.domain.enums.SocialType;
import mju_umc.mju_umc.domain.mapping.MemberAgree;
import mju_umc.mju_umc.domain.mapping.MemberMission;
import mju_umc.mju_umc.domain.mapping.MemberPrefer;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity //JPA에게 관리되는 엔티티라는 것을 명시
@Getter //getter 자동 생성
@Builder //빌터 패턴을 자동으로 만들어주는 롬복이 지원해주는 어노테이션
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 파라미터가 없는 기본 생성자를 생성
//access= PRIVATE는 해당 클래스 내부에서만 생성자에 접근 가능
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자를 생성
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;


    @Column(nullable = false, length = 40)
    private String specAddress;

    private LocalDate inactiveDate;

    @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault("0")
    private Integer point;

    @Builder.Default
    private String phone_num = "010-0000-0000";

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    @Builder.Default //이거 없으면, 빌더 페턴으로 생성한 member의 해당 리스트가 null이 되어 버린다.
    private List<MemberMission> memberMissionList = new ArrayList<>();


    //연관 관계 편의 메소드
    public void setMission(MemberMission memberMission) {
        this.memberMissionList.add(memberMission);
    }
}

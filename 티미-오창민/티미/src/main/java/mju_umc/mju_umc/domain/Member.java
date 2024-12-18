package mju_umc.mju_umc.domain;


import jakarta.persistence.*;
import lombok.*;
import mju_umc.mju_umc.domain.base.BaseEntity;
import mju_umc.mju_umc.domain.enums.Gender;
import mju_umc.mju_umc.domain.enums.MemberStatus;
import mju_umc.mju_umc.domain.enums.Role;
import mju_umc.mju_umc.domain.enums.SocialType;
import mju_umc.mju_umc.domain.mapping.MemberAgree;
import mju_umc.mju_umc.domain.mapping.MemberMission;
import mju_umc.mju_umc.domain.mapping.MemberPrefer;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity //JPA에게 관리되는 엔티티라는 것을 명시
@Getter //getter 자동 생성
@Builder //빌터 패턴을 자동으로 만들어주는 롬복이 지원해주는 어노테이션
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 파라미터가 없는 기본 생성자를 생성
//access= PRIVATE는 해당 클래스 내부에서만 생성자에 접근 가능
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자를 생성
@DynamicInsert // null인 경우에는 쿼리를 안날린다. -> 디폴트 값으로
@DynamicUpdate // null인 경우에는 쿼리를 안날린다. => 디폴트 값으로
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

    //컬럼값으로 ACTIVE를 디폴트 값으로 했지만, 실제 DB에는 NULL로 들어간다.
    //JPA에서는 기본 수정은 전체 필드를 업데이트 하는 방식
    //@DynamicInsert와 @DynamicUpdate를 이용해서 해결 가능
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status; //탈퇴해도 DB에 저장할 수 있다.

    @Enumerated(EnumType.STRING)
    private Role role; //관리자 여부

    //로그인 정보
    @Column(nullable = false)
    private String password;


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


    //
    public void encodePassword(String password) {
        this.password = password;
    }

}

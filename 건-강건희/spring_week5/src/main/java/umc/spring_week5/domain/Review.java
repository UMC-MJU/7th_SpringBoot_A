package umc.spring_week5.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring_week5.domain.common.BaseEntity;


import java.util.ArrayList;
import java.util.List;

@Entity //JPA에게 관리되는 엔티티라는 것을 명시
@Getter //getter 자동 생성
@Builder //빌터 패턴을 자동으로 만들어주는 롬복이 지원해주는 어노테이션
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 파라미터가 없는 기본 생성자를 생성
//access= PRIVATE는 해당 클래스 내부에서만 생성자에 접근 가능
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자를
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewImage> reviewImageList = new ArrayList<>();



}


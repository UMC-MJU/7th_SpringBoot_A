package mju_umc.mju_umc.domain;

import jakarta.persistence.*;
import lombok.*;
import mju_umc.mju_umc.domain.base.BaseEntity;

@Entity //JPA에게 관리되는 엔티티라는 것을 명시
@Getter //getter 자동 생성
@Builder //빌터 패턴을 자동으로 만들어주는 롬복이 지원해주는 어노테이션
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 파라미터가 없는 기본 생성자를 생성
//access= PRIVATE는 해당 클래스 내부에서만 생성자에 접근 가능
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자를 생성
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String address;

    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    public void setRegion(Region region) {
        this.region = region;
    }

    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", score=" + score +
                ", region=" + (region != null ? region.getName() : "N/A") + // region의 이름 출력
                '}';
    }
    }


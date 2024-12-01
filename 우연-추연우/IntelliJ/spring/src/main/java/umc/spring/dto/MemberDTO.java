package umc.spring.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberDTO {

    private Long id;
    private String name;
    private String email;
    private String phoneNum;
    private Integer point;

    @QueryProjection
    public MemberDTO(Long id, String name, String email, Integer point) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.point = point;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", point=" + point +
                '}';
    }
}

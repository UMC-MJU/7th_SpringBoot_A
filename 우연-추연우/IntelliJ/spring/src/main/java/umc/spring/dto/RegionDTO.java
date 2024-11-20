package umc.spring.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegionDTO {

    private Long id;
    private String name;


    @QueryProjection
    public RegionDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

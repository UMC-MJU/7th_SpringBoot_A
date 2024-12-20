package umc.spring.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * umc.spring.dto.QRegionDTO is a Querydsl Projection type for RegionDTO
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QRegionDTO extends ConstructorExpression<RegionDTO> {

    private static final long serialVersionUID = -173968386L;

    public QRegionDTO(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> name) {
        super(RegionDTO.class, new Class<?>[]{long.class, String.class}, id, name);
    }

}


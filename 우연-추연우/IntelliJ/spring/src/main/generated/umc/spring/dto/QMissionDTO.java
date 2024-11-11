package umc.spring.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * umc.spring.dto.QMissionDTO is a Querydsl Projection type for MissionDTO
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMissionDTO extends ConstructorExpression<MissionDTO> {

    private static final long serialVersionUID = 799006048L;

    public QMissionDTO(com.querydsl.core.types.Expression<Long> missionId, com.querydsl.core.types.Expression<String> storeName, com.querydsl.core.types.Expression<Integer> reward, com.querydsl.core.types.Expression<String> missionSpec, com.querydsl.core.types.Expression<String> status) {
        super(MissionDTO.class, new Class<?>[]{long.class, String.class, int.class, String.class, String.class}, missionId, storeName, reward, missionSpec, status);
    }

}


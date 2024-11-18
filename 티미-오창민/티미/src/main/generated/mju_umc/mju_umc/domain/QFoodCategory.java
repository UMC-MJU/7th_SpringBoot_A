package mju_umc.mju_umc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFoodCategory is a Querydsl query type for FoodCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodCategory extends EntityPathBase<FoodCategory> {

    private static final long serialVersionUID = -1279724110L;

    public static final QFoodCategory foodCategory = new QFoodCategory("foodCategory");

    public final mju_umc.mju_umc.domain.base.QBaseEntity _super = new mju_umc.mju_umc.domain.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<mju_umc.mju_umc.domain.mapping.MemberPrefer, mju_umc.mju_umc.domain.mapping.QMemberPrefer> memberPreferList = this.<mju_umc.mju_umc.domain.mapping.MemberPrefer, mju_umc.mju_umc.domain.mapping.QMemberPrefer>createList("memberPreferList", mju_umc.mju_umc.domain.mapping.MemberPrefer.class, mju_umc.mju_umc.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QFoodCategory(String variable) {
        super(FoodCategory.class, forVariable(variable));
    }

    public QFoodCategory(Path<? extends FoodCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFoodCategory(PathMetadata metadata) {
        super(FoodCategory.class, metadata);
    }

}


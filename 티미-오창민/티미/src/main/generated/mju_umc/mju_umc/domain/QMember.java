package mju_umc.mju_umc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 747630928L;

    public static final QMember member = new QMember("member1");

    public final mju_umc.mju_umc.domain.base.QBaseEntity _super = new mju_umc.mju_umc.domain.base.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<mju_umc.mju_umc.domain.enums.Gender> gender = createEnum("gender", mju_umc.mju_umc.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<mju_umc.mju_umc.domain.mapping.MemberAgree, mju_umc.mju_umc.domain.mapping.QMemberAgree> memberAgreeList = this.<mju_umc.mju_umc.domain.mapping.MemberAgree, mju_umc.mju_umc.domain.mapping.QMemberAgree>createList("memberAgreeList", mju_umc.mju_umc.domain.mapping.MemberAgree.class, mju_umc.mju_umc.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final ListPath<mju_umc.mju_umc.domain.mapping.MemberMission, mju_umc.mju_umc.domain.mapping.QMemberMission> memberMissionList = this.<mju_umc.mju_umc.domain.mapping.MemberMission, mju_umc.mju_umc.domain.mapping.QMemberMission>createList("memberMissionList", mju_umc.mju_umc.domain.mapping.MemberMission.class, mju_umc.mju_umc.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<mju_umc.mju_umc.domain.mapping.MemberPrefer, mju_umc.mju_umc.domain.mapping.QMemberPrefer> memberPreferList = this.<mju_umc.mju_umc.domain.mapping.MemberPrefer, mju_umc.mju_umc.domain.mapping.QMemberPrefer>createList("memberPreferList", mju_umc.mju_umc.domain.mapping.MemberPrefer.class, mju_umc.mju_umc.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath phone_num = createString("phone_num");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<mju_umc.mju_umc.domain.enums.Role> role = createEnum("role", mju_umc.mju_umc.domain.enums.Role.class);

    public final EnumPath<mju_umc.mju_umc.domain.enums.SocialType> socialType = createEnum("socialType", mju_umc.mju_umc.domain.enums.SocialType.class);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<mju_umc.mju_umc.domain.enums.MemberStatus> status = createEnum("status", mju_umc.mju_umc.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}


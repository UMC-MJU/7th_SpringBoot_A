package com.umcpractice.chapter_5.domain.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -40789253L;

    public static final QMember member = new QMember("member1");

    public final StringPath address = createString("address");

    public final StringPath age = createString("age");

    public final StringPath email = createString("email");

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath inactiveAt = createString("inactiveAt");

    public final StringPath name = createString("name");

    public final StringPath point = createString("point");

    public final StringPath socialType = createString("socialType");

    public final StringPath specAddress = createString("specAddress");

    public final StringPath status = createString("status");

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


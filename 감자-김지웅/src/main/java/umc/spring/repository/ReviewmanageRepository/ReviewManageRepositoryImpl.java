package umc.spring.repository.ReviewmanageRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.*;
import umc.spring.domain.enums.MissionStatus;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewManageRepositoryImpl implements ReviewManageRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;
    private final QReview review = QReview.review;
    private final QStore store = QStore.store;

    public List<ReviewManageDTO> findReviewListByStore(Long storeId) {


        return jpaQueryFactory
                .select(Projections.constructor(ReviewManageDTO.class,
                        member.name,
                        review.body,
                        review.score))
                .from(review)
                .join(review.member, member)
                .join(review.store, store)
                .where(review.store.id.eq(storeId))
                .fetch();
    }
}

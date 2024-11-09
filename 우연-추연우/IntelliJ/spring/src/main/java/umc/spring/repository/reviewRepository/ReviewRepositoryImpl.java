package umc.spring.repository.reviewRepository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final EntityManager entityManager;

    @Override
    public void insertReview(Long memberId, Long storeId, String body, Float score) {
        Member member = entityManager.find(Member.class, memberId);
        Store store = entityManager.find(Store.class, storeId);

        Review review = Review.create(body, score, member, store);

        entityManager.persist(review);
    }
}

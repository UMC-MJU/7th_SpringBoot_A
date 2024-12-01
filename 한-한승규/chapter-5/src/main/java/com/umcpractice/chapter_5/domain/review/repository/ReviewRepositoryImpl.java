package com.umcpractice.chapter_5.domain.review.repository;

import com.umcpractice.chapter_5.domain.member.entity.Member;
import com.umcpractice.chapter_5.domain.review.entity.Review;
import com.umcpractice.chapter_5.domain.store.entity.Store;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    @Transactional
    public void createReview(Long memberId, Long storeId, String body, float score) {

        Member member = entityManager.find(Member.class, memberId);
        Store store = entityManager.find(Store.class, storeId);

        if (member == null || store == null) {
            throw new IllegalArgumentException("Member or Store not found");
        }

        Review review = Review.builder()
                .member(member)
                .store(store)
                .body(body)
                .score(score)
                .build();

        entityManager.persist(review);
    }
}
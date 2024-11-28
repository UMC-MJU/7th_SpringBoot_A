package com.umcpractice.chapter_5.domain.review.repository;


public interface ReviewRepositoryCustom {

    void createReview(Long memberId, Long storeId, String body, float score);
}
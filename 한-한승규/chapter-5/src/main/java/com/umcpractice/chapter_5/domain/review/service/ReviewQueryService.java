package com.umcpractice.chapter_5.domain.review.service;


public interface ReviewQueryService {

    void createReview(Long memberId, Long storeId, String body, float score);
}

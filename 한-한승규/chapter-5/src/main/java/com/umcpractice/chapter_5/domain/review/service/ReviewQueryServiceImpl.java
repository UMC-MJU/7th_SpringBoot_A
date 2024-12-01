package com.umcpractice.chapter_5.domain.review.service;

import com.umcpractice.chapter_5.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Override
    public void createReview(Long memberId, Long storeId, String body, float score) {
        reviewRepository.createReview(memberId, storeId, body, score);
    }
}
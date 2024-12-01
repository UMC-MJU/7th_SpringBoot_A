package com.umcpractice.chapter_5.domain.review.repository;

import com.umcpractice.chapter_5.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
}
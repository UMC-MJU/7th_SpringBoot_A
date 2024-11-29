package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.review.ReviewRequestDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReviewConverter {

    public static ReviewResponseDTO.addResultDTO toAddResultDTO(Review review) {
        return ReviewResponseDTO.addResultDTO.builder()
                .title(review.getTitle())
                .score(review.getScore())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(Member member, Store store, ReviewRequestDTO.AddResultDTO request) {
        return Review.builder()
                .member(member)
                .store(store)
                .title(request.getTitle())
                .reviewImages(new ArrayList<>())
                .score(request.getScore())
                .build();
    }
}

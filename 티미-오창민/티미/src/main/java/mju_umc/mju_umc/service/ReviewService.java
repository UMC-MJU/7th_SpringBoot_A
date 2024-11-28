package mju_umc.mju_umc.service;

import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.Review;
import mju_umc.mju_umc.domain.Store;
import mju_umc.mju_umc.web.dto.review.ReviewRequestDto;
import mju_umc.mju_umc.web.dto.review.ReviewResponseDto;

import java.util.List;

public interface ReviewService {
    Review addReview(ReviewRequestDto.addReview request);
    ReviewResponseDto.GetReviewsResult getAllByNameAndStore(Long memberId, Long StoreId, Integer page);
    List<Review> getReviewsByNameAndStore(Member member, Store store, Integer page);

}

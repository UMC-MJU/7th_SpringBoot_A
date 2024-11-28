package mju_umc.mju_umc.converter;

import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.Review;
import mju_umc.mju_umc.web.dto.review.ReviewRequestDto;
import mju_umc.mju_umc.web.dto.review.ReviewResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {


    public static ReviewResponseDto.addReviewResult toaddReviewResult(Review review) {
        return ReviewResponseDto.addReviewResult.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now()).build();
    }
    //이미 page된 상태의 리뷰 리스트가 들어와야겠지...? -> 서비스 단에서 해보자.
    public static ReviewResponseDto.GetReviewsResult toGetReviewResult(List<Review> reviewList, Member member, String storeName) {
        return ReviewResponseDto.GetReviewsResult.builder()
                .name(member.getName()) //작성자
                .storeName(storeName) //상점 이름
                .reviews(toGetReviewListDetail(reviewList)) //리뷰 결과
                .build();
    }
    //리뷰 리스트를 리뷰 디테일 DTO 리스트로 변환
    public static List<ReviewResponseDto.GetReviewListDetail> toGetReviewListDetail(List<Review> reviews) {
        return reviews.stream()
                .map(review -> ReviewResponseDto.GetReviewListDetail.builder()
                        .date(review.getUpdatedAt())
                        .score(review.getScore())
                        .build())
                .collect(Collectors.toList());

    }

    public static Review toReview(ReviewRequestDto.addReview request) {
        //상점이랑, 멤버는 나중에 매핑 할 예정
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore()).build();
    }


}

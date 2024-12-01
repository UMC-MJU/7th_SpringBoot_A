package umc.spring.repository.reviewRepository;

public interface ReviewRepositoryCustom {
    void insertReview(Long memberId, Long storeId, String body, Float score);
}

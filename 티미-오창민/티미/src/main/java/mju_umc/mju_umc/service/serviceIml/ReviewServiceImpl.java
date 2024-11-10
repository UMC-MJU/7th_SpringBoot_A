package mju_umc.mju_umc.service.serviceIml;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.domain.Review;
import mju_umc.mju_umc.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl {
    private final ReviewRepository reviewRepository;

    public void saveReview(Review review) {
        reviewRepository.save(review);
    }
}

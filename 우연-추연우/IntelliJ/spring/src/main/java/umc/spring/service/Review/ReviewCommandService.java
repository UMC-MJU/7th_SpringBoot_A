package umc.spring.service.Review;

import umc.spring.domain.Review;
import umc.spring.web.dto.review.ReviewRequestDTO;


public interface ReviewCommandService {
    Review addReview(Long storeId, ReviewRequestDTO.AddResultDTO request);
}

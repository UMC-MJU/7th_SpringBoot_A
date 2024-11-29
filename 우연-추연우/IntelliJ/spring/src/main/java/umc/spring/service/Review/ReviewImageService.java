package umc.spring.service.Review;

import org.springframework.web.multipart.MultipartFile;
import umc.spring.domain.Review;

public interface ReviewImageService {
    String addReviewImage(MultipartFile image, Review review);
}

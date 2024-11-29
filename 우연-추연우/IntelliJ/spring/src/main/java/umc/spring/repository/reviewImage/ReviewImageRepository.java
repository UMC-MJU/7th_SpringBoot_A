package umc.spring.repository.reviewImage;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Review;
import umc.spring.domain.ReviewImage;
import umc.spring.repository.reviewRepository.ReviewRepositoryCustom;

public interface ReviewImageRepository extends JpaRepository<ReviewImage, Long>, ReviewImageRepositoryCustom  {

}

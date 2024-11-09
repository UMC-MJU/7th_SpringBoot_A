package umc.spring.repository.reviewRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
    // 추가적인 커스텀 메서드가 필요한 경우 여기에 정의할 수 있습니다.
}

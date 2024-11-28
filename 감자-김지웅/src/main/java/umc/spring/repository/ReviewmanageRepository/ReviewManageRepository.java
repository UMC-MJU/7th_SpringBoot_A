package umc.spring.repository.ReviewmanageRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository.StoreRepositoryCustom;

public interface ReviewManageRepository extends JpaRepository<Review, Long>, ReviewManageRepositoryCustom {
}

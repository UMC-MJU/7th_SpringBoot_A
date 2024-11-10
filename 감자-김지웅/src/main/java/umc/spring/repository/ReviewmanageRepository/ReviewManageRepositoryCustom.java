package umc.spring.repository.ReviewmanageRepository;

import umc.spring.domain.ReviewManageDTO;
import umc.spring.domain.Store;

import java.util.List;

public interface ReviewManageRepositoryCustom {
    List<ReviewManageDTO> findReviewListByStore(Long storeId);
}

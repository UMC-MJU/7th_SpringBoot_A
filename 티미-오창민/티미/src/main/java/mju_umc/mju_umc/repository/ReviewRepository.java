package mju_umc.mju_umc.repository;

import mju_umc.mju_umc.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}

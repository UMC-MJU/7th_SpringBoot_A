package mju_umc.mju_umc.service;

import jakarta.transaction.Transactional;
import mju_umc.mju_umc.domain.Review;
import mju_umc.mju_umc.repository.ReviewRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class reviewServiceTest {
    @Autowired
    ReviewRepository reviewRepository;

    @Test
    public void reviewSaveTest() {
        //given
        Review review = Review.builder().build();
        long beforeSave = reviewRepository.count();

        //when
        reviewRepository.save(review);

        long afterSave = reviewRepository.count();
        //then
        //저장하기 전보다 저장 후 개수가 1개 더 많아야 한다.
        Assertions.assertThat(afterSave).isEqualTo(beforeSave+1);
    }

}

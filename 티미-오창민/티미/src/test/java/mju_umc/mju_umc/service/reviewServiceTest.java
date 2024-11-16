package mju_umc.mju_umc.service;

import jakarta.transaction.Transactional;
import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.Review;
import mju_umc.mju_umc.domain.enums.Gender;
import mju_umc.mju_umc.repository.ReviewRepository;
import mju_umc.mju_umc.service.serviceIml.MemberServiceImpl;
import mju_umc.mju_umc.service.serviceIml.ReviewServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class reviewServiceTest {
    @Autowired
    ReviewServiceImpl reviewService;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    MemberServiceImpl memberService;

    @Test
    public void reviewSaveTest() {
        //given
//        Review review = Review.builder().build();
        //테스트 회원 생성
        Member member = Member.builder()
                .name("Test")
                .address("testAddress")
                .specAddress("specAddressTest")
                .email("emailTest")
                .gender(Gender.MALE)
                .build();
        //테스트 회원 저장
        Member savedMember = memberService.saveMember(member);
        //테스트 리뷰 생성
        //저장 전 리뷰 개수
        long beforeSave = reviewRepository.count();


        //해당 리뷰 생성 메서드 를 실행 후 , 더티 체크를 통해, 자동으로 save 쿼리를 보내개 된다.
        //따라서 리뷰 생성 전 개수를 제대로 비교하기 위해서는, 해당 메서드 전에 개수를 세야 한다.
        Review review = reviewService.createReview(savedMember.getId(), 1L, "BODY_TEST", 4.0f);


        //when
        reviewRepository.save(review);
        long afterSave = reviewRepository.count();


        //then
        //저장하기 전보다 저장 후 개수가 1개 더 많아야 한다.
        Assertions.assertThat(afterSave).isEqualTo(beforeSave+1);
        Assertions.assertThat(member.getReviewList().size()).isEqualTo(1); //멤버의 리뷰 리스트의 수도 증가해야 한다.
    }



}

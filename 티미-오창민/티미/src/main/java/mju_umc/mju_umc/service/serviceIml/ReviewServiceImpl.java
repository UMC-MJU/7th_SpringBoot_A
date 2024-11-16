package mju_umc.mju_umc.service.serviceIml;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.Review;
import mju_umc.mju_umc.domain.Store;
import mju_umc.mju_umc.repository.MemberRepository;
import mju_umc.mju_umc.repository.ReviewRepository;
import mju_umc.mju_umc.repository.StoreRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReviewServiceImpl {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    public void saveReview(Review review) {
        reviewRepository.save(review);
    }

        public Review createReview(Long memberId, Long storeId, String body, Float score) {
            Member member = memberRepository.findById(memberId).get();
             log.info("멤버"+ member.toString());
            Store store = storeRepository.findById(storeId).get();

            Review createdReview = Review.builder()
                    .member(member)
                    .title(body)
                    .score(score)
                    .store(store)
                    .build();
//            reviewRepository.save(createdReview); //생성만 하는 로직이므로, save는 나중에.-> save를 지워도 더티 체크 때문에, 자동으로 저장 쿼리가 나간다.
            member.getReviewList().add(createdReview);

            return createdReview;
    }
}

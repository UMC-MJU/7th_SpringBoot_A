package umc.spring.service.Review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.repository.memberRepository.MemberRepository;
import umc.spring.repository.reviewRepository.ReviewRepository;
import umc.spring.web.dto.review.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final StoreRepository storeRepository;

    private final MemberRepository memberRepository;

    private final ReviewRepository reviewRepository;

    @Override
    public Review addReview(Long storeId, ReviewRequestDTO.AddResultDTO request) {

        Member member = memberRepository.getReferenceById(1L);
        Store store = storeRepository.getReferenceById(storeId);

        Review newReview = ReviewConverter.toReview(member, store, request);

        return reviewRepository.save(newReview);
    }
}

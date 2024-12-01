package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    public Page<Review> getMyReviews(Long memberId, int page) {
        // Member 존재 확인
        Member member = memberRepository.findById(memberId).get();

        // 페이징 처리된 리뷰 조회
        PageRequest pageRequest = PageRequest.of(page, 10); // 페이지 크기: 10
        return reviewRepository.findAllByMember(member, pageRequest);
    }
}


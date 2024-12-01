package mju_umc.mju_umc.service.serviceIml;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mju_umc.mju_umc.converter.ReviewConverter;
import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.Review;
import mju_umc.mju_umc.domain.Store;
import mju_umc.mju_umc.repository.MemberRepository;
import mju_umc.mju_umc.repository.ReviewRepository;
import mju_umc.mju_umc.repository.StoreRepository;
import mju_umc.mju_umc.response.code.status.ErrorStatus;
import mju_umc.mju_umc.response.exception.handler.MemberHandler;
import mju_umc.mju_umc.response.exception.handler.StoreHandler;
import mju_umc.mju_umc.service.ReviewService;
import mju_umc.mju_umc.web.dto.review.ReviewRequestDto;
import mju_umc.mju_umc.web.dto.review.ReviewResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;


    @Override
    public Review addReview(ReviewRequestDto.addReview request) {
        //리뷰 생성, 아직 멤버와 상점 없음
        Review review = ReviewConverter.toReview(request);
        //아이디로 조회
        Member member = memberRepository.findById(request.getMemberId()).get();
        Store store = storeRepository.findById(request.getStoreId()).get();

        //연관관계 매핑
        review.setMember(member);
        review.setStore(store);

        //저장 및 반환
        return reviewRepository.save(review);
    }

    //서비스 계층에서 dto를 만들어서 내보내면, sql문을 한번에 묶어서 보낼 수 있기 때문에 성능적으로 효율적이다..?
    @Transactional(readOnly = true)
    public ReviewResponseDto.GetReviewsResult getAllByNameAndStore(Long memberId, Long storeId, Integer page) {
        //멤버 조회
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        //상점 조회
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        //리뷰 리스트 조회
        List<Review> reviewList = reviewRepository.findAllByMemberAndStore(member, store, PageRequest.of(page, 10)).stream().toList();

        return ReviewConverter.toGetReviewResult(reviewList, member, store.getName());
    }

    public List<Review> getReviewsByNameAndStore(Member member, Store store, Integer page) {
        return reviewRepository.findAllByMemberAndStore(member, store, PageRequest.of(page, 10)).stream().toList();
    }

    @Override
    public Page<Review> getReviewListByStore(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Page<Review> reviewsByStore = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return reviewsByStore;
    }



}

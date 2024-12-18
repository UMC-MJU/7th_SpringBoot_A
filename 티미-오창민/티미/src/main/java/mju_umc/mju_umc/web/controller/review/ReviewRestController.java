package mju_umc.mju_umc.web.controller.review;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.converter.ReviewConverter;
import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.Review;
import mju_umc.mju_umc.domain.Store;
import mju_umc.mju_umc.response.exception.handler.ApiResponse;
import mju_umc.mju_umc.service.ReviewService;
import mju_umc.mju_umc.service.serviceIml.MemberServiceImpl;
import mju_umc.mju_umc.service.serviceIml.StoreQueryServiceImpl;
import mju_umc.mju_umc.validation.annotation.CheckPage;
import mju_umc.mju_umc.validation.annotation.ExistStore;
import mju_umc.mju_umc.web.dto.review.ReviewRequestDto;
import mju_umc.mju_umc.web.dto.review.ReviewResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
@Validated
public class ReviewRestController {
    private final ReviewService reviewService;
    private final StoreQueryServiceImpl storeService;
    private final MemberServiceImpl memberService;

    @PostMapping("addReview")
    public ApiResponse<ReviewResponseDto.addReviewResult> addReview(@RequestBody @Valid ReviewRequestDto.addReview request) {
        Review review = reviewService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toaddReviewResult(review));
    }

    @GetMapping("/{storeId}")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰을 만료!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰을 토큰 모양이 이상함!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "한 페이지당 10개의 데이터를 뿌립니다. 1 이상의 수를 입력해주세요")
    })
    public ApiResponse<ReviewResponseDto.ReviewPreViewListDTO> getReviewListByStore(@ExistStore @PathVariable("storeId") Long storeId,
                                                                                    @CheckPage @RequestParam(name = "page") Integer page) {

        int editPage = Math.max(0, page - 1); //1이상의 페이지면 -1 (페이징은 0부터 시작), 0이면 0 그대로 반환
        Page<Review> reviewListByStore = reviewService.getReviewListByStore(storeId, editPage);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviewListByStore));

    }

//    //서비스 단에서 데이터를 조회해서 dto를 반환 -> get 요청이므로, body로 요청을 받으면 안된다..
//    @GetMapping("reviews/{memberId}")
//    public ApiResponse<ReviewResponseDto.GetReviewsResult> getReviewsByMemberAndStore(@PathVariable("memberId") Long memberId,@RequestParam("storeId") Long storeId, @RequestParam("page") Integer page) {
//        return ApiResponse.onSuccess(reviewService.getAllByNameAndStore(memberId,storeId, page));
//    }

//    //컨트롤러 단에서 필요한 정보를 요청하고, 데이터를 찾아 변환해 반환
    //위의 서비스 메소드 안에서 한번에 이루어지는 것과 같은 쿼리가 나가지만, 좀더 역할을 분리해서 안정적으로 하였다.
    @GetMapping("reviews/{memberId}")

    public ApiResponse<ReviewResponseDto.GetReviewsResult> getReviewsByController(@PathVariable("memberId") Long memberId, @RequestParam("storeId") Long storeId, @CheckPage @RequestParam("page") Integer page) {
        //page 정보 수정
        int editPage = Math.max(0, page - 1); //1이상의 페이지면 -1 (페이징은 0부터 시작), 0이면 0 그대로 반환
        Member member = memberService.getMemberById(memberId);
        Store store = storeService.findStore(storeId);
        List<Review> reviews = reviewService.getReviewsByNameAndStore(member, store, editPage);
        return ApiResponse.onSuccess(ReviewConverter.toGetReviewResult(reviews, member, store.getName()));
    }
}

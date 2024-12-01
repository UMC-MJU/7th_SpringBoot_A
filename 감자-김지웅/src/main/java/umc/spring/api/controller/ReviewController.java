package umc.spring.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.api.dto.ReviewResponseDTO;
import umc.spring.api.dto.StoreResponseDTO;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewService;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistStore;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{memberId}/my-reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API",
            description = "내가 작성한 리뷰 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 전달하세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "access 토큰을 주세요!",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "access 토큰 만료",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "406", description = "access 토큰 모양이 이상함",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "page", description = "조회할 페이지 번호입니다.")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getMyReviews(
            @PathVariable(name = "memberId") Long memberId,
            @RequestParam(name = "page") @CheckPage Integer page) {

        // 리뷰 목록을 서비스에서 가져옴
        Page<Review> reviewPage = reviewService.getMyReviews(memberId, page - 1);

        // DTO 변환
        StoreResponseDTO.ReviewPreViewListDTO response = StoreConverter.reviewPreViewListDTO(reviewPage);

        return ApiResponse.onSuccess(response);
    }
}



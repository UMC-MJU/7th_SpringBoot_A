package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.Review.ReviewCommandService;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.review.ReviewRequestDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
@Validated
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping(value = "/write/review/storeId/{storeId}")
    public ApiResponse<ReviewResponseDTO.addResultDTO> add(
            @PathVariable("storeId") @ExistStore Long storeId,
            @RequestBody @Valid ReviewRequestDTO.AddResultDTO request
    ) {
        Review review = reviewCommandService.addReview(storeId, request);

        return ApiResponse.onSuccess(ReviewConverter.toAddResultDTO(review));
    }
}

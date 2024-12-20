package umc.spring.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ReviewResponseDTO {

    private List<ReviewDTO> reviewList;
    private Integer listSize;
    private Integer totalPage;
    private Long totalElements;
    private Boolean isFirst;
    private Boolean isLast;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ReviewDTO {
        private String ownerNickname;
        private Float score;
        private String body;
        private LocalDate createdAt;
    }
}

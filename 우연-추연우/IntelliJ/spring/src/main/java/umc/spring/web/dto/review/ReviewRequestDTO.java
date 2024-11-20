package umc.spring.web.dto.review;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class AddResultDTO {

        @NotNull
        String title;

        @NotNull
        Float score;
    }
}

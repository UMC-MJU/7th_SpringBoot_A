package umc.spring.web.dto.store;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class addDTO {
        @NotNull
        String name;

        @Size(min = 5, max = 12)
        String address;
    }
}

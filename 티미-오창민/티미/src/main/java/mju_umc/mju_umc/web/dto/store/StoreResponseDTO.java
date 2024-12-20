package mju_umc.mju_umc.web.dto.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mju_umc.mju_umc.domain.Store;

import java.time.LocalDateTime;


public class StoreResponseDTO {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class joinResult{
        Long storeId; //생성된 상점 id
        LocalDateTime createdAt; //상점이 생성된 시점
    }

}

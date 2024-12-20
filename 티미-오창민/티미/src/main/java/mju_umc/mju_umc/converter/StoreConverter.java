package mju_umc.mju_umc.converter;

import mju_umc.mju_umc.domain.Review;
import mju_umc.mju_umc.domain.Store;
import mju_umc.mju_umc.web.dto.store.StoreRequestDTO;
import mju_umc.mju_umc.web.dto.store.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.joinResult toJoinResult(Store store) {
        return StoreResponseDTO.joinResult.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }


    //상점 생성 -> 지역 할당은 다른 곳에서 할당.
    public static Store toStore(StoreRequestDTO.joinDTO request) {
        return Store.builder()
                .address(request.getAddress())
                .name(request.getName())
                .score(request.getScore()).build();
    }


}

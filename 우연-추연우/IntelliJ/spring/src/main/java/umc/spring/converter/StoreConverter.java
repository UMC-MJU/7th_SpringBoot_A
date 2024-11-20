package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.store.StoreRequestDTO;
import umc.spring.web.dto.store.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.addResultDTO toAddResultDTO(Store store) {
        return StoreResponseDTO.addResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.addDTO request, Region region) {
        return Store.builder()
                .address(request.getAddress())
                .region(region)
                .name(request.getName())
                .build();
    }
}

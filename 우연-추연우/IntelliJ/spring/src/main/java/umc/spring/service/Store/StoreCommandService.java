package umc.spring.service.Store;

import umc.spring.domain.Store;
import umc.spring.web.dto.store.StoreRequestDTO;

public interface StoreCommandService {

    Store addStore(StoreRequestDTO.addDTO request);
}

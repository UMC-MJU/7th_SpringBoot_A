package mju_umc.mju_umc.web.controller.store;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.converter.StoreConverter;
import mju_umc.mju_umc.domain.Store;
import mju_umc.mju_umc.response.exception.handler.ApiResponse;
import mju_umc.mju_umc.service.StoreQueryService;
import mju_umc.mju_umc.web.dto.store.StoreRequestDTO;
import mju_umc.mju_umc.web.dto.store.StoreResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //객체를 반환함으로서 josn 파일을 반환할 것
@RequiredArgsConstructor
@RequestMapping("/stores") //공통 주소 처리
public class StoreRestController {
    private final StoreQueryService storeQueryService;

    @PostMapping("/join")
    public ApiResponse<StoreResponseDTO.joinResult> joinStore(@RequestBody @Valid StoreRequestDTO.joinDTO request) {
        Store store = storeQueryService.joinStore(request);
        return ApiResponse.onSuccess(StoreConverter.toJoinResult(store));

    }
}

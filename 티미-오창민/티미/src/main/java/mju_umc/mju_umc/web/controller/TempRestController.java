package mju_umc.mju_umc.web.controller;

import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.converter.TempConverter;
import mju_umc.mju_umc.response.ApiResponse;
import mju_umc.mju_umc.service.TempQueryService;
import mju_umc.mju_umc.web.dto.TempResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 결과를 json파일로 반환환다
@RequestMapping("/temp") //공통 요청 주소
@RequiredArgsConstructor
public class TempRestController {
    private final TempQueryService tempQueryService;
    @GetMapping("/test") // /temp/test 주소로 날라오는 요청 처리
    public ApiResponse<TempResponse.TempTestDTO> testAPI() {
        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam("flag") Integer flag) {
        tempQueryService.CheckFlag(flag);

        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}

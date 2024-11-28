package mju_umc.mju_umc.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//응답을 위한 dto클래스
public class TempResponse{

    //GET/temp/test 요청에 대한 result을 위한 dto 클래스
    @Builder
    @Getter
    @NoArgsConstructor // 기본 생성자
    @AllArgsConstructor // 모든 요소를 담은 자동 생성자
    public static class TempTestDTO {
        String testString;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TempExceptionDTO{
        Integer flag;
    }
}


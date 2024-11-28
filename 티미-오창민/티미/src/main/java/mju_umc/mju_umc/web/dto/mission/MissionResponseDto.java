package mju_umc.mju_umc.web.dto.mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MissionResponseDto {

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class addMissionResult{
        Long missionId; //만들어진 미션의 아이디
        LocalDateTime createdAt; //미션이 만들어진 시간
    }
}

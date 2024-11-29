package umc.spring.web.dto.mission;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class addMissionResultDTO {

        @NotNull
        Integer reward;

        @NotNull
        String missionSpec;
    }
}

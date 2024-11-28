package mju_umc.mju_umc.web.controller.misison;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.converter.MissionConverter;
import mju_umc.mju_umc.domain.Mission;
import mju_umc.mju_umc.response.exception.handler.ApiResponse;
import mju_umc.mju_umc.service.MissionQueryService;
import mju_umc.mju_umc.web.dto.mission.MissionRequestDto;
import mju_umc.mju_umc.web.dto.mission.MissionResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mission")
@RequiredArgsConstructor
public class MissionRestController {

    private final MissionQueryService missionQueryService;

    @PostMapping("/addMission")
    public ApiResponse<MissionResponseDto.addMissionResult> addMission(@RequestBody @Valid MissionRequestDto.addMission request) {
        Mission mission = missionQueryService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionResult(mission));
    }
}

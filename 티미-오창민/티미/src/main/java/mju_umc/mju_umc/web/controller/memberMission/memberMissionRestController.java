package mju_umc.mju_umc.web.controller.memberMission;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.converter.MemberMissionConverter;
import mju_umc.mju_umc.domain.mapping.MemberMission;
import mju_umc.mju_umc.response.exception.handler.ApiResponse;
import mju_umc.mju_umc.service.MemberMissionService;
import mju_umc.mju_umc.web.dto.memberMission.MemberMissionRequestDto;
import mju_umc.mju_umc.web.dto.memberMission.MemberMissionResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/memberMission")
@RequiredArgsConstructor
public class memberMissionRestController {
    private final MemberMissionService memberMissionService;

    @PostMapping("/addMemberMission")
    public ApiResponse<MemberMissionResponseDto.addMissionResult> addMemberMission(@RequestBody @Valid MemberMissionRequestDto.addMemberMission request) {
        MemberMission memberMission = memberMissionService.addMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toAddMemberMissionResult(memberMission));
    }

    @PatchMapping("/members/toComplete")
    public ApiResponse<MemberMissionResponseDto.toCompleteResult> toComplete(@RequestBody @Valid MemberMissionRequestDto.toComplete request) {
        MemberMission editedMemberMission = memberMissionService.toComplete(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toCompleteResult(editedMemberMission));
    }
}

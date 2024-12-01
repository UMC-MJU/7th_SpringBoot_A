package mju_umc.mju_umc.web.controller.misison;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.converter.MissionConverter;
import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.Mission;
import mju_umc.mju_umc.domain.enums.MissionStatus;
import mju_umc.mju_umc.response.exception.handler.ApiResponse;
import mju_umc.mju_umc.service.MemberCommandService;
import mju_umc.mju_umc.service.MemberMissionService;
import mju_umc.mju_umc.service.MissionQueryService;
import mju_umc.mju_umc.validation.annotation.CheckPage;
import mju_umc.mju_umc.web.dto.mission.MissionRequestDto;
import mju_umc.mju_umc.web.dto.mission.MissionResponseDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
@Validated
public class MissionRestController {

    private final MissionQueryService missionQueryService;
    private final MemberCommandService memberCommandService;

    @PostMapping("/addMission")
    public ApiResponse<MissionResponseDto.addMissionResult> addMission(@RequestBody @Valid MissionRequestDto.addMission request) {
        Mission mission = missionQueryService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionResult(mission));
    }

    //특정 가게의 미션을 조회하는 컨트롤러
    @GetMapping("stores/{storeId}")
    public ApiResponse<MissionResponseDto.getMissionListByStore> getMissions(@PathVariable("storeId") Long storeId, @CheckPage @RequestParam("page") Integer page) {
        //page 정보 수정
        int editPage = Math.min(0, page - 1); //1이상의 페이지면 -1 (페이징은 0부터 시작), 0이면 0 그대로 반환
        List<Mission> missionByStore = missionQueryService.getMissionByStore(storeId, editPage);
        return ApiResponse.onSuccess(MissionConverter.toGetMissionListByStoreResult(storeId,missionByStore));
    }

    //멤버의 진행 중인 미션을 조회하는 컨트롤러
    @GetMapping("members/{memberId}")
    public ApiResponse<MissionResponseDto.getChallengingMissionList> getChallengingMissions(@PathVariable("memberId") Long memberId, @CheckPage @RequestParam("page") Integer page) {
        Member member = memberCommandService.findMember(memberId);
        int editPage = Math.min(0, page - 1); //1이상의 페이지면 -1 (페이징은 0부터 시작), 0이면 0 그대로 반환

        List<Mission> missionsByMemberAndStatus = missionQueryService.getMissionsByMemberAndStatus(MissionStatus.CHALLENGING, member,editPage);
        return ApiResponse.onSuccess(MissionConverter.toChallengingMissionResult(member, missionsByMemberAndStatus));
    }


}

package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.Mission.MissionQueryService;
import umc.spring.validation.annotation.ExistMission;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.mission.MissionRequestDTO;
import umc.spring.web.dto.mission.MissionResponseDTO;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
@Validated
public class MissionRestController {

    private final MissionQueryService missionService;

//    @GetMapping("/ongoing")
//    public ResponseEntity<List<MissionDTO>> getOngoingMissions(
//            @RequestParam Long memberId,
//            @RequestParam(required = false) Long cursor) {
//        List<MissionDTO> missions = missionService.getOngoingMissions(memberId, cursor);
//        return ResponseEntity.ok(missions);
//    }
//
//    @GetMapping("/finished")
//    public ResponseEntity<List<MissionDTO>> getFinishedMissions(
//            @RequestParam Long memberId,
//            @RequestParam(required = false) Long cursor) {
//        List<MissionDTO> missions = missionService.getFinishedMissions(memberId, cursor);
//        return ResponseEntity.ok(missions);
//    }
//
//    @GetMapping("/region")
//    public ResponseEntity<List<MissionRegionDTO>> getMissionsInRegion(
//            @RequestParam String regionName,
//            @RequestParam(required = false) Long cursor,
//            @RequestParam Long memberId) {
//        List<MissionRegionDTO> missions = missionService.getMissionsInRegion(regionName, cursor, memberId);
//        return ResponseEntity.ok(missions);
//    }

    @PostMapping("/add/store/{storeId}")
    public ApiResponse<MissionResponseDTO.addResultDTO> addMission(
            @PathVariable("storeId") @ExistStore Long storeId,
            @RequestBody @Valid MissionRequestDTO.addMissionResultDTO request
    ) {
        Mission mission = missionService.addMission(storeId, request);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission));
    }

    @PostMapping("/{missionId}/challenges")
    public ApiResponse<MissionResponseDTO.changeResultDTO> changeMissionToOngoing(
            @PathVariable("missionId") @ExistMission Long missionId
    ) {
        MemberMission mission = missionService.changeMissionToOnGoing(missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.changeResultDTO(mission));
    }

}

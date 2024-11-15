package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.dto.MissionDTO;
import umc.spring.dto.MissionRegionDTO;
import umc.spring.service.Mission.MissionQueryService;


import java.util.List;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionQueryService missionService;

    @GetMapping("/ongoing")
    public ResponseEntity<List<MissionDTO>> getOngoingMissions(
            @RequestParam Long memberId,
            @RequestParam(required = false) Long cursor) {
        List<MissionDTO> missions = missionService.getOngoingMissions(memberId, cursor);
        return ResponseEntity.ok(missions);
    }

    @GetMapping("/finished")
    public ResponseEntity<List<MissionDTO>> getFinishedMissions(
            @RequestParam Long memberId,
            @RequestParam(required = false) Long cursor) {
        List<MissionDTO> missions = missionService.getFinishedMissions(memberId, cursor);
        return ResponseEntity.ok(missions);
    }

    @GetMapping("/region")
    public ResponseEntity<List<MissionRegionDTO>> getMissionsInRegion(
            @RequestParam String regionName,
            @RequestParam(required = false) Long cursor,
            @RequestParam Long memberId) {
        List<MissionRegionDTO> missions = missionService.getMissionsInRegion(regionName, cursor, memberId);
        return ResponseEntity.ok(missions);
    }
}

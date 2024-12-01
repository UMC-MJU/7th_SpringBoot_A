package umc.spring.api.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.api.dto.MemberMissionDTO;
import umc.spring.api.dto.MissionResponseDTO;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberMissionService.MemberMissionService;
import umc.spring.service.MemberMissionService.MemberMissionServiceImpl;
import umc.spring.validation.annotation.ExistMember;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/member")
public class MemberMissionRestController {

    private final MemberMissionService memberMissionService;

    @GetMapping("/{memberId}/mission_inprogress")
    @Operation(summary = "내가 진행 중인 미션 목록 조회 API",
            description = "내가 진행 중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호를 전달하세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "access 토큰을 주세요!",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "access 토큰 만료",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "406", description = "access 토큰 모양이 이상함",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, path variable 입니다."),
            @Parameter(name = "page", description = "조회할 페이지 번호입니다.")
    })
    public ApiResponse<MemberMissionDTO.MissionPreviewListDTO> getMissionList(
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @RequestParam(name = "page") Integer page) {

        // 진행 중인 미션 목록 조회
        Page<MemberMission> memberMissions = memberMissionService.getMissionList(memberId, page);

        // DTO 변환
        MemberMissionDTO.MissionPreviewListDTO response = MemberMissionConverter.toMissionPreviewListDTO(memberMissions);

        return ApiResponse.onSuccess(response);
    }
}
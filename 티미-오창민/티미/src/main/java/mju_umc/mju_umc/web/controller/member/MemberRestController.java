package mju_umc.mju_umc.web.controller.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.converter.MemberConverter;
import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.response.exception.handler.ApiResponse;
import mju_umc.mju_umc.service.MemberCommandService;
import mju_umc.mju_umc.web.dto.member.MemberRequestDTO;
import mju_umc.mju_umc.web.dto.member.MemberResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    //@RequestBody를 통해, 객체에 요청 정보를 자동으로 담아줄 것.
    //추가로 @Valid를 통해 오류도 검증해 줄 것.
    public ApiResponse<MemberResponseDTO.joinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        //이제 api의 result 부분에 만들어진 멤버를 넣는다.
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTo(member));
    }

}


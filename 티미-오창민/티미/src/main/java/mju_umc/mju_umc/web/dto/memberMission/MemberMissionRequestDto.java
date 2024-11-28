package mju_umc.mju_umc.web.dto.memberMission;

import lombok.Getter;

public class MemberMissionRequestDto {

    @Getter
    //맴버의 아이디와 미션 아이디를 받아
    //멤버 미션을 생성해 리스트에 추가하기 위한 정보를 담는 dto
    public static class addMemberMission{
        Long memberId;
        Long missionId;
    }


}

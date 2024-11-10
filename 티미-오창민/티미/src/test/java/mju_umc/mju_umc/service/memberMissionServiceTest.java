package mju_umc.mju_umc.service;

import jakarta.transaction.Transactional;
import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.Mission;
import mju_umc.mju_umc.domain.Region;
import mju_umc.mju_umc.domain.enums.Gender;
import mju_umc.mju_umc.domain.mapping.MemberMission;
import mju_umc.mju_umc.repository.MemberMissionRepository;
import mju_umc.mju_umc.service.serviceIml.MemberMissionServiceImpl;
import mju_umc.mju_umc.service.serviceIml.MemberServiceImpl;
import mju_umc.mju_umc.service.serviceIml.MissionQueryServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
public class memberMissionServiceTest {
    @Autowired
    MemberMissionRepository memberMissionRepository;
    @Autowired
    MemberMissionServiceImpl memberMissionService;
    @Autowired
    MemberServiceImpl memberService;
    @Autowired
    MissionQueryServiceImpl missionService;

    @Test
    public void getAbleMissionsInRegionByMember() {
        //given

        //멤버 가져오기
        Member member = Member.builder()
                .name("Test")
                .address("testAddress")
                .specAddress("specAddressTest")
                .email("emailTest")
                .gender(Gender.MALE)
                .build();
        //테스트 회원 저장
        memberService.saveMember(member);

        //회원에 미션 부여 -> 맴버 미션 생성 및, 연관관계 매핑
        List<Mission> allMission = missionService.getAllMission();
        for (Mission m : allMission) {
            //멤버 미션 생성 및 연관관계 메핑

            //맴버 미션 객체 생성
            MemberMission memberMission = MemberMission.builder().mission(m).member(member).build();

            //맴버 미션 객체 저장
            memberMissionService.saveMemberMission(memberMission);

            //연관관계 매핑
            member.setMission(memberMission);
            m.setMember(memberMission);
        }
        Region region = Region.builder().name("서울").build(); //서울 지역 생성

        //when
        List<MemberMission> findMissions = memberMissionService.getAbleMissionsInRegionByMember(region, member);

        //then

        //미션은 총 4개, 각 미션은 각각 ,1,1,2,3 번 상점을 가진다.
        //각 상점의 지역은 모두 서울이다. 따라서 4개의 미션이 있다.
        //그중 challenging인 상태는, 1,2 미션 두 개이다.
        //따라서 결과는 2개여야 한다.
        Assertions.assertThat(findMissions.size()).isEqualTo(2);
    }
}

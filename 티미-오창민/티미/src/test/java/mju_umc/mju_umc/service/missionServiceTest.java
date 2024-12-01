//package mju_umc.mju_umc.service;
//
//
//import jakarta.persistence.EntityManager;
//import lombok.extern.slf4j.Slf4j;
//import mju_umc.mju_umc.domain.Member;
//import mju_umc.mju_umc.domain.Mission;
//import mju_umc.mju_umc.domain.enums.Gender;
//import mju_umc.mju_umc.domain.enums.MissionStatus;
//import mju_umc.mju_umc.domain.mapping.MemberMission;
//import mju_umc.mju_umc.repository.MemberMissionRepository;
//import mju_umc.mju_umc.service.serviceIml.MemberMissionServiceImpl;
//import mju_umc.mju_umc.service.serviceIml.MemberServiceImpl;
//import mju_umc.mju_umc.service.serviceIml.MissionQueryServiceImpl;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Transactional
//@SpringBootTest
//public class missionServiceTest {
//
//    @Autowired
//    MemberMissionRepository memberMissionRepository;
//    @Autowired
//    MemberMissionServiceImpl memberMissionService;
//    @Autowired
//    MemberServiceImpl memberService;
//    @Autowired
//    MissionQueryServiceImpl missionService;
//
//    @Test
//    public void getMissionsByMemberAndStatus() {
//        //given
//
//        //테스트 회원 생성
//        Member member = Member.builder()
//                .name("Test")
//                .address("testAddress")
//                .specAddress("specAddressTest")
//                .email("emailTest")
//                .gender(Gender.MALE)
//                .build();
//        //테스트 회원 저장
//        memberService.saveMember(member);
//
//        //회원에 미션 부여 -> 맴버 미션 생성 및, 연관관계 매핑
//        List<Mission> allMission = missionService.getAllMission();
//
//        for (Mission m : allMission) {
//            //멤버 미션 생성 및 연관관계 메핑
//
//            //맴버 미션 객체 생성
//            MemberMission memberMission = MemberMission.builder().mission(m).member(member).status(MissionStatus.CHALLENGING).build(); //모든 미션에 challenging 속성 부여
//
//            //맴버 미션 객체 저장
//            memberMissionService.saveMemberMission(memberMission, member);
//        }
//        //when
//        //미션 상테에 동적으로 반응해서 가져오는 메소드
//        //CHALLENGING 상태의 미션만 가져온다.
//
//        List<Mission> missions = missionService.getMissionsByMemberAndStatus(MissionStatus.CHALLENGING, member);
//
//
//        //then
//        //DB에서 CHALLENGING 상태의 미션의 개수는 4개이다.
//        Assertions.assertThat(missions.size()).isEqualTo(4);
//    }
//}

package mju_umc.mju_umc.converter;

import mju_umc.mju_umc.domain.FoodCategory;
import mju_umc.mju_umc.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

//선호 음식에 대한 변환 클래스
public class MemberPreferConverter {

    //음식 카테고리를 멤버 선호 카테고리로 바꿔준다.
    //멤버 선호 카테고리에 필요한 멤버는 일단 비워둔다. -> 양방향 메핑의 연관관계 설정은 서비스단에서 하는게 좋다.
    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList) {
        return foodCategoryList.stream()
                .map(foodCategory -> //각각의 음식카테고리에 대해서
                        MemberPrefer.builder() //멤버 선호 생성
                                .foodCategory(foodCategory) //음식 카테고리 집어넣기
                                .build()
                ).collect(Collectors.toList()); //멤버 선호 리스트 반환
    }
}

package mju_umc.mju_umc.web.dto.member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import mju_umc.mju_umc.validation.annotation.ExistCategories;

import java.util.List;

//멤버 요청 시 사용되는 DTO
public class MemberRequestDTO {

    //이것도 static class로 필요할때마다 골라 사용하게 함
    //여기에 클라이언트의 요청 정보가 담겨 들어올 예정..
    @Getter //따라서 Getter만 필요!
    public static class JoinDto{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }
}

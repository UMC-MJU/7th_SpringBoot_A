package mju_umc.mju_umc.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.response.code.status.ErrorStatus;
import mju_umc.mju_umc.validation.annotation.CheckPage;
import org.springframework.stereotype.Component;

//페이지 정보 입력이 적절하게 들어왔는지 확인하는 validator
@Component
@RequiredArgsConstructor
public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer> {
    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    //만약 1이 들어오면 0으로 반환 -> page-1을 반환 -> 클라이언트는 1이상을 주지만,
    //page는 0부터 시작하기 때문에 -> 0 미만이면, 오류 반환
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        if (page < 0) { //0보다 작은 페이지를 입력한 경우
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.INVALID_PAGE.toString()).addConstraintViolation();
            return false;
        }
        // 0이상의 페이지인 경우
        return true; //
    }
}







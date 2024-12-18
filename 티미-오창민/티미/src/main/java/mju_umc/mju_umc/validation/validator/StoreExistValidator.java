package mju_umc.mju_umc.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.response.code.status.ErrorStatus;
import mju_umc.mju_umc.service.StoreQueryService;
import mju_umc.mju_umc.validation.annotation.ExistStore;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
//상점 id는 리스트가 아니라, 하나로 들어오니까 <ExistStore, Long>으로 정함
public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> {
    private final StoreQueryService storeQueryService;

    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = storeQueryService.existsById(value); // 존재 여부

        if (!isValid) { //존재하지 않으면..
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
        }


        return isValid;
    }



}

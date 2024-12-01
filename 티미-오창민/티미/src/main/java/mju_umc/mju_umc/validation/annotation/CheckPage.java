package mju_umc.mju_umc.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import mju_umc.mju_umc.validation.validator.CheckPageValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPageValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "적절하지 않는 페이지 입력입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

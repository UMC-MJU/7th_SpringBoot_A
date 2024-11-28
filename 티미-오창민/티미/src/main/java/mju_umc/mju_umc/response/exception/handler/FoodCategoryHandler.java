package mju_umc.mju_umc.response.exception.handler;

import mju_umc.mju_umc.domain.FoodCategory;
import mju_umc.mju_umc.domain.mapping.MemberPrefer;
import mju_umc.mju_umc.response.code.BaseErrorCode;
import mju_umc.mju_umc.response.exception.GeneralException;

import java.util.List;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}


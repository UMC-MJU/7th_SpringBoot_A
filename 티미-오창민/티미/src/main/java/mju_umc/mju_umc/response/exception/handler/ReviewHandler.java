package mju_umc.mju_umc.response.exception.handler;

import mju_umc.mju_umc.response.code.BaseErrorCode;
import mju_umc.mju_umc.response.exception.GeneralException;

public class ReviewHandler extends GeneralException {
    public ReviewHandler(BaseErrorCode baseError) {
        super(baseError);
    }
}

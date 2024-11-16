package mju_umc.mju_umc.response.exception.handler;

import mju_umc.mju_umc.response.code.BaseErrorCode;
import mju_umc.mju_umc.response.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}


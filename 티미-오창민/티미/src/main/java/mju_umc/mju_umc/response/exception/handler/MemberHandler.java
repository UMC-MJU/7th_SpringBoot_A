package mju_umc.mju_umc.response.exception.handler;

import mju_umc.mju_umc.response.code.BaseErrorCode;
import mju_umc.mju_umc.response.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);

    }
}

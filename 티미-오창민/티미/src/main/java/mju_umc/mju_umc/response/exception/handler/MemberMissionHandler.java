package mju_umc.mju_umc.response.exception.handler;

import mju_umc.mju_umc.response.code.BaseErrorCode;
import mju_umc.mju_umc.response.exception.GeneralException;

public class MemberMissionHandler extends GeneralException {
    public MemberMissionHandler(BaseErrorCode errorCode) {
        super(errorCode);

    }
}

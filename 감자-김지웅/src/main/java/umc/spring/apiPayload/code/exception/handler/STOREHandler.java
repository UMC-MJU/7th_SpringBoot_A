package umc.spring.apiPayload.code.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.code.exception.GeneralException;

public class STOREHandler extends GeneralException {

    public STOREHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

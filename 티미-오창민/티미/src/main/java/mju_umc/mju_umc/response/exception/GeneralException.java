package mju_umc.mju_umc.response.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mju_umc.mju_umc.response.code.BaseErrorCode;
import mju_umc.mju_umc.response.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }
    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
}

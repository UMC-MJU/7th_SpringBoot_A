package mju_umc.mju_umc.response.code;

public interface BaseErrorCode {
    ErrorReasonDTO getReason();

    ErrorReasonDTO getReasonHttpStatus();
}

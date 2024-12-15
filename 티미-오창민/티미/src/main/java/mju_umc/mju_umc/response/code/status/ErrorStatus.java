package mju_umc.mju_umc.response.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mju_umc.mju_umc.response.code.BaseCode;
import mju_umc.mju_umc.response.code.BaseErrorCode;
import mju_umc.mju_umc.response.code.ErrorReasonDTO;
import mju_umc.mju_umc.response.code.ReasonDTO;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    //가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403","금지된 요청입니다."),

    // 멤버 관련 응답
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다"),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002","닉네임은 필수 입니다."),
    // 멤버 미션 관련
    MEMBER_MISSION_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER_MISSON4001", "존재하지 않는 멤버 미션입니다."),


    //예씨..
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, " ARTICLE4001", "게시글이 없습니다."),

    //음식 카테고리
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST, "FOOD_CATEGORY4001", "음식 카테고리가 없습니다."),

    //상점
    STORE_NOT_FOUND(HttpStatus.BAD_REQUEST, "STORE4001", "상점이 존재하지 않습니다."),

    //리뷰 관련 응답
    REVIEW_NOT_FOUND(HttpStatus.BAD_REQUEST, "REVIEW001", "잘못된 리뷰 아이디입니다."),
    //페이징 에러
    INVALID_PAGE(HttpStatus.BAD_REQUEST, "PAGE4001", "적절하지 않은 페이지입니다."),
    //테스트를 위한 응답
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST,"TEMP4001", "이거슨 테스트");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    //실패 응답 생성.
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    //http상태를 담은 실패 응답 생성
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}

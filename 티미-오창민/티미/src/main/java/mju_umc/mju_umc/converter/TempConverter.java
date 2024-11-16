package mju_umc.mju_umc.converter;

import mju_umc.mju_umc.web.dto.TempResponse;

//해당 클래슨는 api의 result에 담을, 실제 데이터를 담은 객체를 반환한다.
public class TempConverter {
    //tatic 클래스들은, 여러 요청에 필요한 데이터를, 적절한 요청에 맞게, 실행해서 받아온다.

    //해당 static 클래스는, /temp/test의 결과를 가져올 것이다.
    public static TempResponse.TempTestDTO toTempTestDTO(){
        return TempResponse.TempTestDTO.builder()
                .testString("This is Test!")
                .build();
    }
    //해당 static 클래스는, /tmep/exception에 들어오는 flag를 담아 가져올 것이다.
    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag) {
        return TempResponse.TempExceptionDTO.builder().flag(flag).build();
    }
}
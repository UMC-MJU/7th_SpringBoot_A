package mju_umc.mju_umc.service.serviceIml;

import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.response.code.status.ErrorStatus;
import mju_umc.mju_umc.response.exception.handler.TempHandler;
import mju_umc.mju_umc.service.TempQueryService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempCommandQueryImpl implements TempQueryService {


    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1) {
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
        }
    }
}

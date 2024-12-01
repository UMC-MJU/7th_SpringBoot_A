package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.api.dto.MemberRequestDTO;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);

}

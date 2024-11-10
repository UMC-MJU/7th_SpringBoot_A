package umc.spring.repository.MyPageRepository;

import umc.spring.domain.Member;
import umc.spring.domain.MyPageDTO;

public interface MyPageRepositoryCustom {
    MyPageDTO findMemberInfo();
}

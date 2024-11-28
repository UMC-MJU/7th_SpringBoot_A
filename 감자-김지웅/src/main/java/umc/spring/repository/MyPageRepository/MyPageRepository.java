package umc.spring.repository.MyPageRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository.StoreRepositoryCustom;

public interface MyPageRepository extends JpaRepository<Member, Long>, MyPageRepositoryCustom {
}

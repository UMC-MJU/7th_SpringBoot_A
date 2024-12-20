package mju_umc.mju_umc.repository;

import mju_umc.mju_umc.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

//스프링 데이터 JPA가 제공하는 기본적인 조회 메소드와
//기본적인 것을 제외한 조회 메소드들을 가지는 커스텀 인스턴스를 추가로 extends한다.
public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {

}

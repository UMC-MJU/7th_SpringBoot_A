//package mju_umc.mju_umc.service;
//
//
//import mju_umc.mju_umc.domain.Store;
//import mju_umc.mju_umc.repository.StoreRepository;
//import mju_umc.mju_umc.service.serviceIml.StoreQueryServiceImpl;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Transactional
//@SpringBootTest
//public class storeServiceTest {
//    @Autowired
//    StoreQueryServiceImpl storeQueryService;
//    @Autowired
//    StoreRepository storeRepository;
//
//    @Test
//    public void findByNameAndNameTest() {
//        //given
//        Long beforeSave = storeRepository.count();
//        Store store = new Store(beforeSave+1, "요아정", "test", 4.0f, null);
//
//        //when
//        storeQueryService.saveStore(store);
//        //then
//        //저장된 개수만큼 목록이 증가해야 패스 -> save 테스트
//        Assertions.assertThat(storeRepository.count()).isEqualTo(beforeSave+1);
//
//        //이름이 요아정이고 , 4.0 이상인 모음
//        //기존 2 + 1 = 3개이여야 한다.
//        List<Store> findStore = storeQueryService.findStoresByNameAndScore("요아정", 4.0f);
//        Assertions.assertThat(findStore.size()).isEqualTo(3);
//
//    }
//}

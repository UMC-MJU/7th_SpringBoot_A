package mju_umc.mju_umc.service;


import mju_umc.mju_umc.domain.Store;
import mju_umc.mju_umc.repository.StoreRepository;
import mju_umc.mju_umc.service.serviceIml.StoreQueryServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SpringBootTest
public class storeServiceTest {
    @Autowired
    StoreQueryServiceImpl storeQueryService;
    @Autowired
    StoreRepository storeRepository;

    @Test
    public void findByNameAndNameTest() {
        Store store = new Store(1l, "test", "test", 0.0f, null);
        storeQueryService.saveStore(store);
        Store store2 = new Store(2l, "요아정", "test", 4.0f, null);
        storeQueryService.saveStore(store2);
        Store store3 = new Store(3l, "오우아", "test", 4.0f, null);
        storeQueryService.saveStore(store3);
        Store store4 = new Store(4l, "요아정", "test", 0.0f, null);
        storeQueryService.saveStore(store4);
        Store store5 = new Store(5l, "요아정", "test", 5.0f, null);
        storeQueryService.saveStore(store5);

        Assertions.assertThat(storeRepository.count()).isEqualTo(5);

        //이름이 요아정이고 , 4.0 이상인 모음
        List<Store> findStore = storeQueryService.findStoresByNameAndScore("요아정", 4.0f);
        Assertions.assertThat(findStore.size()).isEqualTo(2);

    }
}

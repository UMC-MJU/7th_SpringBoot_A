package mju_umc.mju_umc.repository;

import mju_umc.mju_umc.domain.Store;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class StoreRepositoryTest {
    @Autowired
    StoreRepository storeRepository;

    @Test
    @Transactional
    public void StoreTest() {
        Store store = new Store(1l, "test", "test", 0.0f, null);
        storeRepository.save(store);
        Assertions.assertThat(storeRepository.count()).isEqualTo(1);

    }
}

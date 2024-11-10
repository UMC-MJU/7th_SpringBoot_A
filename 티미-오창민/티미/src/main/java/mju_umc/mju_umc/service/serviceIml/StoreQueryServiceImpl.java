package mju_umc.mju_umc.service.serviceIml;

import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.domain.Store;
import mju_umc.mju_umc.repository.StoreRepository;
import mju_umc.mju_umc.service.StoreQueryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    //스프링 데이터 JPA에 제공하는 리포지토리를 가져온다.
    //가져오면서, 커스텀 리포지토리 인터페이스를 같이 가져오게 된다.
    //storerepository가 extends하고 있기 때문에..
    private final StoreRepository storeRepository;


    //저장하는 메소드
    @Transactional
    public void saveStore(Store store) {
        storeRepository.save(store);
    }

    @Override
    public Optional<Store> findStore(Long id) {
        Optional<Store> findStore = storeRepository.findById(id);
        return findStore;
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        //가져온 목록들 출력 -> 테스트 코드인듯.. -> 나중에는 log.info로 로깅처리하면 좋을 거 같다.
        filteredStores.forEach(store -> System.out.println("Store : " + store));

        return filteredStores; //가져온 상점 목록 리턴
    }
}

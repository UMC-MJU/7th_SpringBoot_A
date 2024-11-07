package mju_umc.mju_umc.service;

import mju_umc.mju_umc.domain.Store;

import java.util.List;
import java.util.Optional;


//상점 서비스 인터페이스
public interface StoreQueryService {
    Optional<Store> findStore(Long id);

    //상점의 이름과 점수로 조회하는 메소드
    List<Store> findStoresByNameAndScore(String name, Float score);

}


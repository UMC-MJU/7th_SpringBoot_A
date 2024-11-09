package umc.spring.service;

import umc.spring.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStoreById(Long id);
    List<Store> findAllStoresByNameAndScore(String name, float score);
}

package com.umcpractice.chapter_5.domain.store.service;

import com.umcpractice.chapter_5.domain.store.entity.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);

    List<Store> findStoresByNameAndScore(String name, Float score);
}
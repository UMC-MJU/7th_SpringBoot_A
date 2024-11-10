package com.umcpractice.chapter_5.domain.store.repository;

import com.umcpractice.chapter_5.domain.store.entity.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
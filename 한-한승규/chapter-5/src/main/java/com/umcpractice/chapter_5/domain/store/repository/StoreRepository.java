package com.umcpractice.chapter_5.domain.store.repository;

import com.umcpractice.chapter_5.domain.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
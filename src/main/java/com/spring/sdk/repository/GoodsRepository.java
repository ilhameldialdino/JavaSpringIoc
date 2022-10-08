package com.spring.sdk.repository;

import com.spring.sdk.model.Goods;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends CrudRepository<Goods,Long> {
	@Query("SELECT u FROM Users u WHERE u.name = ?1")
	Goods findOneName(String id);
}

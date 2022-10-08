package com.spring.sdk.repository;

import com.spring.sdk.model.Quotations;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotationsRepository extends CrudRepository<Quotations,Long>{
	@Query("SELECT u FROM Users u WHERE u.name = ?1")
	Quotations findOneName(String id);
}

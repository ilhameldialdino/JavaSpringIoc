package com.spring.sdk.repository;

import com.spring.sdk.model.Transactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionsRepository extends CrudRepository<Transactions,Long> {
	@Query("SELECT u FROM transactions u WHERE u.ransactionId = ?1")
	Transactions findOneId(Long id);
}

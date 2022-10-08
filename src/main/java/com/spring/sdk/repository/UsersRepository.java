package com.spring.sdk.repository;

import com.spring.sdk.model.Users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users,Long>{
	@Query("SELECT u FROM Users u WHERE u.name = ?1")
	Users findOneName(String id);
}
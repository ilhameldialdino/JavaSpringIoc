/**
 * 
 */
package com.spring.sdk.services;

import com.spring.sdk.model.Users;
import com.spring.sdk.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Ilham
 *
 */
@Service
@Transactional
public class UsersService {

	@Autowired
	UsersRepository usersRepository;

	public Users createUsers( Users users ){
		return usersRepository.save( users );
	}
	
	public Iterable<Users> findAll() {
        return usersRepository.findAll();
    }
}

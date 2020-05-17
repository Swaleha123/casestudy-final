package com.cts.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cts.project.pojos.User;

public interface UserRepository extends CrudRepository<User,String> {

	User findByUsernameAndPassword(String username, String password);
	User findByUsernameAndPasswordAndConfirm(String username,String password,String confirm);
	 List<User> findAll();

}

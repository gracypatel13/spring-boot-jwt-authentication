package com.onerivet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onerivet.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
	public User findByUserName(String userName);

}

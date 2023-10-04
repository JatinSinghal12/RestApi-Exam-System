package com.virtusa.examserver.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.examserver.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	public User findByUsername(String username);
	
}

package com.virtusa.examserver.service.impl;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.virtusa.examserver.entity.User;
import com.virtusa.examserver.entity.UserRole;
import com.virtusa.examserver.exception.UserFoundException;
import com.virtusa.examserver.repo.RoleRepo;
import com.virtusa.examserver.repo.UserRepo;
import com.virtusa.examserver.service.UserService;

@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {

		User local=this.userRepo.findByUsername(user.getUsername());
		if(local!=null) {
			System.out.println("User is Already There !!");
			throw new UserFoundException();
		}
		else {
			//user create
			for(UserRole ur:userRoles) {
				 roleRepo.save(ur.getRole());
			}
			user.getUserRole().addAll(userRoles);
			local=this.userRepo.save(user);
		}
		return local;
	}

	//getting user by username
	@Override	
	public User getUser(String username) {
		return this.userRepo.findByUsername(username);
	}
	@Override
	public void deleteUser(Long userId) {
		this.userRepo.deleteById(userId);
		
	}
	

}

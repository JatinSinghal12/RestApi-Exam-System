package com.virtusa.examserver;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.virtusa.examserver.entity.Role;
import com.virtusa.examserver.entity.User;
import com.virtusa.examserver.entity.UserRole;
import com.virtusa.examserver.exception.UserFoundException;
import com.virtusa.examserver.service.UserService;

@SpringBootApplication
public class QuizExamPortalApplication{
//implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(QuizExamPortalApplication.class, args);
	}
/*
	@Override
	public void run(String... args) throws Exception {
		try {
		System.out.println("Starting Code");
		
		User user=new User();
		user.setFirstName("Jatin");
		user.setLastName("Singhal");
		user.setUsername("jsinghal12");
		user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
		//user.setPassword("abc")
		user.setEmail("jsinghal.1212@gmail.com");
		user.setProfile("default.png");
		
		Role role1=new Role();
		role1.setRoleId(44L);
		role1.setRoleName("ADMIN");
		
		Set<UserRole> userRoleSet=new HashSet();
		UserRole userRole=new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		
		userRoleSet.add(userRole);
		User user1=this.userService.createUser(user, userRoleSet);
		System.out.println(user1.getUsername());
	}catch (UserFoundException e) {
		e.printStackTrace();
	}
	}*/
	

}

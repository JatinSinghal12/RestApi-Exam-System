package com.virtusa.examserver.controller;

import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.project.examportal.exception.UserFoundException
import com.virtusa.examserver.entity.Role;
import com.virtusa.examserver.entity.User;
import com.virtusa.examserver.entity.UserRole;
import com.virtusa.examserver.exception.UserFoundException;
import com.virtusa.examserver.exception.UserNotFoundException;
import com.virtusa.examserver.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		user.setProfile("default.png");
		//encoding password with bcryptpasswordencoder
		
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole> roles=new HashSet<>();
		
		Role role=new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		UserRole userRole=new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		return this.userService.createUser(user, roles);
	}
	
//	@GetMapping("/admin/{username}")
//	public User getUser(@PathVariable("username") String username) {
//		return this.userService.getUser(username);
//	}
//	
//	//delete user by id
//	@DeleteMapping("/admin/{userId}")
//	public void deleteUser(@PathVariable("userId") Long userId) {
//		this.userService.deleteUser(userId);
////		Optional<User> uobj=userService.findById(userId)
////		userService.deleteById(userId)
//	}
	 @ExceptionHandler(UserFoundException.class)
	    public ResponseEntity<?> exceptionHandler(UserNotFoundException ex) {
	        return ResponseEntity.ok(ex.getMessage());
	    }
}

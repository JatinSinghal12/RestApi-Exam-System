package com.virtusa.examserver.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.examserver.config.JwtUtils;
import com.virtusa.examserver.entity.JwtRequest;
import com.virtusa.examserver.entity.JwtResponse;
import com.virtusa.examserver.entity.User;
import com.virtusa.examserver.exception.UserNotFoundException;
import com.virtusa.examserver.service.impl.UserDetailsServiceImpl;


@RestController
@CrossOrigin("*")
public class AuthenticateController {
	
	 @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private UserDetailsServiceImpl userDetailsService;

	    @Autowired
	    private JwtUtils jwtUtils;
	    
	    //generate token
	    @PostMapping("/generate-token")
	    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
	        try {
	            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
	        } catch (UserNotFoundException e) {
	            e.printStackTrace();
	            throw new Exception("User not found ");
	        }
	        /////authenticate
	        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
	        String token = this.jwtUtils.generateToken(userDetails);
	        return ResponseEntity.ok(new JwtResponse(token));
	    }
	    //http://localhost:8080/generate-token enter username and password it will generate token

	    private void authenticate(String username, String password) throws Exception {
	        try {
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	        } catch (DisabledException e) {
	            throw new Exception("USER DISABLED " + e.getMessage());
	        } catch (BadCredentialsException e) {
	            throw new Exception("Invalid Credentials " + e.getMessage());
	        }
	    }

	    //returns the deatils of current user
	    @GetMapping("/current-user")
	    public User getCurrentUser(Principal principal) {
	        return ((User) this.userDetailsService.loadUserByUsername(principal.getName()));

	    }
	    //http://localhost:8080/current-user token Add to Authentication key with Bearer
}

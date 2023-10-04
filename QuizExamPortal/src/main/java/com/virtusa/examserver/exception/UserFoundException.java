package com.virtusa.examserver.exception;

public class UserFoundException extends Exception{

	 public UserFoundException() {
	        super("User with this username is Already in database !!");
	    }

	    public UserFoundException(String msg) {
	        super(msg);
	    }
}

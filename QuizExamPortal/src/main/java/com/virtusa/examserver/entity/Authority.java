package com.virtusa.examserver.entity;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{

	private String auth;
	
	public Authority(String authority) {
		super();
		this.auth = authority;
	}

	@Override
	public String getAuthority() {
		
		return this.auth;
	}

}


package com.bhawesh.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

	

/**
	 * 
	 */
private static final long serialVersionUID = 1L;
public JwtAuthenticationToken(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities,String token) {
		super(principal, credentials,authorities );
		this.token = token;
	}

private String token;
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}

 

 

  
}
package uk.co.optimisticpanda.play.hmacauth;

import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserAuth extends UsernamePasswordAuthenticationToken {
	
	private static final long serialVersionUID = 1L;

	private String name;

	private String password;
	public UserAuth(String user, String password) {
		super(user, password, Collections.singletonList(new SimpleGrantedAuthority("USER")));
	}

	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
}

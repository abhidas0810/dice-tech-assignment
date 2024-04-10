package com.diceTech.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

	@Bean
	public UserDetailsService getUserDetails() {
		UserDetails userDetails = User.withUsername("abhishek").password("123").build();
		InMemoryUserDetailsManager detailsManager = new InMemoryUserDetailsManager(userDetails);
		return detailsManager;
	}

	@Bean
	public NoOpPasswordEncoder encoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

}

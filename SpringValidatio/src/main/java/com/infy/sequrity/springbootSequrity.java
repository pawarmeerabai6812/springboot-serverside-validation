package com.infy.sequrity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.thymeleaf.standard.expression.AndExpression;

import jakarta.annotation.security.PermitAll;

@Configuration
public class springbootSequrity {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	
	 @Bean
	    public InMemoryUserDetailsManager userDetailsService() {
	        UserDetails normalUser = User.withUsername("user")
	        		.password(passwordEncoder().encode("password"))
	        		.roles("NORMAl")
	            .build();
	        
	        UserDetails adminUser = User.withUsername("mira")
	        		.password(passwordEncoder().encode("password1"))
	        		.roles("ADMIN")
	            .build();
	        
	        
	        return new InMemoryUserDetailsManager(normalUser);
	    }
	
	
	
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSequrity) throws Exception{
		
		httpSequrity
		
		
		.authorizeHttpRequests()
		.requestMatchers("/form/admin")
		.hasRole("ADMIN")
		.requestMatchers("/form/public")
		.permitAll()
		
		
		.anyRequest()
		.authenticated();
		
		
		
		
		 return httpSequrity.build();
	}

}

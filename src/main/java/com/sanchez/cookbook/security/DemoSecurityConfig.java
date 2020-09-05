package com.sanchez.cookbook.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity 
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	// add reference to our security data source
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// use jdbc authentication 
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	}
	
//	// Configure Spring Security to reference our custom login page.
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests()
//			// .anyRequest().authenticated()
//			.antMatchers("/").hasRole("EMPLOYEE")
//			.antMatchers("/leaders/**").hasRole("MANAGER")
//			.antMatchers("/systems/**").hasRole("ADMIN") // /** - all sub-directories recursively 
//			.and()
//			.formLogin()
//				.loginPage("/showMyLoginPage") // need to create this controller.
//				.loginProcessingUrl("/authenticateTheUser") // no controller request mapping needed. Get this for free from spring.
//				.permitAll()
//			.and()
//			.logout().permitAll()
//			.and()
//			.exceptionHandling()
//			.accessDeniedPage("/access-denied");
//	}
}

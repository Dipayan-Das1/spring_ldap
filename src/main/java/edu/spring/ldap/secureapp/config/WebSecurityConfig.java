package edu.spring.ldap.secureapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
	      .authorizeRequests()
	        .anyRequest().fullyAuthenticated()
	        .and()
	      .formLogin();
	}
	
	/*
	 * You also need an LDAP server. Spring Boot provides auto-configuration for an embedded server 
	 * written in pure Java, which is being used for this guide. The ldapAuthentication() method 
	 * configures things so that the user name at the login form is plugged into {0} such that it 
	 * searches uid={0},ou=people,dc=springframework,dc=org in the LDAP server. Also, the 
	 * passwordCompare() method configures the encoder and the name of the password’s attribute.
	 */
	 @Override
	  public void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth
	      .ldapAuthentication()
	        .userDnPatterns("uid={0},ou=people")
	        .groupSearchBase("ou=groups")
	        .contextSource()
	          .url("ldap://localhost:8389/dc=springframework,dc=org")
	          .and()
	        .passwordCompare()
	          //.passwordEncoder(new BCryptPasswordEncoder())
	          .passwordAttribute("userPassword");
	  }
	
}

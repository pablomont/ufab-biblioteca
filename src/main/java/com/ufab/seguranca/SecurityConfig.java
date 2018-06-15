package com.ufab.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
@ComponentScan("com.ufab")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService);
	}

	private PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()                                                                
				.antMatchers(
						"/",  
						"/assets/**"
						).permitAll()                  
				.antMatchers(
						"/curso/**",
						"/usuario/**"
						).authenticated()                                  
				.anyRequest().authenticated()                                                   
         	.and()
         		.formLogin()
         		.failureUrl("/login?error=true")
         		.loginPage("/login")
         		.defaultSuccessUrl("/dash")
         		.permitAll()
         	.and()
         	.logout()
         	.logoutSuccessUrl("/")
         	.permitAll();
	}

}

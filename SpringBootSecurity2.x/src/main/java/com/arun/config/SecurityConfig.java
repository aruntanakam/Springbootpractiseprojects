package com.arun.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private DataSource ds;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * auth.inMemoryAuthentication().passwordEncoder(encoder).withUser("arun")
		 * .password(encoder.encode("arun")).roles("CUSTOMER", "ADMIN");
		 * 
		 * auth.inMemoryAuthentication().passwordEncoder(encoder).withUser("kumar")
		 * .password(encoder.encode("kumar")).roles("CUSTOMER");
		 * auth.inMemoryAuthentication().passwordEncoder(encoder).withUser("tanakam")
		 * .password(encoder.encode("tanakam")).roles("ADMIN") .accountLocked(true);
		 */
		
		auth.jdbcAuthentication().dataSource(ds).passwordEncoder(encoder).authoritiesByUsernameQuery("select username,role from user_roles where username=?")
		.usersByUsernameQuery("select username,password,status from users where username=?");
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/offers").
		 * authenticated() .antMatchers("/balance").hasAnyRole("CUSTOMER",
		 * "ADMIN").antMatchers("/approveLoan").hasRole("ADMIN")
		 * .anyRequest().authenticated() // .and().httpBasic(); .and().formLogin() //
		 * .and().rememberMe() .and().logout().logoutRequestMatcher(new
		 * AntPathRequestMatcher("/signout")).and().exceptionHandling()
		 * .accessDeniedPage("/accessdenied"); //
		 * .and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
		 */		
		
		
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/offers").authenticated()
		.antMatchers("/balance").hasAnyAuthority("CUSTOMER", "ADMIN").antMatchers("/approveLoan").hasAuthority("ADMIN")
		.anyRequest().authenticated()
		// .and().httpBasic();
		.and().formLogin()
		// .and().rememberMe()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout")).and().exceptionHandling()
		.accessDeniedPage("/accessdenied");
// .and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);


	}

}
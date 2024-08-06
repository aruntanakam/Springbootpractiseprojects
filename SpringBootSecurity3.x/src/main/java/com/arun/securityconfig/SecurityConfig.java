package com.arun.securityconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.arun.service.CustomUserDetailsManager;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain createFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(request) -> request.requestMatchers("/ott/welcome","/ott/register").permitAll()
						.requestMatchers("/ott/**").authenticated().anyRequest().permitAll())
				.httpBasic(Customizer.withDefaults());

		http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		http.csrf(csrf -> csrf.disable());

		http.headers(headers -> headers.frameOptions(f -> f.sameOrigin()));
		return http.build();
	}

	/*
	 * @Bean public UserDetailsService inMemoryDetails() { UserDetails
	 * admin=User.withUsername("arun").password(encoder().encode("arun")).
	 * authorities("ADMIN").build();
	 * 
	 * UserDetails
	 * user1=User.withUsername("kumar").password(encoder().encode("kumar")).
	 * authorities("PREMIUM_MEMBER").build();
	 * 
	 * UserDetails
	 * user2=User.withUsername("tanakam").password(encoder().encode("tanakam")).
	 * authorities("NORMAL_USER").build();
	 * 
	 * return new InMemoryUserDetailsManager(admin,user1,user2); }
	 */

	/*
	 * @Bean public UserDetailsService userDetails(DataSource ds) { UserDetails
	 * admin=User.withUsername("arun").password(encoder().encode("arun")).
	 * authorities("ADMIN").build();
	 * 
	 * UserDetails
	 * user1=User.withUsername("kumar").password(encoder().encode("kumar")).
	 * authorities("PREMIUM_MEMBER").build();
	 * 
	 * UserDetails
	 * user2=User.withUsername("tanakam").password(encoder().encode("tanakam")).
	 * authorities("NORMAL_USER").build();
	 * 
	 * JdbcUserDetailsManager manager=new JdbcUserDetailsManager(ds);
	 * 
	 * 
	 * 
	 * manager.createUser(admin); manager.createUser(user1);
	 * manager.createUser(user2);
	 * 
	 * return manager; }
	 */

	@Bean
	public UserDetailsService userDetailsService(CustomUserDetailsManager manager) {
		return manager;
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider provider(CustomUserDetailsManager manager,BCryptPasswordEncoder encoder)
	{
		DaoAuthenticationProvider p= new DaoAuthenticationProvider();	
		p.setUserDetailsService(manager);
		p.setPasswordEncoder(encoder);
		return p;
	}

}

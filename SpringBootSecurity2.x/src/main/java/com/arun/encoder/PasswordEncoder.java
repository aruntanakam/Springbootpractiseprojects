package com.arun.encoder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncoder {

	/*
	 * public static void main(String args[]) { BCryptPasswordEncoder encoder=new
	 * BCryptPasswordEncoder(); System.out.println("arun:"+encoder.encode("arun"));
	 * System.out.println("kumar:"+encoder.encode("kumar"));
	 * 
	 * }
	 */
	@Bean
	public BCryptPasswordEncoder  getEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
}

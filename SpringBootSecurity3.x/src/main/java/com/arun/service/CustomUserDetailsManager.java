package com.arun.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arun.entity.UserInfo;
import com.arun.repository.UserInfoRepository;

@Service
public class CustomUserDetailsManager implements UserDetailsService {
	
	@Autowired
	private UserInfoRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserInfo> opt=repo.findByUserName(username);
		
		UserInfo info=opt.orElseThrow(()->new IllegalArgumentException("No user found with username:"+username));
		
		List<GrantedAuthority> list=Arrays.stream(info.getRoles().split(",")).map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList());
		
		
		
		
		return new User(info.getUserName(),info.getPassword(),true,true,true,true, list);
	}

}

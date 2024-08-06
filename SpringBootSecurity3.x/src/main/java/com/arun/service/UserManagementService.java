package com.arun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.arun.entity.UserInfo;
import com.arun.repository.UserInfoRepository;

@Service
public class UserManagementService {
	
	@Autowired
	private UserInfoRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public String registerUser(UserInfo info)
	{
		info.setPassword(encoder.encode(info.getPassword()));
		int id=repo.save(info).getId();
		return "user registered with id:"+id;
	}

}

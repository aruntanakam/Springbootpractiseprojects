package com.arun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.entity.UserInfo;
import com.arun.service.UserManagementService;

@RestController
@RequestMapping("/ott")
public class OperationsController {
    
	@Autowired
	private UserManagementService service;
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "Hello welcome to home page";
	}
	
	@GetMapping("/preview")
	public String seePreview()
	{
		return "welcome to preview program";
	}
	
	@GetMapping("/subscribe")
	public String enroll()
	{
		return "welcome to enrollment";
	}
	
	@GetMapping("/view")
	@PreAuthorize("hasAnyAuthority('PREMIUM_MEMBER','ADMIN')")
	public String seeVideo()
	{
		return "welcome to this video subscribed memnber";
	}
	
	@GetMapping("/upload")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String uploadVideo()
	{
		return "welcome admin you can upload video";
	}
	
	@PostMapping("/register")
	public String registerUser(@RequestBody UserInfo info)
	{
		return service.registerUser(info);
	}
	
	
}
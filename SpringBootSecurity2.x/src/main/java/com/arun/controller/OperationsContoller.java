package com.arun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OperationsContoller {
	
	@GetMapping("/")
	public String getHome()
	{
		return "home";
	}
	
	@GetMapping("/offers")
	public String getOffers()
	{
		return "offers";
	}
	
	@GetMapping("/balance")
	public String showbalance()
	{
		return "balance";
	}
	
	
	@GetMapping("/approveLoan")
	public String approveLoan()
	{
		return "approve";
	}
	
	@GetMapping("/accessdenied")
	public String accessdenied()
	{
		return "AccessDenied";
	}


}

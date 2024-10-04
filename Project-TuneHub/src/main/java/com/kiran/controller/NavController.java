package com.kiran.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	
	@GetMapping("/login")
	public String login() {
   	 return "login";
    }
	
	@GetMapping("/registration")
	public String registration() {
	   	 return "registration";
	    }
	
	@GetMapping("/newsong")
	public String newsong() {
		return "newsong";
	}
	
//	@GetMapping("/viewplaylist")
//	public String viewplaylist() {
//		return "viewplaylist";
//	}
//	
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	

}

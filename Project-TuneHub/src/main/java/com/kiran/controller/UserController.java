package com.kiran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kiran.entity.Song;
import com.kiran.entity.User;
import com.kiran.serviceimp.SongServiceImp;
import com.kiran.serviceimp.UserServieImp;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
     UserServieImp service;
	@Autowired
	SongServiceImp songservice;
    
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute User user) {
		//email taken from registration form
		String email=user.getEmail();
		//checking if the entered email id in the registration form present in the DB or not
		boolean status=service.emailExists(email);
		if(status==false) {
		service.addUser(user);
		System.out.println("User Added");
		}
		else {
			System.out.println("User Already Exists");
		}
	     return "login";
	}
	
	
	@PostMapping("/validate")
	public String login(@RequestParam("email") String email,@RequestParam("password") String password,Model model,HttpSession session,Song song) {
		 User user=service.login(email, password);
		 model.addAttribute("user", user);
		  if(user!=null) {
		    String role=service.getRole(email);
		    session.setAttribute("email", email);
			if(role.equals("admin")) {
		
				return "adminhome";
			}
			else {
				User users=service.getUser(email);
				boolean userstatus=users.isPremium();
				model.addAttribute("ispremium",userstatus);
				model.addAttribute("song", songservice.viewSongs(song));
				return "customerhome";
			}
		 }
		 else {
			 model.addAttribute("error", "Invalid Email and Password");
			 return "login";
		 }

	    }
	
	   @GetMapping("/logout")
	   public String logout(HttpSession session) {
		   session.invalidate();
		   return "login";
	   }
	   
	
}

package com.kiran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kiran.entity.Song;
import com.kiran.serviceimp.SongServiceImp;

@Controller
public class SongController {
	@Autowired
	SongServiceImp songservice;

	@PostMapping("/addsong")
	public String addSong(@ModelAttribute Song song) {
		String link=song.getLink();
		boolean status=songservice.linkExists(link);
		if(status==false) {
			songservice.addSong(song);
			System.out.println("Songs Added");
		}
		else {
			System.out.println("song already exists");
		}
		return "adminhome";
	}

	@GetMapping("/viewsongs")
	public String viewSongs(Model model,Song song) {
		model.addAttribute("song", songservice.viewSongs(song));
		return "viewsong";
	}

}


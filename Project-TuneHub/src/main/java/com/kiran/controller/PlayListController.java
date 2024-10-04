package com.kiran.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kiran.entity.Playlist;
import com.kiran.entity.Song;
import com.kiran.serviceimp.PlayListServiceImp;
import com.kiran.serviceimp.SongServiceImp;

@Controller
public class PlayListController {
	@Autowired
	SongServiceImp songservice;
	@Autowired
	PlayListServiceImp playlistservice;
	
	@GetMapping("/createplaylist")
	public String viewSongs(Model model,Song song) {
		  List<Song> songs=songservice.viewSongs(song);
		    model.addAttribute("song",songs );
		   return "createplaylist";
	   }
	
	@PostMapping("/addplaylist")
	public String addPlaylist(@ModelAttribute Playlist playlists) {
		playlistservice.addPlaylist(playlists);
		List<Song> songlist=playlists.getSongs();
		for (Song s : songlist) {
			s.getPlaylists().add(playlists);
			songservice.updateSong(s);
		} 
		return "adminhome";
	}
	
	@GetMapping("/viewplaylist")
	public String displayPlaylist(Model model) {
		  List<Playlist> allplaylist=playlistservice.viewPlaylist();
		    model.addAttribute("allplaylist",allplaylist);
		   return "viewplaylist";
	   }
	
}

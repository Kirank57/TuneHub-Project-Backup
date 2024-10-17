package com.kiran.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.entity.Song;
import com.kiran.repository.SongRepo;
import com.kiran.service.SongService;

@Service
public class SongServiceImp implements SongService{
	 @Autowired
     SongRepo songrepo;
	 
	 public Song addSong(Song song) {
		 return songrepo.save(song);
	 }


	public boolean linkExists(String link) {
		if(songrepo.findByLink(link)!=null) {
			return true;
		}
		else {
			return false;
		}
	}

 
	public List<Song> viewSongs(Song song) {
		return songrepo.findAll();
		
	}


	public void  updateSong(Song s) {
		songrepo.save(s);
		
	}
}

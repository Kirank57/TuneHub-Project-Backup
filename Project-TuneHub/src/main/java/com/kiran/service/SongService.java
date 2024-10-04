package com.kiran.service;

import java.util.List;

import com.kiran.entity.Song;

public interface SongService {
   public Song addSong(Song Song);
   public boolean linkExists(String link);
   public List<Song> viewSongs(Song song);
	public void  updateSong(Song s);
}

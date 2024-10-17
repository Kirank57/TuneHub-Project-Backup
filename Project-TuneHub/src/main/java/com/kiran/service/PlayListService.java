package com.kiran.service;

import java.util.List;

import com.kiran.entity.Playlist;

public interface PlayListService {
   
	public Playlist addPlaylist(Playlist playlists);
	public List<Playlist> viewPlaylist();

}

package com.kiran.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.entity.Playlist;
import com.kiran.repository.PlayListRepo;
import com.kiran.service.PlayListService;

@Service
public class PlayListServiceImp implements PlayListService{
	@Autowired
	PlayListRepo repo;

	@Override
	public Playlist addPlaylist(Playlist playlists) {
        return repo.save(playlists);
	}

	@Override
	public List<Playlist> viewPlaylist() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


}

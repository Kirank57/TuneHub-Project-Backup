package com.kiran.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.entity.Song;

public interface SongRepo extends JpaRepository<Song, Integer> {

	public Song findByLink(String link);

}

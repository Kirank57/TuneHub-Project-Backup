package com.kiran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiran.entity.Playlist;

@Repository
public interface PlayListRepo  extends JpaRepository<Playlist, Integer>{

}

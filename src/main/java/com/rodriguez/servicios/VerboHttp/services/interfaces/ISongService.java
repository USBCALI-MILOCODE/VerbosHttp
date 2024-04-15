package com.rodriguez.servicios.VerboHttp.services.interfaces;

import java.util.List;

import org.springframework.http.HttpHeaders;

import com.rodriguez.servicios.VerboHttp.dto.CreateSongDTO;
import com.rodriguez.servicios.VerboHttp.dto.SongDTO;
import com.rodriguez.servicios.VerboHttp.dto.UpdateSongDTO;
import com.rodriguez.servicios.VerboHttp.exceptions.SongException;

public interface ISongService {

	public SongDTO createSong(CreateSongDTO createSongDTO) throws SongException;
	
	public List<SongDTO> getAllSongs();

	public SongDTO getSongById(String id) throws SongException;
	
	public String deleteSong(String id) throws SongException;

	public SongDTO updateSong(UpdateSongDTO updateSongDTO) throws SongException;
	
	public SongDTO patchSong(String id, UpdateSongDTO updateSongDTO) throws SongException;
	
	public HttpHeaders getSongHeader(String id);

	public HttpHeaders optionsSong();





}

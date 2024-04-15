package com.rodriguez.servicios.VerboHttp.services;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.rodriguez.servicios.VerboHttp.dto.CreateSongDTO;
import com.rodriguez.servicios.VerboHttp.dto.SongDTO;
import com.rodriguez.servicios.VerboHttp.dto.UpdateSongDTO;
import com.rodriguez.servicios.VerboHttp.exceptions.SongException;
import com.rodriguez.servicios.VerboHttp.mappers.SongMapper;
import com.rodriguez.servicios.VerboHttp.model.Song;
import com.rodriguez.servicios.VerboHttp.repositories.SongRepository;
import com.rodriguez.servicios.VerboHttp.services.interfaces.ISongService;
import com.rodriguez.servicios.VerboHttp.utils.SongValidations;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SongService implements ISongService {

	private final SongRepository songRepository;

	@Override
	public List<SongDTO> getAllSongs() {
		return SongMapper.domainToGetSongDto(songRepository.findAll());
	}

	@Override
	public SongDTO getSongById(String id) throws SongException {
		if (!songRepository.existsById(id))
			throw new SongException(SongValidations.SONG_NOT_FOUND);
		return SongMapper.domainToGetSongDto(songRepository.findById(id).get());
	}

	@Override
	public HttpHeaders getSongHeader(String id) {
		HttpHeaders httpHeaders = new HttpHeaders();

		if (songRepository.existsById(id)) {
			Song song = songRepository.findById(id).get();
			httpHeaders.add("Title", song.getTitle());
			httpHeaders.add("Artist", song.getArtist());
		}
		return httpHeaders;
	}

	@Override
	public HttpHeaders optionsSong() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("HTTPS", "GETTERS, POST, UPDATE, PATCH, DELETE, HEAD, OPTIONS");
		httpHeaders.add("Permitidos", "GETTERS, POST, UPDATE, PATCH, DELETE, HEAD, OPTIONS");
		return httpHeaders;
	}

	@Override
	public SongDTO createSong(CreateSongDTO createSongDTO) throws SongException {
		return SongMapper.domainToGetSongDto(songRepository.save(SongMapper.createSongDtoToDomain(createSongDTO)));
	}

	@Override
	public SongDTO updateSong(UpdateSongDTO updateSongDTO) throws SongException {
		if (!songRepository.existsById(updateSongDTO.getId()))
			throw new SongException(SongValidations.SONG_NOT_FOUND);
		return SongMapper.domainToGetSongDto(songRepository.save(SongMapper.updateSongDtoToDomain(updateSongDTO)));
	}

	@Override
	public SongDTO patchSong(String id, UpdateSongDTO updateSongDTO) throws SongException {
		if (!songRepository.existsById(id))
			throw new SongException(SongValidations.SONG_NOT_FOUND);

		Song song = songRepository.findById(id).orElseThrow(() -> new SongException(SongValidations.SONG_NOT_FOUND));

		if (updateSongDTO.getTitle() != null) {
			song.setTitle(updateSongDTO.getTitle());
		}
		if (updateSongDTO.getArtist() != null) {
			song.setArtist(updateSongDTO.getArtist());
		}
		if (updateSongDTO.getAlbum() != null) {
			song.setAlbum(updateSongDTO.getAlbum());
		}
		if (updateSongDTO.getGenre() != null) {
			song.setGenre(updateSongDTO.getGenre());
		}

		songRepository.save(song);
		return SongMapper.domainToGetSongDto(song);
	}

	@Override
	public String deleteSong(String id) throws SongException {
		if (!songRepository.existsById(id))
			throw new SongException(String.format(SongValidations.SONG_NOT_FOUND, id));

		songRepository.delete(songRepository.findById(id).get());

		return String.format(SongValidations.SONG_DELETED, id);
	}

}

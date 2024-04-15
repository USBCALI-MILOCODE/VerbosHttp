package com.rodriguez.servicios.VerboHttp.mappers;

import com.rodriguez.servicios.VerboHttp.dto.CreateSongDTO;
import com.rodriguez.servicios.VerboHttp.dto.SongDTO;
import com.rodriguez.servicios.VerboHttp.dto.UpdateSongDTO;
import com.rodriguez.servicios.VerboHttp.model.Song;

import java.util.List;
import java.util.stream.Collectors;

public class SongMapper {
	public static List<SongDTO> domainToGetSongDto(List<Song> songs) {
		return songs.stream().map(song -> domainToGetSongDto(song)).collect(Collectors.toList());
	}

	public static Song updateSongDtoToDomain(UpdateSongDTO updateSongDTO) {
		return Song.builder().id(updateSongDTO.getId()).title(updateSongDTO.getTitle())
				.artist(updateSongDTO.getArtist()).album(updateSongDTO.getAlbum()).genre(updateSongDTO.getGenre())
				.build();
	}

	public static Song createSongDtoToDomain(CreateSongDTO createSongDTO) {
		return Song.builder().title(createSongDTO.getTitle()).artist(createSongDTO.getArtist())
				.album(createSongDTO.getAlbum()).genre(createSongDTO.getGenre()).build();
	}

	public static SongDTO domainToGetSongDto(Song song) {
		return SongDTO.builder().id(song.getId()).title(song.getTitle()).artist(song.getArtist()).album(song.getAlbum())
				.genre(song.getGenre()).build();
	}
}
package com.rodriguez.servicios.VerboHttp.dto;

import com.rodriguez.servicios.VerboHttp.utils.SongValidations;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@AllArgsConstructor
@Data
@ToString
public class CreateSongDTO {

	@NotBlank(message = SongValidations.SONG_NOT_EMPTY)
	@NotNull(message = SongValidations.SONG_NOT_NULL)
	private String title;

	@NotBlank(message = SongValidations.ARTIST_NOT_EMPTY)
	@NotNull(message = SongValidations.ARTIST_NOT_NULL)
	private String artist;

	@NotBlank(message = SongValidations.ALBUM_NOT_EMPTY)
	@NotNull(message = SongValidations.ALBUM_NOT_NULL)
	private String album;

	@NotBlank(message = SongValidations.GENRE_NOT_EMPTY)
	@NotNull(message = SongValidations.GENRE_NOT_NULL)
	private String genre;

}

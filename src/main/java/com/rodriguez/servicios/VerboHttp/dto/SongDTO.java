package com.rodriguez.servicios.VerboHttp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@AllArgsConstructor
@Data
@ToString
public class SongDTO {
	private String id;
	private String title;
	private String artist;
	private String album;
	private String genre;
}

package com.rodriguez.servicios.VerboHttp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
@Document(collection = "Songs")
public class Song {
	@Id
	private String id;
	private String title;
	private String artist;
	private String album;
	private String genre;

}

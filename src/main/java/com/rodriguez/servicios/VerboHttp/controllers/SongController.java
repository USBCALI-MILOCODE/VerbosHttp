package com.rodriguez.servicios.VerboHttp.controllers;

import com.rodriguez.servicios.VerboHttp.dto.CreateSongDTO;
import com.rodriguez.servicios.VerboHttp.dto.ErrorDTO;
import com.rodriguez.servicios.VerboHttp.dto.MsgDTO;
import com.rodriguez.servicios.VerboHttp.dto.UpdateSongDTO;
import com.rodriguez.servicios.VerboHttp.exceptions.SongException;
import com.rodriguez.servicios.VerboHttp.model.Song;
import com.rodriguez.servicios.VerboHttp.services.SongService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,
		RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PATCH })
@RequiredArgsConstructor
@RestController
@RequestMapping("/songs")
@Slf4j
public class SongController {

	private final SongService songService;

	@GetMapping(path = "/getSongs")
	public ResponseEntity getAllSongs() {
		return new ResponseEntity(songService.getAllSongs(), HttpStatus.OK);
	}

	@GetMapping(path = "/getSong/{id}")
	public ResponseEntity getSongById(@PathVariable String id) {
		try {
			return new ResponseEntity(songService.getSongById(id), HttpStatus.OK);
		} catch (SongException ex) {
			return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(path = "/createSong")
	public ResponseEntity createSong(@RequestBody CreateSongDTO createSongDTO) {
	    try {
	        return new ResponseEntity(songService.createSong(createSongDTO), HttpStatus.CREATED);
	    } catch (SongException ex) {
	        return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
	    }
	}

	@PutMapping(path = "/updateSong")
	public ResponseEntity updateSong(@RequestBody UpdateSongDTO updateSongDTO) {
		try {
			return new ResponseEntity(songService.updateSong(updateSongDTO), HttpStatus.OK);
		} catch (SongException ex) {
			return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(path = "/deleteSong/{id}")
	public ResponseEntity deleteSong(@PathVariable String id) {
		try {
			return new ResponseEntity(MsgDTO.builder().message(songService.deleteSong(id)).build(), HttpStatus.OK);
		} catch (SongException ex) {
			return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
		}
	}

	@PatchMapping(path = "/patchSong/{id}")
	public ResponseEntity patchSong(@PathVariable String id, @RequestBody UpdateSongDTO updateSongDTO) {
		try {
			return new ResponseEntity(songService.patchSong(id, updateSongDTO), HttpStatus.OK);
		} catch (SongException ex) {
			return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(path = "/headerSong/{id}", method = RequestMethod.HEAD)
	public ResponseEntity headerSong(@PathVariable String id) {
		return new ResponseEntity(songService.getSongHeader(id), HttpStatus.OK);
	}

	@RequestMapping(path = "/optionsSong", method = RequestMethod.OPTIONS)
	public ResponseEntity optionsSongs() {
		return new ResponseEntity(songService.optionsSong(), HttpStatus.OK);
	}
}
package com.rodriguez.servicios.VerboHttp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rodriguez.servicios.VerboHttp.model.Song;

@Repository
public interface SongRepository extends MongoRepository<Song, String> {

}

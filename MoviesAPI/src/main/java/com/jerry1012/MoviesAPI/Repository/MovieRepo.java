package com.jerry1012.MoviesAPI.Repository;

import com.jerry1012.MoviesAPI.Model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface MovieRepo  extends MongoRepository<Movie, ObjectId> {
    
}
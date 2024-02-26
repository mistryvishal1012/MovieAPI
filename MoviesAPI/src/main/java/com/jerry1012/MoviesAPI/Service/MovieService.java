package com.jerry1012.MoviesAPI.Service;

import com.jerry1012.MoviesAPI.Model.Movie;
import com.jerry1012.MoviesAPI.Repository.MovieRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie addMovie(Movie movie);

    Movie getMovieById(ObjectId id);

    List<String> getMoviesByCountry();

    List<Movie> getMovieByDirector(String directorName);

    Map<String,List<String>> getMenu();

}

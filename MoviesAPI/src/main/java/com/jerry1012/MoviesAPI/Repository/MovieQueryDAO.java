package com.jerry1012.MoviesAPI.Repository;

import com.jerry1012.MoviesAPI.Model.Movie;

import java.util.List;

public interface MovieQueryDAO {

    List<Movie> getMovieByDirector(String directorName);

    List<String> getAllGenre();

    List<String> getAllDirectors();

    List<String> getAllWriter();

    List<String> getAllActors();

    List<String> getAllLanguage();

    List<String> getAllCountry();

}

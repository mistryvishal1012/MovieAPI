package com.jerry1012.MoviesAPI.Service.Impl;

import com.jerry1012.MoviesAPI.Exception.NotFoundException;
import com.jerry1012.MoviesAPI.Model.Movie;
import com.jerry1012.MoviesAPI.Repository.MovieQueryDAO;
import com.jerry1012.MoviesAPI.Repository.MovieRepo;
import com.jerry1012.MoviesAPI.Service.MovieService;
import com.jerry1012.MoviesAPI.Utils.Util;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private MovieQueryDAO movieQueryDAO;

    @Autowired
    private MongoTemplate mongoTemplate;

    private Util util = new Util();

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepo.insert(movie);
    }

    @Override
    public List<Movie> getAllMovies(){
        return movieRepo.findAll();
    }

    @Override
    public Movie getMovieById(ObjectId id){
        return movieRepo.findById(id).stream().findFirst().orElseThrow(() -> new NotFoundException("Movie Does Not Exists"));
    }

    @Override
    public List<String> getMoviesByCountry() {
        List<String> countries = (List<String>) mongoTemplate.getCollection("movies").distinct("Country", String.class);

        return countries;
    }


    @Override
    public List<Movie> getMovieByDirector(String directorName) {

        return movieQueryDAO.getMovieByDirector(directorName);
    }

    @Override
    public Map<String,List<String>> getMenu() {

        List<String> allGenre = util.getAllUnique(movieQueryDAO.getAllGenre());
        List<String> allActors = util.getAllUnique(movieQueryDAO.getAllActors());
        List<String> allDirectors = util.getAllUnique(movieQueryDAO.getAllDirectors());
        List<String> allLanguage = util.getAllUnique(movieQueryDAO.getAllLanguage());
        List<String> allWriter = util.getAllUnique(movieQueryDAO.getAllWriter());
        List<String> allCountry = util.getAllUnique(movieQueryDAO.getAllCountry());

        Map<String,List<String>> homeMenu = new HashMap<>();

        homeMenu.put("Genres",allGenre);
        homeMenu.put("Actors",allActors);
        homeMenu.put("Directors",allDirectors);
        homeMenu.put("Languages",allLanguage);
        homeMenu.put("Writers",allWriter);
        homeMenu.put("Country",allCountry);

        return homeMenu;
    }


}

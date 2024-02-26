package com.jerry1012.MoviesAPI.Repository.impl;

import com.jerry1012.MoviesAPI.Model.Movie;
import com.jerry1012.MoviesAPI.Repository.MovieQueryDAO;
import com.jerry1012.MoviesAPI.Repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class MovieQueryDAOImpl implements MovieQueryDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Movie> getMovieByDirector(String directorName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("Director").is(directorName));
        return new ArrayList<>(mongoTemplate.find(query, Movie.class));
    }

    @Override
    public List<String> getAllGenre() {
        List<String> allGenres = mongoTemplate.query(Movie.class)
                .distinct("Genre")
                .as(String.class)
                .all();
        return allGenres;
    }

    @Override
    public List<String> getAllDirectors() {
        List<String> allDirectors = mongoTemplate.query(Movie.class)
                .distinct("Director")
                .as(String.class)
                .all();
        return allDirectors;
    }

    @Override
    public List<String> getAllWriter() {
        List<String> allWriter = mongoTemplate.query(Movie.class)
                .distinct("Writer")
                .as(String.class)
                .all();
        return allWriter;
    }

    @Override
    public List<String> getAllActors() {
        List<String> allActors = mongoTemplate.query(Movie.class)
                .distinct("Actors")
                .as(String.class)
                .all();
        return allActors;
    }

    @Override
    public List<String> getAllLanguage() {
        List<String> allLanguage = mongoTemplate.query(Movie.class)
                .distinct("Language")
                .as(String.class)
                .all();
        return allLanguage;
    }

    @Override
    public List<String> getAllCountry() {
        List<String> allCountry = mongoTemplate.query(Movie.class)
                .distinct("Country")
                .as(String.class)
                .all();
        return allCountry;
    }

}

package com.jerry1012.MoviesAPI.Controller;

import com.jerry1012.MoviesAPI.Model.Movie;
import com.jerry1012.MoviesAPI.Service.MovieService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/allmovies")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Movie> getMovieById(@PathVariable ObjectId id){
        return new ResponseEntity<Movie>(movieService.getMovieById(id),HttpStatus.OK);
    }

    @GetMapping("/countries")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<List<String>> getCountries(){
        return new ResponseEntity<List<String>>(movieService.getMoviesByCountry(),HttpStatus.OK);
    }

    @GetMapping("/director/{directorName}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<List<Movie>> getMovieByDirectory(@PathVariable String directorName){
        return new ResponseEntity<List<Movie>>(movieService.getMovieByDirector(directorName),HttpStatus.OK);
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Map> home(){
        return new ResponseEntity<Map>(movieService.getMenu(),HttpStatus.OK);
    }

    @PostMapping("/addmovie")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Movie> addMovie(@Valid @RequestBody Movie movie){
        return new ResponseEntity<Movie>(movieService.addMovie(movie),HttpStatus.OK);
    }


}

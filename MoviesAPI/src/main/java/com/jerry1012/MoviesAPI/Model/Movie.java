package com.jerry1012.MoviesAPI.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.ArrayList;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie{

    @Id
    private ObjectId id;
    @NotBlank(message = "Title Is Mandatory")
    public String Title;

    @NotBlank(message = "Year Is Mandatory")
    public String Year;

    @NotBlank(message = "Rated Is Mandatory")
    public String Rated;

    @NotBlank(message = "Released Is Mandatory")
    public String Released;

    @NotBlank(message = "RunTime Is Mandatory")
    public String Runtime;

    @NotBlank(message = "Genre Is Mandatory")
    public String Genre;

    @NotBlank(message = "Director Is Mandatory")
    public String Director;

    @NotBlank(message = "Writer Is Mandatory")
    public String Writer;

    @NotBlank(message = "Actor Is Mandatory")
    public String Actors;

    @NotBlank(message = "Language Is Mandatory")
    public String Language;

    @NotBlank(message = "Country Is Mandatory")
    public String Country;

    public String Poster;

    public ArrayList<Ratings> Ratings;

    public String Metascore;

    @NotBlank(message = "Type Is Mandatory")
    public String Type;

    public Movie(String title, String year, String rated, String released, String runtime, String genre, String director, String writer, String actors, String plot, String language, String country, String awards, String poster, ArrayList<Ratings> ratings, String metascore, String imdbRating, String imdbVotes, String imdbID, String type, String DVD, String boxOffice, String production, String website, String response) {
        Title = title;
        Year = year;
        Rated = rated;
        Released = released;
        Runtime = runtime;
        Genre = genre;
        Director = director;
        Writer = writer;
        Actors = actors;
        Language = language;
        Country = country;
        Poster = poster;
        Ratings = ratings;
        Metascore = metascore;
        Type = type;
    }
}


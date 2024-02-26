package com.jerry1012.MoviesAPI.Model;

import jakarta.validation.constraints.NotBlank;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

public class VotingRequest {

    @NotBlank(message = "Movie Id Is Mandatory")
    private ObjectId movieId;

    @Value("0")
    private int positiveRating;

    @Value("0")
    private int negativeRating;

    @Value("0")
    private int countOfVote;

    @NotBlank(message = "Expires Time Is Mandatory")
    private String expiresTime;

    public VotingRequest(ObjectId movieId, int positiveRating, int negativeRating, int countOfVote, String expiresTime) {
        this.movieId = movieId;
        this.positiveRating = positiveRating;
        this.negativeRating = negativeRating;
        this.countOfVote = countOfVote;
        this.expiresTime = expiresTime;
    }

    public ObjectId getMovieId() {
        return movieId;
    }

    public void setMovieId(ObjectId movieId) {
        this.movieId = movieId;
    }

    public int getPositiveRating() {
        return positiveRating;
    }

    public void setPositiveRating(int positiveRating) {
        this.positiveRating = positiveRating;
    }

    public int getNegativeRating() {
        return negativeRating;
    }

    public void setNegativeRating(int negativeRating) {
        this.negativeRating = negativeRating;
    }

    public int getCountOfVote() {
        return countOfVote;
    }

    public void setCountOfVote(int countOfVote) {
        this.countOfVote = countOfVote;
    }

    public String getExpiresTime() {
        return expiresTime;
    }

    public void setExpiresTime(String expiresTime) {
        this.expiresTime = expiresTime;
    }
}

package com.jerry1012.MoviesAPI.Model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "voting")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voting {

    @Id
    private ObjectId id;

    @NotBlank(message = "Movie Id Is Mandatory")
    private ObjectId movieId;

    @Value("0")
    private int positiveRating;

    @Value("0")
    private int negativeRating;

    @Value("0")
    private int countOfVote;

    @NotBlank(message = "Expires Time Is Mandatory")
    private LocalDateTime expiresTime;

    public Voting(ObjectId movieId, int positiveRating, int negativeRating, int countOfVote, LocalDateTime expiresTime) {
        this.movieId = movieId;
        this.positiveRating = positiveRating;
        this.negativeRating = negativeRating;
        this.countOfVote = countOfVote;
        this.expiresTime = expiresTime;
    }

    public void setMovieId(ObjectId movieId) {
        this.movieId = movieId;
    }

    public void setPositiveRating(int positiveRating) {
        this.positiveRating = positiveRating;
    }

    public void setNegativeRating(int negativeRating) {
        this.negativeRating = negativeRating;
    }

    public void setCountOfVote(int countOfVote) {
        this.countOfVote = countOfVote;
    }

    public void setExpiresTime(LocalDateTime expiresTime) {
        this.expiresTime = expiresTime;
    }
}

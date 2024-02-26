package com.jerry1012.MoviesAPI.Repository;

import com.jerry1012.MoviesAPI.Model.Movie;
import com.jerry1012.MoviesAPI.Model.Voting;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VotingRepo extends MongoRepository<Voting, ObjectId>  {
}

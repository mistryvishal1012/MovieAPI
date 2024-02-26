package com.jerry1012.MoviesAPI.Service;

import com.jerry1012.MoviesAPI.Model.Voting;
import com.jerry1012.MoviesAPI.Model.VotingRequest;
import com.jerry1012.MoviesAPI.Repository.VotingRepo;
import org.bson.types.ObjectId;

public interface VotingService {

    Voting createVoting(VotingRequest voting);

    Voting updatePositiveVoting(ObjectId votingId);

    Voting updateNegativeVoting(ObjectId votingId);

}

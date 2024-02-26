package com.jerry1012.MoviesAPI.Service.Impl;

import com.jerry1012.MoviesAPI.Model.Voting;
import com.jerry1012.MoviesAPI.Model.VotingRequest;
import com.jerry1012.MoviesAPI.Repository.VotingRepo;
import com.jerry1012.MoviesAPI.Service.VotingService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class VotingServiceImpl implements VotingService {

    @Autowired
    private VotingRepo votingRepo;

    @Override
    public Voting createVoting(VotingRequest voting) {

        Voting votingObject = new Voting();
        votingObject.setNegativeRating(voting.getNegativeRating());
        votingObject.setPositiveRating(voting.getPositiveRating());
        votingObject.setCountOfVote(voting.getCountOfVote());
        votingObject.setExpiresTime(LocalDateTime.parse(voting.getExpiresTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        votingObject.setMovieId(voting.getMovieId());

        return votingRepo.insert(votingObject);
    }

    @Override
    public Voting updatePositiveVoting(ObjectId votingId) {

        Voting voting = (votingRepo.findById(votingId)).get();
        voting.setPositiveRating(voting.getPositiveRating() + 1); ;
        voting.setCountOfVote(voting.getCountOfVote() + 1); ;
        votingRepo.save(voting);

        return  voting;
    }

    @Override
    public Voting updateNegativeVoting(ObjectId votingId) {

        Voting voting = (votingRepo.findById(votingId)).get();
        voting.setNegativeRating(voting.getNegativeRating() + 1); ;
        voting.setCountOfVote(voting.getCountOfVote() + 1); ;
        votingRepo.save(voting);

        return  voting;
    }
}

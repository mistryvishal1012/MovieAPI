package com.jerry1012.MoviesAPI.Controller;

import com.jerry1012.MoviesAPI.Model.Voting;
import com.jerry1012.MoviesAPI.Model.VotingRequest;
import com.jerry1012.MoviesAPI.Service.VotingService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
public class VotingController {

    @Autowired
    private VotingService votingService;

    @PostMapping("/createvote")
    public ResponseEntity<Voting> createVoting(@RequestBody VotingRequest voting){
        Voting returnVoting = votingService.createVoting(voting);
        return  new ResponseEntity<Voting>(returnVoting, HttpStatus.OK);
    }

    @PutMapping("/{id}/positive")
    public ResponseEntity<Voting> voteMoviePositive(@PathVariable ObjectId id){
        Voting returnVoting = votingService.updatePositiveVoting(id);
        return  new ResponseEntity<Voting>(returnVoting, HttpStatus.OK);
    }

    @PutMapping("/{id}/negative")
    public ResponseEntity<Voting> voteMovieNegative(@PathVariable ObjectId id){
        Voting returnVoting = votingService.updateNegativeVoting(id);
        return  new ResponseEntity<Voting>(returnVoting, HttpStatus.OK);
    }

}
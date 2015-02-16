package com.capgemini.StarterKit.service;

import com.capgemini.StarterKit.entities.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.StarterKit.repository.CandidateRepo;

import java.util.List;


@Service
public class CandidateService {

    @Autowired
    private CandidateRepo repo;

    public List<Candidate> findAll() {
        return repo.findAll();
    }
    
    public List<Candidate> findCorrectCandidates(int id) {
        return repo.loadCorrectCandidate(id);
    }

    public void create(Candidate candidate) {
        repo.saveAndFlush(candidate);
    }
}

package com.capgemini.StarterKit.service;

import com.capgemini.StarterKit.entities.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.StarterKit.repository.ResultsRepo;

import java.util.List;


@Service
public class ResultService {

    @Autowired
    private ResultsRepo repo;

    public List<Results> findAll() {
        return repo.findAll();
    }

    public void create(Results results) {
        repo.saveAndFlush(results);
    }
}

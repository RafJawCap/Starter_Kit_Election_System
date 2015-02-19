package com.capgemini.StarterKit.service;

import com.capgemini.StarterKit.entities.Voters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.StarterKit.repository.VotersRepo;

import java.util.List;


@Service
public class VotersService {

    @Autowired
    private VotersRepo repo;

    public List<Voters> findAll() {
        return repo.findAll();
    }

    public boolean checkIfRecordExists (String pesel, String zipCode){
    	
    	return repo.checkIfVoterExists(pesel, zipCode);
    }
    
    public int returnVoterId (String pesel){
    	
    	return repo.returnVotersId(pesel);
    }
    
    public void create(Voters voters) {
        repo.saveAndFlush(voters);
    }
}

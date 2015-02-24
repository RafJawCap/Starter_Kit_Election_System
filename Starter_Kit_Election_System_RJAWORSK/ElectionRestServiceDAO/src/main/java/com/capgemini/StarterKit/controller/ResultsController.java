package com.capgemini.StarterKit.controller;

//import com.capgemini.StarterKit.client.HttpRunner;
import com.capgemini.StarterKit.entities.Candidate;
import com.capgemini.StarterKit.entities.Elections;
import com.capgemini.StarterKit.entities.Results;
import com.capgemini.StarterKit.entities.Voters;
import com.capgemini.StarterKit.service.CandidateService;
import com.capgemini.StarterKit.service.ResultService;
import com.capgemini.StarterKit.service.VotersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//import java.util.IllegalFormatException;
import java.util.List;


@Controller
@RequestMapping(value = "/result")
public class ResultsController {

    @Autowired
    private ResultService resultService;
    
    @Autowired
    private CandidateService candidateService;
    
    @Autowired
    private VotersService votersService;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<Results> findAllUser() {
        return resultService.findAll();
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String createResultPOST (@RequestBody Results result) {
        System.out.println("/create POST");
        System.out.println(result);
        resultService.create(result);
        return result.toString();
    }

    @RequestMapping(value = "/createId/{voters}/{candidate}/{election}", method = RequestMethod.GET)
    public void createNewResult (@PathVariable("voters") int voters, 
    						   	 @PathVariable("candidate") int candidate,
    						   	 @PathVariable("election") int election) {
        System.out.println("/create GET");
        	Results results = new Results();
        	
        	Elections electionsObj = new Elections();
        	Candidate candidateObj = new Candidate();
        	Voters votersObj = new Voters();
        		electionsObj.setId(election);
        		candidateObj.setId(candidate);
        		votersObj.setId(voters);
        		
        	results.setElections(electionsObj);
        	results.setVoters(votersObj);
        	results.setCandidate(candidateObj);
        
        resultService.create(results);
    }
    
    @RequestMapping(value = "/createStr/{pesel}/{candidateSurname}/{candidateFirstname}/{election}", method = RequestMethod.GET)
    @ResponseBody
    public String createNewResult (@PathVariable("pesel") String pesel, 
			   				   	   @PathVariable("candidateSurname") String surname,
			   				   	   @PathVariable("candidateFirstname") String firstname,
			   				   	   @PathVariable("election") int election) {
        System.out.println("/create GET");
        	Results results = new Results();
        	
        	Elections electionsObj = new Elections();
        	Candidate candidateObj = new Candidate();
        	Voters votersObj = new Voters();
        		
        		electionsObj.setId(election);
        		
        		int voterId = votersService.returnVoterId(pesel);
        		int candidateId = candidateService.returnCandidateId(firstname, surname);
        		
        		votersObj.setId(voterId);
        		candidateObj.setId(candidateId);
        		
        	results.setElections(electionsObj);
        	results.setVoters(votersObj);
        	results.setCandidate(candidateObj);
        
        resultService.create(results);
        
        return "OK! Vote Accepted!!!";
    }
    
    @RequestMapping(value = "/throwIllegalArgumentException")
    public void throwIllegalArgumentException() throws Exception {
        throw  new IllegalArgumentException("throwIllegalArgumentException");
    }

    @RequestMapping(value = "/throwClassCastException")
    public void throwException() throws Exception {
        throw new ClassCastException();
    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public String handleIllegalArgumentException(Exception e) {
        return "Handled "+e.getLocalizedMessage();
    }
    
    
}

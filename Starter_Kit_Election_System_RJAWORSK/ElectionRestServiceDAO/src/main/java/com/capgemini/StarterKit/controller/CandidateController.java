package com.capgemini.StarterKit.controller;

//import com.capgemini.StarterKit.client.HttpRunner;
import com.capgemini.StarterKit.entities.Candidate;
import com.capgemini.StarterKit.service.CandidateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//import java.util.IllegalFormatException;
import java.util.List;


@Controller
@RequestMapping(value = "/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<Candidate> findAllUser() {
        return candidateService.findAll();
    }

    @RequestMapping(value = "/findCorrectCandidate/{a}")
    @ResponseBody
    public List<Candidate> findSpecificUser(@PathVariable int a) {
        return candidateService.findCorrectCandidates(a);
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

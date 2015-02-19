package com.capgemini.StarterKit.controller;

//import com.capgemini.StarterKit.client.HttpRunner;
import com.capgemini.StarterKit.entities.Voters;
import com.capgemini.StarterKit.service.VotersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//import java.util.IllegalFormatException;
import java.util.List;


@Controller
@RequestMapping(value = "/voters")
public class VotersController {

    @Autowired
    private VotersService votersService;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<Voters> findAllUser() {
        return votersService.findAll();
    }
    

    @RequestMapping(value = "/create/{pesel}/{zipCode}", method = RequestMethod.POST)
    public void createNewVoter(@PathVariable("pesel") String pesel, 
    						   @PathVariable("zipCode") String zipCode) {
        System.out.println("/create GET");
        votersService.create(new Voters (pesel, zipCode));
    }
    
    @RequestMapping(value = "/check/{pesel}/{zipCode}", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkIfRecordExists(@PathVariable("pesel") String pesel, 
    						   		   @PathVariable("zipCode") String zipCode ) {
    	
     return votersService.checkIfRecordExists(pesel, zipCode);
        
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

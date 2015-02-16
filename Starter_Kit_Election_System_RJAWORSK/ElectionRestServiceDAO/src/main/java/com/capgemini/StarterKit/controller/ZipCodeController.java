package com.capgemini.StarterKit.controller;

//import com.capgemini.StarterKit.client.HttpRunner;
import com.capgemini.StarterKit.entities.ZipCode;
import com.capgemini.StarterKit.service.ZipCodeService;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//import java.util.IllegalFormatException;
import java.util.List;


@Controller
@RequestMapping(value = "/zipCode")
public class ZipCodeController {

    @Autowired
    private ZipCodeService zipCodeService;
    

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<ZipCode> findAllUser() {
        return zipCodeService.findAll();
    }

//    @RequestMapping(value = "/create/{id}/{zipCode}", method = RequestMethod.POST)
//    @ResponseBody
//    public String createUser(@RequestBody ZipCode zipCode) {
//        System.out.println("/create POST");
//        System.out.println(zipCode);
//        
//        // @PathVariable("id") int 1, @PathVariable("zipCode") String "12-345"
//        
//        zipCode.setId(@PathVariable 1);
//        
//        zipCodeService.create(new ZipCode();
//        return zipCode.toString();
//    }

    @RequestMapping(value = "/createP", method = RequestMethod.POST)
    @ResponseBody
    public String createUser(@RequestBody ZipCode user) {
        System.out.println("/create POST");
        System.out.println(user);
        zipCodeService.create(user);
        return user.toString();
    }
    
    @RequestMapping(value = "/createG", method = RequestMethod.GET)
    public void createDummyUser() {
        System.out.println("/create GET");
        zipCodeService.create(new ZipCode(10, "12-345"));
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

package com.capgemini.StarterKit.controller;

//import com.capgemini.StarterKit.client.HttpRunner;
import com.capgemini.StarterKit.entities.ZipCode;
import com.capgemini.StarterKit.service.ZipCodeService;
import com.capgemini.StarterKit.service.GreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//import java.util.IllegalFormatException;
import java.util.List;


@Controller
@RequestMapping(value = "/zipCode")
public class UserController {

    @Autowired
    private ZipCodeService zipCodeService;
    
    @Autowired
    private GreetingService greetingService;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<ZipCode> findAllUser() {
        return zipCodeService.findAll();
    }

    @RequestMapping(value = "/throwIllegalArgumentException")
    public void throwIllegalArgumentException() throws Exception {
        throw  new IllegalArgumentException("throwIllegalArgumentException");
    }

    @RequestMapping(value = "/throwClassCastException")
    public void throwException() throws Exception {
        throw new ClassCastException();
    }

    @RequestMapping(value = "/greet/{name}")
    @ResponseBody
    public String greetUser(@PathVariable String name) {
        return greetingService.sayHelloFor(name);
    }

    @RequestMapping(value = "/find2/{name}")
    public ResponseEntity<String> findUser2(@PathVariable String name) {
        return new ResponseEntity<String>(greetingService.sayHelloFor(name), HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public String handleIllegalArgumentException(Exception e) {
        return "Handled "+e.getLocalizedMessage();
    }
    
    
}

package com.capgemini.StarterKit.controller;

import com.capgemini.StarterKit.service.GreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/Greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;
	
    @RequestMapping(value = "/greet/{name}")
    @ResponseBody
    public String greetUser(@PathVariable String name) {
        return greetingService.sayHelloFor(name);
    }
	
}

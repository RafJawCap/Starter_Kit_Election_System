package com.capgemini.StarterKit.service;

import org.springframework.stereotype.Service;


@Service
public class GreetingService {
    public String sayHelloFor(String name) {
        return "Hello "+name;
    }
    public void init() {
        System.out.println("Init GreetingService");
    }
}

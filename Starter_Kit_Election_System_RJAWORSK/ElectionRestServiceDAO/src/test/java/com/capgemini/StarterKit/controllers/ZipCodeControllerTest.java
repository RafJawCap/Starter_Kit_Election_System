package com.capgemini.StarterKit.controllers;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.StarterKit.service.ZipCodeService;
import com.capgemini.StarterKit.controller.ZipCodeController;
import com.capgemini.StarterKit.entities.ZipCode;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ldrygala on 2015-01-26.
 */
@RunWith(MockitoJUnitRunner.class)
public class ZipCodeControllerTest {

    @Mock
    private ZipCodeService service;

    @InjectMocks
    @Spy
    private ZipCodeController controller;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void shouldCreateZipCodeWithStringAndId() throws Exception {
        
    	ZipCode zipCode = new ZipCode(1,"12-345");
    	//ZipCode zipCode = new ZipCode();
    	
        Mockito.when(service.create(zipCode)).thenReturn(zipCode);
        mockMvc.perform(post("/zipCode/createP").content("{\"id\":1,\"zipCode\":\"12-345\"}").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("12-345"))).andExpect(content().string(containsString("1")));
        Mockito.verify(service).create(zipCode);
        
    }

    @Test
    public void shouldFindAllZipCodes() throws Exception {
        
    	ZipCode zipCode1 = new ZipCode(1,"12-345");
    	ZipCode zipCode2 = new ZipCode(2,"67-890");
    	
    	Mockito.when(service.findAll()).thenReturn(Arrays.asList(zipCode1, zipCode2));
        
    	mockMvc.perform(get("/zipCode/findAll")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("12-345"))).andExpect(content().string(containsString("1")));
    	mockMvc.perform(get("/zipCode/findAll")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("67-890"))).andExpect(content().string(containsString("2")));
    
    }

    
    @Test
    public void shouldNotCreateZipCode() throws Exception {
    	
        mockMvc.perform(post("/zipCode/createP").content("{,\"id\":\"1\",\"zipCode\":\"12-345\"}").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
    
    }


}

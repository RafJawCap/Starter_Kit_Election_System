package com.capgemini.StarterKit.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.capgemini.StarterKit.configuration.AppConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Created by ldrygala on 2015-02-18.
 */
@WebAppConfiguration
@ContextConfiguration(classes = AppConfiguration.class) 
@RunWith(SpringJUnit4ClassRunner.class)

public class GreetingControllerTest {
    
	private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void shouldGreetSpring() throws Exception {
        mockMvc.perform(get("/Greeting/greet/Rafal")).andExpect(content().string("Hello Rafal"));
    }

}

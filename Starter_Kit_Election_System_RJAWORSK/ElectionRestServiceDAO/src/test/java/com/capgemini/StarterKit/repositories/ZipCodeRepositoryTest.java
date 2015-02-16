package com.capgemini.StarterKit.repositories;

//import com.capgemini.StarterKit.configuration.AppConfiguration;
import com.capgemini.StarterKit.entities.ZipCode;




import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.fest.assertions.AssertExtension;
import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.StarterKit.repository.ZipCodeRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class ZipCodeRepositoryTest {

    @Autowired
    private ZipCodeRepo repository;

    @Ignore
    @Test
    @Transactional
    public void shouldContainOnlyOneNewZipCode() {
        
//    	ZipCode zipCode = new ZipCode("12-345");
//    	repository.deleteAll();
//        repository.saveAndFlush(zipCode);
//    	Assertions.assertThat(repository.findAll()).containsExactly(zipCode);
    	
    	
    ZipCode zipCode = new ZipCode("52-320");
      System.out.println(zipCode);
      Assert.assertThat(repository.findAll(), Matchers.emptyIterable());
      repository.saveAndFlush(zipCode);
      Assert.assertThat(repository.findAll(), Matchers.hasItem(zipCode));
    }
}
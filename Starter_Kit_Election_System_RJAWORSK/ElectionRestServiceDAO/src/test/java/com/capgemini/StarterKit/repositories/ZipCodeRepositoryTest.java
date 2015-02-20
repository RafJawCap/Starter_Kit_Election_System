package com.capgemini.StarterKit.repositories;

//import com.capgemini.StarterKit.configuration.AppConfiguration;
import com.capgemini.StarterKit.entities.ZipCode;

//import org.hamcrest.Matchers;
//import org.junit.Assert;
//import org.junit.Ignore;
//import org.fest.assertions.AssertExtension;
import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;

import com.capgemini.StarterKit.repository.ZipCodeRepo;

//@Transactional
@Sql("classpath:/sql/TestPrepareSql.sql")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class ZipCodeRepositoryTest {

    @Autowired
    private ZipCodeRepo repository;


    @Test
    public void shouldContainOnlyOneNewZipCode() {
        
    	ZipCode zipCode = new ZipCode("12-345");
    	repository.deleteAll();
        repository.saveAndFlush(zipCode);
        Assertions.assertThat(repository.findAll()).containsExactly(zipCode);
    	
    }
    
     @Test
     public void shouldContainOnly2Items() {
            
        	ZipCode zipCode1 = new ZipCode("12-345");
        	ZipCode zipCode2 = new ZipCode("67-891");
        	repository.deleteAll();
            repository.saveAndFlush(zipCode1);
            repository.saveAndFlush(zipCode2);
            Assertions.assertThat(repository.findAll()).containsExactly(zipCode1, zipCode2);
     }
     
     @Test
     public void shouldContainOnlyUndeletedItem() {
            
        	ZipCode zipCode1 = new ZipCode("12-345");
        	ZipCode zipCode2 = new ZipCode("67-891");
        	repository.deleteAll();
            repository.saveAndFlush(zipCode1);
            repository.saveAndFlush(zipCode2);
            repository.delete(zipCode2);
            Assertions.assertThat(repository.findAll()).containsExactly(zipCode1);	
    	
     }
     
     @Test
     public void shouldContain2Item() {
            
        	ZipCode zipCode1 = new ZipCode("12-345");
        	ZipCode zipCode2 = new ZipCode("67-891");
        	repository.deleteAll();
            repository.saveAndFlush(zipCode1);
            repository.saveAndFlush(zipCode2);
            Assertions.assertThat(repository.count()).isEqualTo(2);	
     }
      
     
            
     
    	
//    ZipCode zipCode = new ZipCode("52-320");
//      System.out.println(zipCode);
//      Assert.assertThat(repository.findAll(), Matchers.emptyIterable());
//      repository.saveAndFlush(zipCode);
//      Assert.assertThat(repository.findAll(), Matchers.hasItem(zipCode));
}
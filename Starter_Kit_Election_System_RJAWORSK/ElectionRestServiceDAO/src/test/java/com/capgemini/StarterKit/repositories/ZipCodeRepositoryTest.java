//package com.capgemini.StarterKit.repositories;
//
//import com.capgemini.StarterKit.configuration.AppConfiguration;
//import com.capgemini.StarterKit.entities.ZipCode;
//
//import org.hamcrest.Matchers;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.capgemini.StarterKit.repository.ZipCodeRepo;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = AppConfiguration.class)
//public class ZipCodeRepositoryTest {
//
//    @Autowired
//    private ZipCodeRepo repository;
//
//    @Test
//    @Transactional
//    public void shouldTestAllCRUDMethods() {
//        //ZipCode zipCode = new ZipCode(1, "52-320");
//        //Assert.assertThat(repository.findAll(), Matchers.emptyIterable());
//        //repository.save(zipCode);
//        //Assert.assertThat(repository.findAll(), Matchers.hasItem(zipCode));
//    }
//}
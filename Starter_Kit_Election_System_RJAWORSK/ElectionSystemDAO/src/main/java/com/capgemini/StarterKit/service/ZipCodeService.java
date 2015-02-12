package com.capgemini.StarterKit.service;

import com.capgemini.StarterKit.entities.ZipCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.StarterKit.repository.ZipCodeRepo;

import java.util.List;


@Service
public class ZipCodeService {

    @Autowired
    private ZipCodeRepo repo;

    public List<ZipCode> findAll() {
        return repo.findAll();
    }

    public void create(ZipCode zipCode) {
        repo.saveAndFlush(zipCode);
    }
}

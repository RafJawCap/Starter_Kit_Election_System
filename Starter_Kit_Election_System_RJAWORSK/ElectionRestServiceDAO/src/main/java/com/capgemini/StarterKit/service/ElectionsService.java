package com.capgemini.StarterKit.service;

import com.capgemini.StarterKit.entities.Elections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.StarterKit.repository.ElectionsRepo;

import java.util.List;


@Service
public class ElectionsService {

    @Autowired
    private ElectionsRepo repo;

    public List<Elections> findAll() {
        return repo.findAll();
    }

    public void create(Elections elections) {
        repo.saveAndFlush(elections);
    }
}

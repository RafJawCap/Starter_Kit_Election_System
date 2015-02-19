package com.capgemini.StarterKit.repository;

import com.capgemini.StarterKit.entities.Results;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsRepo extends JpaRepository<Results, Long>{

}

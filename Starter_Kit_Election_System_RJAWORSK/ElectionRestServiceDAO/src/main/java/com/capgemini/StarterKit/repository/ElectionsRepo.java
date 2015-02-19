package com.capgemini.StarterKit.repository;

import com.capgemini.StarterKit.entities.Elections;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectionsRepo extends JpaRepository<Elections, Long>{

}

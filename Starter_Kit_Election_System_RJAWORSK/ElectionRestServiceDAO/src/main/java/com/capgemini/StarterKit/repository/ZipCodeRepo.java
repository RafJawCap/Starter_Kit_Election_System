package com.capgemini.StarterKit.repository;

import com.capgemini.StarterKit.entities.ZipCode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipCodeRepo extends JpaRepository<ZipCode, Long>{

}

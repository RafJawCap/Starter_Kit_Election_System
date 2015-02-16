package com.capgemini.StarterKit.repository;

import java.util.List;

import com.capgemini.StarterKit.entities.Candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate, Long>{

	@Query("SELECT c FROM Candidate c where c.zip_codes.id= :zipCodeID")
	public List<Candidate> loadCorrectCandidate (@Param("zipCodeID") int zipCodeID);
	
}
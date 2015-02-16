package com.capgemini.StarterKit.repository;

import com.capgemini.StarterKit.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepo extends JpaRepository<Candidate, Long>{

}

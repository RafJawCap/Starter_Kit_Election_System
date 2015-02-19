package com.capgemini.StarterKit.repository;

import com.capgemini.StarterKit.entities.Voters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VotersRepo extends JpaRepository<Voters, Long>{

	@Query("SELECT CASE WHEN EXISTS (SELECT c FROM Voters c WHERE c.pesel = :peselString and c.zip_codes.zipCodes = :zipCodeString) THEN true ELSE false END FROM Voters c")
	public boolean checkIfVoterExists (@Param("peselString") String peselString,
									   @Param("zipCodeString") String zipCodeString );

	@Query("SELECT c.id FROM Voters c where c.pesel= :peselRq")
	public int returnVotersId (@Param("peselRq") String Pesel);
}

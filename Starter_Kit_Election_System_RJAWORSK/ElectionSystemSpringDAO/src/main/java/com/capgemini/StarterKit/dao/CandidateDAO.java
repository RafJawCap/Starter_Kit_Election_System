package com.capgemini.StarterKit.dao;

import java.util.List;

import com.capgemini.StarterKit.model.Candidate;

public interface CandidateDAO {

	public void save(Candidate p);
	
	public List<Candidate> list();
	
}

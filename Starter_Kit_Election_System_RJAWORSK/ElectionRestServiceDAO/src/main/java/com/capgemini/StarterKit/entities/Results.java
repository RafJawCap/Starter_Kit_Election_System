package com.capgemini.StarterKit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//import javax.persistence.Table;

@Entity
@Table(name="results")
public class Results {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "results_seq_gen")
	@SequenceGenerator(name = "results_seq_gen", sequenceName = "results_id_seq", allocationSize=1)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="elections_id")
	private Elections elections;
	
	@ManyToOne
	@JoinColumn(name="voters_id")
	private Voters voters;
	
	@ManyToOne
	@JoinColumn(name="candidates_id")
	private Candidate candidate;
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
    public Results() { }

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Elections getElections() {
		return elections;
	}

	public void setElections(Elections elections) {
		this.elections = elections;
	}
	
	public Voters getVoters() {
		return voters;
	}

	public void setVoters(Voters voters) {
		this.voters = voters;
	}
	
	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@Override
	public String toString(){
		return "id="+id+", elections="+elections+", voters="+voters+", candidate="+candidate;
	}
}

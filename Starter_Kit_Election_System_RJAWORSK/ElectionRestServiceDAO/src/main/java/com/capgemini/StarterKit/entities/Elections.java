package com.capgemini.StarterKit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="elections")
public class Elections {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "elections_seq_gen")
	@SequenceGenerator(name = "elections_seq_gen", sequenceName = "elections_id_seq", allocationSize=1)
	private int id;
	
	@Column(name="election_date")
	private String date;

	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public Elections() {}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setZipCode(String date) {
		this.date = date;
	}
	
	@Override
	public String toString(){
		return "id="+id+", name="+date;
	}
}

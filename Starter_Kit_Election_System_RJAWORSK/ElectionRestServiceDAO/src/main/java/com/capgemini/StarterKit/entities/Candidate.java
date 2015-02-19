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
@Table(name="candidates")
public class Candidate {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidates_seq_gen")
	@SequenceGenerator(name = "candidates_seq_gen", sequenceName = "candidates_id_seq", allocationSize=1)
	private int id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="surname")
	private String surname;
	
	@ManyToOne
	@JoinColumn(name="zip_codes_id")
	private ZipCode zip_codes;
	

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
    public Candidate() { }

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String name) {
		this.firstname = name;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String name) {
		this.surname = name;
	}
	
	public ZipCode getZipCode() {
		return zip_codes;
	}

	public void setZipCode(ZipCode zipCode) {
		this.zip_codes = zipCode;
	}

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@Override
	public String toString(){
		return "id="+id+", surname="+surname+", firstname="+firstname+", zip_codes_id="+zip_codes.getId();
	}
}

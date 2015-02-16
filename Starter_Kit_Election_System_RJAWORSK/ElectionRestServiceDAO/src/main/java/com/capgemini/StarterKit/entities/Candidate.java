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
import javax.persistence.Table;
//import javax.persistence.Table;

@Entity
@Table(name="candidates")
public class Candidate {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	
	public ZipCode getZipCodesId() {
		return zip_codes;
	}

	public void setZipCodesId(ZipCode zipCode) {
		this.zip_codes = zipCode;
	}

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@Override
	public String toString(){
		return "id="+id+", surname="+surname+", firstname="+firstname+", zip_codes_id="+zip_codes;
	}
}

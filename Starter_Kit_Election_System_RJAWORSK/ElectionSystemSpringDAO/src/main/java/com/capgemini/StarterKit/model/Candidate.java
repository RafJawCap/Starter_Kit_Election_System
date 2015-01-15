package com.capgemini.StarterKit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="candidates")
public class Candidate {

	@Id
	@Column(name="id")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="zip_codes_id")
	private int zip_codes_id;
	
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
	
	public int getZipCodesId() {
		return zip_codes_id;
	}

	public void setZipCodesId(int id) {
		this.zip_codes_id = id;
	}

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@Override
	public String toString(){
		return "id="+id+", surname="+surname+", firstname="+firstname+", zip_codes_id="+zip_codes_id;
	}
}

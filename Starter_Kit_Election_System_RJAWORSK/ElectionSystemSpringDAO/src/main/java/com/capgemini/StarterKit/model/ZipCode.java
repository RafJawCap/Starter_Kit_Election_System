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
@Table(name="zip_codes")
public class ZipCode {

	@Id
	@Column(name="id")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="zip_code")
	private String zipCodes;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getZipCode() {
		return zipCodes;
	}

	public void setZipCode(String name) {
		this.zipCodes = name;
	}
	
	@Override
	public String toString(){
		return "id="+id+", name="+zipCodes+"";
	}
}

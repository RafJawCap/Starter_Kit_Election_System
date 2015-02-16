package com.capgemini.StarterKit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zip_codes")
public class ZipCode {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="zip_code")
	private String zipCodes;

	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
//	public ZipCode() {   }
//	
//	public ZipCode(int id, String zipcode){
//		
//		this.id = id;
//		this.zipCodes = zipcode;
//	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
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

package com.capgemini.StarterKit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="zip_codes")
public class ZipCode {

	@Id
	@Column(name="id")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zip_codes_seq_gen")
	@SequenceGenerator(name = "zip_codes_seq_gen", sequenceName = "zip_codes_id_seq", allocationSize=1)
	private int id;
	
	@Column(name="zip_code")
	private String zipCodes;

	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public ZipCode() {   }
	
	public ZipCode(String zipcode){
		
		this.zipCodes = zipcode;
	}
	
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZipCode zipCode = (ZipCode) o;

        if (zipCodes != null ? !zipCodes.equals(zipCode.zipCodes) : zipCode.zipCodes != null) return false;

        return true;
    }
	
	
	@Override
	public String toString(){
		return "id="+id+", name="+zipCodes;
	}
}

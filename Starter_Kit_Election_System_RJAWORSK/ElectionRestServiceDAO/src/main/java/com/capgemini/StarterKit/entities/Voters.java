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
@Table(name="voters")
public class Voters {
	
	@Id
	@Column(name="id")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voters_seq_gen")
	@SequenceGenerator(name = "voters_seq_gen", sequenceName = "voters_id_seq", allocationSize=1)
	private int id;
	
	@Column(name="pesel")
	private String pesel;
	
	@ManyToOne
	@JoinColumn(name="zip_codes_id")
	private ZipCode zip_codes = new ZipCode();
	

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public Voters( ) { }
	
    public Voters( String pesel, String zipCode) {
    	
    	this.pesel = pesel;
    	this.zip_codes.setZipCode(zipCode);
    	
    }

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String name) {
		this.pesel = name;
	}
	
	public ZipCode getZipCode() {
		return zip_codes;
	}

	public void setZipCodes(ZipCode zipCode) {
		this.zip_codes = zipCode;
	}

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@Override
	public String toString(){
		return "id="+id+", firstname="+pesel+", zip_codes_id="+zip_codes.getId();
	}
}

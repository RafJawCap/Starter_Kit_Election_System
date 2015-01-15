package com.capgemini.StarterKit.dao;

import java.util.List;

import com.capgemini.StarterKit.model.ZipCode;

public interface ZipCodeDAO {

	public void save(ZipCode p);
	
	public List<ZipCode> list();
	
}

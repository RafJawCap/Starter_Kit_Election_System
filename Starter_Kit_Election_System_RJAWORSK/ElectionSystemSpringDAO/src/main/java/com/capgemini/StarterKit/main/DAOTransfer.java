package com.capgemini.StarterKit.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.StarterKit.dao.*;
import com.capgemini.StarterKit.model.*;


public class DAOTransfer {

//==============================================================================
//======================== FIELDS ==============================================
	
	//++++++++++++++++++++++++ Zip Code ++++++++++++++++++++
	public List<ZipCode> listZipCode;
	private ZipCodeDAO zipCodeDAO;

	//++++++++++++++++++++++++ Candidate +++++++++++++++++++	
	public List<Candidate> listCandidate;
	public List<Candidate> newlistCandidate;
	private CandidateDAO candidateDAO;
	
	//++++++++++++++++++++++++ XML context +++++++++++++++++
	private ClassPathXmlApplicationContext context;
	
//==============================================================================
//==============================================================================
	
//++++++++++++++++++++ Transfer Methods ++++++++++++++++++++++++++++++++++++++++
	
	public DAOTransfer(){
		
		zipCodeDownload();
		candidatesDownload();
		
	}
	
	
	public void zipCodeDownload() {
		
		context = new ClassPathXmlApplicationContext("spring4.xml");
		zipCodeDAO = context.getBean(ZipCodeDAO.class);
//		ZipCode zipCode = new ZipCode();
//		zipCode.setId(14);
//		zipCode.setZipCode("22-752");
		
		listZipCode = zipCodeDAO.list();
		
		for(ZipCode p : listZipCode)
			{
				System.out.println("ZipCodes List::"+p);
			}
		
		context.close();
		
	}
	
public void candidatesDownload() {
		
		context = new ClassPathXmlApplicationContext("spring4.xml");
		candidateDAO = context.getBean(CandidateDAO.class);
		
		listCandidate = candidateDAO.list();
		
		for(Candidate p : listCandidate)
			{
				System.out.println("Candidate List::"+p);
			}
		
		context.close();
		
	}

//++++++++++++++++++++ Select Methods ++++++++++++++++++++++++++++++++++++++++

// Doesn't work yet
public List<Candidate> selectCandidateByZipCodeId(int zip_code)	{
	
		for (Candidate p : listCandidate)
		{
			if(p.getZipCodesId() == zip_code){
				newlistCandidate.add(p);
				System.out.println("Candidate List::"+p);
		}
		}	
		return newlistCandidate;
	}
	
//	public static void main(String[] args) {
//
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
//		
//		ZipCodeDAO zipCodeDAO = context.getBean(ZipCodeDAO.class);
//		
//		ZipCode zipCode = new ZipCode();
//		zipCode.setId(14);
//		zipCode.setZipCode("22-752");
//		
//		zipCodeDAO.save(zipCode);
//		
//		System.out.println("ZipCodes::"+zipCode);
//		
//		List<ZipCode> list = zipCodeDAO.list();
//		
//		for(ZipCode p : list){
//			System.out.println("ZipCodes List::"+p);
//		}
//		
//		context.close();
//		
//	}

}

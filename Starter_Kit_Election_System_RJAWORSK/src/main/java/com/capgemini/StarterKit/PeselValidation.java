package com.capgemini.StarterKit;



public class PeselValidation {

	public String pesel;

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+++ Setting Pesel number	
	
	public void setPeselNumber(String nPesel) {
		
		pesel = nPesel;
	}
	
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+++ Testing methods
	public int checkNumberOfCharacters() {
		
		return pesel.length();

	}

	public boolean checkIfOnlyDigits() {
		
		if (pesel.matches("[0-9]+"))
			return true;
		else
			return false;
	}

	public String checkSex() {
		
		char[] chArrPesel = pesel.toCharArray();
		
		int sexIdentyficationNumber = Character.getNumericValue(chArrPesel[9]);
		
		if (sexIdentyficationNumber % 2 == 0)
			return "Kobieta";
			
		else if (sexIdentyficationNumber % 2 == 1)
			return "Mężczyzna";
		else
			return "Error";

	}


	
	

}

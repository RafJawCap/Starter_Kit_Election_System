package com.capgemini.StarterKit;

import java.text.ParseException;
import java.text.SimpleDateFormat;

//import java.util.Calendar;
import java.util.Date;
//import java.util.GregorianCalendar;

import org.joda.time.DateTime;

import com.capgemini.StarterKit.Sex.SexOfVoter;


public class PeselValidation {

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// Fields
	
	public String pesel;

	private boolean flagNumberOfCharacters;
	private boolean flagIfOnlyDigits;
	private boolean flagCheckPeselSecureDigit;
	private boolean flagRightToParticipateInElection;
	private boolean flagCorrectBirthDate;
	
	private Date birthDate;
	private SexOfVoter sex;
	private int age;
	
	public PeselValidation()
	{

	}
	
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+++ Setting Pesel number	
	
	public void setPeselNumber(String nPesel) {
		
		pesel = nPesel;
	}
	
	public boolean peselCorrectionTest() // throws ParseException 
	{
		
		checkNumberOfCharacters();
		checkIfOnlyDigits();
		checkPeselSecureDigit();
		checkRightToParticipateInElection();
		
		birthDate = checkBirthDate();
		sex = checkSex();
		
		if 	( 		flagNumberOfCharacters 
				&&	flagIfOnlyDigits
				&&	flagCheckPeselSecureDigit
				&&	flagRightToParticipateInElection 
				&&	flagCorrectBirthDate 				)
			
			return true;
		
		else
			return false;
		
	}
	
	public Date getBirthDate(){ return birthDate; }
	public SexOfVoter getSex(){ return sex; }
	public int getAge(){ return age; }
	public String getPesel(){ return pesel; }
	
	
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+++ Testing methods
	
	public int checkNumberOfCharacters() {
		
		if (pesel.length() == 11)
			flagNumberOfCharacters = true;
		else
			flagNumberOfCharacters = false;
		
		return pesel.length();

	}

	public boolean checkIfOnlyDigits() {
		
		if (pesel.matches("[0-9]+")){
			flagIfOnlyDigits = true;
				return true;
		}
		else
			flagIfOnlyDigits = false;
				return false;
	}

	public SexOfVoter checkSex() {
		
		char[] chArrPesel = pesel.toCharArray();
		
		int sexIdentyficationNumber = Character.getNumericValue(chArrPesel[9]);
		
		if (sexIdentyficationNumber % 2 == 0)
			return sex = Sex.SexOfVoter.FEMALE;
		
		else
			return sex = Sex.SexOfVoter.MALE;	
		
//		else if (sexIdentyficationNumber % 2 == 1)
//			return Sex.SexOfVoter.MALE;
//		else
//			return Sex.SexOfVoter.NONE;
	}

	public int checkPeselSecureDigit() {
		
		char[] chArrPesel = pesel.toCharArray();
		
		// List of first 10 pesel digits
		
		int a = Character.getNumericValue(chArrPesel[0]);
		int b = Character.getNumericValue(chArrPesel[1]);
		int c = Character.getNumericValue(chArrPesel[2]);
		int d = Character.getNumericValue(chArrPesel[3]);
		int e = Character.getNumericValue(chArrPesel[4]);
		int f = Character.getNumericValue(chArrPesel[5]);
		int g = Character.getNumericValue(chArrPesel[6]);
		int h = Character.getNumericValue(chArrPesel[7]);
		int i = Character.getNumericValue(chArrPesel[8]);
		int j = Character.getNumericValue(chArrPesel[9]);
		int k = Character.getNumericValue(chArrPesel[10]);
		
		int secureSum = 1*a + 3*b + 7*c + 9*d + 1*e + 3*f + 7*g + 9*h + 1*i + 3*j;
		
		int mod10secureSum = secureSum % 10;
		
		if (mod10secureSum == 0)
		{
				if (mod10secureSum == k)
					flagCheckPeselSecureDigit = true;
				else
					flagCheckPeselSecureDigit = false;
			return mod10secureSum;
		}	
		else
		{
			if (10 - mod10secureSum == k)
				flagCheckPeselSecureDigit = true;
			else
				flagCheckPeselSecureDigit = false;
			
			return 10 - mod10secureSum;
		}
	}

	public Date checkBirthDate() {
		
		String yearOfBirth = pesel.substring(0, 2);
		String monthOfBirth = pesel.substring(2, 4);
		String dayOfBirth = pesel.substring(4, 6);
			
		//int nYearOfBirth = Integer.valueOf(yearOfBirth);
		int nMonthOfBirth = Integer.valueOf(monthOfBirth);
		int nDayOfBirth = Integer.valueOf(dayOfBirth);
		
		String dateOfBirth;
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
		Date date = new Date();
		
			if( nDayOfBirth >= 1 && nDayOfBirth <= 31 )
			{
				
		//For Range 1900 - 1999 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if (nMonthOfBirth >= 1 && nMonthOfBirth <= 12 )
					
				{
					
					String finalYearOfBirth = "19" + yearOfBirth;
					
					dateOfBirth = dayOfBirth + "." + monthOfBirth + "." + finalYearOfBirth;
					
					try {
						date = dateFormatter.parse(dateOfBirth);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
					birthDate = date;
					flagCorrectBirthDate = true;
					
					return date;
				}

		//For Range 1800 - 1899 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if (nMonthOfBirth >= 81 && nMonthOfBirth <= 92)
					
				{
					String finalYearOfBirth = "18" + yearOfBirth;
					String finalMonthOfBirth = String.valueOf(nMonthOfBirth - 80);
					
					dateOfBirth = dayOfBirth + "." + finalMonthOfBirth + "." + finalYearOfBirth;
					
					try {
						date = dateFormatter.parse(dateOfBirth);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
					birthDate = date;
					flagCorrectBirthDate = true;
					
					return date;
				}
				
		//For Range 2000 - 2099 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if (nMonthOfBirth >= 21 && nMonthOfBirth <= 32)
					
				{
					String finalYearOfBirth = "20" + yearOfBirth;
					String finalMonthOfBirth = String.valueOf(nMonthOfBirth - 20);
					
					dateOfBirth = dayOfBirth + "." + finalMonthOfBirth + "." + finalYearOfBirth;
					
					try {
						date = dateFormatter.parse(dateOfBirth);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					birthDate = date;
					flagCorrectBirthDate = true;
					
					return date;
				}
				
		//For Range 2100 - 2199 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if (nMonthOfBirth >= 41 && nMonthOfBirth <= 52)
					
				{
					String finalYearOfBirth = "21" + yearOfBirth;
					String finalMonthOfBirth = String.valueOf(nMonthOfBirth - 40);
					
					dateOfBirth = dayOfBirth + "." + finalMonthOfBirth + "." + finalYearOfBirth;
					
					try {
						date = dateFormatter.parse(dateOfBirth);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
					birthDate = date;
					flagCorrectBirthDate = true;
					
					return date;
				}
				
		//For Range 2200 - 2299 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if (nMonthOfBirth >= 61 && nMonthOfBirth <= 72)
					
				{
					String finalYearOfBirth = "22" + yearOfBirth;
					String finalMonthOfBirth = String.valueOf(nMonthOfBirth - 60);
					
					dateOfBirth = dayOfBirth + "." + finalMonthOfBirth + "." + finalYearOfBirth;
					
					try {
						date = dateFormatter.parse(dateOfBirth);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					birthDate = date;
					flagCorrectBirthDate = true;
					
					return date;
				}
				
				else
					System.err.println("Błąd w dacie Urodzenia [Miesiąc]");
					flagCorrectBirthDate = false;
			}
			else
				System.err.println("Błąd w dacie Urodzenia [Dzień]");
			flagCorrectBirthDate = false;
		
		 return new Date();
	}

	public boolean checkRightToParticipateInElection() {
		
		Date date = this.checkBirthDate();
		DateTime dateJoda = new DateTime(date);
		
		int diff = new DateTime().getYear() - dateJoda.getYear();
		
		age = diff;
		
			if (diff >= 18){
				flagRightToParticipateInElection = true;
					return true;
			}
			else {
				flagRightToParticipateInElection = false;
					return false;
			}

// +++++++++++++++++++ Date class method
//
//			Date date = this.checkBirthDate();
//			
//			GregorianCalendar BirthDate = new GregorianCalendar();
//			BirthDate.setTime(date);
//				
//			int diff = new GregorianCalendar().get(Calendar.YEAR) - BirthDate.get(Calendar.YEAR); 
			
	}

//	public boolean checkIfBirthDateIsValidInCalendar() {
//		
//		Date date = this.checkBirthDate();
//		
//		 try {
//	            GregorianCalendar gc = new GregorianCalendar();
//	            gc.setLenient(false);        // must do this
//	            gc.setTime(date);
//
//	            gc.getTime(); // exception thrown here
//	            
//
//	        }
//	        catch (Exception e) {
//	            e.printStackTrace();
//	            return false;
//	        }
//		 
//		 return true;
//	    }
		
		
	}


	

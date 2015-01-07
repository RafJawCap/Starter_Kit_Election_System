package com.capgemini.StarterKit.Test;

//import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.fest.assertions.Assertions;
import org.junit.Test;

import com.capgemini.StarterKit.PeselValidation;

public class PeselCompleteTest {

	public String myPesel = "90073010671";
	public String momPesel = "64091611884";
	public String dadPesel = "64071604295";
	
	
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@Test
	public void PeselNumberHaveElevenCharacters() throws Exception {
		
		// given
		PeselValidation peselValidation = new PeselValidation();
		
		// when
		peselValidation.setPeselNumber(myPesel);
		
		// then
		Assertions.assertThat(peselValidation.checkNumberOfCharacters()).isEqualTo(11);
		
	}
			

	@Test
	public void PeselNumberHaveOnlyDigitCharacters() throws Exception {
		
		// given
		PeselValidation peselValidation = new PeselValidation();
		
		// when
		peselValidation.setPeselNumber(myPesel);
		
		// then
		Assertions.assertThat(peselValidation.checkIfOnlyDigits()).isEqualTo(true);
		
	}
	
	@Test
	public void PeselNumberBelongsToMan() throws Exception {
		
		// given
		PeselValidation peselValidation = new PeselValidation();
		
		// when
		//peselValidation.setPeselNumber(myPesel);
		peselValidation.setPeselNumber(dadPesel);
		
		// then
		Assertions.assertThat(peselValidation.checkSex()).isEqualTo("Mężczyzna");
		
	}
		
	@Test
	public void PeselNumberBelongsToWoman() throws Exception {
		
		// given
		PeselValidation peselValidation = new PeselValidation();
		
		// when
		peselValidation.setPeselNumber(momPesel);
				
		// then
		Assertions.assertThat(peselValidation.checkSex()).isEqualTo("Kobieta");
		
	}

	@Test
	public void PeselSecureDigitCheck() throws Exception {
		
		// given
		PeselValidation peselValidation = new PeselValidation();
		
		// when
			peselValidation.setPeselNumber(myPesel);
		//	peselValidation.setPeselNumber(dadPesel);
		//	peselValidation.setPeselNumber(momPesel);
		
		char[] tempChar = peselValidation.pesel.toCharArray();
		int lastDigit = Character.getNumericValue(tempChar[10]);
		
		// then
		Assertions.assertThat(peselValidation.checkPeselSecureDigit()).isEqualTo(lastDigit);
		
	}
	
	@Test
	public void PeselShoudReturnCorrectDateOfBirthForRange_1900_1999() throws Exception {
		
		// given
		PeselValidation peselValidation = new PeselValidation();
		
		// when
		//		peselValidation.setPeselNumber(myPesel);
				peselValidation.setPeselNumber(dadPesel);
		//		peselValidation.setPeselNumber(momPesel);
		
		//	Date date = new SimpleDateFormat("dd.MM.yy").parse("30.07.1990");
			Date date = new SimpleDateFormat("dd.MM.yy").parse("16.07.1964");
		//	Date date = new SimpleDateFormat("dd.MM.yy").parse("16.09.1964");
		
		// then
		Assertions.assertThat(peselValidation.checkBirthDate()).isEqualTo(date);
		
	}
	
	@Test
	public void PeselShoudReturnCorrectDateOfBirthForRange_1800_1899() throws Exception {
		
		// given
		PeselValidation peselValidation = new PeselValidation();
		
		// when
		//		peselValidation.setPeselNumber("35912543480");
				peselValidation.setPeselNumber("01810353391");
		//		peselValidation.setPeselNumber("99833126861");
		
		//	Date date = new SimpleDateFormat("dd.MM.yy").parse("25.11.1835");
			Date date = new SimpleDateFormat("dd.MM.yy").parse("03.01.1801");
		//	Date date = new SimpleDateFormat("dd.MM.yy").parse("31.03.1899");
		
		// then
		Assertions.assertThat(peselValidation.checkBirthDate()).isEqualTo(date);
		
	}

	@Test
	public void PeselShoudReturnCorrectDateOfBirthForRange_2000_2099() throws Exception {
		
		// given
		PeselValidation peselValidation = new PeselValidation();
		
		// when
				peselValidation.setPeselNumber("12262007758");
		//		peselValidation.setPeselNumber("54323177969");
		//		peselValidation.setPeselNumber("76311201191");
		
			Date date = new SimpleDateFormat("dd.MM.yy").parse("20.06.2012");
		//	Date date = new SimpleDateFormat("dd.MM.yy").parse("31.12.2054");
		//	Date date = new SimpleDateFormat("dd.MM.yy").parse("12.11.2076");
		
		// then
		Assertions.assertThat(peselValidation.checkBirthDate()).isEqualTo(date);
		
	}

	@Test
	public void PeselShoudReturnCorrectDateOfBirthForRange_2100_2199() throws Exception {
		
		// given
		PeselValidation peselValidation = new PeselValidation();
		
		// when
		//		peselValidation.setPeselNumber("85490126519");
				peselValidation.setPeselNumber("01451563641");
		//		peselValidation.setPeselNumber("42473074926");
		
		//	Date date = new SimpleDateFormat("dd.MM.yy").parse("01.09.2185");
			Date date = new SimpleDateFormat("dd.MM.yy").parse("15.05.2101");
		//	Date date = new SimpleDateFormat("dd.MM.yy").parse("30.07.2142");
		
		// then
		Assertions.assertThat(peselValidation.checkBirthDate()).isEqualTo(date);
		
	}

	@Test
	public void PeselShoudReturnCorrectDateOfBirthForRange_2200_2299() throws Exception {
		
		// given
		PeselValidation peselValidation = new PeselValidation();
		
		// when
		//		peselValidation.setPeselNumber("00662324645");
				peselValidation.setPeselNumber("33630315312");
		//		peselValidation.setPeselNumber("68622986780");
		
		//	Date date = new SimpleDateFormat("dd.MM.yy").parse("23.06.2200");
			Date date = new SimpleDateFormat("dd.MM.yy").parse("03.03.2233");
		//	Date date = new SimpleDateFormat("dd.MM.yy").parse("29.02.2268");
		
		// then
		Assertions.assertThat(peselValidation.checkBirthDate()).isEqualTo(date);
		
	}
	
	@Test
	public void PeselShoudCheckRightToParticipateInElectionForAdultPerson() throws Exception {
		
		// given
		PeselValidation peselValidation = new PeselValidation();
		
		// when
		
		peselValidation.setPeselNumber(myPesel);

		// then
		Assertions.assertThat(peselValidation.checkRightToParticipateInElection()).isEqualTo(true);
		
	}

	@Test
	public void PeselShoudCheckRightToParticipateInElectionForImmaturePerson() throws Exception {
		
		// given
		PeselValidation peselValidation = new PeselValidation();
		
		// when
		
		peselValidation.setPeselNumber("12262007758");
		
		// then
		Assertions.assertThat(peselValidation.checkRightToParticipateInElection()).isEqualTo(false);
		
	}
}
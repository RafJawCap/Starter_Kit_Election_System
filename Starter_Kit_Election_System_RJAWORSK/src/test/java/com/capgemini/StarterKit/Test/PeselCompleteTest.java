package com.capgemini.StarterKit.Test;

//import static org.junit.Assert.*;

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

	
	
}

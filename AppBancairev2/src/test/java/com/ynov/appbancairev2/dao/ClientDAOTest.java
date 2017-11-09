package com.ynov.appbancairev2.dao;

import org.junit.Assert;
import org.junit.Test;

import com.ynov.appbancairev2.validation.PasswordValidation;

public class ClientDAOTest {

	@Test
	public void testUpdatePasswordLength() {
		Assert.assertEquals(false, PasswordValidation.validPassword("admin"));
		Assert.assertEquals(true, PasswordValidation.validPassword("djeijdiejdi12"));
		Assert.assertEquals(false, PasswordValidation.validPassword("de"));
	}
	
	@Test
	public void testUpdatePasswordDigit() {
		Assert.assertEquals(false, PasswordValidation.validPassword("czbebciz"));
		Assert.assertEquals(false, PasswordValidation.validPassword("ded5dezdd"));
		Assert.assertEquals(true, PasswordValidation.validPassword("61684841648g"));
		Assert.assertEquals(true, PasswordValidation.validPassword("dzdzda54"));
	}
	


}

package com.tests;

import com.base.BaseTest;
import com.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyUserRegistration extends BaseTest {
	@Test
	public void verifyUser_Registration() {
		RegisterPage registerPage = new RegisterPage(page);
		registerPage.navigateToRegisterPage();
		registerPage.registerNewUser();
		String message = registerPage.getSuccessMessage();
		Assert.assertTrue(message.contains("registered"), "An error occurred during registration. Please try again.");

	}
}

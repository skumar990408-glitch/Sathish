package com.pages;

import com.locators.RegisterPageLocators;
import com.microsoft.playwright.Page;

public class RegisterPage {

	private Page page;

	public RegisterPage(Page page) {
		this.page = page;
	}

	public void navigateToRegisterPage() {
		page.click(RegisterPageLocators.TEST_REG_BUTTON);
		page.waitForTimeout(1000);
	}

	public void registerNewUser() {

		page.fill(RegisterPageLocators.NAME_INPUT, "Sathish");
		page.fill(RegisterPageLocators.PASSWORD_INPUT, "Sathish143@");
		page.fill(RegisterPageLocators.CONFIRM_PASSWORD_INPUT, "Sathish143@");
		page.click(RegisterPageLocators.REGISTER_BUTTON);

	}

	public String getSuccessMessage() {
		return page.textContent(RegisterPageLocators.SUCCESS_MESSAGE);
	}
}
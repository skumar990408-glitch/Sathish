package com.locators;

public class RegisterPageLocators {
	
	public static final String NAME_INPUT = "//input[@id='username']";
    public static final String CONFIRM_PASSWORD_INPUT = "//input[@id='confirmPassword']";
    public static final String PASSWORD_INPUT = "//input[@id='password']";
    public static final String REGISTER_BUTTON = "//button[normalize-space()='Register']"; 
    public static final String SUCCESS_MESSAGE = "//b[contains(text(),'An error occurred during registration. Please try ')]";
    public static final String TEST_REG_BUTTON= "//a[normalize-space()='Test Register Page']";

}

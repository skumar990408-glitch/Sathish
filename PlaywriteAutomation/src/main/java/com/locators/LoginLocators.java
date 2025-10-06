package com.locators;





public class LoginLocators {
    public static final String LOGIN_PAGE_LINK = "//a[normalize-space()='Test Login Page']";
    public static final String USERNAME_FIELD = "//input[@id='username']";
    public static final String PASSWORD_FIELD = "//input[@id='password']";
    public static final String LOGIN_BUTTON = "//button[normalize-space()='Login']";
    public static final String SUCCESS_MSG = "//b[normalize-space()='You logged into a secure area!']";
    public static final String ERROR_MSG = "//b[normalize-space()='Your password is invalid!']";
    public static final String AD_CLOSE = "//div[@id='dismiss-button']//div//*[name()='svg']";
}



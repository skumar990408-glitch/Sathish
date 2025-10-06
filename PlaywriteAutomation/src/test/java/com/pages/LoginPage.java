package com.pages;

import com.microsoft.playwright.Page;
import com.locators.LoginLocators ;

public class LoginPage {

	private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void navigateToLogin() {
        page.click(LoginLocators .LOGIN_PAGE_LINK);
        page.waitForTimeout(1000);
    }

    public void closeAdIfPresent() {
        page.waitForTimeout(2000);
        try {
            if (page.locator(LoginLocators .AD_CLOSE).isVisible()) {
                page.locator(LoginLocators .AD_CLOSE).click();
                System.out.println("Ad closed.");
            } else {
                System.out.println("No ad appeared.");
            }
        } catch (Exception e) {
            System.out.println("No ad found or already closed.");
        }
    }

    public void login(String username, String password) {
        page.fill(LoginLocators .USERNAME_FIELD, username);
        page.fill(LoginLocators .PASSWORD_FIELD, password);
        page.click(LoginLocators .LOGIN_BUTTON);
        page.waitForTimeout(1000);
    }

    public String getSuccessMessage() {
        return page.textContent(LoginLocators .SUCCESS_MSG);
    }

    public String getErrorMessage() {
        return page.textContent(LoginLocators .ERROR_MSG);
    }
}


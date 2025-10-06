package com.tests;


import com.base.BaseTest;
import com.pages.LoginPage;
import com.ReportUtils.ReportManager;
import com.aventstack.extentreports.*;
import org.testng.annotations.*;

	
	
	
	public class LoginTest extends BaseTest {

	    private LoginPage loginPage;
	    private static ExtentReports extent;
	    private static ExtentTest test;

	    @BeforeClass
	    public void init() {
	        extent = ReportManager.createInstance("Playwright_Login_Report");
	        test = extent.createTest("Login Test Cases");
	        setup();
	        loginPage = new LoginPage(page);
	    }

	    @Test(priority = 1)
	    public void testValidLogin() {
	        test.info("Starting valid login test");
	        loginPage.navigateToLogin();
	        loginPage.closeAdIfPresent();
	        loginPage.login("practice", "SuperSecretPassword!");
	        String success = loginPage.getSuccessMessage();
	        assert success.contains("logged into a secure area!") : "Login failed!";
	        test.pass("Valid login passed successfully.");
	    }

	    @Test(priority = 2)
	    public void testInvalidLogin() {
	        test.info("Starting invalid login test");
	        loginPage.navigateToLogin();
	        loginPage.closeAdIfPresent();
	        loginPage.login("wrongUser", "wrongPass");
	        String error = loginPage.getErrorMessage();
	        assert error.contains("invalid") : "Error message not displayed!";
	        test.pass("Invalid login test passed successfully.");
	    }

	    @AfterClass
	    public void cleanUp() {
	        tearDown();
	        extent.flush();
	        System.out.println("Report generated successfully.");
	    }
	}



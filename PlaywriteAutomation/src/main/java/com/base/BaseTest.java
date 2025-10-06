package com.base;


import com.Factory.PlayWrightFactory;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
public class BaseTest {

	protected PlayWrightFactory pf;
    protected Page page;

    @BeforeClass
    public void setup() {
        pf = new PlayWrightFactory();
        page = pf.initBrowser("https://practice.expandtesting.com/", false);
        System.out.println("Browser launched successfully.");
    }

    @AfterClass
    public void tearDown() {
        pf.closeBrowser();
        System.out.println("Browser closed successfully.");
    }
	
	
}

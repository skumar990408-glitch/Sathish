package com.Factory;

import com.microsoft.playwright.*;
import com.utils.PlaywrightSetup;
public class PlayWrightFactory {
	
	private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    public Page initBrowser(String url, boolean headless) {
    	
    	// 🔧 Ensure Playwright setup and browsers installed
        PlaywrightSetup.ensurePlaywrightSetup();

        System.out.println("Launching Playwright browser...");
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setChannel("chrome")
                        .setHeadless(headless));

        context = browser.newContext();
        page = context.newPage();
        page.setViewportSize(1920, 1080);
        page.navigate(url);
        return page;
    }

    public void closeBrowser() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}


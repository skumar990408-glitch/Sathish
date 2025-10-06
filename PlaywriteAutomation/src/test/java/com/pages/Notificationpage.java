package com.pages;

import com.locators.NotificationPage;
import com.microsoft.playwright.Page;
 public class Notificationpage {

	  private Page page;

	    public Notificationpage(Page page) {
	        this.page = page;
	    }

	    public void navigate() {
	        page.click(NotificationPage.NOTIFICATION_BUTTON);
	    }

	    public String triggerNotification() {
	        page.click(NotificationPage.CLICK_BUTTON);
	        return page.textContent(NotificationPage.MESSAGE).trim();
	    }
}

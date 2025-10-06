package com.tests;

import com.base.BaseTest;
import com.pages.Notificationpage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationTest extends BaseTest {
	
	 @Test
	    public void verifyNotificationMessages() {
	        Notificationpage notifPage = new Notificationpage(page);
	        notifPage.navigate();
	        String message = notifPage.triggerNotification();
	        Assert.assertTrue(message.contains("Action successful") || message.contains("Action unsuccessful, please try again"),
	                "Unexpected notification message!");
	    }

}

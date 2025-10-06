package com.tests;

import com.base.BaseTest;
import com.pages.AddremovePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveTest extends BaseTest {
	
	  @Test
	    public void verifyAddAndRemoveElements() {
	        AddremovePage addRemovePage = new AddremovePage(page);
	        addRemovePage.navigate();
	        addRemovePage.addElements(3);
	        Assert.assertEquals(addRemovePage.getAddedElementCount(), 3, "Element count match!");
	        addRemovePage.removeAllElements();
	        Assert.assertEquals(addRemovePage.getAddedElementCount(), 0, "Elements removed properly!");
	    }
	}


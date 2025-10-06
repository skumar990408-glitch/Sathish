package com.pages;

import com.locators.AddRemovePage;
import com.microsoft.playwright.Page;

public class AddremovePage {

	private Page page;

	public AddremovePage(Page page) {
		this.page = page;
	}

	public void navigate() {
		page.click(AddRemovePage.ADD_REMOVE_ELEMENTS_BTTUN);
	}

	public void addElements(int count) {
		for (int i = 0; i < count; i++) {
			page.click(AddRemovePage.ADD_BUTTON);
		}
	}

	public int getAddedElementCount() {
		return page.locator(AddRemovePage.DELETE_BUTTONS).count();
	}

	public void removeAllElements() {
		while (page.locator(AddRemovePage.DELETE_BUTTONS).count() > 0) {
			page.locator(AddRemovePage.DELETE_BUTTONS).first().click();
		}
	}

}

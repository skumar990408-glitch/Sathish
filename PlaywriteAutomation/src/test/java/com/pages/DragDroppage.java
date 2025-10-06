package com.pages;

import com.locators.DragDropPage;
import com.microsoft.playwright.Page;

public class DragDroppage {
	
	   private Page page;

	    public DragDroppage(Page page) {
	        this.page = page;
	    }

	    public void navigate() {
	        page.click(DragDropPage.DROP_BOX_BUTTON);
	    }

	    public void performDragDrop() {
	        page.dragAndDrop(DragDropPage.DRAG_BOX, DragDropPage.DROP_BOX);
	    }

	    public String getDropText() {
	        return page.textContent(DragDropPage.DROP_BOX).trim();
	    }

}

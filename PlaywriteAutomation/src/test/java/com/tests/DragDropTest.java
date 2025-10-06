package com.tests;

import com.base.BaseTest;
import com.pages.DragDroppage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropTest extends BaseTest {
	
	
    @Test
    public void testDragAndDrop() {
        DragDroppage dragDropPage = new DragDroppage(page);
        dragDropPage.navigate();
        dragDropPage.performDragDrop();
        Assert.assertTrue(dragDropPage.getDropText().contains("Dropped"), "Drag & Drop failed!");
    }
}



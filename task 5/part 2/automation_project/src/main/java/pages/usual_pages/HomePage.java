package pages.usual_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenusPage;

public class HomePage extends MenusPage{
	public HomePage(MainPageManager pages) {
		super(pages);
	}
	
	public HomePage ensurePageLoaded() {
		super.ensurePageLoaded();
		log.info("Ensure back to main page successfully");
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.id("nivo-slider")));
        driver.findElement(By.className("product-grid"));
		return this;
	}
}
package pages.super_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.usual_pages.LoginPage;

public class MenusPage extends AnyPage{

	public MenusPage(MainPageManager pages) {
		super(pages);
	}

	
	public MenusPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		return this;
	}
	
	public LoginPage clickLoginLink() {
		log.info("Click 'Log in' menu-link");
        driver.findElement(By.linkText("Log in")).click();
        
		
		return pages.loginPage.ensurePageLoaded();
	}
	
	public MenusPage verifyLoginLink() {
		  log.info("Ensure the 'Log in' menu-link appears above");
          driver.findElement(By.linkText("Log in"));
        return this;
	}
	
	public MenusPage clickLogoutLink() {
		 log.info("Click 'Log out' menu-link");
         driver.findElement(By.linkText("Log out")).click();
        return this;
	}
}

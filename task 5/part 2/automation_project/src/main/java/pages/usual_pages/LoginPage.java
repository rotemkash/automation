package pages.usual_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenusPage;

public class LoginPage extends MenusPage{
	public LoginPage(MainPageManager pages) {
		super(pages);
	}
	
	public LoginPage ensurePageLoaded() {
		super.ensurePageLoaded();
		log.info("Ensure the 'Login' page was opened successfully");
        driver.findElement(By.className("returning-wrapper"));
        waitBig.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.login-button")));
		return this;
	}
	
	public RegisterPage clickRegisterLink() {
		log.info("Click 'Register' button");
        driver.findElement(By.linkText("Register")).click();
        return pages.registerPage.ensurePageLoaded();
	}

}

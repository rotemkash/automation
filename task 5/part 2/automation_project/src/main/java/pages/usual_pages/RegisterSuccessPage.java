package pages.usual_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenusPage;

public class RegisterSuccessPage extends MenusPage{
	
	final static String REGISTRATION_COMPLETED = "Your registration completed";

	public RegisterSuccessPage(MainPageManager pages) {
		super(pages);
		
	}
	
	public RegisterSuccessPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".result"))));
		return this;
	}
	
	public RegisterSuccessPage verifyMessageText() {
		log.info("Ensure the registration was completed successfully");
        String actualTextRegistration = driver.findElement(By.className("result")).getText();
        Assert.assertTrue(actualTextRegistration.contains(REGISTRATION_COMPLETED),
                "Expected value to contain: '" + REGISTRATION_COMPLETED + "', but actual is '" + actualTextRegistration + "'");
        return this;
	}
	
	public HomePage clickContinue() {
		log.info("Click 'Continue' button");
        driver.findElement(By.linkText("CONTINUE")).click();
        return pages.homePage.ensurePageLoaded();
	}

}

package pages.usual_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenusPage;

public class RegisterPage extends MenusPage{

	public RegisterPage(MainPageManager pages) {
		super(pages);
	}

	@FindBy(id="register-button")
	private WebElement registerButton;
	
	
	public RegisterPage ensurePageLoaded() {
		super.ensurePageLoaded();
		log.info("Ensure the 'Register' page was opened successfully");
        driver.findElement(By.id("gender-male"));
		waitBig.until(ExpectedConditions.visibilityOf(registerButton));
		return this;
	}
	
	public RegisterPage typeFirstName(String firstName) {
		log.info("Type into 'First name' textbox the value '" + firstName + "'");
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        return this;
	}
	
	public RegisterPage typeLastName(String lastName) {
		log.info("Type into 'Last name' textbox the value '" + lastName + "'");
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        return this;
	}
	
	public RegisterPage typeEmail(String email) {
		 log.info("Type into 'Email' textbox the value '" + email + "'");
         driver.findElement(By.id("Email")).sendKeys(email);
         return this;
	}
	
	public RegisterPage typePassword(String password) {
		log.info("Type into 'Password' textbox the value '" + password + "'");
        driver.findElement(By.id("Password")).sendKeys(password);
        return this;
	}
	
	public RegisterPage typeConfirmPassword(String confirmPassword) {
		log.info("Type into 'Confirm password' textbox the value '" + confirmPassword + "'");
        driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
        return this;
	}
	
	public RegisterSuccessPage clickRegisterButton() { 
		 log.info("Click 'REGISTER' button");
         driver.findElement(By.id("register-button")).click();
         return pages.registerSuccessPage.ensurePageLoaded();
	}
}

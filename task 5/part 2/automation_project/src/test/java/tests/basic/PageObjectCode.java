package tests.basic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import tests.supers.TestBase;
import util.GenUtils;


public class PageObjectCode extends TestBase {
	
	String timestamp;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String confirmPassword;
	
	@Test
	public void test() {
		try {

			initParameter();
			
			WebDriver driver = app.getDriver();
			driver.get("https://demo.nopcommerce.com/");
			app.pages()
			.homePage
			.ensurePageLoaded()
			.clickLoginLink()
			.clickRegisterLink()
			.typeFirstName(firstName)
			.typeLastName(lastName)
			.typeEmail(email)
			.typePassword(password)
			.typeConfirmPassword(confirmPassword)
			.clickRegisterButton()
			.verifyMessageText()
			.clickContinue()
			.clickLogoutLink()
			.verifyLoginLink();
			
			
			
			endTestSuccess();
		} catch (Throwable t) {
			onTestFailure(t);
		}
	}
	
	private void initParameter() {
        timestamp = GenUtils.getCurrentTimestamp(GenUtils.TIME_FORMAT_ddMMyyHHmmSSS);
        firstName = "Rotem";
        lastName = "Kashani";
        email = "rotemkash" + timestamp + "@gmail.com";
        password = "123456";
        confirmPassword = "123456";
    }
}




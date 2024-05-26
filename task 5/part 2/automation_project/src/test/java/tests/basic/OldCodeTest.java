package tests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import tests.supers.TestBase;
import util.GenUtils;

public class OldCodeTest extends TestBase {
    
    String timestamp, firstName, lastName, email, password, confirmPassword;
    final static String REGISTRATION_COMPLETED = "Your registration completed";
    
    @Test
    public void test() {
        try {
            initParameter();
            
            WebDriver driver = app.getDriver();
            log.info("Open site");
            driver.get("https://demo.nopcommerce.com/");
            
            log.info("Click 'Log in' menu-link");
            driver.findElement(By.linkText("Log in")).click();
            
            log.info("Ensure the 'Login' page was opened successfully");
            driver.findElement(By.className("returning-wrapper"));
            
            log.info("Click 'Register' button");
            driver.findElement(By.linkText("Register")).click();
            
            log.info("Ensure the 'Register' page was opened successfully");
            driver.findElement(By.id("gender-male"));
            
            log.info("Type into 'First name' textbox the value '" + firstName + "'");
            driver.findElement(By.id("FirstName")).sendKeys(firstName);
            
            log.info("Type into 'Last name' textbox the value '" + lastName + "'");
            driver.findElement(By.id("LastName")).sendKeys(lastName);
            
            log.info("Type into 'Email' textbox the value '" + email + "'");
            driver.findElement(By.id("Email")).sendKeys(email);
            
            log.info("Type into 'Password' textbox the value '" + password + "'");
            driver.findElement(By.id("Password")).sendKeys(password);
            
            log.info("Type into 'Confirm password' textbox the value '" + confirmPassword + "'");
            driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
            
            log.info("Click 'REGISTER' button");
            driver.findElement(By.id("register-button")).click();
            
            log.info("Ensure the registration was completed successfully");
            String actualTextRegistration = driver.findElement(By.className("result")).getText();
            Assert.assertTrue(actualTextRegistration.contains(REGISTRATION_COMPLETED),
                    "Expected value to contain: '" + REGISTRATION_COMPLETED + "', but actual is '" + actualTextRegistration + "'");
            
            log.info("Click 'Continue' button");
            driver.findElement(By.xpath("//a[contains(text(), 'Continue')]")).click();
            
            log.info("Ensure back to main page successfully");
            driver.findElement(By.className("product-grid"));
            
            log.info("Click 'Log out' menu-link");
            driver.findElement(By.linkText("Log out")).click();
            
            log.info("Ensure the 'Log in' menu-link appears above");
            driver.findElement(By.linkText("Log in"));
            
            GenUtils.sleepMillis(2000);
            
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
package tests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import tests.supers.TestBase;
import util.GenUtils;

public class OldCodeTest extends TestBase {

    String timestamp, email, password;

    @Test
    public void test() {
        try {
            WebDriver driver = app.getDriver();
            log.info("Opened the website");
            driver.get("https://demo.nopcommerce.com/");
            // Adding sleep for 2 seconds
            GenUtils.sleepMillis(2000);

            log.info("Click 'Register' link");
            driver.findElement(By.linkText("Register")).click();

            // Adding sleep for 2 seconds
            GenUtils.sleepMillis(2000);

            log.info("Select male radio");
            driver.findElement(By.id("gender-male")).click();

            // Adding sleep for 2 seconds
            GenUtils.sleepMillis(2000);

            initParameter();
            log.info("Enter email address: " + email);
            driver.findElement(By.id("Email")).sendKeys(email);

            // Adding sleep for 2 seconds
            GenUtils.sleepMillis(2000);

            log.info("Getting text from 'Register' button");
            String registerButtonText = driver.findElement(By.id("register-button")).getText();
            log.info("Text from 'Register' button: " + registerButtonText);

            endTestSuccess();
        } catch (Throwable t) {
            onTestFailure(t);
        }
    }

    private void initParameter() {
        timestamp = GenUtils.getCurrentTimestamp(GenUtils.TIME_FORMAT_ddMMyyHHmmSSS);
        email = "rotemkash" + timestamp + "@gmail.com";
        password = "123456";
    }
}
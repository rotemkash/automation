package tests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import tests.supers.TestBase;

public class AppiumTestExample extends TestBase {

	@Test
	public void test() {
		try {

			WebDriver driver = app.getDriver();
			log.info("Click Delete");
			driver.findElement(By.id("com.google.android.calculator:id/del")).click();

			log.info("Click 9");
			driver.findElement(By.xpath("//android.widget.Button[@text='9']")).click();

			log.info("Click ^");
			driver.findElement(By.id("com.google.android.calculator:id/op_pow")).click();

			log.info("Click 3");
			driver.findElement(By.xpath("//android.widget.Button[@text='3']")).click();

			log.info("Click =");
			driver.findElement(By.xpath("//android.widget.Button[@text='=']")).click();

			log.info("Get result...");
			String result = driver.findElement(By.className("android.widget.TextView")).getText();
			log.info("Result is : " + result);


			endTestSuccess();
		} catch (Throwable t) {
			onTestFailure(t);
		}
	}
}

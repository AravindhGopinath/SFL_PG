package org.runner;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.BaseClass;

public class COS_login extends BaseClass {


	@Test
	private void execution() throws InterruptedException {
		for (int i = 0; i < 30; i++) {

			launchBrowser("chrome");

			loadUrl("https://uatsecure.shriramfinance.in/");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

			WebElement Mobile_no = driver.findElement(By.id("cusMobNo"));

			WebElement until = wait.until(ExpectedConditions.visibilityOf(Mobile_no));

			until.click();

			until.sendKeys("8508888860");

			WebElement Mpin = driver.findElement(By.id("loginWithMPINSubmit"));

			WebElement until2 = wait.until(ExpectedConditions.visibilityOf(Mpin));

			until2.click();

			WebElement findElement = driver.findElement(By.xpath("(//div[@class='otp-inputs'])[2]"));

			WebElement until3 = wait.until(ExpectedConditions.visibilityOf(findElement));

			List<WebElement> findElements = until3.findElements(By.xpath("(//div[@class='otp-inputs'])[2]"));

			for (int i1 = 0; i1 < findElements.size(); ++i1) {

				WebElement checkbox = findElements.get(i1).findElement(By.xpath("./input"));

//            System.out.println(checkbox+"  --> Checkbox1");

				checkbox.sendKeys("1000");

			}

			WebElement findElement2 = driver.findElement(By.id("loginVerifyMPIN"));

			findElement2.click();

			Thread.sleep(6000);

			WebElement findElement3 = driver.findElement(By.xpath("(//a[@class='sm-icon profile-btn'])[1]"));

			WebElement until4 = wait.until(ExpectedConditions.visibilityOf(findElement3));

			until4.click();

			WebElement findElement4 = driver.findElement(By.id("profileLogout"));

			WebElement until5 = wait.until(ExpectedConditions.visibilityOf(findElement4));

			scrollDown(until5);

			until5.click();
			
			driver.quit();

		}
	}
}

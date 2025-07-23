package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicValidation {
	public static WebDriver driver;
	public String url = "https://www.facebook.com";
	
	@BeforeTest
	public void setup() {
		//open chrome browser 
		driver = new ChromeDriver();
		
		//open facebook url
		driver.get(url);
		
	}
	
	@AfterTest
	public void tearDown() {
		//quit the browser instance
		driver.quit();
	}
	
	@Test
	public void welcomeMessageValidation() {
		String expectedResult = "Facebook helps you connect and share with the people in your life.";
		String actualResult = driver.findElement(By.xpath("//h2[@class='_8eso']")).getText();
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Resutl = " + actualResult);
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the welcome message");
	}
	
	@Test
	public void emailPlaceholderValidation() {
		String expectedResult = "Email address or phone number";
		String actualResult = driver.findElement(By.id("email")).getDomAttribute("placeholder");
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Resutl = " + actualResult);
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the email placeholder");
	}
	
	@Test
	public void passwordPlaceholderValidation() {
		String expectedResult = "Password";
		String actualResult = driver.findElement(By.id("pass")).getDomAttribute("placeholder");
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Resutl = " + actualResult);
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the email placeholder");
	}
}

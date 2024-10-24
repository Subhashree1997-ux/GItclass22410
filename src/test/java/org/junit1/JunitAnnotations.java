package org.junit1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitAnnotations {
	public static WebDriver driver;
	@BeforeClass
	public static void tc01() {
		try {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Browser Launched Successfully");
			
		}catch(Exception e) {
			System.out.println("Browser not Launched Successfully");
		}
	}
	
	@Before
	public void tc02() {
		try {
			driver.get("https://adactinhotelapp.com/");
			System.out.println("Application Launched Successfully");
		}catch(Exception e) {
			System.out.println("Application not Launched Successfully");
		}
	}
	
	@Test
	public void tc03() {
		try{
			WebElement element = driver.findElement(By.id("username"));
			element.sendKeys("Alice");
			WebElement element2 = driver.findElement(By.id("password"));
			element2.sendKeys("12345");
			System.out.println("Login Credentials entered successfully");
		}catch(Exception e) {
			System.out.println("Login Credentials not entered successfully");
		}
		
	}
	
	@After
	public void tc04() {
		try{
			WebElement element = driver.findElement(By.id("login"));
			element.click();
			System.out.println("Logged into the site successfully");
		}catch(Exception e) {
			System.out.println("Not Logged into the site successfully");
		}
		
	}
	
	@AfterClass
	public static void tc05() {
		try {
			String expectedErrorMessage="Invalid Login details or Your Password might have expired. Click here to reset your password";
			WebElement element = driver.findElement(By.xpath("//b[contains(text(),'Invalid')]"));
			String text = element.getText();
			if(expectedErrorMessage.equalsIgnoreCase(text)) {
				System.out.println("Successfully displaying the error message");
			}
		}catch(Exception e) {
			System.out.println("Not Successfully displaying the error message");
			System.out.println("changes made by QA");
		}
		
	}

}

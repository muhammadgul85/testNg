package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GooglePage_testNG {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();// Run Time Polymorphism - Over loading , over riding - inheritance -
												// class and object

		// Webdriver = Interface
		// ChromeDriver = Class
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	}

	@Test
	public void Method1() throws InterruptedException {
		
		 driver.findElement(By.name("q")).sendKeys("Muhammad");
		 driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		 
		 Thread.sleep(2000);//wait for 2 sec
		 
		System.out.println("GooglePage: test completed  ");
	}

	@AfterClass
	public void cleanUp() {
		driver.close();
	}

}

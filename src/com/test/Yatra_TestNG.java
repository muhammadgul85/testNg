package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Yatra_TestNG {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();//Run Time Polymorphism - Over loading , over riding - inheritance - class and object
		
		//Webdriver = Interface
		//ChromeDriver = Class
		driver.get("https://www.yatra.com");
		driver.manage().window().maximize();
	}
	@Test
	public void Method1() throws InterruptedException
	{
		WebElement MyAccount = driver.findElement(By.xpath("//a[text()='My Account']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(MyAccount).build().perform();
		
		driver.findElement(By.xpath("//a[@title='My Bookings']")).click();
		
		Thread.sleep(3000);
		
		driver.navigate().back(); //Previous page
		driver.navigate().forward();
			
	}
	
	@AfterClass
	public void clearUp()
	{
		driver.close();
	}

}

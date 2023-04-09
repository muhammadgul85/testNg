package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IRCTC_TestNG_Multiple_Tests {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver ();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test (priority=1)
	public void trains() throws InterruptedException
	{
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()='Ok']")).click();
		Thread.sleep(2000);
		WebElement Trains = driver.findElement(By.xpath("(//a[contains(text(),'TRAINS')])"));
		
		Actions act = new Actions(driver);
		act.moveToElement(Trains).build().perform();
		
		//IRC Trains – when you move to Trains and scroll down another option for IRC Trains comes how to select that ?
		//(//a[contains(text(),'IRCTC TRAINS')]) cannot locate element in Dom
		//Below one is not working either when I click on it, it doesn't respond
		//driver.findElement(By.xpath("//span[text()='Book Ticket']")).click();
		
		driver.findElement(By.xpath("(//span[contains(text(),'Foreign Tourist Booking')])")).click();
		driver.findElement(By.xpath("//button[text()='Ok']")).click();
		
		System.out.println("Popup clicked");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@placeholder='From*']")).sendKeys("mumbai");
		driver.findElement(By.xpath("//span[contains(text(),'MUMBAI CENTRAL - BCT')]")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='To*']")).sendKeys("hyderabad");
		System.out.println("destination entered");
		driver.findElement(By.xpath("//span[text()='HYDERABAD DECAN - HYB']")).click();
		System.out.println("Hyderabad clicked");
		//driver.findElement(By.xpath("(//label[contains(text(),'Flexible With Date')])")).click();
		//label[text()='Flexible With Date']
		driver.findElement(By.xpath("//label[text()='Flexible With Date']")).click();
		driver.findElement(By.xpath("//button[@label='Find Trains']")).click();
	}
	@Test (priority =2)
	public void testmethod2 ()
	{
		System.out.println("2nd test");
	}
	
	@AfterClass
	public void cleanUp()
	{
		driver.close();
	}
}
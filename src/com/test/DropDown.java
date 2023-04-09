/**
 * TestNg - Unit Testing Framework - Developer or Automation People want to use this for Testing Purpose
 */


package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDown {
	
	WebDriver driver;
	
	@BeforeClass
	public void MethodBefore()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();//Run Time Polymorphism - Over loading , over riding - inheritance - class and object
		
		//Webdriver = Interface
		//ChromeDriver = Class
		driver.get("https://www.Amazon.com");
		driver.manage().window().maximize();
	}
	@Test (priority =1)
	public void SelectAdvanceDropDown()
	{
				
		WebElement selectelement=driver.findElement(By.id("searchDropdownBox"));
		
		Select sel = new Select(selectelement);
		
		List<WebElement> li = sel.getOptions();
		System.out.println("List Size "+li.size());
		
		for(int i =0 ; i<li.size() ;i++)
		{
			li.get(i).click();
			System.out.println(li.get(i).getText()); //afzal ansa muhana .get(0).text()=>afzal
		}
			
	}
	
	@Test(priority=2)
	public void DropDown() throws InterruptedException
	{
						
		WebElement selectelement=driver.findElement(By.id("searchDropdownBox"));
		
		Select sel = new Select(selectelement);
//		sel.selectByIndex(7);
//		Thread.sleep(3000);
		
		sel.selectByVisibleText("Computers");
		Thread.sleep(3000);
		sel.selectByValue("search-alias=beauty-intl-ship");
		Thread.sleep(3000);
		
	}	
	@AfterClass
	public void MethodAfter()
	{
		driver.close();
	}
}

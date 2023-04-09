package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTour_TestNG {
	WebDriver driver;
	
	
	@BeforeClass
	public void setUp() 
	{
System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours");
		driver.manage().window().maximize();	
	}
	@Test
	public void Method1() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
		Thread.sleep(2000);
		WebElement selectElement = driver.findElement(By.name("country")); // Ask Afzal Bhai, 2 steps below as well
		
		Select selection = new Select (selectElement); //This will be cleared once constructor is done
		List <WebElement> li =selection.getOptions(); // List , WebElement,(how are they formed)???? (getOptions = Understood) 
		System.out.println("List Size: "+ li.size());// we are printing the size of list== > Understood 
		
		Thread.sleep(1000);
		for (int i = 0; i <li.size(); i++)
		{
			li.get(i).click();//get list and click on list
			System.out.println(li.get(i).getText());//get the list and get the text				
		}		
		//selection.selectByIndex(213);
		selection.selectByValue("BELARUS");  // this is throwing error
		//selection.selectByVisibleText("UNITED KINGDOM");
		driver.findElement(By.id("email")).sendKeys("Alikhan@yopmail.com");
		driver.findElement(By.name("password")).sendKeys("123456789abc");
		driver.findElement(By.name("confirmPassword")).sendKeys("123456789abc");
		driver.findElement(By.name("submit")).click();	
	}
	
	@AfterClass
	public void cleanUp()
	{
		driver.close();
	}

}

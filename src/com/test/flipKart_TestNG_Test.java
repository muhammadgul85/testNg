package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class flipKart_TestNG_Test {
	
	
	@BeforeSuite
	public void beforeSuit() 
	{
		System.out.println("Before Suite: The tests will begin");
	}
	
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Documents\\Drivers\\chromedriver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		System.out.println("Title: "+driver.getTitle());
		//System.out.println("FlipKart_Tests executing");

	}

	@Test
	public void test1() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		System.out.println("Title is: " + driver.getTitle());

		// close the modal popup

		driver.findElement(By.xpath("//button[text()='✕']")).click();
		// Go to Electronics (Store Element)
		// Thread.sleep(4000);

		WebElement Electronics = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[span[text()='Electronics']]")));

//        WebElement Electronics = driver.findElement(By.xpath("//span[text()='Electronics']")); //Ask afzal Bhai why this didn't work, it was unique and located as well in DOM

		Actions act = new Actions(driver);
		// Thread.sleep(3000);
		act.moveToElement(Electronics).build().perform();

		Thread.sleep(5000);
		// click on Mobiles
		driver.findElement(By.xpath("(//a[text()='Mobiles'])[1]")).click();
		//System.out.println("Title is:" + driver.getTitle());
		driver.navigate().back();
		System.out.println("Navigated back to main page");

		act.moveToElement(Electronics).build().perform();
		driver.findElement(By.xpath("//a[text()='Mobile Accessories']")).click();
		// write again with contains
		driver.navigate().back();
	}

	@AfterClass
	public void cleanUp() {
		driver.close();
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After Suite: All the tests executed");
	}

}

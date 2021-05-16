package com.qa.testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase1 {
	
	WebDriver driver;
	
	@BeforeClass
	public void setupmethod()
	{
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\vishal mittal\\Downloads\\chromedriver_win32 (23)\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);	
	}
	
	@Test(priority='1')
	public void HomePageTest() throws InterruptedException
	{
		// for selenium to find an element on the webpage and perform testing on it
		
		// findElement(locators-- address of your element on webpage)
		// xpath locator -- //tagname[@attribute='value']
		
		driver.findElement(By.xpath("//input[@id='searchInput']")).clear();
		
		driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Selenium Automation");
		
		// 2nd element button
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(5000);
		
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.getTitle());
		
	}
	
	
	@Test(priority='2')
	public void CreateAccountPageTest() throws InterruptedException
	{
		
		String title=driver.getTitle();  // fetch title of the page
		System.out.println("the title of the main account page is : "+ title);
		// click on main Page link
		driver.findElement(By.linkText("Create account")).click();
		
		String title1=driver.getTitle();  // fetch title of the page
		System.out.println("the title of the create account page is : "+ title1);
		
		driver.findElement(By.xpath("//input[@id='wpName2']")).sendKeys("sonal");
		driver.findElement(By.xpath("//input[@id='wpPassword2']")).sendKeys("abc@123");
		Thread.sleep(3000);
	}
	
	@Test(priority='3')
	public void navigateTest() throws InterruptedException
	{
		driver.navigate().to("https://ironspider.ca/forms/checkradio.htm");
		driver.findElement(By.xpath("//*[@id=\"Content\"]/div[1]/blockquote[1]/form/input[1]")).click();
	
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"subMenuID_09\"]/a[6]")).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

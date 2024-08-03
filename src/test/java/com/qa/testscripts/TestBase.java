package com.qa.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase 
{
	
	WebDriver driver;
	
	JavascriptExecutor JS;
	
	
	@Parameters({"url"})
	@BeforeClass
	
	//setup method is used to setup selenium webdriver
	public void setUp(String url)
	{
		//System.setProperty is used for to specify the path of the browser driver executable
		System.setProperty("webdriver.edge.driver", "C:\\Users\\vibha\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		//Create the instance of edgedriver
		driver = new EdgeDriver();
		
		JS = (JavascriptExecutor)driver;
		
		//navigate to the specified url
		driver.get(url);
		//used to maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@AfterClass
	public void TearDown()
	{
		//close the browser
		driver.quit();
		
	}

}

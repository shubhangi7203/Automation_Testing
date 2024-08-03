package com.qa.testscripts;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 extends TestBase
{
	
	@Test
	
	public void URL() throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//getCurrentUrl() method is used to fetch current url is browser is looking at.
		boolean contains = driver.getCurrentUrl().contains("https://www.fitpeo.com/");
		if(contains)
		{
			System.out.println("User is landed on HomePage");
		}
		else
		{
			System.out.println("User is not landed on HomePage");
			
		}
		
		//navigate().to is used for the navigate to revenue-calculator webpage.
		
		driver.navigate().to("https://fitpeo.com/revenue-calculator");
		
		//JavascriptExceutor is used for the scrolling window
		JS.executeScript("window.scrollBy(0,350)");
		Thread.sleep(2000);
		
		//to fetch the value by slider
		WebElement Slider = driver.findElement(By.xpath("//span[@class='MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-duk49p']"));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Slider));
        
		//Action class is used to perform drag and drop method.
		Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(element, -26, 2).build();
        action.perform();
        
        Thread.sleep(2000);
        //locate the text field element
        WebElement sildertext=driver.findElement(By.id(":R57alklff9da:"));
      
		sildertext.sendKeys("824");
		//for loop used  to perform backspace
		for (int i = 0; i < "Text to delete".length(); i++) {
			sildertext.sendKeys(Keys.BACK_SPACE);
        }
		
		sildertext.sendKeys("560");
		Thread.sleep(2000);
	
		for (int i = 0; i < "Text to delete".length(); i++) {
			sildertext.sendKeys(Keys.BACK_SPACE);
        }
		sildertext.sendKeys("820");
		Thread.sleep(2000);
		
		
		
		JS.executeScript("window.scrollBy(350,500)");
		Thread.sleep(2000);
		//locate the checkbox
		WebElement checkbox1 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/label/span[1]/input"));
		checkbox1.click();
		
		WebElement checkbox2 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/label/span[1]/input"));
		checkbox2.click();
		
		WebElement checkbox3 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/label/span[1]/input"));
		checkbox3.click();
		
		WebElement checkbox4 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[8]/label/span[1]/input"));
		checkbox4.click();
		
		//locate the reimbursement value
		WebElement R_value = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/p[4]/p"));
		//fetch the reimbursement value
		String exp_R_value=R_value.getText();
		String act_R_value= "$110700";
		
		//Assert is used for verifying the actual and expected result.
		Assert.assertEquals(act_R_value,exp_R_value);
		
	}
	
	

}

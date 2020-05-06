package org.practice.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MakeMyTripDropDownHandle {

	public WebDriver driver;
	
	@Test
	public void testMakeMyTripDropDownHandle() {
		
		System.setProperty("webdriver.chrome.driver", "../selenium.practice/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		Actions action = new Actions(driver);
		
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();			
	}
}

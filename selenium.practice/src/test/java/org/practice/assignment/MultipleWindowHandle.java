package org.practice.assignment;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MultipleWindowHandle {
	
	public WebDriver driver;
	
	@Test
	public void testmultipleWindowHandle() {
		
		System.setProperty("webdriver.chrome.driver", "../selenium.practice/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();
	
		Actions action = new Actions(driver);
		WebElement gmail = driver.findElement(By.xpath("//a[text()='Gmail']"));		
		action.keyDown(Keys.CONTROL).click(gmail).keyUp(Keys.CONTROL).build().perform();				
				
		String firstPage = driver.getWindowHandle();
		System.out.println("*******************************Before Switching*******************************");
		System.out.println(driver.getCurrentUrl());
				
		Set<String> allActiveWindow = driver.getWindowHandles();
		System.out.println("Total number of opened window - "+allActiveWindow.size());
		for(String iterateWindow:allActiveWindow) {
			
			driver.switchTo().window(iterateWindow);
		}
		System.out.println("*******************************After Switching*******************************");
		System.out.println(driver.getCurrentUrl());
		
		System.out.println("*******************************Return back to fist page*******************************");
		driver.switchTo().window(firstPage);
		System.out.println(driver.getCurrentUrl());
	}
}

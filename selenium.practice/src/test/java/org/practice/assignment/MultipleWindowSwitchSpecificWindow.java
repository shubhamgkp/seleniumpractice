package org.practice.assignment;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MultipleWindowSwitchSpecificWindow {
	
	public WebDriver driver;	
	@Test
	public void testMultipleWindowSwitchSpecificWindow() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "../selenium.practice/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://in.linkedin.com/");
		driver.manage().window().maximize();
	
		Actions action = new Actions(driver);
		WebElement joinNow = driver.findElement(By.xpath("//a[text()='Join now']"));
		WebElement signin = driver.findElement(By.xpath("//a[text()='Sign in']"));
						
		action.keyDown(Keys.CONTROL).click(joinNow).keyUp(Keys.CONTROL).build().perform();
		action.keyDown(Keys.CONTROL).click(signin).keyUp(Keys.CONTROL).build().perform();
				
		String parentPage = driver.getWindowHandle();
		System.out.println("*******************************Before Switching*******************************");
		System.out.println("Parent page URL - "+driver.getCurrentUrl());
				
		Set<String> allActiveWindow = driver.getWindowHandles();
		System.out.println("Total number of opened window - "+allActiveWindow.size());
		
		int i = 0;
		for(String iterateWindow:allActiveWindow) {
			
			i++;
			if(i==2) {
				System.out.println("*******************************After Switching*******************************");
				driver.switchTo().window(iterateWindow);
				Thread.sleep(3000);
				break;	
			}			
		}
		System.out.println("*******************************Return Back to Parent Page*******************************");
		driver.switchTo().window(parentPage);
		System.out.println("Parent page URL - "+driver.getCurrentUrl());
	}
}
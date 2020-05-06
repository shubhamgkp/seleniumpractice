package org.practice.assignment;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class demo {

	@Test()
	public void testMultipleWindowSwitchSpecificWindow() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "../selenium.practice/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://in.linkedin.com/");
		driver.manage().window().maximize();

		Actions action = new Actions(driver);
		WebElement joinNow = driver.findElement(By.xpath("//a[text()='Join now']"));
		WebElement signin = driver.findElement(By.xpath("//a[text()='Sign in']"));
		//WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click here.']"));

		action.keyDown(Keys.CONTROL).click(joinNow).keyUp(Keys.CONTROL).build().perform();
		String secondWindow = driver.getWindowHandle();
		System.out.println("secondWindow--->"+secondWindow);
		action.keyDown(Keys.CONTROL).click(signin).keyUp(Keys.CONTROL).build().perform();
		String thirddWindow = driver.getWindowHandle();
		System.out.println("thirddWindow--->"+thirddWindow);
		//action.keyDown(Keys.CONTROL).click(clickHere).keyUp(Keys.CONTROL).build().perform();

		String firstPage = driver.getWindowHandle();
		System.out.println("*******************************Before Switching*******************************");
		System.out.println(driver.getCurrentUrl());

		String parentWindow = driver.getWindowHandle();
		System.out.println("ParentWindowId-->"+parentWindow);
		Set<String> allActiveWindow = driver.getWindowHandles();
		System.out.println(allActiveWindow);
		//List<String> list=(List<String>) allActiveWindow;
		System.out.println("Total number of opened window - "+allActiveWindow.size());
		for(String iterateWindow:allActiveWindow) {
			{
				System.out.println(iterateWindow);
				driver.switchTo().window(iterateWindow);
				Thread.sleep(3000);
			}
			//driver.close();
		}
	}
}

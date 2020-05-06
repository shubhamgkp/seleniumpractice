package org.practice.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FacebookSignUpPageAutomationTestNG {

	public static WebDriver driver;
	public static Select selectDropDown;
	
	@Test
	public void facebookPageAutomation() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "../selenium.practice/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='u_0_m']")).sendKeys("Shubham");
		driver.findElement(By.xpath("//input[@id='u_0_o']")).sendKeys("Verma");
		driver.findElement(By.xpath("//input[@id='u_0_r']")).sendKeys("9307816565");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("shubhamcert@gmail.com");
				
		GenericMethods genMethod = new GenericMethods();
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		genMethod.genericDropDownByValMethod(day, "8");
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		genMethod.genericDropDownByIndexMethod(month, 3);
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		genMethod.genericDropDownByVisibleTextMethod(year, "1990");		
		
		driver.findElement(By.xpath("//input[@id='u_0_7']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();	
	}
}

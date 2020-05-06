package enhance.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sk {

	ChromeDriver driver;

	@BeforeMethod
	public void init() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		String exePath = "driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		options.addArguments("--disable-extensions");
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		//driver.get("http://liondtdtest.cargoflash.com/Index.aspx"); 
		//driver.get("http://liondtdstaging.cargoflash.com/Index.aspx");
		//driver.get("http://uat.lionparcel.com/Login.aspx");
		driver.get("http://elexyslite.cargoflash.com/");
		//driver.get("http://lpt.cargoflash.com/Login.aspx");
	}

	@Test
	public void met() {

		driver.findElement(By.name("Username")).sendKeys("bpnpos1");		
		driver.findElement(By.name("Password")).sendKeys("1234");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Actions actions = new Actions(driver);
		WebElement booking = driver.findElement(By.xpath("//a[text()='Booking']"));
		actions.moveToElement(booking);
		actions.click().build().perform();
	}	
}

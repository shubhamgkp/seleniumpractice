package enhance.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RunGeckoDriver {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement user=driver.findElement(By.id("email")); 
		user.sendKeys("ayusheebh19@gmail.com");
		WebElement password=driver.findElement(By.name("pass"));
		password.sendKeys("Testin12345");
	}
}

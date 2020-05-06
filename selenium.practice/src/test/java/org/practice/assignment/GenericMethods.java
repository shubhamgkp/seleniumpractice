package org.practice.assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericMethods {

	public Select selectDropDown;
	public void genericDropDownByValMethod(WebElement element, String selectByValue) {

		selectDropDown = new Select(element);
		selectDropDown.selectByValue(selectByValue);		
	}
	
	public void genericDropDownByVisibleTextMethod(WebElement element, String selectByVisibleText) {
		
		selectDropDown = new Select(element);
		selectDropDown.selectByVisibleText(selectByVisibleText);
	}
	
	public void genericDropDownByIndexMethod(WebElement element, int selectByIndex) {
		
		selectDropDown = new Select(element);
		selectDropDown.selectByIndex(selectByIndex);
	}
}

package pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
	
	WebDriver driver = null;
	By textbox_search = By.name("q");
	By search_button  = By.name("btnK");
	
	public GoogleSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void inputIntoTextbox(String text) {
		driver.findElement(textbox_search).sendKeys(text);
	}
	
	public void clickSearchButton() {
		//driver.findElement(search_button).sendKeys(Keys.RETURN);
		driver.findElement(search_button).submit();
	}

}

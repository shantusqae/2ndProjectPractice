package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver driver = null;

public static void main(String[] args) {
	googleSearch();
	
}

public static void googleSearch(){

String projectPath = System.getProperty("user.dir");
//System.setProperty("webdriver.gecko.driver", projectPath+"\\drivers\\geckodriver\\geckodriver.exe");
//driver=new FirefoxDriver();

System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
driver = new ChromeDriver();

driver.get("https://www.google.com/");
driver.manage().window().maximize();

GoogleSearchPage.textbox_search(driver).sendKeys("Automation");



//GoogleSearchPage.button_search(driver).click();
GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);

driver.close();
System.exit(0);
}
}
package automationFramework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.Constant;
import utility.ExcelUtils;
import appModules.TableData2;
import onlyExcel.CompareExcel;


public class Apache_POI_TC {

	//private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		// This is to open the Excel file. Excel path, file name and the sheet
		// name are parameters to this method

		ExcelUtils.setExcelFile(
				Constant.Path_TestData + Constant.File_TestData, "Sheet1");

		// driver = new FirefoxDriver();
		String exePath = "C:\\Office Work\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(Constant.URL);

		TableData2.Execute(driver);
		
		Thread.sleep(5000);
		
		CompareExcel.Execute(driver);

		driver.quit();
	}

}
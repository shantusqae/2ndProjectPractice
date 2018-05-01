package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.ExcelUtils;

public class TableData2 {

	public static void  Execute(WebDriver driver) throws Exception {

		// Get number of rows In table.
		int Row_count = driver.findElements(By.xpath("//*[@id='content']/table/tbody/tr")).size();
		System.out.println("Number Of Rows = " + Row_count);

		// Get number of columns In table.
		int Col_count = driver.findElements(
				By.xpath("//*[@id='content']/table/tbody/tr[1]/td")).size();
		System.out.println("Number Of Columns = " + Col_count);
		// Get and print th value
		String thvalue = driver.findElement(
				By.xpath(".//*[@id='content']/table/thead/tr")).getText();
		System.out.println(thvalue + " ");
		//Get row and column value
		String first_part = "//*[@id='content']/table/tbody/tr[";
		String second_part = "]/td[";
		String third_part = "]";

		// Used for loop for number of rows.
		for (int i = 1; i <= Row_count; i++) {
			// Used for loop for number of columns.
			for (int j = 1; j <= Col_count; j++) {
				// Prepared final xpath of specific cell as per values of i and
				// j.
				String final_xpath = first_part + i + second_part + j
						+ third_part;
				// Will retrieve value from located cell and print It.
				String Table_data = driver.findElement(By.xpath(final_xpath)).getText();
				System.out.print(Table_data + "  ");
				ExcelUtils.setCellData(Table_data, i-1, j-1 );
			}
			System.out.println("");
			System.out.println("");
		}

		driver.close();
	}
};
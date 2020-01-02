import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class BrowserTest {

public static void main(String[] args) {

String projectPath = System.getProperty("user.dir");
System.setProperty("webdriver.gecko.driver", projectPath+"\\drivers\\geckodriver\\geckodriver.exe");

WebDriver driver=new FirefoxDriver();
driver.get("https://www.google.com/");
driver.manage().window().maximize();
String appTitle=driver.getTitle();
String expTitle="Google2";
if (appTitle.equals (expTitle)){
System.out.println("Verification Successfull");
}
else{
System.out.println("Verification Failed");

}
driver.close();
System.exit(0);
}
}
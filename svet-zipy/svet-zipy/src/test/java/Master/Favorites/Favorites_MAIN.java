package Master.Favorites;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import zipy_elements.*;
	
	public class Favorites_MAIN {
	
	static WebDriver driver;
	static boolean errorCaught;
	static Boolean logged;
	static WebDriverWait wait;
	
	@BeforeClass
	public static void openDriver() throws Exception {	
		
		

		errorCaught = false;
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		
		wait = new WebDriverWait(driver, 15);	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		//open the main site and close the pop-up, so it won't appear in next tabs
		driver.get("https://www.zipy.co.il");
		//Tests_functions.logIn(driver);
	
	}
	
	
	@AfterClass	
	public static void cartEnding() throws InterruptedException {	
		// Closing all windows of the browser, opened by the test.
		driver.quit();			 
	}
	


}

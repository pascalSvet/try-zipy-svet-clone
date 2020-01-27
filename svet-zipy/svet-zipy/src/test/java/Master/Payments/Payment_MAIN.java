package Master.Payments;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import zipy_elements.*;

public class Payment_MAIN {
	
	static WebDriver driver;
	boolean errorCaught;
	Boolean logged;
	WebDriverWait wait;

	@Before 
	public void closeEnteringPopUp() throws Exception {	
		
		errorCaught = false;
		
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		
		wait = new WebDriverWait(driver, 15);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 

		//enter site 
		driver.get(ElementsWebsites.Zipy_il);
		
	}
	
	@After	
	public void closeBrowser() {	
		// Closing all windows of the browser, opened by the test.	
		driver.quit();		 
	}	
	
	@AfterClass		
	public static void killDriverProcess() throws IOException {		
		driver.quit();
	}

}

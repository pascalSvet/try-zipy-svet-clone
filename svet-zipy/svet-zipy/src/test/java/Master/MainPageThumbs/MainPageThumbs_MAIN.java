package Master.MainPageThumbs;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import zipy_elements.*;
	
	public class MainPageThumbs_MAIN {
	
	static WebDriver driver;
	static Boolean logged;
	static WebDriverWait wait;
	
	@BeforeClass 
	public static void openDriver() throws Exception {	
	
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		
		wait = new WebDriverWait(driver, 15);	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 		
	}
	
	
	
	@AfterClass	
	public static void closeDriver() throws InterruptedException {	
		
		// Closing all windows of the browser, opened by the test.
		driver.quit();			 
	}	

	
}

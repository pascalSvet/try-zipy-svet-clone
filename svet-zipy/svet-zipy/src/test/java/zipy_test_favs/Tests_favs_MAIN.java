package zipy_test_favs;
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
	
	public class Tests_favs_MAIN {
	
	static WebDriver driver;
	static boolean errorCaught;
	static Boolean logged;
	static WebDriverWait wait;
	
	@BeforeClass
	public static void openDriver() throws Exception {	
		
		

		errorCaught = false;
		System.setProperty("webdriver.chrome.driver","src/zipy_resources/chromedriver.exe");
		driver = new ChromeDriver();
		
		wait = new WebDriverWait(driver, 15);	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		//open the main site and close the pop-up, so it won't appear in next tabs
		driver.get("https://www.zipy.co.il");
		Tests_functions.logIn(driver);
	
	}
	
	
	@AfterClass	
	public static void cartEnding() throws InterruptedException {	
		// Closing all windows of the browser, opened by the test.
		driver.quit();			 
	}	
	/*
	@AfterClass		
	public static void killDriverProcess() throws IOException, InterruptedException {		
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");	// Killing the chromedriver process in the end of the test.
        Thread.sleep(500); 
        
	}*/

}

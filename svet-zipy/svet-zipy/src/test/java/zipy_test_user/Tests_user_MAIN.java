package zipy_test_user;
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

	
	public class Tests_user_MAIN {
	
	static WebDriver driver;
	static boolean errorCaught;
	static Boolean logged;
	static WebDriverWait wait;


	
	@BeforeClass
	public static void openDriver() throws Exception {	
		
		errorCaught = false;
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		
		wait = new WebDriverWait(driver, 20);	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 	
		
		driver.get(ElementsWebsites.Zipy_il);

		//login with zipy user
		Tests_functions.logInSpecial(driver, ElementsLogin.Email_zipy, ElementsLogin.Email_zipy_password);
		
	}
	
	

	@AfterClass		
	public static void closeBrowser() {		
		driver.quit();	// Closing all windows of the browser, opened by the test.		 
	}	
	
	/*
	@AfterClass		
	public static void killDriverProcess() throws IOException, InterruptedException {		
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");	// Killing the chromedriver process in the end of the test.
        Thread.sleep(500); 
        
	}*/

}

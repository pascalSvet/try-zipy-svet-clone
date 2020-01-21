package zipy_test_cart;
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
	
	public class Tests_cart_MAIN {
	
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
		
		//enter site and log in
		driver.get(ElementsWebsites.Zipy_il);
		//Tests_functions.logIn(driver);
	
	}
	
	@Before
	public void startCartEmpty() throws Exception {	
		//at the end, remove the product from the cart, for the future tests
		try {
			Tests_functions.openAndEmptyCart(driver);	
		}
		catch(Exception e){			
		}
	}
	
	@After
	public void endCartEmpty() throws Exception {	
		//at the end, remove the product from the cart, for the future tests
		try {
			if(!driver.findElements(By.xpath(ElementsBuying.Product_cartRemove)).isEmpty()) {
				driver.findElement(By.xpath(ElementsBuying.Product_cartRemove)).click();
			}
		}
		catch(Exception e){			
		}
	}
	
	@AfterClass	
	public static void quitDriver() throws Exception {		
		// and close all windows of the browser, opened by the test.
		driver.quit();			 
	}	


}

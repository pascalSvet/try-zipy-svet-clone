package Master.Aliexpress;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import zipy_elements.*;
	
	public class Aliexpress_MAIN {
	
	static WebDriver driver;
	static boolean errorCaught;
	static Boolean logged;
	static WebDriverWait wait;
	static ArrayList<String> tabs;
	
	@BeforeClass
	public static void openDriver() throws Exception {	
		
		

		errorCaught = false;
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		
		wait = new WebDriverWait(driver, 15);	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		//open the main site 
		driver.get(ElementsWebsites.Zipy_il);
		
		//open aliExpress in a new tab, close its pop-up and change currency to NIS
		((JavascriptExecutor) driver).executeScript("window.open()");
		tabs = new ArrayList<String> (driver.getWindowHandles());			
		driver.switchTo().window(tabs.get(1));
				
		driver.get(ElementsWebsites.Aliexpress);
		if(!driver.findElements(By.xpath(ElementsBuying.Aliexpress_PopupClose)).isEmpty()) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Aliexpress_PopupClose))).click();
		}
		Functions.aliexpress_changeCurrency(driver);
		
		//back to the main tab with zipy site
		driver.switchTo().window(tabs.get(0));

	}
	
	
	@AfterClass	
	public static void cartEnding() throws InterruptedException {	
		// Closing all windows of the browser, opened by the test.
		driver.quit();			 
	}
	


}

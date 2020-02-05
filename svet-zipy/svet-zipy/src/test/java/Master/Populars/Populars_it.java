package Master.Populars;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import zipy_elements.*;

public class Populars_it extends Populars_MAIN {
		
	
	//Test - opening thumbnails in populars (Italy - aliExpress)
	@Test		
	public  void Tests_it_popularsThumbs() throws Exception {
		System.out.println("Running test for Italy site - aliExpress - populars thumbnails" );		

		//open the main  page
		Thread.sleep(1000);
		driver.get(ElementsWebsites.Zipy_it);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);


		//opening all thumbnails in different tabs and check their loading
		boolean fails = Functions.checkPopularTabs(driver, 6, ElementsThumbs.populars);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}
	
	//Test - opening thumbnails in populars (Italy - ebay)
	@Test		
	public  void Tests_it_popularsThumbs_ebay() throws Exception {
		System.out.println("Running test for Italy site - ebay - populars thumbnails" );		

		//open the main ebay page
		Thread.sleep(1000);
		driver.get(ElementsWebsites.Zipy_it_ebay);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);
		
		//opening all thumbnails in different tabs and check their loading
		boolean fails = Functions.checkPopularTabs(driver, 6, ElementsThumbs.populars);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}
	
	//Test - opening thumbnails in populars (Italy - amazon)
	@Test		
	public  void Tests_it_popularsThumbs_amazon() throws Exception {
		System.out.println("Running test for Italy site - amazon - populars thumbnails" );		

		//open the main amazon page
		Thread.sleep(1000);
		driver.get(ElementsWebsites.Zipy_it_amazon);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);

		//opening all thumbnails in different tabs and check their loading
		boolean fails = Functions.checkPopularTabs(driver, 6, ElementsThumbs.populars);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}

	
}

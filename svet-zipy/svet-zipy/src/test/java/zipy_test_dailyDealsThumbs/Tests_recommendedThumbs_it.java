package zipy_test_dailyDealsThumbs;
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

public class Tests_recommendedThumbs_it extends Tests_dailyDealsThumbs_MAIN {
		
	
	//Test - opening thumbnails in dailyDeal (Italy - aliExpress)
	@Test		
	public  void Tests_it_dailyDealThumbs() throws Exception {
		System.out.println("Running test for Italy site - aliExpress - dailyDeal thumbnails" );		

		//open the site
		Thread.sleep(1000);
		driver.get(ElementsWebsites.Zipy_it);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);
		
		//opening all thumbnails in different tabs, and counting the number of thumbnails that failed to open
		boolean fails = Tests_functions.checkDailyDealsTabs(driver, 8, ElementsRecommended.dailyDeal);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}
	
	//Test - opening thumbnails in dailyDeal (Italy - ebay)
	@Test		
	public  void Tests_it_dailyDealThumbs_ebay() throws Exception {
		System.out.println("Running test for Italy site - ebay - dailyDeal thumbnails" );		

		//open the site
		Thread.sleep(1000);
		driver.get(ElementsWebsites.Zipy_it_ebay);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);

		//opening all thumbnails in different tabs, and counting the number of thumbnails that failed to open
		boolean fails = Tests_functions.checkDailyDealsTabs(driver, 8, ElementsRecommended.dailyDeal);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}
	
	//Test - opening thumbnails in dailyDeal (Italy - amazon)
	@Test		
	public  void Tests_it_dailyDealThumbs_amazon() throws Exception {
		System.out.println("Running test for Italy site - amazon - dailyDeal thumbnails" );		

		//open the site
		Thread.sleep(1000);
		driver.get(ElementsWebsites.Zipy_it_amazon);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);		

		//opening all thumbnails in different tabs, and counting the number of thumbnails that failed to open
		boolean fails = Tests_functions.checkDailyDealsTabs(driver, 8, ElementsRecommended.dailyDeal);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}
	
}

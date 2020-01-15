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

public class Tests_recommendedThumbs_gr extends Tests_dailyDealsThumbs_MAIN {


	//Test - opening thumbnails in dailyDeal (Greece - aliExpress)
	@Test		
	public  void Tests_gr_dailyDealThumbs() throws Exception {
		System.out.println("Running test for Greece site - aliExpress - dailyDeal thumbnails" );		

		//open the site
		Thread.sleep(1000);
		driver.get(ElementsWebsites.Zipy_gr);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);
		
		//opening all thumbnails in different tabs, and counting the number of thumbnails that failed to open
		boolean fails = Tests_functions.checkDailyDealsTabs(driver, 8, ElementsRecommended.dailyDeal);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}
	
	//Test - opening thumbnails in dailyDeal (Greece - ebay)
	@Test		
	public  void Tests_gr_dailyDealThumbs_ebay() throws Exception {
		System.out.println("Running test for Greece site - ebay - dailyDeal thumbnails" );		

		//open the site
		Thread.sleep(1000);
		driver.get(ElementsWebsites.Zipy_gr_ebay);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);

		//opening all thumbnails in different tabs, and counting the number of thumbnails that failed to open
		boolean fails = Tests_functions.checkDailyDealsTabs(driver, 8, ElementsRecommended.dailyDeal);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}
	
	//Test - opening thumbnails in dailyDeal (Greece - amazon)
	@Test		
	public  void Tests_gr_dailyDealThumbs_amazon() throws Exception {
		System.out.println("Running test for Greece site - amazon - dailyDeal thumbnails" );		

		//open the site
		Thread.sleep(1000);
		driver.get(ElementsWebsites.Zipy_gr_amazon);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);		

		//opening all thumbnails in different tabs, and counting the number of thumbnails that failed to open
		boolean fails = Tests_functions.checkDailyDealsTabs(driver, 8, ElementsRecommended.dailyDeal);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}
	
}

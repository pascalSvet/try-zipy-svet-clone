package TestZipy.TestZipy_test_dailyDealsThumbs;
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

public class TestZipy_test_dailyDealsThumbs_ro extends TestZipy_test_dailyDealsThumbs_MAIN {
		
	
	
	//Test - opening thumbnails in dailyDeal (Test Romania - aliExpress)
	@Test		
	public  void TestZipy_test_ro_dailyDealThumbs() throws Exception {
		System.out.println("Running test for Test Romania site - aliExpress - dailyDeal thumbnails" );		

		//open the site
		Thread.sleep(1000);
		driver.get(ElementsWebsites.TestZipy_ro);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);
		
		//opening all thumbnails in different tabs, and counting the number of thumbnails that failed to open
		boolean fails = Tests_functions.checkDailyDealsTabs(driver, 8, ElementsRecommended.dailyDeal_tst);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}
	
	//Test - opening thumbnails in dailyDeal (Test Romania - ebay)
	@Test		
	public  void TestZipy_test_ro_dailyDealThumbs_ebay() throws Exception {
		System.out.println("Running test for Test Romania site - ebay - dailyDeal thumbnails" );		

		//open the site
		Thread.sleep(1000);
		driver.get(ElementsWebsites.TestZipy_ro_ebay);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);

		//opening all thumbnails in different tabs, and counting the number of thumbnails that failed to open
		boolean fails = Tests_functions.checkDailyDealsTabs(driver, 8, ElementsRecommended.dailyDeal_tst);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}
	
	//Test - opening thumbnails in dailyDeal (Test Romania - amazon)
	@Test		
	public  void TestZipy_test_ro_dailyDealThumbs_amazon() throws Exception {
		System.out.println("Running test for Test Romania site - amazon - dailyDeal thumbnails" );		

		//open the site
		Thread.sleep(1000);
		driver.get(ElementsWebsites.TestZipy_ro_amazon);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);		

		//opening all thumbnails in different tabs, and counting the number of thumbnails that failed to open
		boolean fails = Tests_functions.checkDailyDealsTabs(driver, 8, ElementsRecommended.dailyDeal_tst);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}
	
}

package Master.MainPageThumbs;
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

public class MainPageThumbs_gr extends MainPageThumbs_MAIN {


	//Test - opening main page thumbnails in Greece site
	@Test		
	public  void Tests_gr_dailyDealThumbs() throws Exception {
		System.out.println("Running test for opening main page thumbnails in Greece site" );		

		//open the site
		Thread.sleep(1000);
		driver.get(ElementsWebsites.Zipy_gr);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);
		
		//opening all thumbnails in different tabs, and check if any of them  failed to open
		boolean fails = Functions.checkThumbnailsInTabs(driver, 10, ElementsRecommended.mainPage);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}
	
	//Test - opening main page thumbnails in Greece site - ebay
	@Test		
	public  void Tests_gr_dailyDealThumbs_ebay() throws Exception {
		System.out.println("opening main page thumbnails in Greece site - ebay" );		

		//open the site
		Thread.sleep(1000);
		driver.get(ElementsWebsites.Zipy_gr_ebay);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);

		//opening all thumbnails in different tabs, and check if any of them  failed to open
		boolean fails = Functions.checkThumbnailsInTabs(driver, 10, ElementsRecommended.mainPage);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}
	
	//Test - opening main page thumbnails in Greece site - amazon
	@Test		
	public  void Tests_gr_dailyDealThumbs_amazon() throws Exception {
		System.out.println("opening main page thumbnails in Greece site - amazon" );		

		//open the site
		Thread.sleep(1000);
		driver.get(ElementsWebsites.Zipy_gr_amazon);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);		

		//opening all thumbnails in different tabs, and check if any of them  failed to open
		boolean fails = Functions.checkThumbnailsInTabs(driver, 10, ElementsRecommended.mainPage);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}
	
}

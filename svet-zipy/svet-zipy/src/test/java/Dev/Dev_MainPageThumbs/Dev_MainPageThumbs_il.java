package Dev.Dev_MainPageThumbs;
import java.util.ArrayList;
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

public class Dev_MainPageThumbs_il extends Dev_MainPageThumbs_MAIN {
	
	
	//Test - opening thumbnails in dailyDeal (Dev Israel - aliExpress)
	@Test		
	public  void DevZipy_test_il_dailyDealThumbs() throws Exception {
		System.out.println("Running test for Dev Israel site - aliExpress - dailyDeal thumbnails" );		

		//open the site
		Thread.sleep(1000);
		driver.get(ElementsWebsites.DevZipy_il);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);
		
		//opening all thumbnails in different tabs, and counting the number of thumbnails that failed to open
		boolean fails = Functions.checkThumbnailsInTabs(driver, 8, ElementsThumbs.dailyDeal);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}
	

}

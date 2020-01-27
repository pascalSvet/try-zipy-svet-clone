package Master.MainPageThumbs;
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

public class MainPageThumbs_il extends MainPageThumbs_MAIN {
	
	
	//Test - opening main page thumbnails in Israel site
	@Test		
	public  void Tests_il_dailyDealThumbs() throws Exception {
		System.out.println("Running test for opening main page thumbnails in Israel site" );		

		//open the site
		Thread.sleep(1000);
		driver.get(ElementsWebsites.Zipy_il_withPopup);
		Functions.closePopUp(driver);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);
		
		//opening all thumbnails in different tabs, and check if any of them  failed to open
		boolean fails = Functions.checkThumbnailsInTabs(driver, 10, ElementsRecommended.mainPage);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}
	

}

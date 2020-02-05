package Test.Test_Populars;
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

public class Test_Populars_pt extends Test_Populars_MAIN {
			
	
	//Test - opening thumbnails in populars (Test Portugal - aliExpress)
	@Test		
	public  void TestZipy_test_pt_popularsThumbs() throws Exception {
		System.out.println("Running test for Test Portugal site - aliExpress - populars thumbnails" );		

		//open the site
		Thread.sleep(1000);
		driver.get(ElementsWebsites.TestZipy_pt);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);


		//opening all thumbnails in different tabs, and counting the number of thumbnails that failed to open
		boolean fails = Functions.checkPopularTabs(driver, 6, ElementsThumbs.populars);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}
	
	//Test - opening thumbnails in populars (Test Portugal - ebay)
	@Test		
	public  void TestZipy_test_pt_popularsThumbs_ebay() throws Exception {
		System.out.println("Running test for Test Portugal site - ebay - populars thumbnails" );		

		//open the site
		Thread.sleep(1000);
		driver.get(ElementsWebsites.TestZipy_pt_ebay);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);
		
		//opening all thumbnails in different tabs, and counting the number of thumbnails that failed to open
		boolean fails = Functions.checkPopularTabs(driver, 6, ElementsThumbs.populars);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}
	
	//Test - opening thumbnails in populars (Test Portugal - amazon)
	@Test		
	public  void TestZipy_test_pt_popularsThumbs_amazon() throws Exception {
		System.out.println("Running test for Test Portugal site - amazon - populars thumbnails" );		

		//open the site
		Thread.sleep(1000);
		driver.get(ElementsWebsites.TestZipy_pt_amazon);
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);

		//opening all thumbnails in different tabs, and counting the number of thumbnails that failed to open
		boolean fails = Functions.checkPopularTabs(driver, 6, ElementsThumbs.populars);
		driver.switchTo().window(winHandleBefore);

		// if we managed to open all products correctly, there will be no fails:
		Assert.assertFalse(fails);
	}
	
	
}

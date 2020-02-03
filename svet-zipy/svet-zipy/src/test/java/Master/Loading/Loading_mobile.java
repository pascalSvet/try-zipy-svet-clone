package Master.Loading;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import zipy_elements.*;

public class Loading_mobile extends Loading_MAIN {
	

	//TestsMobile - updating of loader-spinner after clicking on another thumbnail
	@Test		
	public  void TestsMobile_loading_SpinnerPresent() throws Exception {
		System.out.println("Running test (in mobile version) for presence of loader-spinner on thumbnail click");		
		
		//change to mobile screen resolution
		driver.manage().window().setSize(new Dimension(320,480));
		
		//open the deals page
		driver.get(ElementsWebsites.Zipy_il_deals);
		
		//click on thumbnail and check its spinner element
		driver.findElement(By.xpath(ElementsRecommended.dailyDeal_3_thumbnail)).click();
		WebElement spinner = driver.findElement(By.xpath(ElementsRecommended.dailyDeal_3_spinner));
		
		//if correct, spinner displayed
		Assert.assertTrue(spinner.isDisplayed());	

		driver.findElement(By.xpath(ElementsBuying.ProductFramed_close)).click();

	}
	
	//TestsMobile - updating of loader-spinner after clicking on another thumbnail
	@Test		
	public  void TestsMobile_loading_SpinnerUpdate() throws Exception {
		System.out.println("Running test (in mobile version) for updating of loader-spinner after clicking on another thumbnail");		
		driver.manage().window().setSize(new Dimension(320,480));

		driver.get(ElementsWebsites.Zipy_il_deals);

		//click one thumbnail and then another one and check their spinner elements
		driver.findElement(By.xpath(ElementsRecommended.dailyDeal_3_thumbnail)).click();
		driver.findElement(By.xpath(ElementsRecommended.dailyDeal_4_thumbnail)).click();		

		WebElement spinner3 = driver.findElement(By.xpath(ElementsRecommended.dailyDeal_3_spinner));
		WebElement spinner4 = driver.findElement(By.xpath(ElementsRecommended.dailyDeal_4_spinner));
		
		//if correct, spinner displayed on the second thumbnail only
		Assert.assertTrue(!spinner3.isDisplayed() && spinner4.isDisplayed());
		

	}
}

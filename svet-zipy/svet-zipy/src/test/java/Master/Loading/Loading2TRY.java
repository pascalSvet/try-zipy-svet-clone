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

public class Loading2TRY extends Loading_MAIN {
	
	
	//Test - presence of loader-spinner on thumbnail click
	@Test		
	public  void Tests_loading_SpinnerPresent() throws Exception {
		System.out.println("Running test for presence of loader-spinner on thumbnail click");		
		
		//open the deals page
		act.open(ElementsWebsites.Zipy_il_deals, driver);

		//click on thumbnail and check its spinner element
		act.click(ElementsRecommended.dailyDeal_3_thumbnail, driver);
		
		//if correct, spinner displayed
		Assert.assertTrue(act.elementDisplayed(ElementsRecommended.dailyDeal_3_spinner, driver));	

	}
	

	//Test - updating of loader-spinner after clicking on another thumbnail
	@Test		
	public  void Tests_loading_SpinnerUpdate() throws Exception {
		System.out.println("Running test for updating of loader-spinner after clicking on another thumbnail");		
		
		//open the deals page
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

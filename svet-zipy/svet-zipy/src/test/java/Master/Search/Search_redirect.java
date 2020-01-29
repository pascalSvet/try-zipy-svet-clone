package Master.Search;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import zipy_elements.*;

public class Search_redirect extends Search_MAIN {
	
	//Test - redirecting search results from amazon to other, if nothing found
	@Test		
	public  void Tests_Search_redirect_Amazon() throws Exception {
		System.out.println("Running test for redirecting search results from amazon to other , if nothing found");		
		
		driver.get(ElementsWebsites.Zipy_il_amazon);

		// perform search for a product that is definitely not on the site
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_itemOnAliexpressOnly, Keys.ENTER);
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(ElementsWebsites.Zipy_il_amazon_withPopup)));
		
		//if replaced, there is an appropriate message
		Assert.assertFalse(driver.findElements(By.xpath(ElementsBuying.Search_redirect)).isEmpty());	
	}
	
	
	//Test - redirecting search results from ebay to other, if nothing found, when smart search is off
	@Test		
	public  void Tests_Search_redirect_Ebay() throws Exception {
		System.out.println("Running test for redirecting search results from ebay to other, if nothing found");		
		
		driver.get(ElementsWebsites.Zipy_gr_ebay);

		// perform search for a product that is definitely not on the site
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_itemOnAliexpressOnly, Keys.ENTER);
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(ElementsWebsites.Zipy_gr_ebay_withPopup)));
		
		//turn off smart search
		String oldUrl = driver.getCurrentUrl();
		driver.findElement(By.xpath(ElementsBuying.Search_smartSearchButton)).click();
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl)));

		//if replaced, there is an appropriate message
		Assert.assertFalse(driver.findElements(By.xpath(ElementsBuying.Search_redirect)).isEmpty());	
	}

	
	//Test - redirecting search results from ebay to other, more suitable, when smart search is on
	@Test		
	public  void Tests_Search_redirect_Ebay_smartSearch() throws Exception {
		System.out.println("Running test for redirecting search results from ebay to other, more suitable, when smart search is on");		
		
		driver.get(ElementsWebsites.Zipy_gr_ebay);

		// perform search for a product that is definitely not on the site
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_itemEverywhere, Keys.ENTER);
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(ElementsWebsites.Zipy_gr_ebay_withPopup)));
		
		//turn off smart search
		String oldUrl = driver.getCurrentUrl();
		driver.findElement(By.xpath(ElementsBuying.Search_smartSearchButton)).click();
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl)));
		oldUrl = driver.getCurrentUrl();
		//turn it on back
		driver.findElement(By.xpath(ElementsBuying.Search_smartSearchButton)).click();
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl)));


		//if replaced, there is an appropriate message
		Assert.assertTrue(driver.findElements(By.xpath(ElementsBuying.Search_redirect)).isEmpty());	
	}	
	
	
	//Test - redirecting search results from aliExpress to other, if nothing found
	@Test		
	public  void Tests_Search_redirect_AliExpress() throws Exception {
		System.out.println("Running test for redirecting search results from aliExpress to other, if nothing found");		
		
		driver.get(ElementsWebsites.Zipy_gr_ali);

		// perform search for a product that is definitely not on the site
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_itemNotOnAliexpress, Keys.ENTER);
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(ElementsWebsites.Zipy_gr_ali_withPopup)));

		//if replaced, there is an appropriate message
		Assert.assertFalse(driver.findElements(By.xpath(ElementsBuying.Search_redirect)).isEmpty());	
	}

	

	
}

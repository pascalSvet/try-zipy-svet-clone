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

public class Search_links extends Search_MAIN {
	
	
	//Test - searching on Israel site - link from aliExpress
	@Test		
	public  void Tests_Search_links_il_aliExpress() throws Exception {
		System.out.println("Running test for searching in Israel site - link from aliExpress");		
		
		//open product on aliExpress and save its title
		driver.get(ElementsBuying.Search_link_aliExpress);
		
		String titleOnAliexpress = act.elementText(ElementsBuying.Search_link_aliExpress_title, driver);

		// search by the link on zipy, open the product and save its title 
		driver.get(ElementsWebsites.Zipy_il);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_link_aliExpress, Keys.ENTER);
		act.waitForUrlChange(ElementsWebsites.Zipy_il_withPopup, driver);
		
		String titleOnzipy = act.elementAttText(ElementsBuying.Product_titleFromPicture, "alt", driver);

		//if search succeed, the product we found on zipy is the same from aliExpress
		Assert.assertTrue(titleOnAliexpress.equals(titleOnzipy));	

	}


	//Test - searching on Israel site - link from ebay
	@Test		
	public  void Tests_Search_links_il_ebay() throws Exception {
		System.out.println("Running test for searching in Israel site - link from ebay");		
		
		//open product on ebay and save its title
		driver.get(ElementsBuying.Search_link_ebay);
		String titleOnEbay = act.elementAttText(ElementsBuying.Search_link_ebay_title, "content", driver);

		// search by the link on zipy, open the product and save its title 
		driver.get(ElementsWebsites.Zipy_il);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_link_ebay, Keys.ENTER);
		act.waitForUrlChange(ElementsWebsites.Zipy_il_withPopup, driver);
		
		String titleOnzipy = act.elementAttText(ElementsBuying.Product_titleFromPicture, "alt", driver);

		//if search succeed, the product we found on zipy is the same from ebay
		Assert.assertTrue(titleOnEbay.equals(titleOnzipy));	

	}
	
	//Test - searching on Israel site - link from amazon
	@Test		
	public  void Tests_Search_links_il_amazon() throws Exception {
		System.out.println("Running test for searching in Israel site - link from amazon");		
		
		//open product on amazon and save its title
		driver.get(ElementsBuying.Search_link_amazon);
		String titleOnamazon = act.elementText(ElementsBuying.Search_link_amazon_title, driver);

		// search by the link on zipy, open the product and save its title 
		driver.get(ElementsWebsites.Zipy_il);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_link_amazon, Keys.ENTER);
		act.waitForUrlChange(ElementsWebsites.Zipy_il_withPopup, driver);
		
		String titleOnzipy = act.elementAttText(ElementsBuying.Search_link_amazon_zipyTitle, "content", driver);

		//if search succeed, the product we found on zipy is the same from amazon
		Assert.assertTrue(titleOnamazon.equals(titleOnzipy));	

	}


	//Test - searching on Greece site - link from aliExpress
	@Test		
	public  void Tests_Search_links_gr_aliExpress() throws Exception {
		System.out.println("Running test for searching in Greece site - link from aliExpress");		
		
		//open product on aliExpress and save its title
		driver.get(ElementsBuying.Search_link_aliExpress);
		String titleOnAliexpress = act.elementText(ElementsBuying.Search_link_aliExpress_title, driver);

		// search by the link on zipy, open the product and save its title 
		driver.get(ElementsWebsites.Zipy_gr);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_link_aliExpress, Keys.ENTER);		
		act.waitForUrlChange(ElementsWebsites.Zipy_gr_withPopup, driver);
	
		String titleOnzipy = act.elementAttText(ElementsBuying.Product_titleFromPicture, "alt", driver);

		//if search succeed, the product we found on zipy is the same from aliExpress
		Assert.assertTrue(titleOnAliexpress.equals(titleOnzipy));	

	}
	
	//Test - searching on Greece site - link from ebay.de
	@Test		
	public  void Tests_Search_links_gr_ebayDe() throws Exception {
		System.out.println("Running test for searching in Greece site - link from ebay.de");		
		
		//open product on ebay.de and save its title
		driver.get(ElementsBuying.Search_link_ebayDE);
		
		String titleOnEbay = act.elementAttText(ElementsBuying.Search_link_ebayDY_title, "content", driver);

		// search by the link on zipy, open the product and save its title 
		driver.get(ElementsWebsites.Zipy_gr);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_link_ebayDE, Keys.ENTER);
		act.waitForUrlChange(ElementsWebsites.Zipy_gr_withPopup, driver);
		
		String titleOnzipy = act.elementAttText(ElementsBuying.Product_titleFromPicture, "alt", driver);

		//if search succeed, the product we found on zipy is the same from ebay.de
		Assert.assertTrue(titleOnEbay.equals(titleOnzipy));	

	}

	//Test - searching on Greece site - link from amazon.de
	@Test		
	public  void Tests_Search_links_gr_amazonDE() throws Exception {
		System.out.println("Running test for searching in Greece site - link from amazon.de");		
		
		//open product on amazon.de and save its title
		driver.get(ElementsBuying.Search_link_amazonDE);
		String titleOnamazon = act.elementText(ElementsBuying.Search_link_amazon_title, driver);

		// search by the link on zipy, open the product and save its title 
		driver.get(ElementsWebsites.Zipy_gr);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_link_amazonDE, Keys.ENTER);
		act.waitForUrlChange(ElementsWebsites.Zipy_gr_withPopup, driver);
		
		String titleOnzipy = act.elementAttText(ElementsBuying.Search_link_amazon_zipyTitle, "content", driver);

		//if search succeed, the product we found on zipy is the same from amazon.de
		Assert.assertTrue(titleOnamazon.equals(titleOnzipy));	

	}
	
}

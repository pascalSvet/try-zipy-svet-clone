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

public class Search_field extends Search_MAIN {
	
	//Test - clearing search field
	@Test		
	public  void Tests_Search_field_clear() throws Exception {
		System.out.println("Running test for clearing search field");		
		
		//open main page
		driver.get(ElementsWebsites.Zipy_il);

		// enter search keyword and then clear the field
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng);
		act.click(ElementsBuying.Search_delete, driver);
		
		String searchField = act.elementAttText(ElementsBuying.Search_content, "value", driver); 

		//if succeed, then the field will be empty
		Assert.assertTrue("".equals(searchField));	
	}
	
	
	//Test - performing empty search
	@Test		
	public  void Tests_Search_field_emptyField() throws Exception {
		System.out.println("Running test for performing empty search");		
		
		//open main page
		driver.get(ElementsWebsites.Zipy_il);

		// enter search keyword and then clear the field
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys("", Keys.ENTER);
		String searchField = act.elementAttText(ElementsBuying.Search_content, "value", driver); 
		String searchFieldMessage = driver.findElement(By.id("desktop_search_fild")).getAttribute("class"); 

		//if succeed, then the field will be empty and the "type a product name" message will shake
		Assert.assertTrue("shake".equals(searchFieldMessage) && "".equals(searchField));	
	}

		
	//Test - opening of dropdown autocomplete menu
	@Test		
	public  void Tests_Search_field_dropdownOpen() throws Exception {
		System.out.println("Running test for opening of dropdown autocomplete menu");		
		
		//open main page
		driver.get(ElementsWebsites.Zipy_il);

		// enter search keyword
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng);

		//if succeed, then a dropdown menu with autocomplete hints will open
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Search_autocompleteArrow1)).isDisplayed());	
	}
	
	
	//Test - closing of dropdown autocomplete menu after clearing the search field
	@Test		
	public  void Tests_Search_field_dropdownClose() throws Exception {
		System.out.println("Running test for closing of dropdown autocomplete menu after clearing the search field");		
		
		//open main page
		driver.get(ElementsWebsites.Zipy_il);

		// enter search keyword
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng);
		
		//clear the search field
		act.waitForPresence(ElementsBuying.Search_autocompleteArrow1, driver);
		act.click(ElementsBuying.Search_delete, driver);
		Thread.sleep(1000);
		
		//if succeed, then a dropdown menu will close
		Assert.assertFalse(act.elementDisplayed(ElementsBuying.Search_autocompleteArrow1, driver));	
	}

	
	//Test - performing search with autocomplete hint
	@Test		
	public  void Tests_Search_field_autocomplete() throws Exception {
		System.out.println("Running test for performing search with autocomplete hint");		
		
		//open main page
		driver.get(ElementsWebsites.Zipy_il);

		// enter search keyword
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng);

		//choose the first hint and save its name
		String hint1 = act.elementText(ElementsBuying.Search_autocompleteHint1, driver);
		act.click(ElementsBuying.Search_autocompleteArrow1, driver);
		act.click(ElementsBuying.Search_button, driver);
		
		//save the new search name
		act.waitForUrlChange(ElementsWebsites.Zipy_il_withPopup, driver);
		String searchField = act.elementAttText(ElementsBuying.Search_content, "value", driver); 

		//if search succeed correctly, the search field contains the hint and there is option for ordering the results
		Assert.assertTrue( hint1.equals(searchField) && act.elementExist(ElementsBuying.Product_sortBy, driver) );					
	}
	
	
	//Test - keeping the keyword in search field after switching to amazon
	@Test		
	public  void Tests_Search_field_keepSearchForAmazon() throws Exception {
		System.out.println("Running test for keeping the keyword search field after switching to amazon");		
		
		//open main page
		driver.get(ElementsWebsites.Zipy_il);

		// enter search keyword
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng, Keys.ENTER);
		
		//switch to amazon
		act.click(ElementsWebsites.Zipy_il_amazonButton, driver);
		act.waitForUrlChange(ElementsWebsites.Zipy_il_withPopup, driver);
		String searchField = act.elementAttText(ElementsBuying.Search_content, "value", driver); 

		//if succeed, then a search field will keep the keyword
		Assert.assertTrue(ElementsBuying.Search_eng.equals(searchField));	
	}

	
	//Test - keeping the keyword search after switching to ebay
	@Test		
	public  void Tests_Search_field_keepSearchForEbay() throws Exception {
		System.out.println("Running test for keeping the keyword search after switching to ebay");		
		
		//open main page
		driver.get(ElementsWebsites.Zipy_il);

		// enter search keyword
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng, Keys.ENTER);
		
		//switch to ebay
		act.click(ElementsWebsites.Zipy_il_ebayButton, driver);	
		act.waitForUrlChange(ElementsWebsites.Zipy_il_withPopup, driver);
		String searchField = act.elementAttText(ElementsBuying.Search_content, "value", driver); 

		//if succeed, then a search field will keep the keyword
		Assert.assertTrue(ElementsBuying.Search_eng.equals(searchField));	
	}

	
	//Test - keeping the keyword search after switching to Less-than-5
	@Test		
	public  void Tests_Search_field_keepSearchForLessthan5() throws Exception {
		System.out.println("Running test for keeping the keyword search after switching to Less-than-5");		
		
		//open main page
		driver.get(ElementsWebsites.Zipy_il);

		// enter search keyword
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng, Keys.ENTER);

		//switch to Less-than-5
		act.click(ElementsWebsites.Zipy_il_lessThan5Button, driver); 
		act.waitForUrlChange(ElementsWebsites.Zipy_il_withPopup, driver);
		String searchField = act.elementAttText(ElementsBuying.Search_content, "value", driver); 

		//if succeed, then a search field will keep the keyword
		Assert.assertTrue(ElementsBuying.Search_eng.equals(searchField));	

	}
	
	
	//Test - clearing the keyword in search field after switching to amazon
	@Test		
	public  void Tests_Search_field_clearSearchForAmazon() throws Exception {
		System.out.println("Running test for clearing the keyword search field after switching to amazon");		
		
		//open main page
		driver.get(ElementsWebsites.Zipy_il);

		//perform search and then clear the field
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng, Keys.ENTER);
		act.click(ElementsBuying.Search_delete, driver);

		//switch to amazon
		act.click(ElementsWebsites.Zipy_il_amazonButton, driver);	
		act.waitForUrlChange(ElementsWebsites.Zipy_il_withPopup, driver);
		String searchField = act.elementAttText(ElementsBuying.Search_content, "value", driver); 

		//if succeed, then a search field will be empty
		Assert.assertTrue("".equals(searchField));	

	}
	
	
	//Test - clearing the keyword search after switching to ebay
	@Test		
	public  void Tests_Search_field_clearSearchForEbay() throws Exception {
		System.out.println("Running test for clearing the keyword search after switching to ebay");		
		
		//open main page
		driver.get(ElementsWebsites.Zipy_il);

		//perform search and then clear the field
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng, Keys.ENTER);
		act.click(ElementsBuying.Search_delete, driver);
		
		//switch to ebay
		driver.findElement(By.xpath(ElementsWebsites.Zipy_il_ebayButton)).click();	
		act.waitForUrlChange(ElementsWebsites.Zipy_il_withPopup, driver);
		String searchField = act.elementAttText(ElementsBuying.Search_content, "value", driver); 

		//if succeed, then a search field will be empty
		Assert.assertTrue("".equals(searchField));	
	}

	
	//Test - clearing the keyword search after switching to Less-than-5
	@Test		
	public  void Tests_Search_field_clearSearchForLessthan5() throws Exception {
		System.out.println("Running test for clearing the keyword search after switching to Less-than-5");		
		
		//open main page
		driver.get(ElementsWebsites.Zipy_il);

		//perform search and then clear the field
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng, Keys.ENTER);
		act.click(ElementsBuying.Search_delete, driver);

		//switch to Less-than-5
		act.click(ElementsWebsites.Zipy_il_lessThan5Button, driver);
		act.waitForUrlChange(ElementsWebsites.Zipy_il_withPopup, driver);
		String searchField = act.elementAttText(ElementsBuying.Search_content, "value", driver); 

		//if succeed, then a search field will be empty
		Assert.assertTrue("".equals(searchField));	
	}
	
}

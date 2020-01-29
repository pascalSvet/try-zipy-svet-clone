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
		
		driver.get(ElementsWebsites.Zipy_il);

		// enter search keyword and then clear the field
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng);
		driver.findElement(By.xpath(ElementsBuying.Search_delete)).click();
		String serchField = driver.findElement(By.xpath(ElementsBuying.Search_content)).getAttribute("value"); 

		//if succeed, then a dropdown menu with autocomplete hints will open
		Assert.assertTrue("".equals(serchField));	
	}
	
	
	//Test - opening of dropdown autocomplete menu
	@Test		
	public  void Tests_Search_field_dropdownOpen() throws Exception {
		System.out.println("Running test for opening of dropdown autocomplete menu");		
		
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
		
		driver.get(ElementsWebsites.Zipy_il);

		// enter search keyword
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Search_autocompleteArrow1)));
		driver.findElement(By.xpath(ElementsBuying.Search_delete)).click();
		Thread.sleep(1000);
		
		//if succeed, then a dropdown menu will close
		Assert.assertTrue(!driver.findElement(By.xpath(ElementsBuying.Search_autocompleteArrow1)).isDisplayed());	
	}

	
	//Test - performing search with autocomplete hint
	@Test		
	public  void Tests_Search_field_autocomplete() throws Exception {
		System.out.println("Running test for performing search with autocomplete hint");		
		
		driver.get(ElementsWebsites.Zipy_il);

		// enter search keyword
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng);

		//choose the first hint and save its name
		String hint1 = driver.findElement(By.xpath(ElementsBuying.Search_autocompleteHint1)).getText().trim();
		driver.findElement(By.xpath(ElementsBuying.Search_autocompleteArrow1)).click();
		driver.findElement(By.xpath(ElementsBuying.Search_button)).click();
		
		//save the new search name
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(ElementsWebsites.Zipy_il_withPopup)));
		String serchField = driver.findElement(By.xpath(ElementsBuying.Search_content)).getAttribute("value"); 

		
		System.out.println(hint1);
		System.out.println(serchField);

		//if search succeed correctly, the search field contains the hint and there is option for ordering the results
		Assert.assertTrue( hint1.equals(serchField) &&
				!driver.findElements(By.xpath(ElementsBuying.Product_sortBy)).isEmpty() );	
	}
	
	
	//Test - keeping the keyword in search field after switching to amazon
	@Test		
	public  void Tests_Search_field_keepSearchForAmazon() throws Exception {
		System.out.println("Running test for keeping the keyword search field after switching to amazon");		
		
		driver.get(ElementsWebsites.Zipy_il);

		// enter search keyword
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng, Keys.ENTER);
		
		driver.findElement(By.xpath(ElementsWebsites.Zipy_il_amazonButton)).click();	
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(ElementsWebsites.Zipy_il_withPopup)));
		String serchField = driver.findElement(By.xpath(ElementsBuying.Search_content)).getAttribute("value"); 

		//if succeed, then a search field will keep the keyword
		Assert.assertTrue(ElementsBuying.Search_eng.equals(serchField));	
	}

	
	//Test - keeping the keyword search after switching to ebay
	@Test		
	public  void Tests_Search_field_keepSearchForEbay() throws Exception {
		System.out.println("Running test for keeping the keyword search after switching to ebay");		
		
		driver.get(ElementsWebsites.Zipy_il);

		// enter search keyword
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng, Keys.ENTER);
		
		driver.findElement(By.xpath(ElementsWebsites.Zipy_il_ebayButton)).click();	
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(ElementsWebsites.Zipy_il_withPopup)));
		String serchField = driver.findElement(By.xpath(ElementsBuying.Search_content)).getAttribute("value"); 

		//if succeed, then a search field will keep the keyword
		Assert.assertTrue(ElementsBuying.Search_eng.equals(serchField));	
	}

	
	//Test - keeping the keyword search after switching to Less-than-5
	@Test		
	public  void Tests_Search_field_keepSearchForLessthan5() throws Exception {
		System.out.println("Running test for keeping the keyword search after switching to Less-than-5");		
		
		driver.get(ElementsWebsites.Zipy_il);

		// enter search keyword
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng, Keys.ENTER);
		
		driver.findElement(By.xpath(ElementsWebsites.Zipy_il_lessThan5Button)).click();	
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(ElementsWebsites.Zipy_il_withPopup)));
		String serchField = driver.findElement(By.xpath(ElementsBuying.Search_content)).getAttribute("value"); 

		//if succeed, then a search field will keep the keyword
		Assert.assertTrue(ElementsBuying.Search_eng.equals(serchField));	

	}
	
	
	//Test - clearing the keyword in search field after switching to amazon
	@Test		
	public  void Tests_Search_field_clearSearchForAmazon() throws Exception {
		System.out.println("Running test for clearing the keyword search field after switching to amazon");		
		
		driver.get(ElementsWebsites.Zipy_il);

		//perform search and then clear the field
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng, Keys.ENTER);
		driver.findElement(By.xpath(ElementsBuying.Search_delete)).click();

		driver.findElement(By.xpath(ElementsWebsites.Zipy_il_amazonButton)).click();	
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(ElementsWebsites.Zipy_il_withPopup)));
		String serchField = driver.findElement(By.xpath(ElementsBuying.Search_content)).getAttribute("value"); 

		//if succeed, then a search field will keep the keyword
		Assert.assertTrue("".equals(serchField));	

	}
	
	
	//Test - clearing the keyword search after switching to ebay
	@Test		
	public  void Tests_Search_field_clearSearchForEbay() throws Exception {
		System.out.println("Running test for clearing the keyword search after switching to ebay");		
		
		driver.get(ElementsWebsites.Zipy_il);

		//perform search and then clear the field
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng, Keys.ENTER);
		driver.findElement(By.xpath(ElementsBuying.Search_delete)).click();

		driver.findElement(By.xpath(ElementsWebsites.Zipy_il_ebayButton)).click();	
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(ElementsWebsites.Zipy_il_withPopup)));
		String serchField = driver.findElement(By.xpath(ElementsBuying.Search_content)).getAttribute("value"); 

		//if succeed, then a search field will keep the keyword
		Assert.assertTrue("".equals(serchField));	
	}

	
	//Test - clearing the keyword search after switching to Less-than-5
	@Test		
	public  void Tests_Search_field_clearSearchForLessthan5() throws Exception {
		System.out.println("Running test for clearing the keyword search after switching to Less-than-5");		
		
		driver.get(ElementsWebsites.Zipy_il);

		//perform search and then clear the field
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng, Keys.ENTER);
		driver.findElement(By.xpath(ElementsBuying.Search_delete)).click();

		driver.findElement(By.xpath(ElementsWebsites.Zipy_il_lessThan5Button)).click();	
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(ElementsWebsites.Zipy_il_withPopup)));
		String serchField = driver.findElement(By.xpath(ElementsBuying.Search_content)).getAttribute("value"); 

		//if succeed, then a search field will keep the keyword
		Assert.assertTrue("".equals(serchField));	
	}
	
}

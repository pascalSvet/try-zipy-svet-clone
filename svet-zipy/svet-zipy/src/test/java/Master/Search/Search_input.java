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

public class Search_input extends Search_MAIN {
	
	
	//Test - searching in Israel site - in english
	@Test		
	public  void Tests_Search_il_eng() throws Exception {
		System.out.println("Running test for searching in Israel site - in english");		
		
		driver.get(ElementsWebsites.Zipy_il);

		// perform search and open the product
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng, Keys.ENTER);

		//if search succeed, there is option for ordering the results
		Assert.assertFalse(driver.findElements(By.xpath(ElementsBuying.Product_sortBy)).isEmpty());	

	}
	
	//Test - searching in Israel site - in hebrew
	@Test		
	public  void Tests_Search_il_native() throws Exception {
		System.out.println("Running test for searching in Israel site - in hebrew");		
		
		driver.get(ElementsWebsites.Zipy_il);

		// perform search and open the product
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_heb, Keys.ENTER);

		//if search succeed, there is option for ordering the results
		Assert.assertFalse(driver.findElements(By.xpath(ElementsBuying.Product_sortBy)).isEmpty());	

	}
	
	//Test - searching in Portugal site - in english
	@Test		
	public  void Tests_Search_pt_eng() throws Exception {
		System.out.println("Running test for searching in Portugal site - in english");		
		
		driver.get(ElementsWebsites.Zipy_il);

		// perform search and open the product
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_eng, Keys.ENTER);

		//if search succeed, there is option for ordering the results
		Assert.assertFalse(driver.findElements(By.xpath(ElementsBuying.Product_sortBy)).isEmpty());	

	}
		
	//Test - searching in Portugal site - in portuguese with special characters
	@Test		
	public  void Tests_Search_pt_native1() throws Exception {
		System.out.println("Running test for searching in Portugal site - in portuguese with special characters");		
		
		driver.get(ElementsWebsites.Zipy_pt);

		// perform search with the first part of special characters in portuguesep
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_pt1, Keys.ENTER);
		Boolean firstPart = driver.findElements(By.xpath(ElementsBuying.Product_sortBy)).isEmpty();
		
		// perform another search with the second part of special characters in portuguese
		driver.get(ElementsWebsites.Zipy_pt);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_pt2, Keys.ENTER);
		Boolean secondPart = driver.findElements(By.xpath(ElementsBuying.Product_sortBy)).isEmpty();
		
		//if search succeed, there is option for ordering the results in both cases
		Assert.assertFalse(firstPart && secondPart);	

	}
	

	//Test - searching with special signs - apostrophe
	@Test		
	public  void Tests_Search_specialSigns_apostrophe() throws Exception {
		System.out.println("Running test for searching with special signs - apostrophe");		
		
		driver.get(ElementsWebsites.Zipy_il);

		// perform search and open the product
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_special_apostrophe, Keys.ENTER);

		String serchField = driver.findElement(By.xpath(ElementsBuying.Search_content)).getAttribute("value"); 
		
		//if search succeed correctly, the element we were looking for did not change, and there is option for ordering the results
		Assert.assertTrue(serchField.equals(ElementsBuying.Search_special_apostrophe) &&
						!driver.findElements(By.xpath(ElementsBuying.Product_sortBy)).isEmpty() );	

	}
	
	//Test - searching with special signs - dash
	@Test		
	public  void Tests_Search_specialSigns_dash() throws Exception {
		System.out.println("Running test for searching with special signs - dash");		
		
		driver.get(ElementsWebsites.Zipy_il);

		// perform search and open the product
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_special_dash, Keys.ENTER);

		String serchField = driver.findElement(By.xpath(ElementsBuying.Search_content)).getAttribute("value"); 
				
		//if search succeed correctly, the element we were looking for did not change, and there is option for ordering the results
		Assert.assertTrue(serchField.equals(ElementsBuying.Search_special_dash) &&
						!driver.findElements(By.xpath(ElementsBuying.Product_sortBy)).isEmpty() );	

	}
	
	
	//Test - searching with special signs - parenthesis
	@Test		
	public  void Tests_Search_specialSigns_parenthesis() throws Exception {
		System.out.println("Running test for searching with special signs - parenthesis");		
		
		driver.get(ElementsWebsites.Zipy_il);

		// perform search and open the product
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_special_parenthesis, Keys.ENTER);

		String serchField = driver.findElement(By.xpath(ElementsBuying.Search_content)).getAttribute("value"); 
				
		//if search succeed correctly, the element we were looking for did not change, and there is option for ordering the results
		Assert.assertTrue(serchField.equals(ElementsBuying.Search_special_parenthesis) &&
						!driver.findElements(By.xpath(ElementsBuying.Product_sortBy)).isEmpty() );	

	}
	
	//Test - searching with special signs - bracket
	@Test		
	public  void Tests_Search_specialSigns_bracket() throws Exception {
		System.out.println("Running test for searching with special signs - bracket");		
		
		driver.get(ElementsWebsites.Zipy_il);

		// perform search and open the product
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.Search_special_bracket, Keys.ENTER);

		String serchField = driver.findElement(By.xpath(ElementsBuying.Search_content)).getAttribute("value"); 
				
		//if search succeed correctly, the element we were looking for did not change, and there is option for ordering the results
		Assert.assertTrue(serchField.equals(ElementsBuying.Search_special_bracket) &&
						!driver.findElements(By.xpath(ElementsBuying.Product_sortBy)).isEmpty() );	

	}
}

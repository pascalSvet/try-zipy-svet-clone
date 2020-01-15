package zipy_test_favs;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import zipy_elements.*;

public class Tests_favorites extends Tests_favs_MAIN {
	
	
	//Test - adding a product to the cart (product without variations)
	@Test		
	public  void Tests_favorites_pinIcon_DailyDealThumb() throws Exception {
		System.out.println("Running test for appearance of favorite-pin icon on the daiy deals thumbnail, on mouse hover");		
		
		driver.get(ElementsWebsites.Zipy_il_deals_ebay);
		
		//move mouse over the thumbnail
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsRecommended.dailyDeal_onPage))).build().perform();;

		// if correct, the pin button is visible:
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Product_PinThumbIcon)).isDisplayed());				
	}
	
	@Test		
	public  void Tests_favorites_pinIcon_addToFavorites() throws Exception {
		System.out.println("Running test for adding to favorites with favorite-pin icon on the daiy deals thumbnail");		
		
		driver.get(ElementsWebsites.Zipy_il_deals_ebay);
		
		//click the pin button on the thumbnail
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsRecommended.dailyDeal_onPage)))
		.moveToElement(driver.findElement(By.xpath(ElementsBuying.Product_PinThumbIcon))).click().build().perform();

		//open the product to save its title
		Thread.sleep(1000);
		driver.findElement(By.xpath(ElementsRecommended.dailyDeal_onPage)).click();
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");

		
		// open the favorites window
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesButton)).click();
		WebElement favoritesFrame = driver.findElement(By.xpath(ElementsBuying.Product_favoritesFrame));
		wait.until(ExpectedConditions.elementToBeClickable(favoritesFrame));
		
		// if correct, the product title will be found in the favorites window:
		Assert.assertTrue(favoritesFrame.getText().contains(ProductTitle) );
		
		//at the end, remove the products from the favorites, for the future tests		
		Tests_functions.emptyFavorites(driver);		
		
	}
	

}

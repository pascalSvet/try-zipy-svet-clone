package zipy_test_favs;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import zipy_elements.*;

public class Tests_favorites extends Tests_favs_MAIN {
	
	
	//Test - appearance of favorite-pin icon on the daiy deals thumbnail, on mouse hover
	@Test		
	public  void Tests_favorites_pinIcon_DailyDealThumb() throws Exception {
		System.out.println("Running test for appearance of favorite-pin icon on the daiy deals thumbnail, on mouse hover");		
		
		driver.get(ElementsWebsites.Zipy_il_deals);
		
		//move mouse over the thumbnail
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsRecommended.dailyDeal_onPage))).build().perform();;

		// if correct, the pin button is visible:
		Assert.assertTrue(driver.findElement(By.xpath(ElementsRecommended.Product_PinThumbIcon)).isDisplayed());				
	}

	
	//Test - colors of the pin-favorite button
	@Test		
	public  void Tests_favorites_pinIcon_colors() throws Exception {
		System.out.println("Running test for appearance of favorite-pin icon on the daiy deals thumbnail, on mouse hover");		
		
		driver.get(ElementsWebsites.Zipy_il_deals);
		
		//move mouse over the thumbnail
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsRecommended.dailyDeal_onPage))).build().perform();;

		//save the color of pin icon, click it and save the new color
		String colorUnselected = driver.findElement(By.xpath(ElementsRecommended.Product_PinThumbIcon_colorUnselected)).getAttribute("class");
		driver.findElement(By.xpath(ElementsRecommended.Product_PinThumbIcon)).click();		
		Thread.sleep(1000);
		String colorSelected = driver.findElement(By.xpath(ElementsRecommended.Product_PinThumbIcon_colorSelected)).getAttribute("class");
		
		// if correct, the unselected color is grey and the selected color is pink:
		Assert.assertTrue(colorUnselected.contains("grey") && colorSelected.contains("pink"));	
		
		//at the end, remove the product from the favorites, for the future tests		
		driver.findElement(By.xpath(ElementsRecommended.Product_PinThumbIcon_Selected)).click();		
	}
	
	
	//Test - adding to favorites from daiy deals thumbnail, with favorite-pin icon
	@Test		
	public  void Tests_favorites_add_fromDealsThumb() throws Exception {
		System.out.println("Running test for adding to favorites from daiy deals thumbnail, with favorite-pin icon");		
		
		driver.get(ElementsWebsites.Zipy_il_deals);
		
		//click the pin button on the thumbnail
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsRecommended.dailyDeal_onPage)))
		.moveToElement(driver.findElement(By.xpath(ElementsRecommended.Product_PinThumbIcon))).click().build().perform();

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
		Tests_functions.emptyFavoritesOneItem(driver);		
		
	}
	
	
	//Test - adding to favorites from the product page
	@Test		
	public  void Tests_favorites_add_fromProductPage() throws Exception {
		System.out.println("Running test for adding product to favorites from the product page");		

		//get to the required product page and save its title
		driver.get(ElementsBuying.Product_noVariations);
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");
		
		//add to the favorites
		driver.findElement(By.xpath(ElementsBuying.Product_pin)).click();

		// open the favorites window
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesButton)).click();
		WebElement favoritesFrame = driver.findElement(By.xpath(ElementsBuying.Product_favoritesFrame));
		wait.until(ExpectedConditions.elementToBeClickable(favoritesFrame));
		
		// if correct, the product title will be found in the favorites window:
		Assert.assertTrue(favoritesFrame.getText().contains(ProductTitle) );
		
		//at the end, remove the products from the favorites, for the future tests		
		Tests_functions.emptyFavoritesOneItem(driver);						
	}

	//Test - adding to favorites from the product pop-up page
	@Test		
	public  void Tests_favorites_add_fromProductPopupPage() throws Exception {
		System.out.println("Running test for adding product to favorites from the product pop-up page");		

		//open one of the products on the main page and save its name
		driver.get(ElementsWebsites.Zipy_il);
		driver.findElement(By.xpath(ElementsRecommended.dailyDeal_3)).click();
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");
		
		//add to favorites
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesButton_popup)).click();
			
		// open the favorites window
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesButton)).click();
		WebElement favoritesFrame = driver.findElement(By.xpath(ElementsBuying.Product_favoritesFrame));
		wait.until(ExpectedConditions.elementToBeClickable(favoritesFrame));
		
		// if correct, the product title will be found in the favorites window:
		Assert.assertTrue(favoritesFrame.getText().contains(ProductTitle) );
		
		//at the end, remove the products from the favorites, for the future tests		
		Tests_functions.emptyFavoritesOneItem(driver);						
	}

	
	//Test - adding to favorites from the product pop-up page
	@Test		
	public  void Tests_favorites_add_fromLessThen5() throws Exception {
		System.out.println("Running test for adding product to favorites from the product pop-up page");		

		//open the less-than-5 tab
		driver.get(ElementsWebsites.Zipy_il_lessThan5);

		//click the pin button on the thumbnail
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsRecommended.lessThan5_3)))
		.moveToElement(driver.findElement(By.xpath(ElementsRecommended.Product_PinThumbIcon))).click().build().perform();

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
		Tests_functions.emptyFavoritesOneItem(driver);		
	}

}

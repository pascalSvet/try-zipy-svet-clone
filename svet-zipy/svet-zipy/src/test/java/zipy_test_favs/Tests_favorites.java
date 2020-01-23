package zipy_test_favs;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import zipy_elements.*;

public class Tests_favorites extends Tests_favs_MAIN {
	
	
	//Test - appearance of favorite-pin icon on thumbnail, on mouse hover
	@Test		
	public  void Tests_favorites_pinIcon_appearOnHover() throws Exception {
		System.out.println("Running test for appearance of favorite-pin icon on the daiy deals thumbnail, on mouse hover");		
		
		driver.get(ElementsWebsites.Zipy_il_deals);
		
		//move mouse over the thumbnail
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsRecommended.dailyDeal_onPage_3))).build().perform();;

		// if correct, the pin button is visible:
		Assert.assertTrue(driver.findElement(By.xpath(ElementsRecommended.Product_PinThumbIcon)).isDisplayed());				
	}

	
	//Test - correct colors of favorite-pin button
	@Test		
	public  void Tests_favorites_pinIcon_colors() throws Exception {
		System.out.println("Running test for coreect colors of favorite-pin before and after clicking");		
		
		driver.get(ElementsWebsites.Zipy_il_deals);
		
		//move mouse over the thumbnail
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsRecommended.dailyDeal_onPage_3))).build().perform();;

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
	
		
	//Test - adding to favorites from product page
	@Test		
	public  void Tests_favorites_add_fromProductPage() throws Exception {
		System.out.println("Running test for adding to favorites from the product page");		

		//get to the required product page and save its title
		driver.get(ElementsBuying.Product_noVariations);
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt").trim();

		//add to the favorites
		driver.findElement(By.xpath(ElementsBuying.Product_pin)).click();

		// open the favorites window and save its contents
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesButton)).click();
		Thread.sleep(500);
		String favoritesFrame = driver.findElement(By.xpath(ElementsBuying.Product_favoritesFrame)).getText();
		
		
		System.out.println(driver.findElement(By.xpath("/html/head/meta[7]")).getAttribute("content"));
		System.out.println();
		System.out.println();
		
		// if correct, the product title will be found in the favorites window:
		Assert.assertTrue(favoritesFrame.contains(ProductTitle) );
		
		//at the end, remove the products from the favorites, for the future tests		
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesRemove)).click();
	}
	
	//Test - adding to favorites from product pop-up page
	@Test		
	public  void Tests_favorites_add_fromQuickPopupPage() throws Exception {
		System.out.println("Running test for adding to favorites from the quick pop-up page");		

		//open one of the products on the main page and save its name
		driver.get(ElementsWebsites.Zipy_il);
		driver.findElement(By.xpath(ElementsRecommended.dailyDeal_3)).click();
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPopup)).getText().trim();

		//add to favorites
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesButton_popup)).click();
			
		// open the favorites window and save its contents
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesButton)).click();
		Thread.sleep(500);
		String favoritesFrame = driver.findElement(By.xpath(ElementsBuying.Product_favoritesFrame)).getText();
		
		// if correct, the product title will be found in the favorites window:
		Assert.assertTrue(favoritesFrame.contains(ProductTitle) );
		
		//at the end, remove the products from the favorites, for the future tests		
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesRemove)).click();
	}


	//Test - adding to favorites from daiy deals thumbnail
	@Test		
	public  void Tests_favorites_add_fromDealsThumb() throws Exception {
		System.out.println("Running test for adding to favorites from daiy deals thumbnail");		
		
		driver.get(ElementsWebsites.Zipy_il_deals);
		
		//click the pin button on the thumbnail
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsRecommended.dailyDeal_onPage_3)))
		.moveToElement(driver.findElement(By.xpath(ElementsRecommended.Product_PinThumbIcon))).click().build().perform();

		//save products title			
		String ProductTitle = driver.findElement(By.xpath(ElementsRecommended.dailyDeal_onPage_3_title)).getText().trim();
				
		// open the favorites window and save its contents
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesButton)).click();
		Thread.sleep(500);
		String favoritesFrame = driver.findElement(By.xpath(ElementsBuying.Product_favoritesFrame)).getText();
		
		// if correct, the product title will be found in the favorites window:
		Assert.assertTrue(favoritesFrame.contains(ProductTitle) );
		
		//at the end, remove the products from the favorites, for the future tests		
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesRemove)).click();
		
	}
		
	
	//Test - adding to favorites from less-than-5 tab
	@Test		
	public  void Tests_favorites_add_fromLessThen5() throws Exception {
		System.out.println("Running test for adding to favorites from the less-than-5 tab");		

		//open the less-than-5 tab
		driver.get(ElementsWebsites.Zipy_il_lessThan5);

		//click the pin button on the thumbnail
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsRecommended.lessThan5_3)))
		.moveToElement(driver.findElement(By.xpath(ElementsRecommended.lessThan5_3_PinThumbIcon))).click().build().perform();

		//save products title			
		String ProductTitle = driver.findElement(By.xpath(ElementsRecommended.lessThan5_3_title)).getText().trim();
					
		// open the favorites window and save its contents
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesButton)).click();
		Thread.sleep(500);
		String favoritesFrame = driver.findElement(By.xpath(ElementsBuying.Product_favoritesFrame)).getText();
		
		// if correct, the product title will be found in the favorites window:
		Assert.assertTrue(favoritesFrame.contains(ProductTitle) );
		
		//at the end, remove the products from the favorites, for the future tests		
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesRemove)).click();
	}
	
	
	//Test - adding to favorites from search thumbnail
	@Test		
	public  void Tests_favorites_add_fromSearchThumb() throws Exception {
		System.out.println("Running test for adding to favorites from search thumbnail");		
		
		driver.get(ElementsWebsites.Zipy_il);
		
		// perform search and open the product
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys("usb", Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath(ElementsRecommended.search_3))));
		
		//click the pin button on the thumbnail
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsRecommended.search_3)))
		.moveToElement(driver.findElement(By.xpath(ElementsRecommended.Product_search_3_PinThumbIcon))).click().build().perform();

		//save products title			
		String ProductTitle = driver.findElement(By.xpath(ElementsRecommended.search_3_title)).getText().trim();
				
		// open the favorites window and save its contents
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesButton)).click();
		Thread.sleep(500);
		String favoritesFrame = driver.findElement(By.xpath(ElementsBuying.Product_favoritesFrame)).getText();
		
		// if correct, the product title will be found in the favorites window:
		Assert.assertTrue(favoritesFrame.contains(ProductTitle) );
			
		//at the end, remove the products from the favorites, for the future tests		
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesRemove)).click();
	}

	
	//Test - adding to favorites from category thumbnail (from categories side panel)
	@Test		
	public  void Tests_favorites_add_fromCategoryThumb() throws Exception {
		System.out.println("Running test for adding to favorites from category thumbnail");		
		
		driver.get(ElementsWebsites.Zipy_il);
		
		//chose the first category from side panel and choose the first sub category
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.sideCategory1))).click()
		.moveToElement(driver.findElement(By.xpath(ElementsLogin.sideCategory1_1))).click().build().perform();
		
		//click the pin button on the third thumbnail
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsRecommended.category_3)))
		.moveToElement(driver.findElement(By.xpath(ElementsRecommended.category_3_PinThumbIcon))).click().build().perform();

		//save products title			
		String ProductTitle = driver.findElement(By.xpath(ElementsRecommended.category_3_title)).getText().trim();
				
		// open the favorites window and save its contents
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesButton)).click();
		Thread.sleep(500);
		String favoritesFrame = driver.findElement(By.xpath(ElementsBuying.Product_favoritesFrame)).getText();
		
		// if correct, the product title will be found in the favorites window:
		Assert.assertTrue(favoritesFrame.contains(ProductTitle) );
		
		//at the end, remove the products from the favorites, for the future tests		
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesRemove)).click();
		
	}
	
	
}

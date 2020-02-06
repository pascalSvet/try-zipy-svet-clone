package Master.Favorites;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import zipy_elements.*;

public class Favorites_adding extends Favorites_MAIN {
	
			
	//Test - adding to favorites from product page
	@Test		
	public  void Tests_favorites_add_fromProductPage() throws Exception {
		System.out.println("Running test for adding to favorites from the product page");		

		//get to the required product page and save its title
		driver.get(ElementsBuying.Product_noVariations);		
		String ProductTitle = act.elementAttText(ElementsBuying.Product_titleFromPicture, "alt", driver);

		//add to the favorites
		act.click(ElementsBuying.Product_pin, driver);

		// open the favorites window and save its contents 
		act.click(ElementsBuying.Product_favoritesButton, driver);
		Thread.sleep(500);
		
		String favoritesFrame = act.elementText(ElementsBuying.Product_favoritesFrame, driver);
		
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
		act.click(ElementsThumbs.dailyDeal_3, driver);
		act.waitForUrlChange(ElementsWebsites.Zipy_il_withPopup, driver);
		
		String ProductTitle = act.elementText(ElementsBuying.Product_titleFromPopup, driver);

		//add to favorites
		act.click(ElementsBuying.Product_favoritesButton_popup, driver);
		Thread.sleep(2000);
		
		// open the favorites window and save its contents
		act.click(ElementsBuying.Product_favoritesButton, driver);
		Thread.sleep(2000);
		String favoritesFrame = act.elementText(ElementsBuying.Product_favoritesFrame, driver);

		System.out.println(favoritesFrame);
		System.out.println(ProductTitle);

		// if correct, the product title will be found in the favorites window:
		Assert.assertTrue(favoritesFrame.contains(ProductTitle) );
		
		//at the end, remove the products from the favorites, for the future tests		
		act.click(ElementsBuying.Product_favoritesRemove, driver);
	}


	//Test - adding to favorites from daiy deals thumbnail
	@Test		
	public  void Tests_favorites_add_fromDealsThumb() throws Exception {
		System.out.println("Running test for adding to favorites from daiy deals thumbnail");		
		
		//open the deals page
		driver.get(ElementsWebsites.Zipy_il_deals);
		
		//click the pin button on the thumbnail
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsThumbs.dailyDeal_onPage_3)))
		.moveToElement(driver.findElement(By.xpath(ElementsThumbs.Product_PinThumbIcon))).click().build().perform();

		//save products title			
		String ProductTitle = act.elementText(ElementsThumbs.dailyDeal_onPage_3_title, driver);
				
		// open the favorites window and save its contents
		act.click(ElementsBuying.Product_favoritesButton, driver);
		Thread.sleep(500);
		String favoritesFrame = act.elementText(ElementsBuying.Product_favoritesFrame, driver);
		
		// if correct, the product title will be found in the favorites window:
		Assert.assertTrue(favoritesFrame.contains(ProductTitle) );
		
		//at the end, remove the products from the favorites, for the future tests		
		act.click(ElementsBuying.Product_favoritesRemove, driver);
		
	}
		
	
	//Test - adding to favorites from less-than-5 tab
	@Test		
	public  void Tests_favorites_add_fromLessThen5() throws Exception {
		System.out.println("Running test for adding to favorites from the less-than-5 tab");		

		//open the less-than-5 tab
		driver.get(ElementsWebsites.Zipy_il_lessThan5);

		//click the pin button on the thumbnail
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsThumbs.lessThan5_3)))
		.moveToElement(driver.findElement(By.xpath(ElementsThumbs.lessThan5_3_PinThumbIcon))).click().build().perform();
		
		//save products title			
		String ProductTitle = act.elementText(ElementsThumbs.lessThan5_3_title, driver);
					
		// open the favorites window and save its contents
		act.click(ElementsBuying.Product_favoritesButton, driver);
		Thread.sleep(500);
		String favoritesFrame = act.elementText(ElementsBuying.Product_favoritesFrame, driver);
		
		// if correct, the product title will be found in the favorites window:
		Assert.assertTrue(favoritesFrame.contains(ProductTitle) );
		
		//at the end, remove the products from the favorites, for the future tests		
		act.click(ElementsBuying.Product_favoritesRemove, driver);
	}
	
	
	//Test - adding to favorites from search thumbnail
	@Test		
	public  void Tests_favorites_add_fromSearchThumb() throws Exception {
		System.out.println("Running test for adding to favorites from search thumbnail");		
		
		//open the main page
		driver.get(ElementsWebsites.Zipy_il_withPopup);
		Functions.closePopUp(driver);

		//perform search and open the product
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys("usb", Keys.ENTER);
		act.waitForUrlChange(ElementsWebsites.Zipy_il_withPopup, driver);

		//click the pin button
		act.click(ElementsThumbs.search_3, driver);
		act.click(ElementsBuying.Product_favoritesButton_popup, driver);
		Thread.sleep(1500);

		//save products title	
		String ProductTitle = act.elementText(ElementsBuying.Product_titleFromPopup, driver);
				
		// open the favorites window and save its contents
		act.click(ElementsBuying.Product_favoritesButton, driver);
		Thread.sleep(500);
		String favoritesFrame = act.elementText(ElementsBuying.Product_favoritesFrame, driver);
		
		// if correct, the product title will be found in the favorites window:
		Assert.assertTrue(favoritesFrame.contains(ProductTitle) );
			
		//at the end, remove the products from the favorites, for the future tests		
		act.click(ElementsBuying.Product_favoritesRemove, driver);
	}

	
	//Test - adding to favorites from category  
	@Test		
	public  void Tests_favorites_add_fromCategoryThumb() throws Exception {
		System.out.println("Running test for adding to favorites from category thumbnail");		
		
		//open the main page
		driver.get(ElementsWebsites.Zipy_il);
		
		//chose the first category from side panel and choose the first sub category
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.sideCategoryUp1))).click()
		.moveToElement(driver.findElement(By.xpath(ElementsLogin.sideCategoryUp1_1))).click().build().perform();
		
		//click the pin button on the third thumbnail
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsThumbs.category_3)))
		.moveToElement(driver.findElement(By.xpath(ElementsThumbs.category_3_PinThumbIcon))).click().build().perform();

		//save products title			
		String ProductTitle = act.elementText(ElementsThumbs.category_3_title, driver);
				
		// open the favorites window and save its contents
		act.click(ElementsBuying.Product_favoritesButton, driver);
		Thread.sleep(500);
		String favoritesFrame = act.elementText(ElementsBuying.Product_favoritesFrame, driver);
		
		// if correct, the product title will be found in the favorites window:
		Assert.assertTrue(favoritesFrame.contains(ProductTitle) );
		
		//at the end, remove the products from the favorites, for the future tests		
		act.click(ElementsBuying.Product_favoritesRemove, driver);
		
	}
	
	
}

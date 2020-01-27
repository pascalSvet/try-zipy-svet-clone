package Master.Cart;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import zipy_elements.*;

public class Cart_addProduct extends Cart_MAIN {
	
	//Test - adding a product to the cart from quick pop-up page
	@Test		
	public  void Tests_cart_addProduct_fromQuickPopup() throws Exception {
		System.out.println("Running test for adding to favorites from the quick pop-up page");		

		//open one of the deals products on the main page and save its name
		driver.get(ElementsWebsites.Zipy_il_deals);
		driver.findElement(By.xpath(ElementsRecommended.dailyDeal_onPage_3)).click();
		Thread.sleep(1000);
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPopup)).getText().trim();

		//choose variations if exist and add to the cart
		Functions.chooseVariations_ProductFramed(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.ProductFramed_addToCart))).click();
		WebElement cartFrame = Functions.openCart(driver);
		
		// if we managed to add the product, its title is found in the cart:
		Assert.assertTrue(cartFrame.getText().contains(ProductTitle));
	}
	
	
	//Test - adding a product to the cart from less-than-5 tab
	@Test		
	public  void Tests_cart_addProduct_fromLessThen5() throws Exception {
		System.out.println("Running test for adding to favorites from the less-than-5 tab");		

		//open the less-than-5 tab
		driver.get(ElementsWebsites.Zipy_il_lessThan5);

		//click the third thumbnail and save its title	
		driver.findElement(By.xpath(ElementsRecommended.lessThan5_3)).click();	
		String ProductTitle = driver.findElement(By.xpath(ElementsRecommended.lessThan5_3_title)).getText().trim();
					
		//choose variations if exist and add to the cart
		Functions.chooseVariations_ProductFramed(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.ProductFramed_addToCart))).click();		
		WebElement cartFrame = Functions.openCart(driver);
		
		// if we managed to add the product, its title is found in the cart:
		Assert.assertTrue(cartFrame.getText().contains(ProductTitle));
	}

	 
	//Test - adding a product to the cart from category (from categories side panel)
	@Test		
	public  void Tests_cart_addProduct_fromCategory() throws Exception {
		System.out.println("Running test for adding to favorites from category thumbnail");		
		
		driver.get(ElementsWebsites.Zipy_il);
		
		//chose the first category from side panel and choose the first sub category
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.sideCategoryUp1))).click()
		.moveToElement(driver.findElement(By.xpath(ElementsLogin.sideCategoryUp1_1))).click().build().perform();
		
		//click the third thumbnail and save its title	
		driver.findElement(By.xpath(ElementsRecommended.category_3)).click();			
		String ProductTitle = driver.findElement(By.xpath(ElementsRecommended.category_3_title)).getText().trim();
		Functions.closePopUp(driver);
		
		//choose variations if exist and add to the cart
		Functions.chooseVariations_ProductFramed(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.ProductFramed_addToCart))).click();
		WebElement cartFrame = Functions.openCart(driver);
		
		// if we managed to add the product, its title is found in the cart:
		Assert.assertTrue(cartFrame.getText().contains(ProductTitle));
		
	}
	
	//Test - adding a product to the cart from next quick pop-up page
	@Test		
	public  void Tests_cart_addProduct_fromQuickPopup_Next() throws Exception {
		System.out.println("Running test for adding to favorites from next quick pop-up page");		

		//open one of the deals products and 
		driver.get(ElementsWebsites.Zipy_il_deals);
		String currentUrl = driver.getCurrentUrl();
		driver.findElement(By.xpath(ElementsRecommended.dailyDeal_onPage_3)).click();
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
		currentUrl = driver.getCurrentUrl();
		

		//move to the next product and save its name
		driver.findElement(By.xpath(ElementsBuying.ProductFramed_next)).click();
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPopup)).getText().trim();

		//choose variations if exist and add to the cart
		Functions.chooseVariations_ProductFramed(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.ProductFramed_addToCart))).click();
		WebElement cartFrame = Functions.openCart(driver);

		// if we managed to add the product, its title is found in the cart:
		Assert.assertTrue(cartFrame.getText().contains(ProductTitle));
	}
			
	//Test - adding a product to the cart from product page
	@Test		
	public  void Tests_cart_addProduct_fromPage() throws Exception {
		System.out.println("Running test for adding product to the cart from product page ");	

		//get to the required product page and save its title
		driver.get(ElementsBuying.Product_noVariations);
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");
		
		//add to the cart
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();
		WebElement cartFrame = Functions.openCart(driver);

		// if we managed to add the product, its title is found in the cart:
		Assert.assertTrue(cartFrame.getText().contains(ProductTitle));
	}

	//Test - adding both a product from aliExpress and a product from Amazon to the cart 
	@Test		
	public  void Tests_cart_addProduct_aliExpressPlusAmazon() throws Exception {
		System.out.println("Running test for adding product to the cart (product without variations)");		
		
		//get to the aliExpress product page and save its title
		driver.get(ElementsBuying.Product_noVariations);
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");
		
		//add to the cart
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();

		//get to the amazon product page and save its title
		driver.get(ElementsBuying.Product_noVariationsAmazon);
		String ProductTitleAmazon = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");
		
		//add to the cart
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_addToCart))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addedToCart))).click();
		
		WebElement cartFrame = Functions.openCart(driver);

		// if we managed to add the products, both titles are in the cart:
		Assert.assertTrue((cartFrame.getText().contains(ProductTitle)) &&
				(cartFrame.getText().contains(ProductTitleAmazon)));
				
		//at the end, remove the product from the cart, for the future tests
		driver.findElement(By.xpath(ElementsBuying.Product_cartRemove)).click();
				
	}
	
	
}

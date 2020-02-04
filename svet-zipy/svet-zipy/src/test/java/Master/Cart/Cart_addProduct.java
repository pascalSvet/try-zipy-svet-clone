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
		System.out.println("Running test for adding a product to the cart from quick pop-up page");		

		//open deals page
		driver.get(ElementsWebsites.Zipy_il_deals);
		
		//open one of the deals products
		driver.findElement(By.xpath(ElementsRecommended.dailyDeal_onPage_3)).click();
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(ElementsWebsites.Zipy_il_deals_withPopup)));
		Thread.sleep(2000);
		
		//make sure there is no 400 error
		if(driver.getTitle().contains("404")) {
			System.out.println("test failed because of 404 eror");
			Assert.assertTrue(false);
		}
		//save its name
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPopup)).getText().trim();

		//choose variations if exist and add to the cart
		Thread.sleep(2000);
		Functions.chooseVariations_ProductFramed(driver);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.ProductFramed_addToCart))).click();
		WebElement cartFrame = Functions.openCart(driver);
		
		// if we managed to add the product, its title is found in the cart:
		Assert.assertTrue(cartFrame.getText().contains(ProductTitle));
	}
	
	
	//Test - adding a product to the cart from less-than-5 tab
	@Test		
	public  void Tests_cart_addProduct_fromLessThan5() throws Exception {
		System.out.println("Running test for adding a product to the cart from the less-than-5 tab");		

		//open the less-than-5 tab
		driver.get(ElementsWebsites.Zipy_il_lessThan5);

		//click the third thumbnail
		driver.findElement(By.xpath(ElementsRecommended.lessThan5_3)).click();	
		//make sure there is no 400 error
		if(driver.getTitle().contains("404")) {
			System.out.println("test failed because of 404 eror");
			Assert.assertTrue(false);
		}
		//save its title	
		String ProductTitle = driver.findElement(By.xpath(ElementsRecommended.lessThan5_3_title)).getText().trim();
					
		//choose variations if exist and add to the cart
		Functions.chooseVariations_ProductFramed(driver);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.ProductFramed_addToCart))).click();		
		WebElement cartFrame = Functions.openCart(driver);
		
		// if we managed to add the product, its title is found in the cart:
		Assert.assertTrue(cartFrame.getText().contains(ProductTitle));
	}

	 
	//Test - adding a product to the cart from category 
	@Test		
	public  void Tests_cart_addProduct_fromCategory() throws Exception {
		System.out.println("Running test for adding a product to the cart from category");		
		
		//open main page
		driver.get(ElementsWebsites.Zipy_il);

		//chose the first category from side panel and choose the first sub category
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.sideCategoryUp1))).click()
		.moveToElement(driver.findElement(By.xpath(ElementsLogin.sideCategoryUp1_1))).click().build().perform();
		
		//click the third thumbnail  
		driver.findElement(By.xpath(ElementsRecommended.category_3)).click();	
		//make sure there is no 400 error
		if(driver.getTitle().contains("404")) {
			System.out.println("test failed because of 404 eror");
			Assert.assertTrue(false);
		} 
		//save its title	
		String ProductTitle = driver.findElement(By.xpath(ElementsRecommended.category_3_title)).getText().trim();
		Functions.closePopUp(driver);
		
		//choose variations if exist and add to the cart
		Functions.chooseVariations_ProductFramed(driver);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.ProductFramed_addToCart))).click();
		WebElement cartFrame = Functions.openCart(driver);
		
		// if we managed to add the product, its title is found in the cart:
		Assert.assertTrue(cartFrame.getText().contains(ProductTitle));
		
	}
	
	//Test - adding a product to the cart from next quick pop-up page
	@Test		
	public  void Tests_cart_addProduct_fromQuickPopup_Next() throws Exception {
		System.out.println("Running test for adding to the cart from next quick pop-up page");		

		//open deals page
		driver.get(ElementsWebsites.Zipy_il_deals);		
		String currentUrl = driver.getCurrentUrl();
		
		//open one of the deals products  
		driver.findElement(By.xpath(ElementsRecommended.dailyDeal_onPage_3)).click();		
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
		Thread.sleep(2000);	
		//make sure there is no 400 error
		if(driver.getTitle().contains("404")) {
			System.out.println("test failed because of 404 eror");
			Assert.assertTrue(false);
		} 
		currentUrl = driver.getCurrentUrl();		

		//move to the next product  
		driver.findElement(By.xpath(ElementsBuying.ProductFramed_next)).click();
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
		Thread.sleep(2000);	
		
		//make sure there is no 400 error
		if(driver.getTitle().contains("404")) {
			System.out.println("test failed because of 404 eror");
			Assert.assertTrue(false);
		} 
		//save its name
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPopup)).getText().trim();

		//choose variations if exist and add to the cart
		Functions.chooseVariations_ProductFramed(driver);
		Thread.sleep(2000);	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.ProductFramed_addToCart))).click();
		WebElement cartFrame = Functions.openCart(driver);

		// if we managed to add the product, its title is found in the cart:
		Assert.assertTrue(cartFrame.getText().contains(ProductTitle));
	}
			
	//Test - adding a product to the cart from product page
	@Test		
	public  void Tests_cart_addProduct_fromPage() throws Exception {
		System.out.println("Running test for adding product to the cart from product page ");	

		//get to the required product page 
		driver.get(ElementsBuying.Product_noVariations);
		
		//make sure there is no 400 error
		if(driver.getTitle().contains("404")) {
			System.out.println("test failed because of 404 eror");
			Assert.assertTrue(false);
		}
		
		//save its name
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");
		
		//add to the cart
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();
		WebElement cartFrame = Functions.openCart(driver);

		// if we managed to add the product, its title is found in the cart:
		Assert.assertTrue(cartFrame.getText().contains(ProductTitle));
	}

	//Test - adding both a product from aliExpress and a product from Amazon to the cart 
	@Test		
	public  void Tests_cart_addProduct_aliExpressPlusAmazon() throws Exception {
		System.out.println("Running test for adding product to the cart (one from aliExpress and one from amazon)");		
		
		//get to the aliExpress product page 
		driver.get(ElementsBuying.Product_noVariations);
		
		//make sure there is no 400 error
		if(driver.getTitle().contains("404")) {
			System.out.println("test failed because of 404 eror");
			Assert.assertTrue(false);
		} 
		//save its name
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");
		
		//add to the cart
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();

		//get to the amazon product page
		driver.get(ElementsBuying.Product_noVariationsAmazon);
		//make sure there is no 400 error
		if(driver.getTitle().contains("404")) {
			System.out.println("test failed because of 404 eror");
			Assert.assertTrue(false);
		} 
		//save its name
		String ProductTitleAmazon = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture_amazon)).getAttribute("content");
		
		//add to the cart
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_addToCart))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addedToCart))).click();
		Thread.sleep(1000);

		WebElement cartFrame = Functions.openCart(driver);

		// if we managed to add the products, both titles are in the cart:
		Assert.assertTrue((cartFrame.getText().contains(ProductTitle)) &&
				(cartFrame.getText().contains(ProductTitleAmazon)));
				
		//at the end, remove the product from the cart, for the future tests
		driver.findElement(By.xpath(ElementsBuying.Product_cartRemove)).click();
				
	}
	
	
}

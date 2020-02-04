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

public class Cart_removeProduct extends Cart_MAIN {
	
	
	//Test - removing product from the cart
	@Test		
	public  void Tests_cart_removeProduct() throws Exception {
		System.out.println("Running test for removing product from the cart");		

		//get to the required product page  
		driver.get(ElementsBuying.Product_noVariations);

		//make sure there is no 400 error
		if(driver.getTitle().contains("404")) {
			System.out.println("test failed because of 404 eror");
			Assert.assertTrue(false);
		}
		
		//save its title
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");
		
		//add to the cart
		Thread.sleep(1500);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();

		//empty the cart
		Functions.openAndEmptyCart(driver);	

		// if we managed to remove the product from the cart, it contains a message of empty cart
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Product_cartIsEmpty)).isDisplayed());					
	}
	
	
	//Test - removing product from the cart to the favorites
	@Test		
	public  void Tests_cart_removeProduct_toFavorites() throws Exception {
		System.out.println("Running test for removing product from the cart to the favorites");		

		//get to the required product page
		driver.get(ElementsBuying.Product_noVariations);

		//make sure there is no 400 error
		if(driver.getTitle().contains("404")) {
			System.out.println("test failed because of 404 eror");
			Assert.assertTrue(false);
		}
		
		//save its title
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");
		
		//add to the cart
		Thread.sleep(1500);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();

		//back to main page and open the cart			
		driver.get(ElementsWebsites.Zipy_il);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_openCart))).click();
		
		//remove the item and choose adding it to favorites
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_cartRemove))).click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_cart_moveToFavorites))).click();
		
		//check if the cart contains the removed item  
		boolean removedItem = driver.findElement(By.xpath(ElementsBuying.Product_cartIsEmpty)).isDisplayed();		
		
		// open the favorites window and save its contents
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesButton)).click();
		Thread.sleep(1000);
		String favoritesFrame = driver.findElement(By.xpath(ElementsBuying.Product_favoritesFrame)).getText();
				
		// if we managed to remove the product, the cart won't contain its title, but the favorites will contain it:			
		Assert.assertTrue(favoritesFrame.contains(ProductTitle) && removedItem);
		
		//at the end, remove the products from the favorites, for the future tests		
		Functions.emptyFavorites(driver);		
	}
	
	
	//Test - removing product from the cart and then returning it back
	@Test		
	public  void Tests_cart_removeProduct_return() throws Exception {
		System.out.println("Running test for removing product from the cart and then returning it back");		
	
		//get to the required product page
		driver.get(ElementsBuying.Product_noVariations);

		//make sure there is no 400 error
		if(driver.getTitle().contains("404")) {
			System.out.println("test failed because of 404 eror");
			Assert.assertTrue(false);
		}
		
		//save its title
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");
		
		//add to the cart
		Thread.sleep(1500);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();
	
		//back to main page and open the cart			
		driver.get(ElementsWebsites.Zipy_il);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_openCart))).click();
		
		//remove the item and choose returning it to the cart
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_cartRemove))).click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_cart_returnToCart))).click();
		Thread.sleep(1500);
		WebElement cartFrame = driver.findElement(By.xpath(ElementsBuying.Product_cartFrame));
		wait.until(ExpectedConditions.visibilityOf(cartFrame));

		// if we managed to return the product, its title is found in the cart:
		Assert.assertTrue(cartFrame.getText().contains(ProductTitle));
		
	}
	
	
	//Test - adding same product twice with different variations, and then removing one of them from the cart
	@Test		
	public  void Tests_cart_removeProduct_partOfVariations() throws Exception {
		System.out.println("Running test for removing one of the variations of the same product which is in the cart");		

		//get to the required product page 
		driver.get(ElementsBuying.Product_oneVariation);

		//make sure there is no 400 error
		if(driver.getTitle().contains("404")) {
			System.out.println("test failed because of 404 eror");
			Assert.assertTrue(false);
		}
		
		//save its title
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");		

		//choose the product variation - first option from the droplist - and save its name
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_variationsColor))).click();		
		Thread.sleep(1000);
		WebElement variationColor_1 = driver.findElement(By.xpath(ElementsBuying.Product_variationsColor_1));
		String ProductVariation1 = variationColor_1.getText().trim();;
		variationColor_1.click();						
		
		//add to the cart
		Thread.sleep(1500);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_quantityPlusAgain)));

		//choose another product variation - second option from the droplist - and save its name
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_variationsColorAgain))).click();
		Thread.sleep(2000);
		WebElement variationColor_2 = driver.findElement(By.xpath(ElementsBuying.Product_variationsColor_3));
		String ProductVariation2 = variationColor_2.getText().trim();
		variationColor_2.click();
		
		//add to the cart again
		Thread.sleep(1500);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();

		//back to main page and open the cart			
		driver.get(ElementsWebsites.Zipy_il);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_openCart))).click();
		
		//remove the first item from the cart
		Thread.sleep(500);
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_cartRemove))).click();
			
		//reopen the cart			
		WebElement cartFrame = Functions.openCart(driver);
		
		// if we removed the first variation only, then the cart includes the title of product and its second variation only 
		Assert.assertTrue((cartFrame.getText().contains(ProductTitle)) &&
				(cartFrame.getText().contains(ProductVariation2)) &&
				!(cartFrame.getText().contains(ProductVariation1)));
			
	}
	
	//Test - removing product from the payment page
	@Test		
	public  void Tests_cart_removeProduct_fromPayment() throws Exception {
		System.out.println("Running test for removing product from the payment page");		

		//get to the required product page 
		driver.get(ElementsBuying.Product_noVariations);

		//make sure there is no 400 error
		if(driver.getTitle().contains("404")) {
			System.out.println("test failed because of 404 eror");
			Assert.assertTrue(false);
		}
		
		//save its title
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");
		
		//add to the cart and proceed to the payment
		Thread.sleep(2000);
		driver.findElement(By.xpath(ElementsBuying.PayNow_button)).click();

		//remove the product
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_payment_Remove))).click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_paymentPopup_Remove))).click();

		//reopen the cart	
		Functions.openCart(driver);
				
		// if we managed to remove the product from the cart, it contains a message of empty cart
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Product_cartIsEmpty)).isDisplayed());					
	}

	//Test - removing product to favorites from the payment page
	@Test		
	public  void Tests_cart_removeProduct_toFavorites_fromPayment() throws Exception {
		System.out.println("Running test for removing product to favorites from the payment page");		

		//get to the required product page
		driver.get(ElementsBuying.Product_noVariations);

		//make sure there is no 400 error
		if(driver.getTitle().contains("404")) {
			System.out.println("test failed because of 404 eror");
			Assert.assertTrue(false);
		}
		
		//save its title
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");
		
		//add to the cart and proceed to the payment
		Thread.sleep(2000);
		driver.findElement(By.xpath(ElementsBuying.PayNow_button)).click();

		//remove the product
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_payment_Remove))).click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_paymentPopup_moveToFavs))).click();

		//reopen the cart	
		Functions.openCart(driver);

		//check if the cart contains the removed item  
		boolean removedItem = driver.findElement(By.xpath(ElementsBuying.Product_cartIsEmpty)).isDisplayed();		
		
		// open the favorites window and save its contents
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesButton)).click();
		Thread.sleep(1500);
		String favoritesFrame = driver.findElement(By.xpath(ElementsBuying.Product_favoritesFrame)).getText();
				
		// if we managed to remove the product, the cart won't contain its title, but the favorites will contain it:			
		Assert.assertTrue(favoritesFrame.contains(ProductTitle) && removedItem);
		
		//at the end, remove the products from the favorites, for the future tests		
		Functions.emptyFavorites(driver);					
	}
	
}

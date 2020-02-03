package Master.Cart;
import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import zipy_elements.*;

public class Cart_mobile extends Cart_MAIN {
			
	//TestsMobile - checking the final sum in the cart affected by changing the quantity in the cart
	@Test		
	public  void TestsMobile_cart_price_changeQuantity() throws Exception {
		System.out.println("Running test (in mobile version) for checking the final sum in the cart affected by changing the quantity in the cart");		

		//change to mobile screen resolution
		driver.manage().window().setSize(new Dimension(320,600));

		//get to the required product page  
		driver.get(ElementsBuying.Product_noVariations);
		Thread.sleep(500);

		//make sure there is no 400 error
		if(driver.getTitle().contains("404")) {
			System.out.println("test failed because of 404 eror");
			Assert.assertTrue(false);
		}
		//save its price
		String price = Functions.priceSum(driver, ElementsBuying.Product_price, ElementsBuying.Product_delivery).trim();
		
		//increase the quantity to 2 and then add to the cart 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_quantityPlus))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_plusOne)));

		//reopen the cart and change the quantity manually to "1"
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_openCart))).click();
		WebElement Sum = driver.findElement(By.xpath(ElementsBuying.Product_cart_finalSum_mobile));
		String FirstSum = Sum.getText();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_cart_quantityDrop))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_cart_quantityDrop_1))).click();
				
		new WebDriverWait(driver, 30).until(ExpectedConditions.not(ExpectedConditions.
				textToBePresentInElement(Sum, FirstSum)));
		String FinalSum = driver.findElement(By.xpath(ElementsBuying.Product_cart_finalSum_mobile)).getText();

		// the final sum supposed to be of 1 unit only :
		Assert.assertTrue(FinalSum.contains(price) && !FirstSum.equals(FinalSum));
		
		//remove the product at the end, for the future tests
		Functions.removeFromCart_mobile(driver);
	}
		
	//TestsMobile - adding product to the cart and changing quantity manually in the cart, for more then 10 items
	@Test		
	public  void TestsMobile_cart_addProduct_changeQuantity_moreThan10() throws Exception {
		System.out.println("Running test (in mobile version) for adding product to the cart and changing quantity manually in the cart, for more then 10 items");		

		//change to mobile screen resolution
		driver.manage().window().setSize(new Dimension(320,600));

		//add required product to the cart
		Functions.addSampleProductToCart(driver);

		//reopen the cart and change the quantity manually to "11"
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_openCart))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_cart_quantityDrop))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(ElementsBuying.Product_cart_quantityDrop_10)).click();
		Thread.sleep(2500);

		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsBuying.Product_cart_quantity10plus_mobile))).click()
		.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys("11",Keys.ENTER).build().perform();

		//reopen the cart and check for the current quantity
		driver.get(ElementsWebsites.Zipy_il);		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_openCart))).click();
		String Quantity = driver.findElement(By.xpath(ElementsBuying.Product_cart_quantity_mobile)).getAttribute("value");

		// if succeed, the final quantity supposed to be 11 units :
		Assert.assertTrue(Quantity.equals("11"));
				
		//remove the product at the end, for the future tests
		Functions.removeFromCart_mobile(driver);
	}
	
	//TestMobile - removing product from from the cart
	@Test		
	public  void TestsMobile_cart_removeProduct() throws Exception {
		System.out.println("Running test (in mobile version) for removing product from the cart");		
		
		//change to mobile screen resolution
		driver.manage().window().setSize(new Dimension(320,480));

		//add required product to the cart
		Functions.addSampleProductToCart(driver);
		
		//remove the product and reopen the cart
		Functions.openAndRemoveFromCart_mobile(driver);
		Functions.openCart(driver);
		
		// if we managed to remove the product from the cart, it contains a message of empty cart
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Product_cartIsEmpty)).isDisplayed());			
	}


	//TestMobile - removing product from the cart to favorites 
	@Test		
	public  void TestsMobile_cart_removeProduct_toFavorites_fromPayment() throws Exception {
		System.out.println("Running test (in mobile version) for removing product from the cart to favorites");		

		//change to mobile screen resolution
		driver.manage().window().setSize(new Dimension(150,650));

		//add required product to the cart and save its title
		String ProductTitle = Functions.addSampleProductToCart(driver);

		//remove the product to favorites and reopen the cart
		Functions.removeFromCart_toFavs_mobile(driver); 
		Functions.openCart(driver);
		boolean removedItem = driver.findElement(By.xpath(ElementsBuying.Product_cartIsEmpty)).isDisplayed();		
		
		// open the favorites window and save its contents
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesButton)).click();
		Thread.sleep(500);
		String favoritesFrame = driver.findElement(By.xpath(ElementsBuying.Product_favoritesFrame)).getText();
				
		// if we managed to remove the product, the cart won't contain its title, but the favorites will contain it:			
		Assert.assertTrue(favoritesFrame.contains(ProductTitle) && removedItem);
		
		//at the end, remove the products from the favorites, for the future tests		
		Functions.emptyFavorites(driver);					
	}
	
}

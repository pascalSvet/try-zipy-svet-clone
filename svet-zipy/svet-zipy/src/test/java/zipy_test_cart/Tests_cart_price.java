package zipy_test_cart;
import java.math.BigDecimal;

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

public class Tests_cart_price extends Tests_cart_MAIN {
	
	
	//Test - checking the final sum in the cart includes the delivery 
	@Test		
	public  void Tests_cart_price_includesDelivery() throws Exception {
		System.out.println("Running test for checking the final sum in the cart includes the delivery ");		

		//get to the required product page and save the sum of its price and delivery price/
		driver.get(ElementsBuying.Product_noVariations);
		String Sum = Tests_functions.priceSum(driver,ElementsBuying.Product_price,ElementsBuying.Product_delivery).trim();


		//add to the cart
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();
		Tests_functions.openCart(driver);
		String FinalSum = driver.findElement(By.xpath(ElementsBuying.Product_cart_finalSum)).getText();

		// if the prices added correctly, the final price will be the sum of original price plus delivery :
		Assert.assertTrue(FinalSum.contains(Sum));
					
	}
	

	//Test - checking the final sum in the cart includes the discount 
	@Test		
	public  void Tests_cart_price_includesDiscount() throws Exception {
		System.out.println("Running test for checking the final sum in the cart includes the discount");		

		//get to the required product page
		driver.get(ElementsBuying.Product_oneVariation);

		//choose the product variation - first option from the droplist
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_variationsColor))).click();		
		WebElement variationColor_1 = driver.findElement(By.xpath(ElementsBuying.Product_variationsColor_1));
		variationColor_1.click();
				
		//add to the cart and save the price after discount
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();
		Thread.sleep(3000);
		String priceAfterDiscount = driver.findElement(By.xpath(ElementsBuying.Product_discount)).getText();	
		Tests_functions.openCart(driver);
		
		String FinalSum = driver.findElement(By.xpath(ElementsBuying.Product_cart_finalSum)).getText();
		
		// if the prices added correctly, the price after the discount will be the final sum	
		Assert.assertTrue(FinalSum.contains(priceAfterDiscount));
						
	}

	
	//Test - checking the final sum in the cart includes all products in the cart 
	@Test		
	public  void Tests_cart_price_sumOfProducts() throws Exception {
		System.out.println("Running test for checking the final sum in the cart includes all products in the cart ");		

		//get to the first product page and save its price
		driver.get(ElementsBuying.Product_noVariations);
		Thread.sleep(500);
		String price1 = Tests_functions.priceSum(driver, ElementsBuying.Product_price, ElementsBuying.Product_delivery).trim();
		
		//add to the cart 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();

		//get to the second product page and save its price
		driver.get(ElementsBuying.Product_noVariations2);
		Thread.sleep(500);
		String price2 = Tests_functions.priceSum(driver, ElementsBuying.Product_price, ElementsBuying.Product_delivery).trim();
		
		//add to the cart
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();
		
		//the sum of both products
		String Sum = Tests_functions.stringSum(driver,price1,price2).trim();
		Tests_functions.openCart(driver);
		String FinalSum = driver.findElement(By.xpath(ElementsBuying.Product_cart_finalSum)).getText();

		// if the prices added correctly, the final price will be the sum of two products	
		Assert.assertTrue(FinalSum.contains(Sum));
					
		//at the end, remove the products from the cart, for the future tests		
		Tests_functions.emptyCart(driver);		
	}
		
		
	//Test - checking the final sum in the cart affected by the quantity of the product 
	@Test		
	public  void Tests_cart_price_quantity() throws Exception {
		System.out.println("Running test for checking the final sum in the cart affected by the quantity of the product");		

		//get to the first product page and save its price
		driver.get(ElementsBuying.Product_noVariations);
				
		//increase the quantity to 2 and save the price
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_quantityPlus))).click();
		Thread.sleep(3000);
		String price = Tests_functions.priceSum(driver, ElementsBuying.Product_price, ElementsBuying.Product_delivery).trim();
		
		//the sum of two products
		String Sum = Tests_functions.stringSum(driver,price,price).trim();
						
		//add to the cart 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();
		Tests_functions.openCart(driver);
		String FinalSum = driver.findElement(By.xpath(ElementsBuying.Product_cart_finalSum)).getText();

		// if the prices added correctly, the final price will be the sum of two units
		Assert.assertTrue(FinalSum.contains(Sum));
						
		}
		
	
	//Test - checking the final sum in the cart includes all different variations of the same product 
	@Test		
	public  void Tests_cart_price_diffElements() throws Exception {
		System.out.println("Running test for checking the final sum in the cart includes all variations of the same product");		

		//get to the required product page
		driver.get(ElementsBuying.Product_oneVariation);

		//choose the product variation - first option from the droplist and save its price
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_variationsColor))).click();		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_variationsColor_1))).click();;
		Thread.sleep(3000);
		String price1 = driver.findElement(By.xpath(ElementsBuying.Product_discount)).getText().trim();	
		
		//add to the cart 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_quantityPlusAgain)));

		//choose another product variation - second option from the droplist - and save its name
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_variationsColorAgain))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_variationsColor_3))).click();;
		Thread.sleep(3000);
		String price2 = driver.findElement(By.xpath(ElementsBuying.Product_discount)).getText().trim();	
		
		//the sum of two variations
		String Sum = Tests_functions.stringSum(driver,price1,price2).trim();
		
		//add to the cart 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();
		Tests_functions.openCart(driver);
		String FinalSum = driver.findElement(By.xpath(ElementsBuying.Product_cart_finalSum)).getText();

		// if the prices added correctly, the final sum	includes the prices of all variations
		Assert.assertTrue(FinalSum.contains(Sum));
					
		//at the end, remove the products from the cart, for the future tests		
		Tests_functions.emptyCart(driver);		
	}
	
	
	//Test - checking the final sum in the cart affected by removing one of the products
	@Test		
	public  void Tests_cart_price_removingProduct() throws Exception {
		System.out.println("Running test for checking the final sum in the cart affected by removing one of the products ");		

		//get to the first product page and save its price
		driver.get(ElementsBuying.Product_noVariations);
		Thread.sleep(500);
		String price1 = Tests_functions.priceSum(driver, ElementsBuying.Product_price, ElementsBuying.Product_delivery).trim();
		
		//add to the cart 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();

		//get to the second product page and save its price
		driver.get(ElementsBuying.Product_noVariations2);
		Thread.sleep(500);
		String price2 = Tests_functions.priceSum(driver, ElementsBuying.Product_price, ElementsBuying.Product_delivery).trim();
		
		//add to the cart
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();
		
		//reopen the cart and remove the first item from the cart		
		driver.get(ElementsWebsites.Zipy_il);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_openCart))).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_cartRemove))).click();
		Thread.sleep(500);
		String FinalSum = driver.findElement(By.xpath(ElementsBuying.Product_cart_finalSum)).getText();

		// if the prices added correctly, the final price will be of the second product only	
		Assert.assertTrue(FinalSum.contains(price2));
		
		//at the end, remove the products from the cart, for the future tests		
		Tests_functions.openAndEmptyCart(driver);	
							
	}
	
	
	//Test - checking the final sum in the cart affected by changing the quantity in the cart
	@Test		
	public  void Tests_cart_price_changeQuantity() throws Exception {
		System.out.println("Running test for checking the final sum in the cart affected by changing the quantity in the cart");		

		//get to the required product page and save its price
		driver.get(ElementsBuying.Product_noVariations);
		Thread.sleep(500);
		String price = Tests_functions.priceSum(driver, ElementsBuying.Product_price, ElementsBuying.Product_delivery).trim();
		
		//increase the quantity to 2 and then add to the cart 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_quantityPlus))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();

		//reopen the cart and change the quantity manually to "1"
		driver.get(ElementsWebsites.Zipy_il);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_openCart))).click();	
		String FirstSum = driver.findElement(By.xpath(ElementsBuying.Product_cart_finalSum)).getText();
		Thread.sleep(500);
		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsBuying.Product_quantity))).click()
				.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys("1",Keys.ENTER).build().perform();
		
		WebElement Sum = driver.findElement(By.xpath(ElementsBuying.Product_cart_finalSum));
		new WebDriverWait(driver, 30).until(ExpectedConditions.not(ExpectedConditions.
				textToBePresentInElement(Sum, FirstSum)));
		String FinalSum = driver.findElement(By.xpath(ElementsBuying.Product_cart_finalSum)).getText();

		// the final sum supposed to be of 1 unit only :
		Assert.assertTrue(FinalSum.contains(price));
						
	}
	
}

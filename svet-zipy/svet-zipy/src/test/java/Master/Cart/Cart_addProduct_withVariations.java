package Master.Cart;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import zipy_elements.*;

public class Cart_addProduct_withVariations extends Cart_MAIN {
	

	//Test - adding a product to the cart - with one variation)
	@Test		
	public  void Tests_cart_addProduct_oneVariation() throws Exception {
		System.out.println("Running test for adding product to the cart - with one variation)");		
		
		//get to the required product page
		driver.get(ElementsBuying.Product_oneVariation);
		
		//make sure there is no 400 error
		Functions.validate_error404(driver);

		//save its name
		String ProductTitle = act.elementAttText(ElementsBuying.Product_titleFromPicture, "alt", driver);		

		//choose the product variation - first option - and save variation name
		Functions.chooseVariations_firstVariation_productPage(driver, "1");
		String ProductElement1 = act.elementText(ElementsBuying.Product_variationsFirst_text, driver);
						
		//add to the cart
		Thread.sleep(2000);
		act.waitForPresenceAndClick(ElementsBuying.Product_addToCart, driver);
		WebElement cartFrame = Functions.openCart(driver);

		// if we managed to add the product correctly, its title and its chosen variation are found in the cart:
		Assert.assertTrue((cartFrame.getText().contains(ProductTitle))&&
						(cartFrame.getText().contains(ProductElement1)));
	}
			

	//Test - adding a product to the cart - with two variations
	@Test		
	public  void Tests_cart_addProduct_twoVariations() throws Exception {
		System.out.println("Running test for adding product to the cart - with two variations");		
		
		//get to the required product page
		driver.get(ElementsBuying.Product_twoVariations);
		//make sure there is no 400 error
		Functions.validate_error404(driver);

		//save its name
		String ProductTitle = act.elementAttText(ElementsBuying.Product_titleFromPicture, "alt", driver);				

		//choose the first variation - first option - and save its name
		Functions.chooseVariations_firstVariation_productPage(driver, "1");
		String ProductVariation1 = act.elementText(ElementsBuying.Product_variationsFirst_text, driver);
		
		//choose the second variation - first option - and save its name
		Functions.chooseVariations_secondVariation_productPage(driver, "1");
		String ProductVariation2 = act.elementText(ElementsBuying.Product_variationsSecond_text, driver);
		
		//add to the cart
		Thread.sleep(2000);
		act.waitForPresenceAndClick(ElementsBuying.Product_addToCart, driver);
		WebElement cartFrame = Functions.openCart(driver);

		// if we managed to add the product correctly, its title and its chosen variations are found in the cart:
		Assert.assertTrue((cartFrame.getText().contains(ProductTitle))&&
						(cartFrame.getText().contains(ProductVariation1))&&
						(cartFrame.getText().contains(ProductVariation2)));
	}
	
		
	//Test - adding a same product twice to the cart, each time with one different variation
	@Test		
	public  void Tests_cart_addProductTwice_oneVariation() throws Exception {
			System.out.println("Running test for adding product to the cart twice, each time with one different variation");		
			
			//get to the required product page
			driver.get(ElementsBuying.Product_oneVariation);
	
			//make sure there is no 400 error
			Functions.validate_error404(driver);

			//save its name
			String ProductTitle = act.elementAttText(ElementsBuying.Product_titleFromPicture, "alt", driver);		

			//choose the product variation - first option - and save elements name
			Functions.chooseVariations_firstVariation_productPage(driver, "1");
			String ProductVariation1 = act.elementText(ElementsBuying.Product_variationsFirst_text, driver);						
			
			//add to the cart
			Thread.sleep(2000);
			act.waitForPresenceAndClick(ElementsBuying.Product_addToCart, driver);
			act.waitForPresence(ElementsBuying.Product_quantityPlusAgain, driver);

			//choose another product variation - third option - and save its name
			Functions.chooseVariations_firstVariationAgain_productPage(driver, "3");
			String ProductVariation2 = act.elementText(ElementsBuying.Product_variationsFirst_text, driver);
			
			//add to the cart again
			Thread.sleep(2000);
			act.waitForPresenceAndClick(ElementsBuying.Product_addToCart, driver);
			WebElement cartFrame = Functions.openCart(driver);

			// if we managed to add the product correctly, its title and its chosen variations are found in the cart:
			Assert.assertTrue((cartFrame.getText().contains(ProductTitle))&&
							(cartFrame.getText().contains(ProductVariation1))&&
							(cartFrame.getText().contains(ProductVariation2)));
							
			//at the end, remove the product from the cart, for the future tests
			Functions.emptyCart(driver);

		}	
	
				
	//Test - adding a same product twice to the cart, each time with two different variation (while the first is the same in both cases)
	@Test		
	public  void Tests_cart_addProductTwice_twoVariations() throws Exception {
		System.out.println("adding a same product twice to the cart, each time with two different variation (while the first is the same in both cases)");		
		
		//get to the required product page
		driver.get(ElementsBuying.Product_twoVariations);
		//make sure there is no 400 error
		Functions.validate_error404(driver);

		//save its name
		String ProductTitle = act.elementAttText(ElementsBuying.Product_titleFromPicture, "alt", driver);				

		//choose the first variation - first option - and save its name
		Functions.chooseVariations_firstVariation_productPage(driver, "1");
		String ProductVariation1 = act.elementText(ElementsBuying.Product_variationsFirst_text, driver);
		
		//choose the second variation - first option - and save its name
		Functions.chooseVariations_secondVariation_productPage(driver, "1");
		String ProductVariation2 = act.elementText(ElementsBuying.Product_variationsSecond_text, driver);
		
		//add to the cart
		Thread.sleep(2000);
		act.waitForPresenceAndClick(ElementsBuying.Product_addToCart, driver);
		act.waitForPresence(ElementsBuying.Product_quantityPlusAgain, driver);

		//choose another second product variation - second option - and save its name
		Functions.chooseVariations_secondVariationAgain_productPage(driver, "2");
		String ProductVariation3 = act.elementText(ElementsBuying.Product_variationsFirst_text, driver);

		//add to the cart again
		Thread.sleep(2000);
		act.waitForPresenceAndClick(ElementsBuying.Product_addToCart, driver);

		WebElement cartFrame = Functions.openCart(driver);

		// if we managed to add the product correctly, its title and its chosen variations are found in the cart:
		Assert.assertTrue((cartFrame.getText().contains(ProductTitle))&&
						(cartFrame.getText().contains(ProductVariation1))&&
						(cartFrame.getText().contains(ProductVariation2))&&
						(cartFrame.getText().contains(ProductVariation3)));
						
		//at the end, remove the product from the cart, for the future tests
		Functions.emptyCart(driver);
		}		
		
	
	//Test - adding twice the same product to the cart, using plus-one button  
	@Test		
	public  void Tests_cart_addProduct_plusOne() throws Exception {
		System.out.println("Running test for adding twice the same product to the cart, using plus-one button ");		
		
		//get to the required product page
		driver.get(ElementsBuying.Product_noVariations);

		//make sure there is no 400 error
		Functions.validate_error404(driver);


		//add to the cart and then add another one to the cart with the plus-one button
		Thread.sleep(1500);
		act.waitForPresenceAndClick(ElementsBuying.Product_addToCart, driver);
		Thread.sleep(1500);
		act.waitForPresenceAndClick(ElementsBuying.Product_plusOne, driver);

		WebElement cartFrame = Functions.openCart(driver);

		// if we managed to add the product twice, its quantity in the cart is 2:
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Product_cart_quantity)).getAttribute("value").equals("2"));	
		
	}
		
	
	//Test - adding twice the same product to the cart, using quantity button 
	@Test		
	public  void Tests_cart_addProduct_quantityTwo() throws Exception {
		System.out.println("Running test for adding twice the same product to the cart, using quantity button");				
		
		//get to the required product page
		driver.get(ElementsBuying.Product_noVariations);

		//make sure there is no 400 error
		Functions.validate_error404(driver);

		
		//increase the quantity to 2 and then add to the cart 
		act.waitForClickableAndClick(ElementsBuying.Product_quantityPlus, driver);

		Thread.sleep(2000);
		act.waitForPresenceAndClick(ElementsBuying.Product_addToCart, driver);

		WebElement cartFrame = Functions.openCart(driver);

		// if we managed to add the product twice, its quantity in the cart is 2:
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Product_cart_quantity)).getAttribute("value").equals("2"));	
		

	}
	
		
	//Test - adding twice the same product to the cart, using quantity and then plus-one button
	@Test		
	public  void Tests_cart_addProduct_quantityTwo_plusOne() throws Exception {
		System.out.println("Running test for adding twice the same product to the cart, using quantity and then plus-one button");		

		//get to the required product page
		driver.get(ElementsBuying.Product_noVariations);

		//make sure there is no 400 error
		Functions.validate_error404(driver);


		//add to the cart and then increase the quantity to another 2 and add to the cart again 
		Thread.sleep(2000);
		act.waitForPresenceAndClick(ElementsBuying.Product_addToCart, driver);
		act.waitForClickableAndClick(ElementsBuying.Product_quantityPlusAgain, driver);

		Thread.sleep(1000);
		act.waitForClickableAndClick(ElementsBuying.Product_plusOne, driver);

		WebElement cartFrame = Functions.openCart(driver);

		// if we managed to add the product and then add it twice again, its quantity in the cart is 3:
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Product_cart_quantity)).getAttribute("value").equals("3"));

	}
	
	
	//Test - adding twice the same product to the cart, by changing quantity manually in the cart
	@Test		
	public  void Tests_cart_addProduct_changeQuantity() throws Exception {
		System.out.println("Running test for adding twice the same product to the cart, by changing quantity manually in the cart");		
		
		//get to the required product page
		driver.get(ElementsBuying.Product_noVariations);

		//make sure there is no 400 error
		Functions.validate_error404(driver);


		//add to the cart 
		Thread.sleep(2000);
		act.waitForPresenceAndClick(ElementsBuying.Product_addToCart, driver);

		//back to main page and open the cart			
		driver.get(ElementsWebsites.Zipy_il);

		act.waitForClickableAndClick(ElementsBuying.Product_openCart, driver);
		Thread.sleep(3000);
		//change the quantity in the cart manually to 3
		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsBuying.Product_cart_quantity))).click()
				.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys("3",Keys.ENTER).build().perform();
		
		WebElement cartFrame = Functions.openCart(driver);

		// if we managed to add the product twice, its quantity in the cart is 2:
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Product_cart_quantity)).getAttribute("value").equals("3"));
		

	}
	

}

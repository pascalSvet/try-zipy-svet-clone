package zipy_test_cart;
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

public class Tests_cart_addProduct_withVariations extends Tests_cart_MAIN {
	

	//Test - adding a product to the cart - with one variation)
	@Test		
	public  void Tests_cart_addProduct_oneVariation() throws Exception {
		System.out.println("Running test for adding product to the cart - with one variation)");		
		
		//get to the required product page and save its title
		driver.get(ElementsBuying.Product_oneVariation);
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");		

		//choose the product variation - first option from the droplist - and save variation name
		driver.findElement(By.xpath(ElementsBuying.Product_variationsColor)).click();		
		WebElement elementColor_1 = driver.findElement(By.xpath(ElementsBuying.Product_variationsColor_1));
		String ProductElement1 = elementColor_1.getText();
		elementColor_1.click();
		
		//add to the cart
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();
		WebElement cartFrame = Tests_functions.openCart(driver);

		// if we managed to add the product correctly, its title and its chosen variation are found in the cart:
		Assert.assertTrue((cartFrame.getText().contains(ProductTitle))&&
						(cartFrame.getText().contains(ProductElement1)));
	
	}
			

	//Test - adding a product to the cart - with two variations
	@Test		
	public  void Tests_cart_addProduct_twoVariations() throws Exception {
		System.out.println("Running test for adding product to the cart - with two variations)");		
		
		//get to the required product page and save its title
		driver.get(ElementsBuying.Product_twoVariations);
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");				

		//choose the first variation - first option from the first droplist - and save its name
		driver.findElement(By.xpath(ElementsBuying.Product_variationsColor)).click();		
		WebElement variationColor_1 = driver.findElement(By.xpath(ElementsBuying.Product_variationsColor_1));
		String ProductVariation1 = variationColor_1.getText();
		variationColor_1.click();
		
		//choose the second variation - first option from the second droplist - and save its name
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_variationsLength))).click();		
		WebElement variationLength_1 = driver.findElement(By.xpath(ElementsBuying.Product_variationsLength_1));
		String ProductVariation2 = variationLength_1.getText();
		variationLength_1.click();
		
		//add to the cart
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();
		WebElement cartFrame = Tests_functions.openCart(driver);

		// if we managed to add the product correctly, its title and its chosen variations are found in the cart:
		Assert.assertTrue((cartFrame.getText().contains(ProductTitle))&&
						(cartFrame.getText().contains(ProductVariation1))&&
						(cartFrame.getText().contains(ProductVariation2)));
	}
	
		
	//Test - adding a same product twice to the cart, each time with one different variation
	@Test		
	public  void Tests_cart_addProductTwice_oneVariation() throws Exception {
			System.out.println("Running test for adding product to the cart twice, each time with one different variation");		
			
			//get to the required product page and save its title
			driver.get(ElementsBuying.Product_oneVariation);
			String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");		

			//choose the product variation - first option from the droplist - and save elements name
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_variationsColor))).click();		
			Thread.sleep(1000);
			WebElement variationColor_1 = driver.findElement(By.xpath(ElementsBuying.Product_variationsColor_1));
			String ProductVariation1 = variationColor_1.getText().trim();;
			variationColor_1.click();						
			
			//add to the cart
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();

			//choose another product variation - second option from the droplist - and save its name
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_variationsColorAgain))).click();
			Thread.sleep(2000);
			WebElement variationColor_2 = driver.findElement(By.xpath(ElementsBuying.Product_variationsColor_3));
			String ProductVariation2 = variationColor_2.getText().trim();
			variationColor_2.click();
			
			//add to the cart again
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();
			WebElement cartFrame = Tests_functions.openCart(driver);

			// if we managed to add the product correctly, its title and its chosen variations are found in the cart:
			Assert.assertTrue((cartFrame.getText().contains(ProductTitle))&&
							(cartFrame.getText().contains(ProductVariation1))&&
							(cartFrame.getText().contains(ProductVariation2)));
							
			//at the end, remove the product from the cart, for the future tests
			driver.findElement(By.xpath(ElementsBuying.Product_cartRemove)).click();
		}	
	
			
	//Test - adding a same product twice to the cart, each time with two different variation (while the first is the same in both cases)
	@Test		
	public  void Tests_cart_addProductTwice_twoVariations() throws Exception {
		System.out.println("adding a same product twice to the cart, each time with two different variation (while the first is the same in both cases)");		
		
		//get to the required product page and save its title
		driver.get(ElementsBuying.Product_twoVariations);
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");				

		//choose the first variation - first option from the first droplist - and save its name
		driver.findElement(By.xpath(ElementsBuying.Product_variationsColor)).click();		
		WebElement variationColor_1 = driver.findElement(By.xpath(ElementsBuying.Product_variationsColor_1));
		String ProductVariation1 = variationColor_1.getText().trim();;
		variationColor_1.click();
		
		//choose the second variation - first option from the second droplist - and save its name
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_variationsLength))).click();		
		WebElement variationLength_1 = driver.findElement(By.xpath(ElementsBuying.Product_variationsLength_1));
		String ProductVariation2 = variationLength_1.getText().trim();;
		variationLength_1.click();
		
		//add to the cart
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();

		//choose the second variation again - second option from the second droplist - and save its name
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_variationsLengthAgain))).click();	
		Thread.sleep(1000);
		WebElement variationLength_2 = driver.findElement(By.xpath(ElementsBuying.Product_variationsLength_2));
		String ProductVariation3 = variationLength_2.getText().trim();
		variationLength_2.click();

		//add to the cart again
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();

		WebElement cartFrame = Tests_functions.openCart(driver);

		// if we managed to add the product correctly, its title and its chosen variations are found in the cart:
		Assert.assertTrue((cartFrame.getText().contains(ProductTitle))&&
						(cartFrame.getText().contains(ProductVariation1))&&
						(cartFrame.getText().contains(ProductVariation2))&&
						(cartFrame.getText().contains(ProductVariation3)));
						
		//at the end, remove the product from the cart, for the future tests
		driver.findElement(By.xpath(ElementsBuying.Product_cartRemove)).click();
		}		
		
		
	//Test - adding twice the same product to the cart, using plus-one button  
	@Test		
	public  void Tests_cart_addProduct_plusOne() throws Exception {
		System.out.println("Running test for adding twice the same product to the cart, using plus-one button ");		
		
		//get to the required product page and save its title
		driver.get(ElementsBuying.Product_noVariations);
		
		//add to the cart and then add another one to the cart with the plus-one button
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_plusOne))).click();

		WebElement cartFrame = Tests_functions.openCart(driver);

		// if we managed to add the product twice, its quantity in the cart is 2:
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Product_quantity)).getAttribute("value").equals("2"));	
		
		//at the end, remove the product from the cart, for the future tests
		driver.findElement(By.xpath(ElementsBuying.Product_cartRemove)).click();
	}
		
	
	//Test - adding twice the same product to the cart, using quantity button 
	@Test		
	public  void Tests_cart_addProduct_quantityTwo() throws Exception {
		System.out.println("Running test for adding twice the same product to the cart, using quantity button");				
		
		//get to the required product page and save its title
		driver.get(ElementsBuying.Product_noVariations);
		
		//increase the quantity to 2 and then add to the cart 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_quantityPlus))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_addToCart))).click();

		WebElement cartFrame = Tests_functions.openCart(driver);

		// if we managed to add the product twice, its quantity in the cart is 2:
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Product_quantity)).getAttribute("value").equals("2"));	
		
		//at the end, remove the product from the cart, for the future tests
		driver.findElement(By.xpath(ElementsBuying.Product_cartRemove)).click();
	}
	
		
	//Test - adding twice the same product to the cart, using quantity and then plus-one button
	@Test		
	public  void Tests_cart_addProduct_quantityTwo_plusOne() throws Exception {
		System.out.println("Running test for adding twice the same product to the cart, using quantity and then plus-one button");		

		//get to the required product page and save its title
		driver.get(ElementsBuying.Product_noVariations);
		
		//ad to the cart and then increase the quantity to another 2 and add to the cart again 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_addToCart))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_quantityPlusAgain))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_plusOne))).click();

		WebElement cartFrame = Tests_functions.openCart(driver);

		// if we managed to add the product and then add it twice again, its quantity in the cart is 3:
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Product_quantity)).getAttribute("value").equals("3"));
		
		//at the end, remove the product from the cart, for the future tests
		driver.findElement(By.xpath(ElementsBuying.Product_cartRemove)).click();
	}
	
	
	//Test - adding twice the same product to the cart, by changing quantity manually in the cart
	@Test		
	public  void Tests_cart_addProduct_changeQuantity() throws Exception {
		System.out.println("Running test for adding twice the same product to the cart, by changing quantity manually in the cart");		
		
		//get to the required product page and save its title
		driver.get(ElementsBuying.Product_noVariations);
		
		//add to the cart 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();

		//back to main page and open the cart			
		driver.get(ElementsWebsites.Zipy_il);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_openCart))).click();
		Thread.sleep(2000);
		//change the quantity in the cart manually to 2
		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsBuying.Product_quantity))).click()
				.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys("2",Keys.ENTER).build().perform();
		
		WebElement cartFrame = Tests_functions.openCart(driver);

		// if we managed to add the product twice, its quantity in the cart is 2:
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Product_quantity)).getAttribute("value").equals("2"));
		
		//at the end, remove the product from the cart, for the future tests
		driver.findElement(By.xpath(ElementsBuying.Product_cartRemove)).click();
	}
	

}

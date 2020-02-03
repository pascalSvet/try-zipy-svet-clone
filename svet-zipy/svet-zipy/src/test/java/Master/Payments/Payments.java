package Master.Payments;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import zipy_elements.*;

public class Payments extends Payments_MAIN {
	
	
	//Test - buying product, directy from search
	@Test		
	public  void buy_from_search() throws Exception {
	System.out.println("Running test for finding and buying a sample product");
	
		//login with credited user
		Functions.logInVika(driver);		
				
		// perform search and open the product
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(ElementsBuying.SearchItemAli, Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath(ElementsBuying.SearchItemAli_thumb)))).click();;
		
		//choose the color and size options 
		Functions.chooseVariations_ProductFramed(driver);
		
		//buy directly
		driver.findElement(By.xpath(ElementsBuying.Checkout_button)).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(ElementsBuying.FinalBuy_button)))).click();
		
		// if we managed to buy there is a message of "thank you for buying"
		wait.until(ExpectedConditions.urlToBe("https://www.zipy.co.il/payment/success"));
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Thanks_box)).getText().contains(ElementsHeb.ThanksForBuying_heb));

	}

 
	//Test - buying product from the cart
	@Test		
	public  void buy_from_cart() throws Exception {
	System.out.println("Running test for buying a product from the cart");
	
		//login with credited user
		Functions.logInVika(driver);		
				
		// open the product page
		driver.get(ElementsBuying.SearchItemAli_link);

		//choose the color and size options
		Functions.chooseVariations_ProductPage(driver);

		//add to the cart
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();

		//back to main page and open the cart			
		driver.get(ElementsWebsites.Zipy_il);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_openCart))).click();
		WebElement cartFrame = driver.findElement(By.xpath(ElementsBuying.Product_cartFrame));
		wait.until(ExpectedConditions.visibilityOf(cartFrame));
				
		//buy from cart
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_cartPay))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(ElementsBuying.FinalBuy_button)))).click();

		// if we managed to buy there is a message of "thank you for buying"
		wait.until(ExpectedConditions.urlToBe("https://www.zipy.co.il/payment/success"));
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Thanks_box)).getText().contains(ElementsHeb.ThanksForBuying_heb));

	}
	
	
	//Test - buying all products from the cart
	@Test		
	public  void buy_From_cartAll() throws Exception {
	System.out.println("Running test for buying all products from the cart");
	
		//login with credited user
		Functions.logInVika(driver);		
				
		// open the first product page
		driver.get(ElementsBuying.SearchItemAli_link);

		//choose the variations and add to the cart
		Functions.chooseVariations_ProductPage(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();

		// open the second product page
		driver.get(ElementsBuying.SearchItemAli_link2);

		//choose the variations and add to the cart
		Functions.chooseVariations_ProductPage(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();

		//back to main page and open the cart			
		driver.get(ElementsWebsites.Zipy_il);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_openCart))).click();
		WebElement cartFrame = driver.findElement(By.xpath(ElementsBuying.Product_cartFrame));
		wait.until(ExpectedConditions.visibilityOf(cartFrame));
				
		//buy from cart
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_cartPay))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(ElementsBuying.FinalBuy_button)))).click();
		wait.until(ExpectedConditions.urlToBe("https://www.zipy.co.il/payment/success"));

		//back to main page and open the cart again		
		driver.get(ElementsWebsites.Zipy_il);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_openCart))).click();
		wait.until(ExpectedConditions.visibilityOf(cartFrame));
		
		// if we managed to buy all products, there is a message of empty cart
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Product_cartIsEmpty)).isDisplayed());					

	}	
	
	
	//Test - buying product directly from its page, when there is another product in the cart
	@Test		
	public  void buy_fromLinkDirectly_cartNotEmpty() throws Exception {
	System.out.println("Running test for buying a product directly from its page, when there is another product in the cart");
	
		//login with credited user
		Functions.logInVika(driver);		
				
		// open the first product page
		driver.get(ElementsBuying.SearchItemAli_link);

		//choose the variations and add to the cart
		Functions.chooseVariations_ProductPage(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();

		// open the second product page
		driver.get(ElementsBuying.SearchItemAli_link2);

		//choose the variations and buy directly
		Functions.chooseVariations_ProductPage(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.PayNow_button))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(ElementsBuying.FinalBuy_button)))).click();
		wait.until(ExpectedConditions.urlToBe("https://www.zipy.co.il/payment/success"));
		
		//back to main page and open the cart again		
		driver.get(ElementsWebsites.Zipy_il);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_openCart))).click();
		WebElement cartFrame = driver.findElement(By.xpath(ElementsBuying.Product_cartFrame));
		wait.until(ExpectedConditions.visibilityOf(cartFrame));
		
		// if we managed to buy all products, including the one that was in the cart, there is a message of empty cart
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Product_cartIsEmpty)).isDisplayed());					

	}	
	
	
	//Test - buying product, from aliExpress
	@Test		
	public  void buy_from_aliExpress() throws Exception {
	System.out.println("Running test for finding and buying a sample product");
	
		//login with credited user
		Functions.logInVika(driver);		
				
		// open the product page
		driver.get(ElementsBuying.SearchItemAli_link);

		//choose the color and size options
		Functions.chooseVariations_ProductPage(driver);
		
		//buy directly
		driver.findElement(By.xpath(ElementsBuying.Checkout_button)).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(ElementsBuying.FinalBuy_button)))).click();
		wait.until(ExpectedConditions.urlToBe("https://www.zipy.co.il/payment/success"));

		// if we managed to buy there is a message of "thank you for buying"
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Thanks_box)).getText().contains(ElementsHeb.ThanksForBuying_heb));

	}

		
	//Test - buying product from amazon
	@Test		
	public  void buy_from_amazon() throws Exception {
	System.out.println("Running test for buying a sample product directly from amazon");
	
		//login with credited user 
		Functions.logInVika(driver);		
				
		// open the product page
		driver.get(ElementsBuying.SearchItemAmazon_link);

		//choose the variations and buy directly
		Functions.chooseVariations_ProductPage(driver);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.PayNow_button))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(ElementsBuying.FinalBuy_button)))).click();
		wait.until(ExpectedConditions.urlToBe("https://www.zipy.co.il/payment/success"));
		
		// if we managed to buy there is a message of "thank you for buying"
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Thanks_box)).getText().contains(ElementsHeb.ThanksForBuying_heb));				
	}
	 
	
	//Test - buying random product, from lessThan5 tab 
	@Test		
	public  void buy_from_lessThan5() throws Exception {
	System.out.println("Running test for buying random product, from lessThan5 tab ");
	
		//login with credited user
		Functions.logInVika(driver);		
		
		//open the lessThan5 tab and pick the first product in deals 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.lessThan5_Open))).click();;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.lessThan5_dealThumbnail1))).click();;
		new WebDriverWait(driver, 20).until(ExpectedConditions.not(ExpectedConditions.urlToBe("https://www.zipy.co.il/fiveshekel/")));

		//choose the color and size options if exist
		Functions.chooseVariations_ProductFramed(driver);

		//buy directly
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Checkout_button))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.FinalBuy_button))).click();
		
		// if we managed to buy there is a message of "thank you for buying"
		wait.until(ExpectedConditions.urlToBe("https://www.zipy.co.il/payment/success"));
		Assert.assertTrue(driver.findElement(By.xpath(ElementsBuying.Thanks_box)).getText().contains(ElementsHeb.ThanksForBuying_heb));
	}

}

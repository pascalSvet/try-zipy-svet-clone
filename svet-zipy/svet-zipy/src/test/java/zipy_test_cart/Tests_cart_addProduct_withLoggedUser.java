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

public class Tests_cart_addProduct_withLoggedUser extends Tests_cart_MAIN {
	
			
	//Test - adding a product while unlogged, and then logging in and checking for the product in the cart
	@Test		
	public  void Tests_cart_addProduct_logginAfterAdding() throws Exception {
		System.out.println("Running test for adding product to the cart while the user unlogged, and then logging in");		
		

		//get to the required product page and save its title
		driver.get(ElementsBuying.Product_noVariations);
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");
		
		//add to the cart
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_added)));

		//back to main page and connect to the user
		driver.get(ElementsWebsites.Zipy_il);
		Tests_functions.logIn(driver);
				
		WebElement cartFrame = Tests_functions.openCart(driver);

		// if we managed to add the product, its title is found in the cart:
		Assert.assertTrue(cartFrame.getText().contains(ProductTitle));
		
		//empty the cart and disconect from the user for the next tests
		Tests_functions.openAndEmptyCart(driver);
		Tests_functions.unLogIn(driver);				
		}
	
	
	//Test - adding a product for logged user, then disconnecting and logging in back, and checking for the product in the cart
	@Test		
	public  void Tests_cart_addProduct_disconnectAndLogInBack() throws Exception {
		System.out.println("Running test for adding product to the cart for logged user,then disconnecting and logging in back");		
		
		//connect to the user
		driver.get(ElementsWebsites.Zipy_il);
		Tests_functions.logIn(driver);
		
		//get to the required product page and save its title
		driver.get(ElementsBuying.Product_noVariations);
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");
		
		//add to the cart /
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();
		
		//disconnect from the user and then connect back 
		Tests_functions.unLogIn(driver);
		Thread.sleep(1000);
		driver.get(ElementsWebsites.Zipy_il);
		Tests_functions.logIn(driver);
				
		WebElement cartFrame = Tests_functions.openCart(driver);

		// if we managed to add the product, its title is found in the cart:
		Assert.assertTrue(cartFrame.getText().contains(ProductTitle));
		
		//empty the cart and unlogging at the end for the next tests
		Tests_functions.openAndEmptyCart(driver);
		Tests_functions.unLogIn(driver);
		}
	
	
	
}

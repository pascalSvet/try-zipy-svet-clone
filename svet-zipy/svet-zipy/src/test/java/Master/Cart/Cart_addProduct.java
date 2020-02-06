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
		act.click(ElementsThumbs.dailyDeal_onPage_3, driver);
		act.waitForUrlChange(ElementsWebsites.Zipy_il_deals_withPopup, driver);
		Thread.sleep(2000);
		
		//make sure there is no 400 error
		Functions.validate_error404(driver);

		//save its name
		String ProductTitle = act.elementText(ElementsBuying.Product_titleFromPopup, driver);

		//choose variations if exist and add to the cart
		Thread.sleep(2000);
		Functions.chooseVariations_quickPopupPage(driver);		
		Functions.addToCart_quickPopup(driver);
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
		act.click(ElementsThumbs.lessThan5_3, driver);

		//make sure there is no 400 error
		Functions.validate_error404(driver);

		//save its title	
		String ProductTitle = act.elementText(ElementsThumbs.lessThan5_3_title, driver);
		
		//choose variations if exist and add to the cart
		Functions.chooseVariations_quickPopupPage(driver);		
		Functions.addToCart_quickPopup(driver);
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
		act.click(ElementsThumbs.category_3, driver);

		//make sure there is no 400 error
		Functions.validate_error404(driver);

		//save its title	
		String ProductTitle = act.elementText(ElementsThumbs.category_3_title, driver);
		Functions.closePopUp(driver);
		
		//choose variations if exist and add to the cart
		Functions.chooseVariations_quickPopupPage(driver);
		Functions.addToCart_quickPopup(driver);
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
		act.click(ElementsThumbs.dailyDeal_onPage_3, driver);
		act.waitForUrlChange(currentUrl, driver);
		Thread.sleep(2000);	
		
		//make sure there is no 400 error
		Functions.validate_error404(driver);

		currentUrl = driver.getCurrentUrl();		

		//move to the next product  
		act.click(ElementsBuying.ProductFramed_next, driver);
		act.waitForUrlChange(currentUrl, driver);
		Thread.sleep(2000);	
		
		//make sure there is no 400 error
		Functions.validate_error404(driver);

		//save its name
		String ProductTitle = act.elementText(ElementsBuying.Product_titleFromPopup, driver);

		//choose variations if exist and add to the cart
		Functions.chooseVariations_quickPopupPage(driver);
		Functions.addToCart_quickPopup(driver);
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
		Functions.validate_error404(driver);
		
		//save its name		
		String ProductTitle = act.elementAttText(ElementsBuying.Product_titleFromPicture, "alt", driver);
		
		//add to the cart
		Functions.addToCart(driver);
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
		Functions.validate_error404(driver);

		//save its name		
		String ProductTitle = act.elementAttText(ElementsBuying.Product_titleFromPicture, "alt", driver);
		
		//add to the cart
		Functions.addToCart(driver);

		//get to the amazon product page
		driver.get(ElementsBuying.Product_noVariationsAmazon);
		
		//make sure there is no 400 error
		Functions.validate_error404(driver);

		//save its name
		String ProductTitleAmazon = act.elementAttText(ElementsBuying.Product_titleFromPicture_amazon, "content", driver);
		
		//add to the cart
		Functions.addToCart(driver);
		WebElement cartFrame = Functions.openCart(driver);

		// if we managed to add the products, both titles are in the cart:
		Assert.assertTrue((cartFrame.getText().contains(ProductTitle)) &&
				(cartFrame.getText().contains(ProductTitleAmazon)));
				
		//at the end, remove the product from the cart, for the future tests
		act.click(ElementsBuying.Product_cartRemove, driver);
	
	}
	
	
}

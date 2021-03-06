package zipy_elements;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import zipy_elements.*;

	
public class Functions {
	
////////////// log-in functions: ////////////////////////////////////////////////////////
	
	// A function for login with test user.
	public static void logIn(WebDriver driver) throws Exception{
			
		//press login button		
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click()", driver.findElement(By.xpath(ElementsLogin.Login_button)));
		Thread.sleep(500);
						
		//enter login+password and wait for the logging-in
		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.Login_usernameField))).click()
		.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(ElementsLogin.Email, Keys.TAB, ElementsLogin.Password, Keys.ENTER)
		.build().perform();
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsLogin.UserTopBar)));											
	}
	
	// A function for login with Vika user.
	public static void logInVika(WebDriver driver) throws Exception{
			
		//press login button		
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click()", driver.findElement(By.xpath(ElementsLogin.Login_button)));
		Thread.sleep(500);
						
		//enter login+password and wait for the logging-in
		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.Login_usernameField))).click()
		.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(ElementsLogin.EmailCredit, Keys.TAB, ElementsLogin.PasswordCredit, Keys.ENTER)
		.build().perform();
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsLogin.UserTopBar)));											
	}
	
	// A function for login with test user.
	public static void logInSpecial(WebDriver driver, String email, String password) throws Exception{
			
		//press login button		
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click()", driver.findElement(By.xpath(ElementsLogin.Login_button)));
		Thread.sleep(500);
						
		//enter login+password and wait for the logging-in
		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.Login_usernameField))).click()
		.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(email, Keys.TAB, password, Keys.ENTER)
		.build().perform();
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsLogin.UserTopBar)));											
	}
				
	// A function for unloging.
	public static void unLogIn(WebDriver driver) throws Exception{
			
		//press login button		
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click()", driver.findElement(By.xpath(ElementsLogin.Logedin_button)));
								
		//enter login+password and wait for the logging-in
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsLogin.Login_disconnect))).click();				
	}


	
////////////// user functions: ////////////////////////////////////////////////////////
	
	// A function for changing password.
	public static void changePassword(WebDriver driver, String oldPassword, String newPassword) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 15);	

		//enter private data and choose - change password 
		driver.findElement(By.xpath(ElementsLogin.user_personalDataButton)).click();
		if (driver.manage().window().getSize().getWidth()<=550) {
			driver.findElement(By.xpath(ElementsLogin.user_changePassword_mobile)).click();

		} else {
			driver.findElement(By.xpath(ElementsLogin.user_changePassword)).click();
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsLogin.user_changePassword_currentPassField)));
		Thread.sleep(1000);
		
		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.user_changePassword_currentPassField))).click()
		.sendKeys(oldPassword, Keys.TAB, newPassword, Keys.TAB, newPassword,Keys.ENTER)
		.build().perform();
		Thread.sleep(1000);		
	}
	
	// A function for changing email.
	public static void changeEmail(WebDriver driver, String newEmail, String password) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 15);	

		//enter private data and choose - change password 
		driver.findElement(By.xpath(ElementsLogin.user_personalDataButton)).click();
		if (driver.manage().window().getSize().getWidth()<=550) {
			driver.findElement(By.xpath(ElementsLogin.user_changeEmail_mobile)).click();
		} else {
			driver.findElement(By.xpath(ElementsLogin.user_changeEmail)).click();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsLogin.user_changeEmail_newEmaiField))).click();
		Thread.sleep(1000);
		
		new Actions (driver).sendKeys(newEmail, Keys.TAB, newEmail, Keys.TAB, password,Keys.ENTER)
		.build().perform();
		Thread.sleep(1000);		
	}
	

	
////////////// pop-up functions: ////////////////////////////////////////////////////////

	//close the pop-up window if exist
	public static void closePopUp(WebDriver driver) throws Exception{
		try {
			new WebDriverWait(driver, 10).
			until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsLogin.Popup_welcome_close))).click();
		} catch (Exception e) { }			
	}
	
	//close the pop-up window if exist (in greece version)
	public static void closePopUp_gr(WebDriver driver) throws Exception{

		try {
			new WebDriverWait(driver, 10).
			until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='tucson-body']")));
			System.out.println("0");
			act.click(ElementsLogin.Popup_welcome_close_gr, driver);
			System.out.println("2");
		} catch (Exception e) { System.out.println("111");}
	}

	
	//close the advert pop-up note if exist (in greece version)
	public static void advertNote_close_gr(WebDriver driver) throws Exception{	
		try {
			new WebDriverWait(driver, 8).
			until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ElementsLogin.Start_advertNote_close))).click();
		} catch (Exception e) { }

					
	}
	
	//stop the test in case of 404 error
	public static void validate_error404(WebDriver driver) throws Exception{
		if(driver.getTitle().contains("404")) {
			System.out.println("test failed because of 404 eror");
			Assert.assertTrue(false);
		}	
	}
	
	
////////////// cart functions: ////////////////////////////////////////////////////////
		
	// A function for emptying the cart.
	public static void emptyCart(WebDriver driver) throws Exception{
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, 15);	
		//while there is pay button in the cart, continue deleting the first product from the cart and reopen it
		while (!driver.findElements(By.xpath(ElementsBuying.Product_cartPay)).isEmpty() ) {
				driver.findElement(By.xpath(ElementsBuying.Product_cartRemove)).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_cart_returnToCart)));
				driver.findElement(By.xpath(ElementsBuying.Product_closeCart)).click();
				driver.findElement(By.xpath(ElementsBuying.Product_openCart)).click();
				Thread.sleep(500);
		}	
	}

	// A function for open and emptying the cart.
	public static void openAndEmptyCart(WebDriver driver) throws Exception{
		//back to main page and open the cart			
		driver.get(ElementsWebsites.Zipy_il);
		WebDriverWait wait = new WebDriverWait(driver, 15);	
		
		if(!driver.findElement(By.xpath(ElementsBuying.Product_cart_topBarQuantity)).getText().equals("0")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_openCart))).click();
			WebElement cartFrame = driver.findElement(By.xpath(ElementsBuying.Product_cartFrame));
			wait.until(ExpectedConditions.visibilityOf(cartFrame));
			Functions.emptyCart(driver);
		}
	}
	
	// A function for open the cart and focus on the contents.
	public static WebElement openCart(WebDriver driver) throws Exception{
		//back to main page and open the cart			
		driver.get(ElementsWebsites.Zipy_il);
		WebDriverWait wait = new WebDriverWait(driver, 15);	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_openCart))).click();
		WebElement cartFrame = driver.findElement(By.xpath(ElementsBuying.Product_cartFrame));
		wait.until(ExpectedConditions.visibilityOf(cartFrame));
		return(cartFrame);
	}
	
	// A function for opening and removing product from the cart (in mobile version).
	public static void openAndRemoveFromCart_mobile(WebDriver driver) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 15);	
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_openCart))).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_payment_Remove))).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_paymentPopup_Remove))).click();
	}
	
	// A function for removing product from the cart (in mobile version).
	public static void removeFromCart_mobile(WebDriver driver) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 15);	
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_payment_Remove))).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_paymentPopup_Remove))).click();
	}
	
	// A function for removing product from the cart to favorites (in mobile version).
	public static void removeFromCart_toFavs_mobile(WebDriver driver) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 15);	
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_openCart))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_payment_Remove))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_paymentPopup_moveToFavs))).click();
	}
	
	// A function for emptying the favorites.
	public static void emptyFavorites(WebDriver driver) throws Exception{
		Thread.sleep(500);
		//while there is pay button in the cart, continue deleting the first product from the cart and reopen it
		while (!driver.findElements(By.xpath(ElementsBuying.Product_favoritesTitle)).isEmpty() ) {
				driver.findElement(By.xpath(ElementsBuying.Product_favoritesRemove)).click();
				driver.findElement(By.xpath(ElementsBuying.Product_favoritesButton)).click();
				driver.findElement(By.xpath(ElementsBuying.Product_favoritesButton)).click();
				Thread.sleep(500);
		}	
	}

	
	// A function for adding product to the cart (on product page)
	public static void addToCart(WebDriver driver) throws Exception{
		
		Thread.sleep(2000);
		String cart = act.elementText(ElementsBuying.Product_cart_topBarQuantity, driver);
		Thread.sleep(2000);
		act.waitForClickableAndClick(ElementsBuying.Product_addToCart, driver);
		act.waitForTextChange(ElementsBuying.Product_cart_topBarQuantity, cart, driver);				
	}
	
	// A function for adding product to the cart (on quick popup page)
	public static void addToCart_quickPopup(WebDriver driver) throws Exception{
		
		Thread.sleep(2000);
		String cart = act.elementText(ElementsBuying.Product_cart_topBarQuantity, driver);
		Thread.sleep(2000);
		act.waitForClickableAndClick(ElementsBuying.ProductQuickPopup_addToCart, driver);
		act.waitForTextChange(ElementsBuying.Product_cart_topBarQuantity, cart, driver);				
	}
	
////////////// price functions: ////////////////////////////////////////////////////////
	
	// A function for summing two product prices.
	public static String priceSum(WebDriver driver, String price1, String price2) throws Exception{
		WebElement firstPrice1 = driver.findElement(By.xpath(price1));
		WebElement secondPrice2 = driver.findElement(By.xpath(price2));
		String first = firstPrice1.getText();
		if( first == null) {
			first = "0";
		}
		String second = secondPrice2.getText();
		if( second == null) {
			second = "0";
		}
		double firstPrice = Double.parseDouble(first);
		double secondPrice = Double.parseDouble(second);
		BigDecimal sumTemp = BigDecimal.valueOf(firstPrice).add(BigDecimal.valueOf(secondPrice));
		String Sum = String.valueOf(sumTemp);
		
		while((Sum.charAt(Sum.length() - 1) == '0' && Sum.contains(".")) || Sum.charAt(Sum.length() - 1) == '.') {
			Sum = Sum.substring(0, Sum.length() - 1);			
		}
		return Sum;
	}
		
	
	// A function for summing two strings.
	public static String stringSum(WebDriver driver, String price1, String price2) throws Exception{
		if( price1 == null) {
			price1 = "0";
		}
		if( price2 == null) {
			price2 = "0";
		}
		double firstPrice = Double.parseDouble(price1);
		double secondPrice = Double.parseDouble(price2);
		BigDecimal sumTemp = BigDecimal.valueOf(firstPrice).add(BigDecimal.valueOf(secondPrice));
		String Sum = String.valueOf(sumTemp);

		while((Sum.charAt(Sum.length() - 1) == '0' && Sum.contains(".")) || Sum.charAt(Sum.length() - 1) == '.') {
			Sum = Sum.substring(0, Sum.length() - 1);			
		}
		return Sum;
	}
	
	// A function for multiplying string.
	public static String stringMultiply(WebDriver driver, String price1, int num) throws Exception{
		if( price1 == null) {
			price1 = "0";
		}
		double firstPrice = Double.parseDouble(price1);
		BigDecimal multTemp = BigDecimal.valueOf(firstPrice).multiply(BigDecimal.valueOf(num));
		String Mult = String.valueOf(multTemp);

		while((Mult.charAt(Mult.length() - 1) == '0' && Mult.contains(".")) || Mult.charAt(Mult.length() - 1) == '.') {
			Mult = Mult.substring(0, Mult.length() - 1);			
		}
		return Mult;
	}

	
	
//////////////variations functions: ////////////////////////////////////////////////////////
	
	// A function for choosing color and size variations, if exist, in quick pop-up page.
	public static void chooseVariations_quickPopupPage(WebDriver driver) throws Exception{		

		//we won't change the variation, if it already contains any value beside "choose"
		String choose = "";
		String[] chooseInternational = {"Выбрать","בחר", "Διάλεξε","Selectează ", "Scegli","Selecionar"};
		
		String first = "exist";
		String second = "exist";
		String third = null;

		//check if there is a weight field, and fill it if so
		Functions.checkWeight(driver);
		
		//check if there is first variation to choose
		try {
			new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.ProductQuickPopup_variationsFirst)));
		} 	catch (Exception e) { 
			first = null;
		}
		//check if there is second variation to choose
		try {
			new WebDriverWait(driver, 2).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.ProductQuickPopup_variationsSecond)));
			//check if there is third variation to choose
			try {
				third = "exist";
				new WebDriverWait(driver, 2).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.ProductQuickPopup_variationsThird)));				
			} 	catch (Exception e) { 
				third = null;
			}	
		} 	catch (Exception e) {
			second = null;
		}		

		
		
		//choose the first variation if exist
		if (first != null){
			Thread.sleep(1000);
			choose = act.elementText(ElementsBuying.ProductQuickPopup_variationsFirst, driver);
			if (Arrays.asList(chooseInternational).contains(choose)) {
				Functions.chooseVariations_firstVariation_quickPopup(driver);
			}
		}
		//choose the second variation if exist
		if (second != null){
			Thread.sleep(1000);
			choose = driver.findElement(By.xpath(ElementsBuying.ProductQuickPopup_variationsSecond)).getText().trim();
			if (Arrays.asList(chooseInternational).contains(choose)) {
				Functions.chooseVariations_secondVariation_quickPopup(driver);
			}						
		}		
		//choose the third variation if exist
		if (third != null){
			Thread.sleep(1000);
			choose = driver.findElement(By.xpath(ElementsBuying.ProductQuickPopup_variationsThird)).getText().trim();
			if (Arrays.asList(chooseInternational).contains(choose)) {
				Functions.chooseVariations_thirdVariation_quickPopup(driver);
			}
		}


	}
		
	// A function for choosing color and size variations, if exist, in product page.
	public static void chooseVariations_ProductPage(WebDriver driver) throws Exception{
		
		//we won't change the variation, if it already contains any value beside "choose"
		String choose = "";
		String[] chooseInternational = {"Выбрать","בחר", "Διάλεξε","Selectează ", "Scegli","Selecionar"};

		String first = "exist";
		String second = "exist";
		String third = "exist";

		//check if there is a weight field, and fill it if so
		//Functions.checkWeight(driver);

		//check if there is first variation to choose
		try {
			new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_variationsFirst)));
		} 	catch (Exception e) { 
			first = null;
		}
		//check if there is second variation to choose
		try {
			new WebDriverWait(driver, 2).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_variationsSecond)));
		} 	catch (Exception e) {
			second = null;
		}
		//check if there is third variation to choose
		try {
			new WebDriverWait(driver, 2).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_variationsThird)));				
		} 	catch (Exception e) { 
			third = null;
		}	


		
		//choose the first variation if there is such option
		if (first != null){
			Thread.sleep(1000);
			choose = act.elementText(ElementsBuying.Product_variationsFirst, driver);			
			if (Arrays.asList(chooseInternational).contains(choose)) {
				Functions.chooseVariations_firstVariation_productPage(driver, "1");
			}
		}
		//choose the second variation if there is such option
		if (second != null){
			Thread.sleep(1000);
			choose = act.elementText(ElementsBuying.Product_variationsSecond, driver);
			if (Arrays.asList(chooseInternational).contains(choose)) {
				Functions.chooseVariations_secondVariation_productPage(driver, "1");
			}
		}
		//choose the third variation if there is such option
		if (third != null){
			Thread.sleep(1000);
			choose = act.elementText(ElementsBuying.Product_variationsThird, driver);
			if (Arrays.asList(chooseInternational).contains(choose)) {
				Functions.chooseVariations_thirdVariation_productPage(driver, "1");
			}
		}
	}

	// A function for choosing first variation (usually color) on product page - selecting "i" line 
	public static void chooseVariations_firstVariation_productPage(WebDriver driver, String i) throws Exception{
		i = String.valueOf( Integer.valueOf(i) + 1 );
		act.click(ElementsBuying.Product_variationsFirst, driver);
		act.waitForAttributeChange(ElementsBuying.Product_variationsFirst_dropdownFrame, "class", "selectric-wrapper", driver);		
		act.waitForClickableAndClick(ElementsBuying.Product_variationsFirst_i + i + "]", driver);
		try{
		act.waitForAttribute(ElementsBuying.Product_variationsFirst_dropdownFrame, "class", "selectric-wrapper", driver);
		} catch (Exception e) { // in case the first option is out of stock
			i = String.valueOf( Integer.valueOf(i) + 2 );
			act.waitForClickableAndClick(ElementsBuying.Product_variationsFirst_i + i + "]", driver);
			act.waitForAttribute(ElementsBuying.Product_variationsFirst_dropdownFrame, "class", "selectric-wrapper", driver);
		}
	}
	
	// A function for choosing first variation AGAIN (usually color) on product page - selecting "i" line 
	public static void chooseVariations_firstVariationAgain_productPage(WebDriver driver, String i) throws Exception{
		i = String.valueOf( Integer.valueOf(i) + 1 );
		act.click(ElementsBuying.Product_variationsFirstAgain, driver);
		act.waitForAttributeChange(ElementsBuying.Product_variationsFirst_dropdownFrame, "class", "selectric-wrapper", driver);
		try {
			act.waitForClickableAndClick(ElementsBuying.Product_variationsFirst_i + i + "]", driver);
		}
		catch (Exception e) {
			Thread.sleep(3000);
			act.waitForClickableAndClick(ElementsBuying.Product_variationsFirst_i + i + "]", driver);
		}
		act.waitForAttribute(ElementsBuying.Product_variationsFirst_dropdownFrame, "class", "selectric-wrapper", driver);
	
	}
	
	// A function for choosing second variation (usually size) on product page - selecting "i" line 
	public static void chooseVariations_secondVariation_productPage(WebDriver driver, String i) throws Exception{
		i = String.valueOf( Integer.valueOf(i) + 1 );
		act.click(ElementsBuying.Product_variationsSecond, driver);
		act.waitForAttributeChange(ElementsBuying.Product_variationsSecond_dropdownFrame, "class", "selectric-wrapper", driver);		
		act.waitForClickableAndClick(ElementsBuying.Product_variationsSecond_i + i + "]", driver);
		try{
		act.waitForAttribute(ElementsBuying.Product_variationsSecond_dropdownFrame, "class", "selectric-wrapper", driver);
		} catch (Exception e) { // in case the first option is out of stock
			i = String.valueOf( Integer.valueOf(i) + 2 );
			act.waitForClickableAndClick(ElementsBuying.Product_variationsSecond_i + i + "]", driver);
			act.waitForAttribute(ElementsBuying.Product_variationsSecond_dropdownFrame, "class", "selectric-wrapper", driver);
		}
	}
	
	// A function for choosing second variation AGAIN (usually size) on product page - selecting "i" line 
	public static void chooseVariations_secondVariationAgain_productPage(WebDriver driver, String i) throws Exception{
		i = String.valueOf( Integer.valueOf(i) + 1 );
		act.click(ElementsBuying.Product_variationsSecondAgain, driver);
		act.waitForAttributeChange(ElementsBuying.Product_variationsSecond_dropdownFrame, "class", "selectric-wrapper", driver);
		try {
			act.waitForClickableAndClick(ElementsBuying.Product_variationsSecond_i + i + "]", driver);
		}
		catch (Exception e) {
			Thread.sleep(3000);
			act.waitForClickableAndClick(ElementsBuying.Product_variationsSecond_i + i + "]", driver);
		}		act.waitForAttribute(ElementsBuying.Product_variationsSecond_dropdownFrame, "class", "selectric-wrapper", driver);
	
	}
	

	// A function for choosing third variation on product page - selecting "i" line 
	public static void chooseVariations_thirdVariation_productPage(WebDriver driver, String i) throws Exception{
		i = String.valueOf( Integer.valueOf(i) + 1 );
		act.click(ElementsBuying.Product_variationsThird, driver);
		act.waitForAttributeChange(ElementsBuying.Product_variationsThird_dropdownFrame, "class", "selectric-wrapper", driver);
		act.waitForClickableAndClick(ElementsBuying.Product_variationsThird_i + i + "]", driver);
		try{
		act.waitForAttribute(ElementsBuying.Product_variationsThird_dropdownFrame, "class", "selectric-wrapper", driver);
		} catch (Exception e) { // in case the first option is out of stock
			i = String.valueOf( Integer.valueOf(i) + 2 );
			act.waitForClickableAndClick(ElementsBuying.Product_variationsThird_i + i + "]", driver);
			act.waitForAttribute(ElementsBuying.Product_variationsThird_dropdownFrame, "class", "selectric-wrapper", driver);
		}
	}
	
	// A function for choosing first variation (usually color) on quick Popup page 
	public static void chooseVariations_firstVariation_quickPopup(WebDriver driver) throws Exception{
		act.click(ElementsBuying.ProductQuickPopup_variationsFirst, driver);
		act.waitForAttributeChange(ElementsBuying.ProductQuickPopup_variationsFirst_dropdownFrame, "class", "selectric-wrapper", driver);		
		act.waitForClickableAndClick(ElementsBuying.ProductQuickPopup_variationsFirst_1, driver);
		try{
			act.waitForAttribute(ElementsBuying.ProductQuickPopup_variationsFirst_dropdownFrame, "class", "selectric-wrapper", driver);	
		} catch (Exception e) { // in case the first option is out of stock
			act.waitForClickableAndClick(ElementsBuying.ProductQuickPopup_variationsFirst_2, driver);
			act.waitForAttribute(ElementsBuying.ProductQuickPopup_variationsFirst_dropdownFrame, "class", "selectric-wrapper", driver);	
		}
	}
	
	// A function for choosing second variation (usually size) on quick Popup page 
	public static void chooseVariations_secondVariation_quickPopup(WebDriver driver) throws Exception{
		act.click(ElementsBuying.ProductQuickPopup_variationsSecond, driver);
		act.waitForAttributeChange(ElementsBuying.ProductQuickPopup_variationsSecond_dropdownFrame, "class", "selectric-wrapper", driver);
		act.waitForClickableAndClick(ElementsBuying.ProductQuickPopup_variationsSecond_1, driver);
		try{
			act.waitForAttribute(ElementsBuying.ProductQuickPopup_variationsSecond_dropdownFrame, "class", "selectric-wrapper", driver);
		} catch (Exception e) { // in case the first option is out of stock
			act.waitForClickableAndClick(ElementsBuying.ProductQuickPopup_variationsSecond_2, driver);
			act.waitForAttribute(ElementsBuying.ProductQuickPopup_variationsSecond_dropdownFrame, "class", "selectric-wrapper", driver);
		}
	}
		

	// A function for choosing third variation (usually size) on quick Popup page 
	public static void chooseVariations_thirdVariation_quickPopup(WebDriver driver) throws Exception{
		act.click(ElementsBuying.ProductQuickPopup_variationsThird, driver);
		act.waitForAttributeChange(ElementsBuying.ProductQuickPopup_variationsThird_dropdownFrame, "class", "selectric-wrapper", driver);
		act.waitForClickableAndClick(ElementsBuying.ProductQuickPopup_variationsThird_1, driver);
		try{
		act.waitForAttribute(ElementsBuying.ProductQuickPopup_variationsThird_dropdownFrame, "class", "selectric-wrapper", driver);
		} catch (Exception e) { // in case the first option is out of stock
			act.waitForClickableAndClick(ElementsBuying.ProductQuickPopup_variationsThird_2, driver);
			act.waitForAttribute(ElementsBuying.ProductQuickPopup_variationsThird_dropdownFrame, "class", "selectric-wrapper", driver);
		}
	}
	
//////////////product functions: ////////////////////////////////////////////////////////
	
	// A function for adding a sample product to a cart (no variations, one unit).
	public static String addSampleProductToCart(WebDriver driver) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 15);	

		driver.get(ElementsBuying.Product_noVariations);
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");
		Functions.addToCart(driver);

		return ProductTitle;		
	}
	
	// A function for checking if there is an option of weight on the page
	public static void checkWeight(WebDriver driver) throws Exception{	
	
		//check if there is a weight field to enter
		String weight = "exist";

		try {
			new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_chooseWeight)));
		} 	
		catch (Exception e) { 
			weight = null;
		}
		//enter weight if exist
		if (weight != null) {
			Thread.sleep(1000);
			String url = driver.getCurrentUrl();
			driver.findElement(By.xpath(ElementsBuying.Product_chooseWeight)).sendKeys("300", Keys.ENTER);
			act.waitForUrlChange(url, driver);
		}
	}


	
//////////////tabs functions: ////////////////////////////////////////////////////////
	
	// A function for checking loading of every thumbnails in populars.
	public  static boolean checkPopularTabs(WebDriver driver, int thumbs, String element) throws InterruptedException {
		
		Thread.sleep(2000);
		int fails = 0;
		
		//open all thumbnails in a new tab each
		for(int i=1; i <= thumbs; i++) {
			WebElement webel = driver.findElement(By.xpath(element + String.valueOf(i) + "]"));	
 			new WebDriverWait(driver, 5).until( ExpectedConditions.elementToBeClickable(webel));
			new Actions (driver).keyDown(Keys.CONTROL).moveToElement(webel).click().build().perform();
		}	
		
		//check every tab if it's loaded or not
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());			
		for(int i=1; i<=thumbs; i++){
			driver.switchTo().window(tabs.get(i));
			
			//if product loaded correctly, there is a "pin the product" option
			try {
				boolean t = driver.findElement(By.xpath(ElementsBuying.Product_sortBy)).isDisplayed(); 
			}
			catch (Exception ex) {
				if(driver.getCurrentUrl().contains("toys")) {					
				}	
				else {
					System.out.println("the category:  \"" + driver.getTitle() + "\" failed to load \n it's link: " + driver.getCurrentUrl());
				    fails++;
				}
				/*else if(!driver.findElements((By.xpath(ElementsBuying.Product_notFound))).isEmpty()) {
					System.out.println("the category:  \"" + driver.getTitle() + "\" failed to load \n it's link: " + driver.getCurrentUrl());
				    fails++;	
				}	*/			
			}
			driver.close();
		}
		if(fails!=0) {
			System.out.println("in total: " + fails + " of categories failed to load");			
		}
		driver.switchTo().window(tabs.get(0));
		return (fails!=0);		
	}
	
	
	// A function for checking loading of every thumbnails on page.
	public  static boolean checkThumbnailsInTabs(WebDriver driver, int thumbs, String element) throws InterruptedException {
		
		int fails = 0;
		Thread.sleep(2000);
		
		//scroll down, to avoid the cookies pop-up 
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");

		//open all thumbnails in a new tab each
		for(int i=1; i <= thumbs; i++) {
			WebElement webel = driver.findElement(By.xpath(element + String.valueOf(i) + "]"));	
			new WebDriverWait(driver, 10).until( ExpectedConditions.elementToBeClickable(webel));
			new Actions (driver).keyDown(Keys.CONTROL).moveToElement(webel).click().build().perform();
		}	
		
		//check every tab if it's loaded or not
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());			
		for(int i=1; i<=thumbs; i++){
			driver.switchTo().window(tabs.get(i));
			
			//if product loaded correctly, there is a "pin the product" option
			try {
				boolean t = driver.findElement(By.xpath(ElementsBuying.Product_pin)).isDisplayed(); 
			}
			catch (Exception ex) {
				if(driver.getTitle().contains("404")) {	
					System.out.println("the link :" + driver.getCurrentUrl() + "encountered an 404 error");
				}
				else if(!driver.findElements((By.xpath(ElementsBuying.Product_notFound))).isEmpty()) {
					System.out.println("the product:  \"" + driver.getTitle() + "\" failed to load \n it's link: " + driver.getCurrentUrl());
				    fails++;	
				}				
			}
			driver.close();
		}
		if(fails!=0) {
			System.out.println("in total: " + fails + " of thumbs failed to load");			
		}
		driver.switchTo().window(tabs.get(0));
		return (fails!=0);		
	}
	
	
	// A function for checking 502 error of every link on page
	public  static boolean checkLinksInTabs_error502(WebDriver driver, int thumbs, String element) throws InterruptedException {
		
		int fails = 0;
		Thread.sleep(2000);

		//open all thumbnails in a new tab each
		for(int i=1; i <= thumbs; i++) {
			WebElement webel = driver.findElement(By.xpath(element + String.valueOf(i) + "]"));	
			new WebDriverWait(driver, 10).until( ExpectedConditions.elementToBeClickable(webel));
			new Actions (driver).keyDown(Keys.CONTROL).moveToElement(webel).click().build().perform();
		}	
		
		//check every tab
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());			
		for(int i=1; i<=thumbs; i++){
			driver.switchTo().window(tabs.get(i));

			//catch 502 error if exist
			boolean tr = driver.getTitle().contains("502"); 
			if (tr ==true) {
					fails++;
					System.out.println("the link:  " + driver.getCurrentUrl() + " encountered an 502 error" );			
			}
			driver.close();
		}
		
		if(fails!=0) {
			System.out.println("in total: " + fails + " links encountered an 502 error");			
		} else {
			System.out.println("none 502 error catched");			
		}
		driver.switchTo().window(tabs.get(0));
		return (fails!=0);		
	}

	// A function for checking 502 error of every link on page
	public  static boolean checkCategoriesInTabs_error502(WebDriver driver, int first, int second, String element, String element2) throws InterruptedException {
		
		int fails = 0;
		Thread.sleep(2000);

		//open all thumbnails in a new tab each
		
		for(int i=1; i <= first; i++) {
			WebElement webel = driver.findElement(By.xpath(element + String.valueOf(i) + "]"));					
			new WebDriverWait(driver, 10).until( ExpectedConditions.elementToBeClickable(webel));
			new Actions (driver).keyDown(Keys.CONTROL).moveToElement(webel).click().build().perform();
		}
		
		for(int i=1; i <= second; i++) {
			WebElement webel = driver.findElement(By.xpath(element2 + String.valueOf(i) + "]"));	
			new WebDriverWait(driver, 10).until( ExpectedConditions.elementToBeClickable(webel));
			new Actions (driver).keyDown(Keys.CONTROL).moveToElement(webel).click().build().perform();
		}	

		
		//check every tab
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());			
		for(int i=1; i<=(second + first); i++){
			driver.switchTo().window(tabs.get(i));

			//catch 502 error if exist
			boolean tr = driver.getTitle().contains("502"); 
			if (tr ==true) {
					fails++;
					System.out.println("the link:  " + driver.getCurrentUrl() + "/n encountered an 502 error" );			
			}
			driver.close();
		}
		
		if(fails!=0) {
			System.out.println("in total: " + fails + " links encountered an 502 error");			
		} else {
			System.out.println("none 502 error catched");			
		}
		driver.switchTo().window(tabs.get(0));
		return (fails!=0);		
	}
	
	
	
//////////////aliExpress functions: ////////////////////////////////////////////////////////

	// A function for opening the same product in aliExpress site
	public  static ArrayList<String> aliexpress_openSameProduct(WebDriver driver, ArrayList<String> tabs) throws InterruptedException {
		
		String id = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div/div/div/div[1]/div/div[1]/div/div[2]")).getAttribute("data-id");
		String aliexpressAddress = ElementsWebsites.AliexpressByID + id + ".html";

		//switch to aliExpress tab		
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(1000);
		
		driver.get(aliexpressAddress);
		Thread.sleep(500);
		
		return tabs;
	}
		
	// A function for changing the currency in aliExpress site
	public  static void aliexpress_changeCurrency(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath(ElementsBuying.Aliexpress_Localization)).click();
		driver.findElement(By.xpath(ElementsBuying.Aliexpress_PopupCurrency)).click();
		driver.findElement(By.xpath(ElementsBuying.Aliexpress_PopupCurrency_NIS)).click();
		driver.findElement(By.xpath(ElementsBuying.Aliexpress_Localization_Save)).click();
		Thread.sleep(1000);
	}
		
	
	
//////////////aliExpress functions: ////////////////////////////////////////////////////////

	
	// A function for finding index.
	public static void findZipIndex(String city, String street, String house, WebDriver driver) throws Exception{

		//clear all fields
		act.click(ElementsLogin.index_clearButton, driver);

		//enter city:
		driver.findElement(By.xpath(ElementsLogin.index_cityField)).sendKeys(city);
		Thread.sleep(3000);
		act.waitForPresenceAndClick(ElementsLogin.index_cityField_data_1, driver);
		Thread.sleep(2000);
		
		//enter street and house:
		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.index_streetField))).click()
		.sendKeys(street, Keys.TAB, house, Keys.ENTER)
		.build().perform();	
		Thread.sleep(3000);
		
	}
	
	// A function for finding index in the same city as in previous search.
	public static void findZipIndex_sameCity(String city, String street, String house, WebDriver driver) throws Exception{

		//clear all fields
		act.click(ElementsLogin.index_clearButton, driver);

		//enter city, street and house:
		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.index_cityField))).click()
		.sendKeys(city, Keys.TAB, street, Keys.TAB, house, Keys.ENTER)
		.build().perform();	
		Thread.sleep(3000);
		
	}
}

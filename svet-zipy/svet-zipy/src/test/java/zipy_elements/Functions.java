package zipy_elements;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
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
		if (driver.manage().window().getSize().getWidth()<=400) {
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
		if (driver.manage().window().getSize().getWidth()<=400) {
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
			if (driver.findElements(By.xpath(ElementsLogin.Popup_welcome_close)).size() != 0){
				driver.findElement(By.xpath(ElementsLogin.Popup_welcome_close)).click();
				new WebDriverWait(driver, 10).
				until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ElementsLogin.Popup_welcome_close)));
			}
	}
	
	//close the pop-up window if exist (in greece version)
	public static void closePopUp_gr(WebDriver driver) throws Exception{
			if (driver.findElements(By.xpath(ElementsLogin.Popup_welcome_close_gr)).size() != 0){
				driver.findElement(By.xpath(ElementsLogin.Popup_welcome_close_gr)).click();
				new WebDriverWait(driver, 10).
				until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ElementsLogin.Popup_welcome_close_gr)));
			}
	}

	
	//close the advert pop-up note if exist (in greece version)
	public static void advertNote_close_gr(WebDriver driver) throws Exception{
			if (!driver.findElements(By.xpath(ElementsLogin.Start_advertNote_close)).isEmpty()){
				driver.findElement(By.xpath(ElementsLogin.Start_advertNote_close)).click();
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

	
	
////////////// price functions: ////////////////////////////////////////////////////////
	
	// A function for summing two product prices.
	public static String priceSum(WebDriver driver, String price1, String price2) throws Exception{
		WebElement firstPrice1 = driver.findElement(By.xpath(price1));
		WebElement secondPrice2 = driver.findElement(By.xpath(price2));
		double firstPrice = Double.parseDouble(firstPrice1.getText());
		double secondPrice = Double.parseDouble(secondPrice2.getText());
		BigDecimal sumTemp = BigDecimal.valueOf(firstPrice).add(BigDecimal.valueOf(secondPrice));
		String Sum = String.valueOf(sumTemp);
		
		while((Sum.charAt(Sum.length() - 1) == '0' && Sum.contains(".")) || Sum.charAt(Sum.length() - 1) == '.') {
			Sum = Sum.substring(0, Sum.length() - 1);			
		}
		return Sum;
	}
		
	
	// A function for summing two strings.
	public static String stringSum(WebDriver driver, String price1, String price2) throws Exception{
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
		double firstPrice = Double.parseDouble(price1);
		BigDecimal multTemp = BigDecimal.valueOf(firstPrice).multiply(BigDecimal.valueOf(num));
		String Mult = String.valueOf(multTemp);

		while((Mult.charAt(Mult.length() - 1) == '0' && Mult.contains(".")) || Mult.charAt(Mult.length() - 1) == '.') {
			Mult = Mult.substring(0, Mult.length() - 1);			
		}
		return Mult;
	}

	
	
//////////////product functions: ////////////////////////////////////////////////////////
	
	// A function for choosing color and size variations, if exist, in product frame.
	public static void chooseVariations_ProductFramed(WebDriver driver) throws Exception{		

		//we won't change the variation, if it already contains any value beside "choose"
		String choose = "";
		String[] chooseInternational = {"Выбрать","בחר", "Διάλεξε","Selectează ", "Scegli","Selecionar"};

		//choose the first color if there is such an option
		if (!driver.findElements(By.xpath(ElementsBuying.ProductFramed_color)).isEmpty()){
			Thread.sleep(1000);
			choose = driver.findElement(By.xpath(ElementsBuying.ProductFramed_color)).getText().trim();
			if (Arrays.asList(chooseInternational).contains(choose)) {
				driver.findElement(By.xpath(ElementsBuying.ProductFramed_color)).click();
				new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.ProductFramed_color_1))).click();
				Thread.sleep(500);
			}
		}
		//choose the first size if there is such an option
		if (!driver.findElements(By.xpath(ElementsBuying.ProductFramed_length)).isEmpty()){
			Thread.sleep(1000);
			choose = driver.findElement(By.xpath(ElementsBuying.ProductFramed_length)).getText().trim();
			if (Arrays.asList(chooseInternational).contains(choose)) {
				driver.findElement(By.xpath(ElementsBuying.ProductFramed_length)).click();
				new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.ProductFramed_length_1))).click();
				Thread.sleep(500);
			}
		}
		
		

	}
	
	
	// A function for choosing color and size variations, if exist, in product page.
	public static void chooseVariations_ProductPage(WebDriver driver) throws Exception{
		
		//we won't change the variation, if it already contains any value beside "choose"
				String choose = "";
				String[] chooseInternational = {"Выбрать","בחר", "Διάλεξε","Selectează ", "Scegli","Selecionar"};

		//choose the first color if there is such option
		if (!driver.findElements(By.xpath(ElementsBuying.Product_variationsColor)).isEmpty()){
			Thread.sleep(1000);
			choose = driver.findElement(By.xpath(ElementsBuying.Product_variationsColor)).getText().trim();
			if (Arrays.asList(chooseInternational).contains(choose)) {
				driver.findElement(By.xpath(ElementsBuying.Product_variationsColor)).click();
				new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_variationsColor_1))).click();
				Thread.sleep(500);
			}
		}
		//choose the first size if there is such option
		if (!driver.findElements(By.xpath(ElementsBuying.Product_variationsLength)).isEmpty()){
			Thread.sleep(1000);
			choose = driver.findElement(By.xpath(ElementsBuying.Product_variationsLength)).getText().trim();
			if (Arrays.asList(chooseInternational).contains(choose)) {
				driver.findElement(By.xpath(ElementsBuying.Product_variationsLength)).click();
				new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_variationsLength_1))).click();
				Thread.sleep(500);
			}
		}
	}

	
	// A function for adding a sample product to a cart (no variations, one unit).
	public static String addSampleProductToCart(WebDriver driver) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 15);	

		driver.get(ElementsBuying.Product_noVariations);
		String ProductTitle = driver.findElement(By.xpath(ElementsBuying.Product_titleFromPicture)).getAttribute("alt");
		Thread.sleep(500);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_addToCart))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_plusOne)));

		return ProductTitle;		
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
	public  static boolean checkCategoriesInTabs_error502(WebDriver driver, int thumbs, String element) throws InterruptedException {
		
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
			try {
				boolean t = !driver.getTitle().contains("502"); 
			}
			catch (Exception ex) {
					fails++;
					System.out.println("the link:  " + driver.getCurrentUrl() + " encountered an 502 error" );			
			}
			driver.close();
		}
		
		if(fails!=0) {
			System.out.println("in total: " + fails + "links encountered an 502 error");			
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
		
			
}

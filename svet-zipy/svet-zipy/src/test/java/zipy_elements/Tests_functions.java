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

	
public class Tests_functions {
	
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
		.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(ElementsLogin.Username, Keys.TAB, ElementsLogin.Password, Keys.ENTER)
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
	
	//close the pop-up window if exist
	public static void closePopUp(WebDriver driver) throws Exception{
			if (driver.findElements(By.xpath(ElementsLogin.Popup_welcome_close)).size() != 0){
				driver.findElement(By.xpath(ElementsLogin.Popup_welcome_close)).click();
				new WebDriverWait(driver, 10).
				until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ElementsLogin.Popup_welcome_close)));
			}
	}
	
	//close the pop-up window if exist
		public static void closePopUpForce(WebDriver driver) throws Exception{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsLogin.Popup_welcome_close))).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ElementsLogin.Popup_welcome_close)));
				
		}
	
	//open main website and close the pop-up window if exist
	public static void openWebsiteAndClosePopUp(WebDriver driver, String website) throws Exception{
			driver.get(website);
				if (driver.findElements(By.xpath(ElementsLogin.Popup_welcome_close)).size() != 0){
					driver.findElement(By.xpath(ElementsLogin.Popup_welcome_close)).click();
					new WebDriverWait(driver, 10).
					until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ElementsLogin.Popup_welcome_close)));
					driver.get(website);
				}
		}
	
	// A function for emptying the cart.
	public static void emptyCart(WebDriver driver) throws Exception{
		Thread.sleep(500);
		//while there is pay button in the cart, continue deleting the first product from the cart and reopen it
		while (!driver.findElements(By.xpath(ElementsBuying.Product_cartPay)).isEmpty() ) {
				driver.findElement(By.xpath(ElementsBuying.Product_cartRemove)).click();
				driver.findElement(By.xpath(ElementsBuying.Product_closeCart)).click();
				driver.findElement(By.xpath(ElementsBuying.Product_openCart)).click();
				Thread.sleep(500);
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
	
	// A function for open and remove one product from the cart.
	public static void openAndEmptyCart(WebDriver driver) throws Exception{
		//back to main page and open the cart			
		driver.get(ElementsWebsites.Zipy_il);
		WebDriverWait wait = new WebDriverWait(driver, 15);	
		
		if(!driver.findElement(By.xpath(ElementsBuying.Product_cart_topBarQuantity)).getText().equals("0")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_openCart))).click();
			WebElement cartFrame = driver.findElement(By.xpath(ElementsBuying.Product_cartFrame));
			wait.until(ExpectedConditions.visibilityOf(cartFrame));
			Tests_functions.emptyCart(driver);
		}
	}
	
	// A function for open and remove one product from the cart in mobile version.
	public static void openAndEmptyCart_mobile(WebDriver driver) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 15);	

		driver.get(ElementsWebsites.Zipy_il);
		driver.findElement(By.xpath(ElementsBuying.Product_openCart)).click();
		//wait.until(ExpectedConditions.urlToBe(ElementsWebsites.Zipy_il_payment));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_payment_Remove))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsBuying.Product_paymentPopup_Remove))).click();

	}
	
	// A function for emptying the favorites.
	public static void emptyFavorites(WebDriver driver) throws Exception{
		Thread.sleep(500);
		//while there is pay button in the cart, continue deleting the first product from the cart and reopen it
		while (!driver.findElements(By.xpath(ElementsBuying.Product_favoritesTitle)).isEmpty() ) {
				driver.findElement(By.xpath(ElementsBuying.Product_favoritesRemove)).click();
				driver.findElement(By.xpath(ElementsBuying.Product_closeFavorites)).click();
				driver.findElement(By.xpath(ElementsBuying.Product_openFavorites)).click();
				Thread.sleep(500);
		}	
	}

	// A function for deleting one item from favorites.
	public static void emptyFavoritesOneItem(WebDriver driver) throws Exception{
		Thread.sleep(500);		
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesRemove)).click();
		
	}
	
	// A function for summing two product prices.
	public static String priceSum(WebDriver driver, String price1, String price2) throws Exception{
		double firstPrice = Double.parseDouble(driver.findElement(By.xpath(price1)).getText());
		double secondPrice = Double.parseDouble(driver.findElement(By.xpath(price2)).getText());
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
		return (fails!=0);		
	}
	
	
	// A function for checking loading of every thumbnails in dailyDeals.
	public  static boolean checkDailyDealsTabs(WebDriver driver, int thumbs, String element) throws InterruptedException {
		
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
		return (fails!=0);		
	}
}

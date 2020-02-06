package Master.Favorites;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import zipy_elements.*;

public class Favorites_icon extends Favorites_MAIN {
	
	
	//Test - appearance of favorite-pin icon on thumbnail, on mouse hover
	@Test		
	public  void Tests_favorites_pinIcon_appearOnHover() throws Exception {
		System.out.println("Running test for appearance of favorite-pin icon on the daiy deals thumbnail, on mouse hover");		
		
		//open deals page
		driver.get(ElementsWebsites.Zipy_il_deals);
		
		//move mouse over one of the thumbnails
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsThumbs.dailyDeal_onPage_3))).build().perform();;

		// if correct, the pin button is visible:
		Assert.assertTrue(driver.findElement(By.xpath(ElementsThumbs.Product_PinThumbIcon)).isDisplayed());				
	}

	
	//Test - correct colors of favorite-pin button
	@Test		
	public  void Tests_favorites_pinIcon_colors() throws Exception {
		System.out.println("Running test for coreect colors of favorite-pin before and after clicking");		
		
		//open deals page
		driver.get(ElementsWebsites.Zipy_il_deals);
		
		//move mouse over one of the thumbnails
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsThumbs.dailyDeal_onPage_3))).build().perform();;

		//save the color of pin icon, click it and save the new color
		
		String colorUnselected = act.elementAttText(ElementsThumbs.Product_PinThumbIcon_colorUnselected, "class", driver);
		driver.findElement(By.xpath(ElementsThumbs.Product_PinThumbIcon)).click();		
		Thread.sleep(1000);
		String colorSelected = act.elementAttText(ElementsThumbs.Product_PinThumbIcon_colorSelected, "class", driver);
		
		// if correct, the unselected color is grey and the selected color is pink:
		Assert.assertTrue(colorUnselected.contains("grey") && colorSelected.contains("pink"));	
		
		//at the end, remove the product from the favorites, for the future tests	
		act.click(ElementsThumbs.Product_PinThumbIcon_Selected, driver);	
	}
	
	
	
}

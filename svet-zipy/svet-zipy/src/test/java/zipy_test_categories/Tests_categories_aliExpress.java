package zipy_test_categories;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import zipy_elements.*;

public class Tests_categories_aliExpress extends Tests_categories_MAIN {
	
	
	//Test - adding to favorites from category thumbnail (from categories side panel)
	@Test		
	public  void Tests_categories_add_fromCategoryThumb() throws Exception {
		System.out.println("Running test for adding to favorites from category thumbnail");		
		
		driver.get(ElementsWebsites.Zipy_il_ali);
		
		//chose the first category from side panel and choose the first sub category
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.sideCategory1))).click()
		.moveToElement(driver.findElement(By.xpath(ElementsLogin.sideCategory1_1))).click().build().perform();
		
		//click the pin button on the third thumbnail
		new Actions(driver).moveToElement(driver.findElement(By.xpath(ElementsRecommended.category_3)))
		.moveToElement(driver.findElement(By.xpath(ElementsRecommended.category_3_PinThumbIcon))).click().build().perform();

		//save products title			
		String ProductTitle = driver.findElement(By.xpath(ElementsRecommended.category_3_title)).getText().trim();
				
		// open the favorites window and save its contents
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesButton)).click();
		Thread.sleep(500);
		String favoritesFrame = driver.findElement(By.xpath(ElementsBuying.Product_favoritesFrame)).getText();
		
		// if correct, the product title will be found in the favorites window:
		Assert.assertTrue(favoritesFrame.contains(ProductTitle) );
		
		//at the end, remove the products from the favorites, for the future tests		
		driver.findElement(By.xpath(ElementsBuying.Product_favoritesRemove)).click();
		
	}
}

package zipy_test_catalogs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import zipy_elements.*;

@RunWith(Parameterized.class)
public class Tests_catalogs_gr_aliExpress extends Tests_catalogs_MAIN {
	
	private static String num;
	public Tests_catalogs_gr_aliExpress(String num) {
		super();
		this.num = num;
	}		
	//our parameters to test- email and password 
	@Parameterized.Parameters
	public static Collection falseData(){
		return Arrays.asList( new Object[][]{				
						{"1"},	
						{"2"},
						{"3"},
						{"4"},
						{"5"},
						{"6"},
						{"7"},
						{"8"},
						});
	}
	
	
	//Test - opening all sub categories in aliExpress - Israel
	@Test		
	public  void Tests_categories_gr_aliExpress() throws Exception {		
		System.out.println("Running test for opening all subcategories in #" + num + " category from aliExpress - Greece");	

		counter++;
		driver.get(ElementsWebsites.Zipy_gr_withPopup);
		if( counter ==1) {
			Tests_functions.closePopUp_gr(driver);
		}
		
		int fails = 0;

		wait.until( ExpectedConditions.elementToBeClickable(By.xpath(ElementsWebsites.Zipy_gr_aliButton))).click();
		
		
		driver.findElement(By.xpath(ElementsLogin.sideCategoryUp1)).click();
		String winHandleMain = driver.getWindowHandle();
		Thread.sleep(2000);
		
		List<WebElement> links = driver.findElements(By.xpath(ElementsRecommended.category_linksStart + num + "]/div//*[@href]"));
		ArrayList<String> hrf = new ArrayList<String>();
		for(int i = 0; i<links.size(); i++) {
			hrf.add(i, links.get(i).getAttribute("href"));
		}

		String nameCategory = driver.findElement(By.xpath(ElementsRecommended.category_mainCategoryStart + num + "]/a/span[2]")).getText();
		System.out.println("openning " +  hrf.size() + " sub categories of " + nameCategory);
		
		for(int i = 1; i<hrf.size(); i++) {
			String currentLink = hrf.get(i);
			driver.get(currentLink);
			
				try {
					boolean t = driver.findElement(By.xpath(ElementsBuying.Product_sortBy)).isDisplayed(); 
				}
				catch (Exception ex) {
					if(driver.getCurrentUrl().contains("toys")) {					
					}	else {					
						System.out.println("the category:  \"" + driver.getTitle() + "\" failed to load \n it's link: " + driver.getCurrentUrl());
					    fails++;
					}				
				}		
		}		     
		// if everything opened correct, then no fails caught
		Assert.assertTrue(fails==0);	
	}



}

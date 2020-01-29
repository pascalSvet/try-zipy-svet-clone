package Master.Catalogs;
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

public class Catalogs_gr_amazon_separated extends Catalogs_MAIN {
		
	
	//Test - opening all sub categories in amazon - Israel - 1 category - fashion
	@Test		
	public  void Tests_categories_gr_amazon_1category() throws Exception {		
		System.out.println("Running test for opening all subcategories in #" + "1" + " category from amazon - Israel");	

		counter++;
		driver.get(ElementsWebsites.Zipy_gr_withPopup);
		if( counter ==1) {
			Functions.closePopUp_gr(driver);
		}
		
		int fails = 0;

		wait.until( ExpectedConditions.elementToBeClickable(By.xpath(ElementsWebsites.Zipy_gr_amazonButton))).click();
		
		driver.findElement(By.xpath(ElementsLogin.sideCategoryUp1)).click();
		String winHandleMain = driver.getWindowHandle();
		Thread.sleep(2000);
		
		List<WebElement> links = driver.findElements(By.xpath(ElementsRecommended.category_linksStart + "1" + "]/div//*[@href]"));
		ArrayList<String> hrf = new ArrayList<String>();
		for(int i = 0; i<links.size(); i++) {
			hrf.add(i, links.get(i).getAttribute("href"));
		}

		String nameCategory = driver.findElement(By.xpath(ElementsRecommended.category_mainCategoryStart + "1" + "]/a/span[2]")).getText();
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
		if(fails!=0) {
			System.out.println("in total " + fails + "failures in " + nameCategory + " category");
			fails = 0;
		} else {
			System.out.println("no failures in " + nameCategory + " category");
		}
		
		// if everything opened correct, then no fails caught
		Assert.assertTrue(fails==0);	
	}
	
	//Test - opening all sub categories in amazon - Israel - 2 category - cars
	@Test		
	public  void Tests_categories_gr_amazon_2category() throws Exception {		
		System.out.println("Running test for opening all subcategories in #" + "2" + " category from amazon - Israel");	

		counter++;
		driver.get(ElementsWebsites.Zipy_gr_withPopup);
		if( counter ==1) {
			Functions.closePopUp_gr(driver);
		}
		
		int fails = 0;

		wait.until( ExpectedConditions.elementToBeClickable(By.xpath(ElementsWebsites.Zipy_gr_amazonButton))).click();
		
		driver.findElement(By.xpath(ElementsLogin.sideCategoryUp1)).click();
		String winHandleMain = driver.getWindowHandle();
		Thread.sleep(2000);
		
		List<WebElement> links = driver.findElements(By.xpath(ElementsRecommended.category_linksStart + "2" + "]/div//*[@href]"));
		ArrayList<String> hrf = new ArrayList<String>();
		for(int i = 0; i<links.size(); i++) {
			hrf.add(i, links.get(i).getAttribute("href"));
		}

		String nameCategory = driver.findElement(By.xpath(ElementsRecommended.category_mainCategoryStart + "2" + "]/a/span[2]")).getText();
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
		if(fails!=0) {
			System.out.println("in total " + fails + "failures in " + nameCategory + " category");
			fails = 0;
		} else {
			System.out.println("no failures in " + nameCategory + " category");
		}
		
		// if everything opened correct, then no fails caught
		Assert.assertTrue(fails==0);	
	}
		
	//Test - opening all sub categories in amazon - Israel - 3 category - electronics
	@Test		
	public  void Tests_categories_gr_amazon_3category() throws Exception {		
		System.out.println("Running test for opening all subcategories in #" + "3" + " category from amazon - Israel");	

		counter++;
		driver.get(ElementsWebsites.Zipy_gr_withPopup);
		if( counter ==1) {
			Functions.closePopUp_gr(driver);
		}
		
		int fails = 0;

		wait.until( ExpectedConditions.elementToBeClickable(By.xpath(ElementsWebsites.Zipy_gr_amazonButton))).click();
		
		driver.findElement(By.xpath(ElementsLogin.sideCategoryUp1)).click();
		String winHandleMain = driver.getWindowHandle();
		Thread.sleep(2000);
		
		List<WebElement> links = driver.findElements(By.xpath(ElementsRecommended.category_linksStart + "3" + "]/div//*[@href]"));
		ArrayList<String> hrf = new ArrayList<String>();
		for(int i = 0; i<links.size(); i++) {
			hrf.add(i, links.get(i).getAttribute("href"));
		}

		String nameCategory = driver.findElement(By.xpath(ElementsRecommended.category_mainCategoryStart + "3" + "]/a/span[2]")).getText();
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
		if(fails!=0) {
			System.out.println("in total " + fails + "failures in " + nameCategory + " category");
			fails = 0;
		} else {
			System.out.println("no failures in " + nameCategory + " category");
		}
		
		// if everything opened correct, then no fails caught
		Assert.assertTrue(fails==0);	
	}
	
	//Test - opening all sub categories in amazon - Israel - 4 category - computers
	@Test		
	public  void Tests_categories_gr_amazon_4category() throws Exception {		
		System.out.println("Running test for opening all subcategories in #" + "4" + " category from amazon - Israel");	

		counter++;
		driver.get(ElementsWebsites.Zipy_gr_withPopup);
		if( counter ==1) {
			Functions.closePopUp_gr(driver);
		}
		
		int fails = 0;

		wait.until( ExpectedConditions.elementToBeClickable(By.xpath(ElementsWebsites.Zipy_gr_amazonButton))).click();
		
		driver.findElement(By.xpath(ElementsLogin.sideCategoryUp1)).click();
		String winHandleMain = driver.getWindowHandle();
		Thread.sleep(2000);
		
		List<WebElement> links = driver.findElements(By.xpath(ElementsRecommended.category_linksStart + "4" + "]/div//*[@href]"));
		ArrayList<String> hrf = new ArrayList<String>();
		for(int i = 0; i<links.size(); i++) {
			hrf.add(i, links.get(i).getAttribute("href"));
		}

		String nameCategory = driver.findElement(By.xpath(ElementsRecommended.category_mainCategoryStart + "4" + "]/a/span[2]")).getText();
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
		if(fails!=0) {
			System.out.println("in total " + fails + "failures in " + nameCategory + " category");
			fails = 0;
		} else {
			System.out.println("no failures in " + nameCategory + " category");
		}
		
		// if everything opened correct, then no fails caught
		Assert.assertTrue(fails==0);	
	}
	
	//Test - opening all sub categories in amazon - Israel - 5 category - photography
	@Test		
	public  void Tests_categories_gr_amazon_5category() throws Exception {		
		System.out.println("Running test for opening all subcategories in #" + "5" + " category from amazon - Israel");	

		counter++;
		driver.get(ElementsWebsites.Zipy_gr_withPopup);
		if( counter ==1) {
			Functions.closePopUp_gr(driver);
		}
		
		int fails = 0;

		wait.until( ExpectedConditions.elementToBeClickable(By.xpath(ElementsWebsites.Zipy_gr_amazonButton))).click();
		
		driver.findElement(By.xpath(ElementsLogin.sideCategoryUp1)).click();
		String winHandleMain = driver.getWindowHandle();
		Thread.sleep(2000);
		
		List<WebElement> links = driver.findElements(By.xpath(ElementsRecommended.category_linksStart + "5" + "]/div//*[@href]"));
		ArrayList<String> hrf = new ArrayList<String>();
		for(int i = 0; i<links.size(); i++) {
			hrf.add(i, links.get(i).getAttribute("href"));
		}

		String nameCategory = driver.findElement(By.xpath(ElementsRecommended.category_mainCategoryStart + "5" + "]/a/span[2]")).getText();
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
		if(fails!=0) {
			System.out.println("in total " + fails + "failures in " + nameCategory + " category");
			fails = 0;
		} else {
			System.out.println("no failures in " + nameCategory + " category");
		}
		
		// if everything opened correct, then no fails caught
		Assert.assertTrue(fails==0);	
	}

	//Test - opening all sub categories in amazon - Israel - 6 category - cellular
	@Test		
	public  void Tests_categories_gr_amazon_6category() throws Exception {		
		System.out.println("Running test for opening all subcategories in #" + "6" + " category from amazon - Israel");	

		counter++;
		driver.get(ElementsWebsites.Zipy_gr_withPopup);
		if( counter ==1) {
			Functions.closePopUp_gr(driver);
		}
		
		int fails = 0;

		wait.until( ExpectedConditions.elementToBeClickable(By.xpath(ElementsWebsites.Zipy_gr_amazonButton))).click();
		
		driver.findElement(By.xpath(ElementsLogin.sideCategoryUp1)).click();
		String winHandleMain = driver.getWindowHandle();
		Thread.sleep(2000);
		
		List<WebElement> links = driver.findElements(By.xpath(ElementsRecommended.category_linksStart + "6" + "]/div//*[@href]"));
		ArrayList<String> hrf = new ArrayList<String>();
		for(int i = 0; i<links.size(); i++) {
			hrf.add(i, links.get(i).getAttribute("href"));
		}

		String nameCategory = driver.findElement(By.xpath(ElementsRecommended.category_mainCategoryStart + "6" + "]/a/span[2]")).getText();
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
		if(fails!=0) {
			System.out.println("in total " + fails + "failures in " + nameCategory + " category");
			fails = 0;
		} else {
			System.out.println("no failures in " + nameCategory + " category");
		}
		
		// if everything opened correct, then no fails caught
		Assert.assertTrue(fails==0);	
	}
		
	//Test - opening all sub categories in amazon - Israel - 7 category - and
	@Test		
	public  void Tests_categories_gr_amazon_7category() throws Exception {		
		System.out.println("Running test for opening all subcategories in #" + "7" + " category from amazon - Israel");	

		counter++;
		driver.get(ElementsWebsites.Zipy_gr_withPopup);
		if( counter ==1) {
			Functions.closePopUp_gr(driver);
		}
		
		int fails = 0;

		wait.until( ExpectedConditions.elementToBeClickable(By.xpath(ElementsWebsites.Zipy_gr_amazonButton))).click();
		
		driver.findElement(By.xpath(ElementsLogin.sideCategoryUp1)).click();
		String winHandleMain = driver.getWindowHandle();
		Thread.sleep(2000);
		
		List<WebElement> links = driver.findElements(By.xpath(ElementsRecommended.category_linksStart + "7" + "]/div//*[@href]"));
		ArrayList<String> hrf = new ArrayList<String>();
		for(int i = 0; i<links.size(); i++) {
			hrf.add(i, links.get(i).getAttribute("href"));
		}

		String nameCategory = driver.findElement(By.xpath(ElementsRecommended.category_mainCategoryStart + "7" + "]/a/span[2]")).getText();
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
		if(fails!=0) {
			System.out.println("in total " + fails + "failures in " + nameCategory + " category");
			fails = 0;
		} else {
			System.out.println("no failures in " + nameCategory + " category");
		}
		
		// if everything opened correct, then no fails caught
		Assert.assertTrue(fails==0);	
	}

	//Test - opening all sub categories in amazon - Israel - 8 category - jewelry
	@Test		
	public  void Tests_categories_gr_amazon_8category() throws Exception {		
		System.out.println("Running test for opening all subcategories in #" + "8" + " category from amazon - Israel");	

		counter++;
		driver.get(ElementsWebsites.Zipy_gr_withPopup);
		if( counter ==1) {
			Functions.closePopUp_gr(driver);
		}
		
		int fails = 0;

		wait.until( ExpectedConditions.elementToBeClickable(By.xpath(ElementsWebsites.Zipy_gr_amazonButton))).click();
		
		driver.findElement(By.xpath(ElementsLogin.sideCategoryUp1)).click();
		String winHandleMain = driver.getWindowHandle();
		Thread.sleep(2000);
		
		List<WebElement> links = driver.findElements(By.xpath(ElementsRecommended.category_linksStart + "8" + "]/div//*[@href]"));
		ArrayList<String> hrf = new ArrayList<String>();
		for(int i = 0; i<links.size(); i++) {
			hrf.add(i, links.get(i).getAttribute("href"));
		}

		String nameCategory = driver.findElement(By.xpath(ElementsRecommended.category_mainCategoryStart + "8" + "]/a/span[2]")).getText();
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
		if(fails!=0) {
			System.out.println("in total " + fails + "failures in " + nameCategory + " category");
			fails = 0;
		} else {
			System.out.println("no failures in " + nameCategory + " category");
		}
		
		// if everything opened correct, then no fails caught
		Assert.assertTrue(fails==0);	
	}
	
	//Test - opening all sub categories in amazon - Israel - 9 category - books
	@Test		
	public  void Tests_categories_gr_amazon_9category() throws Exception {		
		System.out.println("Running test for opening all subcategories in #" + "9" + " category from amazon - Israel");	

		counter++;
		driver.get(ElementsWebsites.Zipy_gr_withPopup);
		if( counter ==1) {
			Functions.closePopUp_gr(driver);
		}
		
		int fails = 0;

		wait.until( ExpectedConditions.elementToBeClickable(By.xpath(ElementsWebsites.Zipy_gr_amazonButton))).click();
		
		driver.findElement(By.xpath(ElementsLogin.sideCategoryUp1)).click();
		String winHandleMain = driver.getWindowHandle();
		Thread.sleep(2000);
		
		List<WebElement> links = driver.findElements(By.xpath(ElementsRecommended.category_linksStart + "9" + "]/div//*[@href]"));
		ArrayList<String> hrf = new ArrayList<String>();
		for(int i = 0; i<links.size(); i++) {
			hrf.add(i, links.get(i).getAttribute("href"));
		}

		String nameCategory = driver.findElement(By.xpath(ElementsRecommended.category_mainCategoryStart + "9" + "]/a/span[2]")).getText();
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
		if(fails!=0) {
			System.out.println("in total " + fails + "failures in " + nameCategory + " category");
			fails = 0;
		} else {
			System.out.println("no failures in " + nameCategory + " category");
		}
		
		// if everything opened correct, then no fails caught
		Assert.assertTrue(fails==0);	
	}	
}

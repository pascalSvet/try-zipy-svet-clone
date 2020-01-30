package Master.Errors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import zipy_elements.*;

public class Errors_502 extends Errors_MAIN {
	

	
	
	//Test - catching 502 error while opening many tabs in aliexpress #1 category - Greece
	@Test		
	public  void Tests_errors502_gr_aliExpress() throws Exception {		
		System.out.println("Running test for catching 502 error while opening many tabs in aliexpress categories - Greece");	

		driver.get(ElementsWebsites.Zipy_gr);
		Functions.advertNote_close_gr(driver);
				
		driver.findElement(By.xpath(ElementsLogin.sideCategoryUp1)).click();
		boolean fails = Functions.checkCategoriesInTabs_error502(driver, 11, 6, ElementsLogin.sideCategoryUp1_i, ElementsLogin.sideCategoryUp1_i_secondRow);

		Assert.assertFalse(fails);	
	}

	
	//Test - catching 502 error while opening many tabs in aliexpress #1 category - Portugal
	@Test		
	public  void Tests_errors502_pt_aliExpress() throws Exception {		
		System.out.println("Running test for catching 502 error while opening many tabs in aliexpress categories - Portugal");	

		driver.get(ElementsWebsites.Zipy_pt);
		Functions.advertNote_close_gr(driver);
		
		driver.findElement(By.xpath(ElementsLogin.sideCategoryUp1)).click();
		boolean fails = Functions.checkCategoriesInTabs_error502(driver, 11, 6, ElementsLogin.sideCategoryUp1_i, ElementsLogin.sideCategoryUp1_i_secondRow);

		Assert.assertFalse(fails);	
	}
	
	//Test - catching 502 error while opening many tabs in aliexpress #1 category - Israel
	@Test		
	public  void Tests_errors502_il_aliExpress() throws Exception {		
		System.out.println("Running test for catching 502 error while opening many tabs in aliexpress categories - Israel");	

		driver.get(ElementsWebsites.Zipy_il);
		Functions.advertNote_close_gr(driver);
		
		driver.findElement(By.xpath(ElementsLogin.sideCategoryUp1)).click();
		boolean fails = Functions.checkCategoriesInTabs_error502(driver, 11, 6, ElementsLogin.sideCategoryUp1_i, ElementsLogin.sideCategoryUp1_i_secondRow);

		Assert.assertFalse(fails);	
	}

	
	//Test - catching 502 error while opening many tabs in deals - Greece
	@Test		
	public  void Tests_errors502_gr_deals() throws Exception {		
		System.out.println("Running test for catching 502 error while opening many tabs in deals - Greece");	

		driver.get(ElementsWebsites.Zipy_gr_deals);
		//Functions.advertNote_close_gr(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,1000);");		
		boolean fails = Functions.checkLinksInTabs_error502(driver, 16, ElementsRecommended.dailyDeal_onPage_i);

		Assert.assertFalse(fails);	
	}
	
	//Test - catching 502 error while opening many tabs in deals - Portugal
	@Test		
	public  void Tests_errors502_pt_deals() throws Exception {		
		System.out.println("Running test for catching 502 error while opening many tabs in deals - Portugal");	

		driver.get(ElementsWebsites.Zipy_pt_deals);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,1000);");		
				
		boolean fails = Functions.checkLinksInTabs_error502(driver, 16, ElementsRecommended.dailyDeal_onPage_i);

		Assert.assertFalse(fails);	
	}
	
	
	//Test - catching 502 error while opening many tabs in deals - Israel
	@Test		
	public  void Tests_errors502_il_deals() throws Exception {		
		System.out.println("Running test for catching 502 error while opening many tabs in deals - Israel");	

		driver.get(ElementsWebsites.Zipy_il_deals);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,1000);");		
				
		boolean fails = Functions.checkLinksInTabs_error502(driver, 16, ElementsRecommended.dailyDeal_onPage_i);

		Assert.assertFalse(fails);	
	}
	
	
}

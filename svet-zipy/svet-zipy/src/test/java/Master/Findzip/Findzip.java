package Master.Findzip;
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

public class Findzip extends Findzip_MAIN {
	
	
	//Test - opening droplist with suggestions in city field, after the first letters entered
	@Test		
	public  void Tests_findzip_city_openDroplist() throws Exception {		
		System.out.println("Running test for opening droplist with suggestions in city field, after the first letters entered");	

		//open index page
		driver.get(ElementsWebsites.Zipy_il_findzip);
		
		//enter first letters of the city 
		WebElement city = act.saveElement(ElementsLogin.index_cityField, driver);
		city.sendKeys(ElementsLogin.index_cityField_partData);		
		Thread.sleep(3000);

		//if correct, droplist with suggestions opened
		Assert.assertTrue(act.elementDisplayed(ElementsLogin.index_cityField_data_1, driver));	
	}
	
	
	//Test - suggesting correct cities, according to the first letters
	@Test		
	public  void Tests_findzip_city_correctSuggestions() throws Exception {		
		System.out.println("Running test for suggesting correct cities, according to the first letters");	

		//open index page
		driver.get(ElementsWebsites.Zipy_il_findzip);
		
		//enter first letters of the city and save the first suggestion
		WebElement city = act.saveElement(ElementsLogin.index_cityField, driver);
		city.sendKeys(ElementsLogin.index_cityField_partData);		
		Thread.sleep(3000);
		String suggestion = act.elementText(ElementsLogin.index_cityField_data_1, driver);

		//if correct, the suggested option will contain the letters we entered
		Assert.assertTrue(suggestion.contains((ElementsLogin.index_cityField_partData)));	
	}
	
	
	//Test - finding the correct index
	@Test		
	public  void Tests_findzip_performSearch() throws Exception {		
		System.out.println("Running test for finding the correct index");	

		//open index page
		driver.get(ElementsWebsites.Zipy_il_findzip);
		
		//choose city 
		driver.findElement(By.xpath(ElementsLogin.index_cityField)).sendKeys(ElementsLogin.index_cityField_data_BS);
		Thread.sleep(3000);
		act.waitForPresenceAndClick(ElementsLogin.index_cityField_data_1, driver);
		Thread.sleep(2000);

		//enter street and house
		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.index_streetField))).click()
		.sendKeys(ElementsLogin.index_streetField_data1, Keys.TAB, ElementsLogin.index_houseField_data1, Keys.ENTER)
		.build().perform();	
		Thread.sleep(3000);
		
		//save the found index
		String foundIndex = act.elementText(ElementsLogin.index_foundByZipy, driver);
		
		//if correct, the index is the same as the index from post office
		Assert.assertTrue(foundIndex.equals(ElementsLogin.index_correctIndex1));	
	}
	
	
	//Test - performing search with city from the map-list
	@Test		
	public  void Tests_findzip_city_searchWithMapList() throws Exception {		
		System.out.println("Running test for performing search with city from the map-list");	

		//open index page
		driver.get(ElementsWebsites.Zipy_il_findzip);
		
		//open list of cities and choose the required city
		act.waitForPresenceAndClick(ElementsLogin.index_city_mapList, driver);
		act.waitForPresenceAndClick(ElementsLogin.index_city_mapList_BS, driver);

		//enter street and house
		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.index_streetField))).click()
		.sendKeys(ElementsLogin.index_streetField_data1, Keys.TAB, ElementsLogin.index_houseField_data1, Keys.ENTER)
		.build().perform();	
		Thread.sleep(3000);
		
		//save the found index
		String foundIndex = act.elementText(ElementsLogin.index_foundByZipy, driver);
		
		//if correct, the index is the same as the index from post office
		Assert.assertTrue(foundIndex.equals(ElementsLogin.index_correctIndex1));	
	}

	
	//Test - saving the previous found indexes in history
	@Test		
	public  void Tests_findzip_searcHistory() throws Exception {		
		System.out.println("Running test for saving the previous found indexes in history");	

		//open index page
		driver.get(ElementsWebsites.Zipy_il_findzip);
		
		//choose city 
		act.waitForPresenceAndClick(ElementsLogin.index_city_mapList, driver);
		act.waitForPresenceAndClick(ElementsLogin.index_city_mapList_BS, driver);
		Functions.closePopUp(driver);
		
		//enter street and house and search
		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.index_streetField))).click()
		.sendKeys(ElementsLogin.index_streetField_data1, Keys.TAB, ElementsLogin.index_houseField_data1, Keys.ENTER)
		.build().perform();	
		Thread.sleep(3000);

		//enter another street and house and search
		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.index_streetField))).click()
		.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
		.sendKeys(ElementsLogin.index_streetField_data2, Keys.TAB, ElementsLogin.index_houseField_data1, Keys.ENTER)
		.build().perform();	
		Thread.sleep(3000);

		//save the history indexes
		String historyIndex1 = act.elementText(ElementsLogin.index_history1, driver);
		String historyIndex2 = act.elementText(ElementsLogin.index_history2, driver);

		//if correct, both indexes are saved in history
		Assert.assertTrue(historyIndex1.equals(ElementsLogin.index_correctIndex1)  
				&& historyIndex2.equals(ElementsLogin.index_correctIndex2));	
	}


	//Test - finding the correct index in same house with two different entries
	@Test		
	public  void Tests_findzip_performSearch_houseNum() throws Exception {		
		System.out.println("Running test for finding the correct index in same house with two different entries");	

		//open index page
		driver.get(ElementsWebsites.Zipy_il_findzip);
		
		
		//choose city 
		act.waitForPresenceAndClick(ElementsLogin.index_city_mapList, driver);
		act.waitForPresenceAndClick(ElementsLogin.index_city_mapList_BS, driver);
		Functions.closePopUp(driver);
		
		//enter entry index
		act.waitForPresenceAndClick(ElementsLogin.index_entryField, driver);
		act.waitForPresenceAndClick(ElementsLogin.index_entryField_1, driver);
		Thread.sleep(2000);
		
		//enter street and house number and search
		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.index_streetField))).click()
		.sendKeys(ElementsLogin.index_streetField_data3, Keys.TAB, ElementsLogin.index_houseField_data1, Keys.ENTER)
		.build().perform();	
		
		Thread.sleep(2000);

		//enter another entry index and search
		act.waitForPresenceAndClick(ElementsLogin.index_entryField, driver);
		act.waitForPresenceAndClick(ElementsLogin.index_entryField_2, driver);

		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.index_houseField))).click()
		.sendKeys(Keys.ENTER).build().perform();	
		
		//save the history indexes
		String historyIndex1 = act.elementText(ElementsLogin.index_history1, driver);
		String historyIndex2 = act.elementText(ElementsLogin.index_history2, driver);

		//if correct, both indexes are different from each other (and fit the post office index) 
		Assert.assertTrue(historyIndex1.equals(ElementsLogin.index_correctIndex3)  
				&& historyIndex2.equals(ElementsLogin.index_correctIndex4));	}
	
	
	
	//Test - clearing the fields with the clear button
	@Test		
	public  void Tests_findzip_clearButton() throws Exception {		
		System.out.println("Running test for clearing the fields with the clear button");	

		//open index page
		driver.get(ElementsWebsites.Zipy_il_findzip);
		
		//choose city 
		driver.findElement(By.xpath(ElementsLogin.index_cityField)).sendKeys(ElementsLogin.index_cityField_data_BS);
		Thread.sleep(3000);
		act.waitForPresenceAndClick(ElementsLogin.index_cityField_data_1, driver);
		Thread.sleep(2000);

		//enter street and house
		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.index_streetField))).click()
		.sendKeys(ElementsLogin.index_streetField_data1, Keys.TAB, ElementsLogin.index_houseField_data1, Keys.ENTER)
		.build().perform();	
		Thread.sleep(3000);
		
		//clear the fields
		act.click(ElementsLogin.index_clearButton, driver);
		
		//choose another city 
		driver.findElement(By.xpath(ElementsLogin.index_cityField)).sendKeys(ElementsLogin.index_cityField_data_TA);
		Thread.sleep(3000);
		act.waitForPresenceAndClick(ElementsLogin.index_cityField_data_1, driver);
		Thread.sleep(2000);
		
		//enter street and house
		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.index_streetField))).click()
		.sendKeys(ElementsLogin.index_streetField_data1, Keys.TAB, ElementsLogin.index_houseField_data2, Keys.ENTER)
		.build().perform();	
		Thread.sleep(3000);
		
		//save the found index
		String foundIndex = act.elementText(ElementsLogin.index_foundByZipy, driver);

		//if correct, the index is the same as the index from post office
		Assert.assertTrue(foundIndex.equals(ElementsLogin.index_correctIndex5));	
	}
	
	
	//Test - searching for another index without clearing the previous fields
	@Test		
	public  void Tests_findzip_clear_searchWithoutClearing() throws Exception {		
		System.out.println("Running test for searching for another index without clearing the previous fields");	

		//open index page
		driver.get(ElementsWebsites.Zipy_il_findzip);
		
		//choose city 
		driver.findElement(By.xpath(ElementsLogin.index_cityField)).sendKeys(ElementsLogin.index_cityField_data_BS);
		Thread.sleep(3000);
		act.waitForPresenceAndClick(ElementsLogin.index_cityField_data_1, driver);
		Thread.sleep(2000);

		//enter street and house
		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.index_streetField))).click()
		.sendKeys(ElementsLogin.index_streetField_data1, Keys.TAB, ElementsLogin.index_houseField_data1, Keys.ENTER)
		.build().perform();	
		Thread.sleep(3000);

		//choose another city without clearing
		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.index_cityField))).click()
		.sendKeys(ElementsLogin.index_cityField_data_TA, Keys.ENTER)
		.build().perform();	
		Thread.sleep(3000);
		
		//if correct, an error message will appear and none index will be found
		Assert.assertTrue(act.elementDisplayed(ElementsLogin.index_infoIcon, driver) && 
				!act.elementDisplayed(ElementsLogin.index_foundByZipy, driver));	
	}
	
	
	//Test - saving history for more than 6 searches
	@Test		
	public  void Tests_findzip_history_moreThan6searches() throws Exception {		
		System.out.println("Running test for searching another index without clearing the previous fields");	

		//open index page
		driver.get(ElementsWebsites.Zipy_il_findzip);
		
		//find 1 address (index №1 - באר שבע, אביגדור המאירי  27 ):		
		Functions.findZipIndex(ElementsLogin.index_cityField_data_BS, ElementsLogin.index_streetField_data1, ElementsLogin.index_houseField_data1, driver);
		//find 2 address (index №2 -  27 באר שבע, שד' ירושלים )	:	
		Functions.findZipIndex_sameCity(ElementsLogin.index_cityField_data_BS, ElementsLogin.index_streetField_data2, ElementsLogin.index_houseField_data1, driver);
		//find 3 address (index №5 - תל אביב , אביגדור המאירי  9 ):		
		Functions.findZipIndex(ElementsLogin.index_cityField_data_TA, ElementsLogin.index_streetField_data1, ElementsLogin.index_houseField_data2, driver);
		//find 4 address (index №6 - באר שבע, אביגדור המאירי  29 ):		
		Functions.findZipIndex(ElementsLogin.index_cityField_data_BS, ElementsLogin.index_streetField_data1, ElementsLogin.index_houseField_data3, driver);
		//find 5 address (index №7 - באר שבע, הר כנען  27 ):		
		Functions.findZipIndex_sameCity(ElementsLogin.index_cityField_data_BS, ElementsLogin.index_streetField_data4, ElementsLogin.index_houseField_data1, driver);
		//find 6 address (index №8 - באר שבע, הר כנען  9 ):		
		Functions.findZipIndex_sameCity(ElementsLogin.index_cityField_data_BS, ElementsLogin.index_streetField_data4, ElementsLogin.index_houseField_data2, driver);
		//find 7 address (index №9 - באר שבע, שד' ירושלים  9 ):		
		Functions.findZipIndex_sameCity(ElementsLogin.index_cityField_data_BS, ElementsLogin.index_streetField_data2, ElementsLogin.index_houseField_data2, driver);
	
		//save the 7th address in history if exist
		WebElement seventhHistory = act.saveElement(ElementsLogin.index_history_i + "7]/button/span", driver);
		
		//if correct, the seventh index is appeared at history
		Assert.assertTrue(seventhHistory.isDisplayed());	
	}

	//Test - searching for index by post box
	@Test		
	public  void Tests_findzip_findByPostBox() throws Exception {		
		System.out.println("Running test for searching for index by post box");	

		//open index page
		driver.get(ElementsWebsites.Zipy_il_findzip);
		
		//choose city 
		driver.findElement(By.xpath(ElementsLogin.index_cityField)).sendKeys(ElementsLogin.index_cityField_data_BS);
		Thread.sleep(3000);
		act.waitForPresenceAndClick(ElementsLogin.index_cityField_data_1, driver);
		Thread.sleep(2000);

		//enter post box
		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.index_postboxField))).click()
		.sendKeys(ElementsLogin.index_postboxField_data1, Keys.ENTER)
		.build().perform();	
		Thread.sleep(3000);
		
		//save the found index
		String foundIndex = act.elementText(ElementsLogin.index_foundByZipy, driver);
		
		//if correct, the index is the same as the index from post office
		Assert.assertTrue(foundIndex.equals(ElementsLogin.index_correctIndex10));	
	}
		
}

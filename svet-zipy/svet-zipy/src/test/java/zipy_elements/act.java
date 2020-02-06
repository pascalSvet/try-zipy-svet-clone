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

//class of base actions with web elements	
public class act {
	
	
	// A function for returning web-element (found by xpath)
	public static WebElement saveElement(String path, WebDriver driver) throws Exception{			
		return driver.findElement(By.xpath(path));										
	}

	
	// A function for returning web-element text
	public static String elementText(String path, WebDriver driver) throws Exception{			
		return driver.findElement(By.xpath(path)).getText().trim();										
	}
	
		
	// A function for returning web-element attribute text
	public static String elementAttText(String path, String attribute, WebDriver driver) throws Exception{			
		return driver.findElement(By.xpath(path)).getAttribute(attribute).trim();										
	}
	
	
	// A function for clicking on web-element
	public static void click(String path, WebDriver driver) throws Exception{			
		driver.findElement(By.xpath(path)).click();										
	}
		
	
	// A function for clicking (using executor) on web-element 
	public static void exClick(String path, WebDriver driver) throws Exception{			
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click()", driver.findElement(By.xpath(path)));
		Thread.sleep(500);		
	}
	
		
	// A function for waiting for web-element appearance
	public static void waitForPresence(String path, WebDriver driver) throws Exception{				
		new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
	}

	// A function for waiting for web-element appearance and click
	public static void waitForPresenceAndClick(String path, WebDriver driver) throws Exception{				
		new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath(path))).click();
	}
	// A function for waiting for web-element to be clickable and click
	public static void waitForClickableAndClick(String path, WebDriver driver) throws Exception{				
		new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath(path))).click();
	}
	
	
	// A function for waiting for web-element to be invisible
	public static void waitForInvisibility(String path, WebDriver driver) throws Exception{				
		new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(path)));
	}
		
	// A function for waiting for web-element to be visible
	public static void waitForVisibility(String path, WebDriver driver) throws Exception{				
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
	}
	// A function for waiting for url to change
	public static void waitForUrlChange(String url, WebDriver driver) throws Exception{				
		new WebDriverWait(driver, 15).until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));
	}
	
	// A function for waiting for attribute to change
	public static void waitForAttributeChange(String path, String att, String old, WebDriver driver) throws Exception{				
		new WebDriverWait(driver, 15).until(ExpectedConditions.not(ExpectedConditions.attributeToBe(By.xpath(path), att, old)));

	}
	
	// A function for waiting for attribute to be
	public static void waitForAttribute(String path, String att, String update, WebDriver driver) throws Exception{				
		new WebDriverWait(driver, 15).until(ExpectedConditions.attributeToBe(By.xpath(path), att, update));

	}	
	
	// A function for waiting for element text to change
		public static void waitForTextChange(String path, String text, WebDriver driver) throws Exception{				
			new WebDriverWait(driver, 15).until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.xpath(path), text)));

		}
		
		
	// A function for returning if element is displayed
	public static boolean elementDisplayed(String path, WebDriver driver) throws Exception{				
		return driver.findElement(By.xpath(path)).isDisplayed();
	}
	
	
	// A function for returning if element is exist
	public static boolean elementExist(String path, WebDriver driver) throws Exception{				
		return driver.findElements(By.xpath(path)).isEmpty();
	}
	
	
	
	// A function for returning if element is exist
	public static void open(String url, WebDriver driver) throws Exception{				
		driver.get(url);
	}
	
}

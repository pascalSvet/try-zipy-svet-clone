package Master.Aliexpress;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import zipy_elements.*;

public class Aliexpress extends Aliexpress_MAIN {
	
	
	//Test - comparing to aliExpress
	@Test		
	public  void Tests_Aliexpress() throws Exception {
		System.out.println("Running test for comparing to aliExpress");		
		
		driver.get(ElementsWebsites.Aliexpress_sampleFromZipy);
		
		//open the same product in aliExpress
		ArrayList<String> tabsCurrent = Functions.aliexpress_openSameProduct(driver, tabs);
				
		String DeliveryPrice = driver.findElement(By.xpath("/html//div[@id='root']/div[@class='glodetail-wrap']/div[@class='product-main']//span[@class='bold']")).getText();
		String Price = driver.findElement(By.xpath("/html//div[@id='root']//div[@class='product-main']//div[@class='product-price']/div[1]/span[@class='product-price-value']")).getText();
		
		System.out.println(DeliveryPrice);
		System.out.println(Price);

		//back to zipy tab
		driver.switchTo().window(tabsCurrent.get(0));
		
		String ZipyDeliveryPrice = driver.findElement(By.xpath("/html//div[@id='wrapper']/div[@class='product__page']//section/div[@class='product__body']//div[@class='product__table-wrapper']/table[@class='product__params']//span[@class='product__params-free-delivery-text']")).getText();
		String ZipyPrice = driver.findElement(By.xpath("/html//div[@id='wrapper']/div[@class='product__page']//section/div[@class='product__body']//div[@class='product__table-wrapper']/table[@class='product__params']/thead/tr[2]/td[@class='product__params-sale']/span/span[@class='value']")).getText();
		
		System.out.println(ZipyDeliveryPrice);
		System.out.println(ZipyPrice);
		

	}


}

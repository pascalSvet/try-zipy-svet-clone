package Master.Gallery;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import zipy_elements.*;

public class Gallery extends Gallery_MAIN {
	
	
	//Test - updating gallery image according to the chosen variation
	@Test		
	public  void Tests_Gallery_imageOfChosenVariation() throws Exception {
		System.out.println("Running test for updating gallery image according to the chosen variation");		
		
		//open required product and save its main picture at gallery
		driver.get(ElementsBuying.ProductWithColors);
		Thread.sleep(1000);
		String gallery_image = driver.findElement(By.xpath(ElementsBuying.Product_galleryImage)).getAttribute("src");		

		//choose the first variation and save its image
		driver.findElement(By.xpath(ElementsBuying.Product_variationsColor)).click();
		Thread.sleep(1000);
		String variation1_image = driver.findElement(By.xpath(ElementsBuying.Product_variationsColor_1_img)).getAttribute("src");		
		
		//save the new image of gallery
		driver.findElement(By.xpath(ElementsBuying.Product_variationsColor_1)).click();
		wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(By.xpath(ElementsBuying.Product_galleryImage), "src", gallery_image)));
		gallery_image = driver.findElement(By.xpath(ElementsBuying.Product_galleryImage)).getAttribute("src");		

		//if correct, the images are identical 
		Assert.assertTrue(gallery_image.equals(variation1_image));	

	}
	
	//Test - updating gallery image after changing chosen variation
	@Test		
	public  void Tests_Gallery_imageOfChangedVariation() throws Exception {
		System.out.println("Running test for updating gallery image after changing chosen variation");		
		
		//open required product and save its main picture at gallery
		driver.get(ElementsBuying.ProductWithColors);
		Thread.sleep(1000);
		String gallery_image = driver.findElement(By.xpath(ElementsBuying.Product_galleryImage)).getAttribute("src");		

		//choose first variation 
		driver.findElement(By.xpath(ElementsBuying.Product_variationsColor)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsBuying.Product_variationsColor_1))).click();
		Thread.sleep(3000);

		//change to second variation and save its image 
		driver.findElement(By.xpath(ElementsBuying.Product_variationsColorAgain)).click();
		Thread.sleep(1000);
		gallery_image = driver.findElement(By.xpath(ElementsBuying.Product_galleryImage)).getAttribute("src");
		String variation2_image = driver.findElement(By.xpath(ElementsBuying.Product_variationsColor_2_img)).getAttribute("src");		
		driver.findElement(By.xpath(ElementsBuying.Product_variationsColor_2)).click();
	
		//save the new image of gallery
		wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(By.xpath(ElementsBuying.Product_galleryImage), "src", gallery_image)));
		gallery_image = driver.findElement(By.xpath(ElementsBuying.Product_galleryImage)).getAttribute("src");		

		//if correct, the images are identical 
		Assert.assertTrue(gallery_image.equals(variation2_image));			
	}
	
	//Test - updating gallery image after sliding left
	@Test		
	public  void Tests_Gallery_sliderImages_left() throws Exception {
		System.out.println("Running test for updating gallery image after sliding left");		
		
		//open required product
		driver.get(ElementsBuying.ProductWithColors);
		
		//save the main picture image and the second bottom image in gallery 
		String gallery_bottomImage2 = driver.findElement(By.xpath(ElementsBuying.Product_galleryImage_bottom2)).getAttribute("src");					
		String gallery_image = driver.findElement(By.xpath(ElementsBuying.Product_galleryImage)).getAttribute("src");		

		//slide left in gallery and save the new image
		driver.findElement(By.xpath(ElementsBuying.Product_galleryImage_left)).click();
		wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(By.xpath(ElementsBuying.Product_galleryImage), "src", gallery_image)));
		gallery_image = driver.findElement(By.xpath(ElementsBuying.Product_galleryImage)).getAttribute("src");		

		//if correct, the images are identical 
		Assert.assertTrue(gallery_image.equals(gallery_bottomImage2));					
	}

	
	//Test - updating gallery image after sliding right
	@Test		
	public  void Tests_Gallery_sliderImages_right() throws Exception {
		System.out.println("Running test for updating gallery image after sliding right");		
		
		//open required product
		driver.get(ElementsBuying.ProductWithColors);
		
		//save the main picture image and the first bottom image in gallery 
		String gallery_bottomImage1 = driver.findElement(By.xpath(ElementsBuying.Product_galleryImage_bottom1)).getAttribute("src");		
		String gallery_image = driver.findElement(By.xpath(ElementsBuying.Product_galleryImage)).getAttribute("src");		

		//slide left in gallery and save the new image
		driver.findElement(By.xpath(ElementsBuying.Product_galleryImage_left)).click();
		wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(By.xpath(ElementsBuying.Product_galleryImage), "src", gallery_image)));
		gallery_image = driver.findElement(By.xpath(ElementsBuying.Product_galleryImage)).getAttribute("src");		

		//slide back right in gallery and save the new image
		driver.findElement(By.xpath(ElementsBuying.Product_galleryImage_right)).click();
		wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(By.xpath(ElementsBuying.Product_galleryImage), "src", gallery_image)));
		gallery_image = driver.findElement(By.xpath(ElementsBuying.Product_galleryImage)).getAttribute("src");		

		//if correct, the images are identical 
		Assert.assertTrue(gallery_image.equals(gallery_bottomImage1));	
	}


	//Test - updating gallery image after sliding more the once
	@Test		
	public  void Tests_Gallery_sliderImages_leftTwice() throws Exception {
		System.out.println("Running test for updating gallery image after sliding more the once");		
		
		//open required product
		driver.get(ElementsBuying.ProductWithColors);
		
		//save the main picture image and the third bottom image in gallery 
		String gallery_bottomImage3 = driver.findElement(By.xpath(ElementsBuying.Product_galleryImage_bottom3)).getAttribute("src");					
		String gallery_image = driver.findElement(By.xpath(ElementsBuying.Product_galleryImage)).getAttribute("src");		

		//slide left in gallery and save the new image
		driver.findElement(By.xpath(ElementsBuying.Product_galleryImage_left)).click();
		wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(By.xpath(ElementsBuying.Product_galleryImage), "src", gallery_image)));
		gallery_image = driver.findElement(By.xpath(ElementsBuying.Product_galleryImage)).getAttribute("src");		

		//slide left in gallery and save the new image
		driver.findElement(By.xpath(ElementsBuying.Product_galleryImage_left)).click();
		wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(By.xpath(ElementsBuying.Product_galleryImage), "src", gallery_image)));
		gallery_image = driver.findElement(By.xpath(ElementsBuying.Product_galleryImage)).getAttribute("src");		

		//if correct, the images are identical 
		Assert.assertTrue(gallery_image.equals(gallery_bottomImage3));					
	}

	//Test - adding image near the chosen variation according to the choice
	@Test		
	public  void Tests_Gallery_imageNearChosenVariation() throws Exception {
		System.out.println("Running test for adding image near the chosen variation according to the choice");		
		
		//open required product
		driver.get(ElementsBuying.ProductWithColors);
		Thread.sleep(1000);

		//save the image of the first variation
		driver.findElement(By.xpath(ElementsBuying.Product_variationsColor)).click();
		Thread.sleep(1000);
		String variation1_image = driver.findElement(By.xpath(ElementsBuying.Product_variationsColor_1_img)).getAttribute("src");		
		driver.findElement(By.xpath(ElementsBuying.Product_variationsColor_1)).click();

		//save the image appeared near the chosen variation
		String nearVariation_image = driver.findElement(By.xpath(ElementsBuying.Product_gallery_nearVariation)).getAttribute("src");
		
		//if correct, the images are identical 
		Assert.assertTrue(variation1_image.equals(nearVariation_image));			
	}
	
	//Test - updating image near the variation after changing the chosen variation
	@Test		
	public  void Tests_Gallery_imageNearChosenVariation_update() throws Exception {
		System.out.println("Running test for updating image near the variation after changing the chosen variation");		
		
		//open required product
		driver.get(ElementsBuying.ProductWithColors);
		Thread.sleep(1000);

		//choose first variation 
		driver.findElement(By.xpath(ElementsBuying.Product_variationsColor)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(ElementsBuying.Product_variationsColor_1)).click();
		Thread.sleep(3000);

		//change to second variation and save its image 
		driver.findElement(By.xpath(ElementsBuying.Product_variationsColorAgain)).click();
		Thread.sleep(1000);
		String variation2_image = driver.findElement(By.xpath(ElementsBuying.Product_variationsColor_2_img)).getAttribute("src");		
		driver.findElement(By.xpath(ElementsBuying.Product_variationsColor_2)).click();

		//save the image appeared near the chosen variation
		String nearVariation_image = driver.findElement(By.xpath(ElementsBuying.Product_gallery_nearVariation)).getAttribute("src");
		
		//if correct, the images are identical 
		Assert.assertTrue(variation2_image.equals(nearVariation_image));			
	}
	
	
	
}

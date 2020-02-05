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
		String gallery_image = act.elementAttText(ElementsBuying.Product_galleryImage, "src", driver);		

		//choose the first variation and save its image
		Functions.chooseVariations_firstVariation_productPage(driver, "1");
		String variation1_image = act.elementAttText(ElementsBuying.Product_variationsFirst_1_imgSelected, "src", driver);
		
		act.waitForAttributeChange(ElementsBuying.Product_galleryImage, "src", gallery_image, driver);
		gallery_image = act.elementAttText(ElementsBuying.Product_variationsFirst_1_img, "src", driver);

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
		String gallery_image = act.elementAttText(ElementsBuying.Product_galleryImage, "src", driver);		
		
		//choose first variation - first option
		Functions.chooseVariations_firstVariation_productPage(driver, "1");

		//change to second option and save its image 
		Functions.chooseVariations_firstVariationAgain_productPage(driver, "2");
		String variation2_image = act.elementAttText(ElementsBuying.Product_variationsFirst_2_imgSelected, "src", driver);

		//save the new image of gallery
		gallery_image = act.elementAttText(ElementsBuying.Product_galleryImage, "src", driver);		

		//if correct, the images are identical 
		Assert.assertTrue(gallery_image.equals(variation2_image));			
	}
	
	//Test - updating gallery image after sliding left
	@Test		
	public  void Tests_Gallery_sliderImages_left() throws Exception {
		System.out.println("Running test for updating gallery image after sliding left");		
		
		//open required product
		driver.get(ElementsBuying.ProductWithColors);
		Thread.sleep(1000);

		//save the main picture image and the second bottom image in gallery 	
		String gallery_bottomImage2 = act.elementAttText(ElementsBuying.Product_galleryImage_bottom2, "src", driver);			
		String gallery_image = act.elementAttText(ElementsBuying.Product_galleryImage, "src", driver);			

		//slide left in gallery and save the new image
		act.click(ElementsBuying.Product_galleryImage_left, driver);
		act.waitForAttributeChange(ElementsBuying.Product_galleryImage, "src", gallery_image, driver);
		gallery_image = act.elementAttText(ElementsBuying.Product_galleryImage, "src", driver);		

		//if correct, the images are identical 
		Assert.assertTrue(gallery_image.equals(gallery_bottomImage2));					
	}

	
	//Test - updating gallery image after sliding right
	@Test		
	public  void Tests_Gallery_sliderImages_right() throws Exception {
		System.out.println("Running test for updating gallery image after sliding right");		
		
		//open required product
		driver.get(ElementsBuying.ProductWithColors);
		Thread.sleep(1000);

		//save the main picture image and the first bottom image in gallery 
		String gallery_image = act.elementAttText(ElementsBuying.Product_galleryImage, "src", driver);			

		//slide left in gallery and save the new image
		act.click(ElementsBuying.Product_galleryImage_left, driver);
		act.waitForAttributeChange(ElementsBuying.Product_galleryImage, "src", gallery_image, driver);
		String gallery_imageNew = act.elementAttText(ElementsBuying.Product_galleryImage, "src", driver);		

		//slide back right in gallery and save the new image
		act.click(ElementsBuying.Product_galleryImage_right, driver);
		act.waitForAttributeChange(ElementsBuying.Product_galleryImage, "src", gallery_imageNew, driver);
		gallery_imageNew = act.elementAttText(ElementsBuying.Product_galleryImage, "src", driver);		

		//if correct, the images are identical 
		Assert.assertTrue(gallery_image.equals(gallery_imageNew));	
	}


	//Test - updating gallery image after sliding more the once
	@Test		
	public  void Tests_Gallery_sliderImages_leftTwice() throws Exception {
		System.out.println("Running test for updating gallery image after sliding more the once");		
		
		//open required product
		driver.get(ElementsBuying.ProductWithColors);
		Thread.sleep(1000);

		//save the main picture image and the third bottom image in gallery 
		String gallery_bottomImage3 = act.elementAttText(ElementsBuying.Product_galleryImage_bottom3, "src", driver);			
		String gallery_image = act.elementAttText(ElementsBuying.Product_galleryImage, "src", driver);			

		//slide left in gallery twice and save the new image
		act.click(ElementsBuying.Product_galleryImage_left, driver);
		act.click(ElementsBuying.Product_galleryImage_left, driver);
		Thread.sleep(1000);
		gallery_image = act.elementAttText(ElementsBuying.Product_galleryImage, "src", driver);	

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
		Functions.chooseVariations_firstVariation_productPage(driver, "1");
		String variation1_image = act.elementAttText(ElementsBuying.Product_variationsFirst_1_imgSelected, "src", driver);

		//save the image appeared near the chosen variation
		String nearVariation_image = act.elementAttText(ElementsBuying.Product_gallery_nearVariation, "src", driver);
		
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
		Functions.chooseVariations_firstVariation_productPage(driver, "1");

		//change to second variation and save its image 
		Functions.chooseVariations_firstVariationAgain_productPage(driver, "2");
		String variation2_image = act.elementAttText(ElementsBuying.Product_variationsFirst_2_imgSelected, "src", driver);

		//save the image appeared near the chosen variation
		String nearVariation_image = act.elementAttText(ElementsBuying.Product_gallery_nearVariation, "src", driver);
		
		//if correct, the images are identical 
		Assert.assertTrue(variation2_image.equals(nearVariation_image));			
	}
	
	
	
}

package Master.SignUp;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import zipy_elements.*;

@RunWith(Enclosed.class)
public class Negative_signUp_byPhone extends signUp_MAIN {
	
	//tests with parameters 
	@RunWith(Parameterized.class)
	public static class NegativeTests_signUpByPhone_parameterized extends signUp_MAIN  {	
			
		private static String paramPhone;
		public NegativeTests_signUpByPhone_parameterized(String paramPhone) {
			super();
			this.paramPhone = paramPhone;
		}		
		//our parameters to test- phone numbers 
		@Parameterized.Parameters
		public static Collection falseData(){
			return Arrays.asList( new Object[][]{
							{ElementsLogin.PhoneNumber},				//existing number
							{ElementsLogin.PhoneNumber_emptySpace},		//empty number
							{ElementsLogin.PhoneNumber_short},			//number too short 
							{ElementsLogin.PhoneNumber_long},			//number too long 
							{ElementsLogin.PhoneNumber_letters},		//number including non digit signs in the middle
							{ElementsLogin.PhoneNumber_letterF},		//number starting not with 0
							{ElementsLogin.PhoneNumber_wiredPhone},		//wired phone number
							{ElementsLogin.PhoneNumber_mobileIllegal},	//illegal mobile number
							{ElementsLogin.PhoneNumber_wiredIllegal}	//illegal wired phone number
							});
		}
		
		
		//TEST - sign up with incorrect phone number
		@Test		
		public  void N_signUp_byPhone_existingNumber() throws InterruptedException {
			System.out.println("Running test with phone: " + paramPhone);
			
			//enter main page
			driver.get(ElementsWebsites.Zipy_il);

					//press signup button		
					JavascriptExecutor ex=(JavascriptExecutor)driver;
					ex.executeScript("arguments[0].click()", driver.findElement(By.xpath(ElementsLogin.SignUp_button)));

					//choose signup by phone
					driver.findElement(By.xpath(ElementsLogin.SignUp_phone_button)).click();
					
					// enter phone number according to the parameters			
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsLogin.SignUp_phoneNumber)))
					.sendKeys(paramPhone, Keys.ENTER);
				try {
					//press sign-up button if enabled
					wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(ElementsLogin.SignUp_phone_pressEnter)))).click();
					
					//enter phone code if needed: 		
					if(!driver.findElement(By.xpath(ElementsLogin.SignUp_phone_messageExist)).isEnabled()) {
							System.out.println("Please enter the code from your phone:  ");
							Scanner j= new Scanner(System.in);
							String  phone_code= j.nextLine();
						wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsLogin.SignUp_phone_fieldCode)))
						.sendKeys(phone_code, Keys.ENTER);
					}
							
					//check if user logged in
					new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsLogin.UserTopBar)));
					logged = (driver.findElement(By.xpath(ElementsLogin.UserTopBar)).getText().contains(ElementsHeb.SignedIn_ezorIshi));
					
				}
				//checking for an error in logging 
				catch (Exception exc) {
					System.out.println("Negative test - failed as expected");
					errorCaught = true;
				}
				//if succeed, the test caught an error as expected and the user is not logged in
				finally {	
					Assert.assertTrue(errorCaught || !logged);		
				}	
			}
			
		}
	
	//tests without parameters
	public static class NegativeTests_signUpByPhone_notParameterized extends signUp_MAIN  {	
		
		//TEST - sign up with incorrect phone, entered by the user (The comment markers should be deleted if this test is needed)
		@Test		
		public  void N_signUp_byPhone_numberEnteredByUser() throws InterruptedException {			
			/*	
			//enter main page
			driver.get(ElementsWebsites.Zipy_il);
		
			try {
				//press signup button		
				JavascriptExecutor ex=(JavascriptExecutor)driver;
				ex.executeScript("arguments[0].click()", driver.findElement(By.xpath(ElementsLogin.SignUp_button)));

				//choose signup by phone
				driver.findElement(By.xpath(ElementsLogin.SignUp_phone_button)).click();
				
				// enter temporary phone number from user: 		
						System.out.println("Please enter your phone number:   ");
						Scanner k= new Scanner(System.in);
						String  Temp_phoneNumber= k.nextLine();		
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsLogin.SignUp_phoneNumber)))
				.sendKeys(Temp_phoneNumber, Keys.ENTER);
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(ElementsLogin.SignUp_phone_pressEnter)))).click();
				
				// enter phone code from user: 		
				if(!driver.findElement(By.xpath(ElementsLogin.SignUp_phone_messageExist)).isEnabled()) {
						System.out.println("Please enter the code from your phone:  ");
						Scanner j= new Scanner(System.in);
						String  phone_code= j.nextLine();
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsLogin.SignUp_phone_pressEnter)))
					.sendKeys(phone_code, Keys.ENTER);
				}
						
				//check if user logged in
				new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsLogin.UserTopBar)));
				logged = (driver.findElement(By.xpath(ElementsLogin.UserTopBar)).getText().contains(ElementsHeb.SignedIn_ezorIshi));
				
			}
			//checking for an error in logging 
			catch (Exception ex) {
				System.out.println("The test failed as expexted");
				errorCaught = true;
			}
			//if succeed, the test caught an error as expected and the user is not logged in
			finally {	
				Assert.assertTrue(errorCaught || !logged);		
			}	
			*/ 
		}
	}
}

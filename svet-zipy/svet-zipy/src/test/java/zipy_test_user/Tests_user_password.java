package zipy_test_user;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import org.junit.experimental.runners.Enclosed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import zipy_elements.*;

public class Tests_user_password extends Tests_user_MAIN {
			
		
	//TEST - changing the password
	@Test	
	public  void user_passwordChange() throws Exception {
		System.out.println("running test for changing the password");
		
		driver.get(ElementsWebsites.Zipy_il);

		//enter private data and change password 
		Tests_functions.changePassword(driver, ElementsLogin.Email_zipy_password, "123456");

		//if changed correctly, there is a success message
		Assert.assertFalse(driver.findElements(By.xpath(ElementsLogin.user_changePassword_succesMessageVi)).isEmpty());
		
		//change the password back at the end, for future tests
		driver.get(ElementsWebsites.Zipy_il);
		Tests_functions.changePassword(driver, "123456", ElementsLogin.Email_zipy_password);
	
	}
	
	//TEST - recovering the password
	// The recovered password entered by user. (The comment markers should be deleted if this test is needed)
	// The email used for recovery: testzipy1@gmail.com , password: testzipy1testzipy1
	@Test	
	public  void user_passwordRecovery_enteredByUser() throws Exception {
	/*	
		System.out.println("running test for recovering the password");
		
		//disconnect from the user
		driver.get(ElementsWebsites.Zipy_il);
		Tests_functions.unLogIn(driver);
		Thread.sleep(1000);
		
		//press login button		
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click()", driver.findElement(By.xpath(ElementsLogin.Login_button)));
		Thread.sleep(500);		
				
		//recover the password by email 
		driver.findElement(By.xpath(ElementsLogin.user_recoverPassword)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ElementsLogin.user_recoverPassword_help)));

		new Actions (driver).moveToElement(driver.findElement(By.xpath(ElementsLogin.user_recoverPassword_field))).click()
		.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(ElementsLogin.Email_zipy, Keys.ENTER)
		.build().perform();
		
		// ask user to enter the new password from the email: 		
			System.out.println("Please enter your new password from the e-mail:  ");
			Scanner i= new Scanner(System.in);
			String  recovered_password= i.nextLine();	
		driver.get(ElementsWebsites.Zipy_il);
		Tests_functions.logInSpecial(driver, ElementsLogin.Email_zipy, recovered_password);

		//if recovered successfully, the user logged in
		new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementsLogin.UserTopBar)));
		Boolean logged = (driver.findElement(By.xpath(ElementsLogin.UserTopBar)).getText().contains(ElementsHeb.SignedIn_ezorIshi));
		Assert.assertTrue(logged);
				
		//change the password back at the end, for future tests
		driver.get(ElementsWebsites.Zipy_il);
		Tests_functions.changePassword(driver, recovered_password, ElementsLogin.Email_zipy_password);
	*/
	}

	
	//TEST - changing the email
	@Test	
	public  void user_changeEmail() throws Exception {
		System.out.println("running test for changing the email");
		
		driver.get(ElementsWebsites.Zipy_il);

		//enter private data and change password 
		Tests_functions.changeEmail(driver, ElementsLogin.Email_zipy2, ElementsLogin.Email_zipy_password);

		//if changed correctly, there is a success message
		Assert.assertFalse(driver.findElements(By.xpath(ElementsLogin.user_changePassword_succesMessageVi)).isEmpty());
		
		//change the email back at the end, for future tests
		driver.get(ElementsWebsites.Zipy_il);
		Tests_functions.changeEmail(driver, ElementsLogin.Email_zipy, ElementsLogin.Email_zipy_password);
	
	}
	
}

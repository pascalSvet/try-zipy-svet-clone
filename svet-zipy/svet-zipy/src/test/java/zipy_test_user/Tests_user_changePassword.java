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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import zipy_elements.*;

public class Tests_user_changePassword extends Tests_user_MAIN {
			
		
	//TEST - sign up with incorrect email or incorrect password
	@Test	
	public  void user_changePassword() throws Exception {
		System.out.println("");
		
		driver.get(ElementsWebsites.Zipy_il);

		//login with zipy user
		Tests_functions.logInSpecial(driver, ElementsLogin.Email_zipy, ElementsLogin.Email_zipy_password);
		
		//enter private data and change password 
		Tests_functions.changePassword(driver, ElementsLogin.Email_zipy_password, "123456");

		//if changed correctly, there is a success message
		Assert.assertFalse(driver.findElements(By.xpath(ElementsLogin.user_changePassword_succesMessageVi)).isEmpty());
		
		//change the password back at the end, for future tests
		driver.get(ElementsWebsites.Zipy_il);
		Tests_functions.changePassword(driver, "123456", ElementsLogin.Email_zipy_password);
	
	}

	
}

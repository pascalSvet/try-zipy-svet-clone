package Master.User;
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

public class User_email extends User_MAIN {
			
		
	//TEST - changing the email
	@Test	
	public  void user_changeEmail() throws Exception {
		System.out.println("running test for changing the email");
		
		//enter main page
		driver.get(ElementsWebsites.Zipy_il);

		//enter private data and change password 
		Functions.changeEmail(driver, ElementsLogin.Email_zipy2, ElementsLogin.Email_zipy_password);

		//if changed correctly, there is a success message
		Assert.assertFalse(driver.findElements(By.xpath(ElementsLogin.user_changePassword_succesMessageVi)).isEmpty());
		
		//change the email back at the end, for future tests
		driver.get(ElementsWebsites.Zipy_il);
		Functions.changeEmail(driver, ElementsLogin.Email_zipy, ElementsLogin.Email_zipy_password);
	
	}
	
}

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

public class User_mobile extends User_MAIN {
			
		
	//TestsMobile - changing the password
	@Test	
	public  void TestsMobile_user_passwordChange() throws Exception {
		System.out.println("running test (in mobile version) for changing the password");
		
		//change to mobile screen resolution and enter main page
		driver.manage().window().setSize(new Dimension(320,700));
		
		driver.get(ElementsWebsites.Zipy_il);

		System.out.println(driver.manage().window().getSize().getWidth());
		System.out.println(driver.manage().window().getSize().getHeight());

		//enter private data and change password 
		Functions.changePassword(driver, ElementsLogin.Email_zipy_password, "123456");

		//if changed correctly, there is a success message		
		Assert.assertTrue(act.elementExist(ElementsLogin.user_changePassword_succesMessageVi, driver));
		
		//change the password back at the end, for future tests
		driver.get(ElementsWebsites.Zipy_il);
		Functions.changePassword(driver, "123456", ElementsLogin.Email_zipy_password);
	
	}

	
	//TestsMobile - changing the email
	@Test	
	public  void TestsMobile_user_changeEmail() throws Exception {
		System.out.println("running test (in mobile version) for changing the email");
		
		//change to mobile screen resolution and enter main page
		driver.manage().window().setSize(new Dimension(320,700));
		driver.get(ElementsWebsites.Zipy_il);

		System.out.println(driver.manage().window().getSize().getWidth());
		System.out.println(driver.manage().window().getSize().getHeight());

		//enter private data and change email 
		Functions.changeEmail(driver, ElementsLogin.Email_zipy2, ElementsLogin.Email_zipy_password);

		//if changed correctly, there is a success message
		Assert.assertTrue(act.elementExist(ElementsLogin.user_changePassword_succesMessageVi, driver));
		
		//change the email back at the end, for future tests
		driver.get(ElementsWebsites.Zipy_il);
		Functions.changeEmail(driver, ElementsLogin.Email_zipy, ElementsLogin.Email_zipy_password);
	
	}
	
	
}

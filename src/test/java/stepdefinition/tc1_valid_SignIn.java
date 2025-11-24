package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.edge.EdgeDriver;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.SignIn;
import utilities.Screenshot;
import utilities.extentreport;

public class tc1_valid_SignIn{
	WebDriver driver=hooks.driver;
	SignIn signin = new SignIn(driver);
	Screenshot ss=new Screenshot(driver);
	@When("The user enters username as {string} and password as {string}")
	public void the_user_enters_username_as_and_password_as(String username, String password) {
		extentreport.logger = extentreport.extent.startTest("Valid login with user: " + username);
		signin.enterusername(username);
		signin.enterpassword(password);
		
	    
	}
	@Then("system redirects the user to the HOME page")
	public void system_redirects_to_the_home_page() throws InterruptedException, WebDriverException, IOException {
		signin.clickloginbutton();
		Thread.sleep(2000);
		String expecout="Silicon Valley Engineers Club";
		String actout=driver.getTitle();
		try {
			assertEquals(actout, expecout);
			extentreport.logger.log(LogStatus.PASS, "test case passed");
			
			
		}catch(AssertionError e)
		{
			ss.takeScreenshot();
			extentreport.logger.log(LogStatus.FAIL, "test case failed");
			e.printStackTrace();
			
		}
		finally {
			extentreport.extent.endTest(extentreport.logger);
		}
		
		Thread.sleep(2000);
	}


}

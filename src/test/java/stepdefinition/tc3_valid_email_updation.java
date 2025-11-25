package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Update;
import utilities.Screenshot;
import utilities.extentreport;

public class tc3_valid_email_updation {
	private String currentusername;
	WebDriver driver=hooks.driver;
	Update update= new Update(driver);
	Screenshot ss = new Screenshot(driver);
	String scenarioname=hooks.currentScenario.getName();

@When("the user enters a valid email address like {string} and clicks the submit button")
public void the_user_enters_a_valid_email_address_like_and_clicks_the_submit_button(String email) throws InterruptedException {
	extentreport.logger=extentreport.extent.startTest("Valid Email updation with email "+ email);
	this.currentusername=email;
	update.clearemailfield();
	Thread.sleep(2000);
	update.enteremail(email);
	Thread.sleep(2000);
}
@Then("the system redirects the user to the home page")
public void the_system_redirects_the_user_to_the_home_page() throws InterruptedException, WebDriverException, IOException {
	update.clicksubmit();
	Thread.sleep(2000);
	String expecout="Silicon Valley Engineers Club";
	String actout=driver.getTitle();
	try {
		assertEquals(actout, expecout);
		extentreport.logger.log(LogStatus.PASS, "test case passed");
		
		
	}catch(AssertionError e)
	{
		ss.takeScreenshot(scenarioname,this.currentusername);
		extentreport.logger.log(LogStatus.FAIL, "test case failed");
		e.printStackTrace();
		
	}
		
	finally {
		extentreport.extent.endTest(extentreport.logger);
	}
	
	Thread.sleep(2000);
    
}

}

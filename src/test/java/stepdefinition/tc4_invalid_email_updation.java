package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import pageobjects.Update;
import utilities.Screenshot;
import utilities.extentreport;

public class tc4_invalid_email_updation {
	private String currentusername;
	WebDriver driver=hooks.driver;
	Update upd=new Update(driver);
	Screenshot ss= new Screenshot(driver);
	String scenarioname=hooks.currentScenario.getName();
	@When("the user enters an invalid email address like {string} and click the submit button")
	public void the_user_enters_an_invalid_email_address_like_and_click_the_submit_button(String email) throws InterruptedException {
		extentreport.logger=extentreport.extent.startTest("Invalid Email updation with email "+ email);
		this.currentusername=email;
		upd.clearemailfield();
		Thread.sleep(2000);
		upd.enteremail(email);
		Thread.sleep(2000);
	}
	@Then("the system should display an error message Provide a valid email id")
	public void the_system_should_display_an_error_message() throws InterruptedException, WebDriverException, IOException {
		upd.clicksubmit();
		Thread.sleep(2000);
		String expecout="Provide a valid email id";
		try {
			String actout=driver.findElement(By.xpath("//*[contains(text(),'Provide a valid email id')]")).getText();
			assertEquals(actout, expecout);
			extentreport.logger.log(LogStatus.PASS, "test case passed");
			Allure.step("Verification: Invalid Email Updation with "+this.currentusername+" passed");
			
			
		}catch(AssertionError e)
		{
			ss.takeScreenshot(scenarioname,this.currentusername);
			extentreport.logger.log(LogStatus.FAIL, "test case failed");
			Allure.addAttachment("Invalid Email updation Details", e.getMessage());
			e.printStackTrace();
			throw e;
			
		}
		catch(org.openqa.selenium.NoSuchElementException e) {
			ss.takeScreenshot(scenarioname,this.currentusername);
			extentreport.logger.log(LogStatus.FAIL, "test case failed");
			Allure.addAttachment("Invalid Email updation Details", e.getMessage());
			e.printStackTrace();
			throw e;
			
		}
		finally {
			extentreport.extent.endTest(extentreport.logger);
		}
		Thread.sleep(2000);
	    
	}

}

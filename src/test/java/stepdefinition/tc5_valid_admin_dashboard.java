package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.edge.EdgeDriver;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import pageobjects.Admin;
import pageobjects.SignIn;
import utilities.Screenshot;
import utilities.extentreport;

public class tc5_valid_admin_dashboard {
	private String currentusername;
	WebDriver driver=hooks.driver;
	Screenshot ss= new Screenshot(driver);
	SignIn signin= new SignIn(driver);
	Admin admin = new Admin(driver);
	String scenarioname=hooks.currentScenario.getName();
	@When("the user clicks the admin button and enters the username as {string} and password as {string}")
	public void the_user_clicks_the_admin_button_and_enters_the_username_as_and_password_as(String uname, String pwd) throws InterruptedException {
		this.currentusername=uname;
		admin.clickadminbutton();
		extentreport.logger=extentreport.extent.startTest("Accessing admin dashboard as admin");
		signin.enterusername(uname);
		signin.enterpassword(pwd);
		signin.clickloginbutton();
		Thread.sleep(2000);
		
	}
	@Then("the system redirects the user to admin dashboard")
	public void the_system_redirects_the_user_to_admin_dashboard() throws WebDriverException, IOException, InterruptedException {
		String expecout="Administration";
		String actout=driver.getTitle();
		try {
			assertEquals(actout, expecout);
			extentreport.logger.log(LogStatus.PASS, "test case passed");
			Allure.step("Verification: Accessing admin dashboard as "+this.currentusername+" passed");
			
			
		}catch(AssertionError e)
		{
			ss.takeScreenshot(scenarioname,this.currentusername);
			extentreport.logger.log(LogStatus.FAIL, "test case failed");
			Allure.addAttachment("Invalid access of admin dashboard", e.getMessage());
			e.printStackTrace();
			throw e;
			
		}
		finally {
			extentreport.extent.endTest(extentreport.logger);
		}
		
		Thread.sleep(2000);
		}

}


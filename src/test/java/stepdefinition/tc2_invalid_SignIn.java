package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.SignIn;
import utilities.Screenshot;
import utilities.extentreport;

public class tc2_invalid_SignIn extends extentreport {
	private String currentusername;
	WebDriver driver=hooks.driver;
	String scenarioname=hooks.currentScenario.getName();
	SignIn signin = new SignIn(driver);
	Screenshot ss = new Screenshot(driver);
	@When("the user enters the username as {string} and password as {string}")
	public void the_user_enters_the_username_as_and_password_as(String uname, String pwd) {
		logger=extent.startTest("Invalid login with user:" + uname);
		this.currentusername=uname;
		signin.enterusername(uname);
		signin.enterpassword(pwd);
	}
	@Then("system shows an error message Login or password in incorrect")
	public void system_shows_an_error_message_Login_or_password_in_incorrect() throws InterruptedException, WebDriverException, IOException {
		signin.clickloginbutton();
		String expecout="Login or Password is incorrect.";
		try {
			String actout=driver.findElement(By.xpath("//*[contains(text(),'Login or Password is incorrect')]")).getText();
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

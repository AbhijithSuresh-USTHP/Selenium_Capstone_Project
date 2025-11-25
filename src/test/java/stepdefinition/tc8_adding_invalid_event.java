package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Event;
import utilities.Screenshot;
import utilities.extentreport;

public class tc8_adding_invalid_event {
	private String currenttitle,currentdate;
	WebDriver driver=hooks.driver;
	Event event=new Event(driver);
	Screenshot ss= new Screenshot(driver);
	String scenarioname=hooks.currentScenario.getName();
	@When("the admin enters the invalid event details, Date as {string}, Title as {string}, Description as {string}, Location as {string}, and Presenter as {string}")
	public void the_admin_enters_the_invalid_event_details_Date_as_Title_as_Description_as_Location_as_and_Presenter_as(String date, String title, String desc, String location, String presenter) {
		this.currenttitle=title;
		this.currentdate=date;
	    extentreport.logger=extentreport.extent.startTest("Adding Event with invalid date");
		event.gotoevents();
	    event.addnewevent();
	    event.enterdate(date);
	    event.entertitle(title);
	    event.enterdescription(desc);
	    event.enterlocation(location);
	    event.enterpresenter(presenter);
	}
	@When("click the add button for invalid case")
	public void click_the_add_button_for_invalid_case() throws InterruptedException {
		event.clickadd();
		Thread.sleep(3000);
	}
	@Then("the system should display and error message Event date must be today or a future date")
	public void the_system_should_display_and_error_message_Event_date_must_be_today_or_a_future_date() throws WebDriverException, IOException {
		try {
			   WebElement ifevent= driver.findElement(By.xpath("//*[contains(text(),'"+this.currenttitle+"')]"));
			   ss.takeScreenshot(scenarioname,this.currentdate);
			   extentreport.logger.log(LogStatus.FAIL, "test case failed");
		   }
		   catch(NoSuchElementException e) {
			   System.out.println("No such element");
				extentreport.logger.log(LogStatus.PASS, "test case passed");
				e.printStackTrace();
		   }
		
		   finally {
				extentreport.extent.endTest(extentreport.logger);
			}
	}
}

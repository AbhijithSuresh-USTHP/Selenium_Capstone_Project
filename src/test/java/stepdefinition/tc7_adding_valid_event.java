package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;import org.openqa.selenium.ElementNotInteractableException;
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

public class tc7_adding_valid_event {
	private String currenttitle,currentdate;
	WebDriver driver=hooks.driver;
	Event event=new Event(driver);
	Screenshot ss= new Screenshot(driver);
	String scenarioname=hooks.currentScenario.getName();
	@When("the admin enters the valid event details ,Date as {string}, Title as {string}, Description as {string}, Location as {string}, and Presenter as {string}")
	public void the_admin_enters_the_valid_event_details_Date_as_Title_as_Description_as_Location_as_and_Presenter_as(String date, String title, String desc, String location, String presenter) {
		this.currenttitle=title;
		this.currentdate=date;
	    extentreport.logger=extentreport.extent.startTest("Adding Event with valid date");
		event.gotoevents();
	    event.addnewevent();
	    event.enterdate(date);
	    event.entertitle(title);
	    event.enterdescription(desc);
	    event.enterlocation(location);
	    event.enterpresenter(presenter);
	    
	    
	}
	@When("clicks the add button for valid case")
	public void clicks_the_add_button_for_valid_case() throws InterruptedException {
		event.clickadd();
		Thread.sleep(3000);
	    
	}
	@Then("the system navigates to the events page and shows the added event in the event list")
	public void the_system_navigates_to_the_events_page_and_shows_the_added_event_in_the_event_list() throws WebDriverException, IOException {
	   
	   try {
		   String expecout=this.currenttitle;
		   String actout;	
		   WebElement ifevent= driver.findElement(By.xpath("//*[contains(text(),'"+this.currenttitle+"')]"));
		   actout=ifevent.getText().trim();
		   assertEquals(actout, expecout);
		   extentreport.logger.log(LogStatus.PASS, "test case passed");
	   }
	   catch(NoSuchElementException e) {
		   ss.takeScreenshot(scenarioname,this.currentdate);
			extentreport.logger.log(LogStatus.FAIL, "test case failed");
			e.printStackTrace();
	   }
	   catch(AssertionError e) {
		   ss.takeScreenshot(scenarioname,this.currentdate);
			extentreport.logger.log(LogStatus.FAIL, "test case failed");
			e.printStackTrace();
	   }
	   finally {
			extentreport.extent.endTest(extentreport.logger);
		}
	}
}

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Event {
	WebDriver driver;
	WebElement event,addnew,date,title,desc,location,presenter,add;
	
	public Event(WebDriver driver) {
		this.driver=driver;
	}
	
	public void gotoevents() {
		event=driver.findElement(By.linkText("Events"));
		event.click();
	}
	public void addnewevent() {
		addnew=driver.findElement(By.linkText("Add New"));
		addnew.click();
	}
	public void enterdate(String eventdate) {
		date=driver.findElement(By.name("date_start"));
		date.sendKeys(eventdate);
	}
	public void entertitle(String newtitle) {
		title=driver.findElement(By.name("event_name"));
		title.sendKeys(newtitle);
	}
	public void enterdescription(String description) {
		desc=driver.findElement(By.name("event_desc"));
		desc.sendKeys(description);
	}
	public void enterlocation(String newlocation) {
		location=driver.findElement(By.name("location"));
		location.sendKeys(newlocation);
	}
	public void enterpresenter(String newpresenter) {
		presenter=driver.findElement(By.name("presenter"));
		presenter.sendKeys(newpresenter);
	}
	public void clickadd() {
		add=driver.findElement(By.name("Insert"));
		add.click();
	}

}

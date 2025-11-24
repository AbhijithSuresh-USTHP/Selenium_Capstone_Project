package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Update {
	WebDriver driver;
	WebElement email;
	
	private final By accountLink = By.xpath("//img[@src='images/p_account.gif']");
    private final By registrationLink = By.xpath("//a[@href='Registration.php']");
    private final By emailField = By.name("email");
    private final By updateButton = By.name("Update");
	
	public Update(WebDriver driver) {
		this.driver=driver;
	}
	public void gotoupdate() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(accountLink)).click();
		
	}
	public void clickRegistrationlink() {
		driver.findElement(registrationLink).click();
	}
	public void clearemailfield() {
		driver.findElement(emailField).clear();
	}
	public void enteremail(String emailid) {
		driver.findElement(emailField).sendKeys(emailid);
	}
	public void clicksubmit() {
		driver.findElement(updateButton).click();
	}
	

}

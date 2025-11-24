package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Admin {
	WebDriver driver;
	WebElement adminbutton;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	private final By adminLink = By.xpath("//img[@src='images/p_admin.gif']");
	public Admin(WebDriver driver) {
		this.driver=driver;
	}
	public void clickadminbutton() {
		driver.findElement(adminLink).click();
	}

}

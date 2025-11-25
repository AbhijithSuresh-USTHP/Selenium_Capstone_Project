package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn {
	WebDriver driver;
	WebElement username,password;
	public SignIn(WebDriver driver) {
		this.driver=driver;
		
	}
	public void gotologin() {
		driver.findElement(By.xpath("//img[@src='images/p_signin.gif']")).click();
	}
	public void enterusername(String username) {
		driver.findElement(By.name("login")).sendKeys(username);
	}
	public void enterpassword(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}
	public void clickloginbutton() {
		driver.findElement(By.name("Button_DoLogin")).click();
	}
	public void clicklogoutbutton() {
		driver.findElement(By.linkText("Logout")).click();
	}

}

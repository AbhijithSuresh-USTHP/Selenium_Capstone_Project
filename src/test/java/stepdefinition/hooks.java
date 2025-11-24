package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pageobjects.SignIn;
import pageobjects.Update;

public class hooks {
	static WebDriver driver;
	
	
	
	@Before("@login")
	public void gotologin() {
		driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://examples.codecharge.com/Portal/Default.php");
		SignIn signin1 = new SignIn(driver);
		signin1.gotologin();
		}
	@Before("@update")
	public void gotoupdate() {
		driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://examples.codecharge.com/Portal/Default.php");
		SignIn signin1 = new SignIn(driver);
		signin1.gotologin();
		signin1.enterusername("admin");
		signin1.enterpassword("admin");
		signin1.clickloginbutton();
		Update upd=new Update(driver);
		upd.gotoupdate();
		upd.clickRegistrationlink();
		
	}
	@Before("@admin")
	public void gotoadmin() {
		driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://examples.codecharge.com/Portal/Default.php");
		SignIn signin1 = new SignIn(driver);
		
	}
	
	@After
	public void closebrowser() {
		driver.quit();
	}

}

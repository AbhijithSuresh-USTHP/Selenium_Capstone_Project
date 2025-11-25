package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageobjects.Admin;
import pageobjects.SignIn;
import pageobjects.Update;

public class hooks {
	static WebDriver driver;
	public static Scenario currentScenario;
	
	
	@Before("@login")
	
	public void gotologin(Scenario scenario) {
		currentScenario=scenario;
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://examples.codecharge.com/Portal/Default.php");
		SignIn signin1 = new SignIn(driver);
		signin1.gotologin();
		}
	@Before("@update")
	public void gotoupdate(Scenario scenario) {
		currentScenario=scenario;
		driver=new EdgeDriver();
		driver.manage().window().maximize();
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
	public void gotoadmin(Scenario scenario) {
		currentScenario=scenario;
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://examples.codecharge.com/Portal/Default.php");
		SignIn signin1 = new SignIn(driver);
		
	}
	
	@Before("@event")
	public void gotoevent(Scenario scenario) {
		currentScenario=scenario;
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://examples.codecharge.com/Portal/Default.php");
		SignIn signin=new SignIn(driver);
		Admin admin=new Admin(driver);
		signin.gotologin();
		signin.enterusername("admin");
		signin.enterpassword("admin");
		signin.clickloginbutton();
		admin.clickadminbutton();
	}
	
	@After
	public void closebrowser() {
		driver.quit();
	}

}

package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.google.common.io.Files;

public class Screenshot{
	WebDriver driver;
	static int step=1;
	
	public Screenshot(WebDriver driver) {
		this.driver=driver;
	}
	public void takeScreenshot(String scenarioname,String uniqueid) throws IOException, WebDriverException {
		System.out.println("Taking Screenshot");
		String actualfilename=scenarioname+"_"+uniqueid;
		String safeFilename = actualfilename.replaceAll("[\\\\/:*?\"<>|]", "_");
		File scrFile;
		scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(scrFile, new File("//C:\\Users\\Administrator\\Documents\\Selenium demo\\codecharge_community_portal_capstone\\Screenshots\\test "+safeFilename+".jpeg"));		
	}

}

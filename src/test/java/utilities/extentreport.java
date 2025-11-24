package utilities;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class extentreport {
	public static ExtentReports extent;
    public static ExtentTest logger;  
    


  @Test
  public void f() 
  {
  
  }
//  @AfterMethod
//  public void getResult(ITestResult result)
//  {
//      if(result.getStatus() == ITestResult.FAILURE)
//      {
//          logger.log(LogStatus.FAIL, "Test is failed");
//          
//      }
//      else if(result.getStatus() == ITestResult.SUCCESS)
//      {
//          logger.log(LogStatus.PASS, "Test is pass");
//      }
//  }


  @BeforeSuite
  public void beforeSuite() 
  {
	  extent = new ExtentReports ("C:\\Users\\Administrator\\Documents\\Selenium demo\\codecharge_community_portal_capstone\\Report\\report.html", true);
  }

  @AfterSuite
  public void afterSuite() 
  {
	  extent.flush();
  }

}

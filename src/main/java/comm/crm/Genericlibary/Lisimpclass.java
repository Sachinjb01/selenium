package comm.crm.Genericlibary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Lisimpclass  implements ITestListener{
	
	
	public void onTestFailure(ITestResult result)
	
	{
		String test = result.getMethod().getMethodName();
		
		WebDriver driver = null;
		EventFiringWebDriver edrive=new EventFiringWebDriver(driver);
		File src=edrive.getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(src, new File("./screenshoot/test.png"));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}

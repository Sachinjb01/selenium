package comm.crm.screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;



import comm.crm.Genericlibary.BaseClass;

public class Screenshot extends BaseClass{
	
	
	
	@Test
	public void SampleScreneshot() throws IOException
	{
		
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./data/screenshot/test.png") ;
		FileUtils.copyFile(src, dest);
		
	}
	
	
	
	

}

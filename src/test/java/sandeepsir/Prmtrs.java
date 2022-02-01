package sandeepsir;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Prmtrs {
	WebDriver driver;
	@Test
	@Parameters({"browser","url"})
	public void test(String browser,String url)
	{
		if(browser.equals("firefox")){
			driver=new FirefoxDriver();
		}
		else if(browser.equals("Chrome")){
			driver=new ChromeDriver();
		}
		driver.get(url);
	}

}

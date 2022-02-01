package comm.crm.Genericlibary;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import comm.vtiger.comcast.pomrepositylib.Home;
import comm.vtiger.comcast.pomrepositylib.Login;

public class BaseClass {

	
	
	
	public WebDriver driver=null;
	/*OBJECT CREATION FOR UTILITY*/
    public 	FileUtility fLib=new FileUtility();
	public  ExcelUtility eLib=new ExcelUtility();
	public  JavaUtility jLib=new JavaUtility();
    public 	WebDriverUtility wLib=new WebDriverUtility();


@BeforeSuite(groups={"Smoke Testing","Regression Testing"})
public void ConfigBS()
{
	System.out.println(" =====connect to DB========");
	


}	
	//@Parameters("browser")
	@BeforeClass(groups={"Smoke Testing","Regression Testing"})
	public void ConfigBC() throws IOException
	{
		System.out.println("====Launch the Browser");
		String Br = fLib.getPropertykeyValue("browser");
		
		if(Br.equalsIgnoreCase("firefox"))
		{
			System.out.println("Launching fire");
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Launching chrome");
		driver = new ChromeDriver();
		}
		wLib.waitUntilPageLoad(driver);
		
		

	}
	@BeforeMethod(groups={"Smoke Testing","Regression Testing"})
	public void ConfigBM() throws Throwable 
	{
		/*read common Data*/

		
		String Url = fLib.getPropertykeyValue("url");
		String Username = fLib.getPropertykeyValue("username");
		String Password = fLib.getPropertykeyValue("password");
		
		/*navigate to application*/
		driver.get(Url);
		
		/*login*/
		Login lp=new Login(driver);
		lp.loginToApp(Username, Password);
	}
	
	@AfterMethod(groups={"Smoke Testing","Regression Testing"})
	public void ConfigAm()
	{
		Home hp=new Home(driver);
		/*logout*/
		hp.logout();
	}
	@AfterClass(groups={"Smoke Testing","Regression Testing"})
	public void ConfigAc()
	{
		System.out.println("======close the Browser=====");
		/*:-close the browser*/
		driver.close();
	}
	@AfterSuite(groups={"Smoke Testing","Regression Testing"})
	public void ConfigAs()
	{
		System.out.println("====close db======");
		
			
			
		}
	}


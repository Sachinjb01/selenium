package comm.vtiger.comcast.organizationtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

import comm.crm.Genericlibary.ExcelUtility;
import comm.crm.Genericlibary.FileUtility;
import comm.crm.Genericlibary.JavaUtility;
import comm.crm.Genericlibary.WebDriverUtility;
import comm.vtiger.comcast.pomrepositylib.CreateNewOrganization;
import comm.vtiger.comcast.pomrepositylib.Home;
import comm.vtiger.comcast.pomrepositylib.Login;
import comm.vtiger.comcast.pomrepositylib.Organization;
import comm.vtiger.comcast.pomrepositylib.Organizationinfo;

public class CreateOrganization {
	
	public static void main(String[] args) throws IOException
	{
		/*create objects*/
		WebDriver driver=null;;
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		/*read comm data*/
		
		
		String Br = fLib.getPropertykeyValue("browser");
		String Url = fLib.getPropertykeyValue("url");
		String Username = fLib.getPropertykeyValue("username");
		String Password = fLib.getPropertykeyValue("password");
		
		/*reading data from Excel*/
		String OrgName = eLib.getDataFromExcel("Org", 1, 1)+jLib.getRandomNumber();
		
		
		String orgName = eLib.getDataFromExcel("Org",1,1)+"_"+jLib.getRandomNumber();
		
		if(Br.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		
		wLib.waitUntilPageLoad1(driver);
		/*navigate to application*/
		driver.get(Url);
		
		/*login*/
		Login lp=new Login(driver);
		lp.loginToApp(Username, Password);
		
        /* : navigate to organization*/
		Home hp=new Home(driver);
		hp.getOrganizationlink().click();
		
		 /* : navigate to "create new organization"page by click on "+" image */
		
		Organization op=new Organization(driver);
		op.getCreateorgImg().click();
		
		/* : create organization*/
		CreateNewOrganization cno=new CreateNewOrganization(driver);
		
		cno.createOrg(OrgName);
		
		
		
		
		
		
		  /*: verify the successful msg with org name*/
		Organizationinfo org=new Organizationinfo(driver);
		String orl = org.getSuccessfull().getText();
		
		if(orl.contains(OrgName))
		{
			System.out.println("org is created pass");
		}
		else
		{
			System.out.println("org is not created fail");
		}
		
		/*logout*/
		hp.logout();
		/*step8:-close the browser*/
		driver.close();
		
		
		
		
		
		
		
		
		
		
	}

}

package Com.crm.comcast.contacttest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import comm.crm.Genericlibary.ExcelUtility;
import comm.crm.Genericlibary.FileUtility;
import comm.crm.Genericlibary.JavaUtility;
import comm.crm.Genericlibary.WebDriverUtility;
import comm.vtiger.comcast.pomrepositylib.Contact;
import comm.vtiger.comcast.pomrepositylib.ContactInformation;
import comm.vtiger.comcast.pomrepositylib.CreateNewOrganization;
import comm.vtiger.comcast.pomrepositylib.CreatingNewContacts;
import comm.vtiger.comcast.pomrepositylib.Home;
import comm.vtiger.comcast.pomrepositylib.Login;
import comm.vtiger.comcast.pomrepositylib.Organization;
import comm.vtiger.comcast.pomrepositylib.Organizationinfo;

public class CreateContactWithOrgTest {

	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		WebDriver driver=null;
		/*OBJECT CREATION FOR UTILITY*/
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		
		/*  READ COMMON DATE FROM PROPERTIES FILE  */
		String Browser = fLib.getPropertykeyValue("browser");
		String Url = fLib.getPropertykeyValue("url");
		String Username = fLib.getPropertykeyValue("username");
		String Password= fLib.getPropertykeyValue("password");
		
		
		/*  READ TEST DATA FROM EXCEL FILES  */
		String OrgName = eLib.getDataFromExcel("Org", 1, 1)+jLib.getRandomNumber();
		String lastname = eLib.getDataFromExcel("Contact", 1, 1)+jLib.getRandomNumber();
		
		/* LAUNCH THE BROWSER   */
		if(Browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else{
			driver=new ChromeDriver();
		}
		
		wLib.waitUntilPageLoad1(driver);
		driver.get(Url);
		/*  LOGIN TO APLICATION  */
		Login lp=new Login(driver);
		lp.loginToApp(Username, Password);
		
		
        /*navigate to the org*/
		Home hp1=new Home(driver);
		hp1.getOrganizationlink().click();	
		
	
		Organization op=new Organization(driver);
		op.getCreateorgImg().click();
		
		/*pass the value*/
		CreateNewOrganization cno=new CreateNewOrganization(driver);
		cno.createOrg(OrgName);
		
		/*click on contact*/
		Organizationinfo info=new Organizationinfo(driver);
		wLib.waitUntilelementVisible(driver, info.getSuccessfull());
		hp1.getContactEdt().click();
			
		Contact c=new Contact(driver);
		c.getCreateContact().click();
		
		CreatingNewContacts cn=new CreatingNewContacts(driver);
		cn.CreateCon(lastname, OrgName);
		
		
		
		
		
		/*  VERIFY THE DETAILS  */
		
		ContactInformation ci=new ContactInformation(driver);
		String cin = ci.getOname().getText();
		System.out.println(cin);
		
		if(cin.trim().equals(OrgName))
		{
			System.out.println(" conatact created pass");
		}
		else
		{
			System.out.println("contact not created fail");
		}
		
		
		
		/* LOGOUT   */
		hp1.logout();
		
		/*CLOSE    */
		driver.close();

	}
		
}

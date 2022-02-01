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
import comm.vtiger.comcast.pomrepositylib.CreatingNewContacts;
import comm.vtiger.comcast.pomrepositylib.Home;
import comm.vtiger.comcast.pomrepositylib.Login;
import comm.vtiger.comcast.pomrepositylib.Organization;

public class CreateContactTest {

	public static void main(String[] args) throws IOException{
		
	
	WebDriver driver=null;
	
	/*Object creation for Utility*/
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	
	
	/*read common data from properties File*/
	String Browser = fLib.getPropertykeyValue("browser");
	String Url = fLib.getPropertykeyValue("url");
	String Username = fLib.getPropertykeyValue("username");
	String Password= fLib.getPropertykeyValue("password");
	
	/*read test data from Excel File*/
	
	
	String Lname = eLib.getDataFromExcel("Contact", 1, 1)+jLib.getRandomNumber();
	
	/*step1:-Login*/
	
	if(Browser.equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else
	{
		driver=new ChromeDriver();
	}
	wLib.waitUntilPageLoad1(driver);
	driver.get(Url);
	
	/*step:-2 Login to application*/
	
	Login lp=new Login(driver);
	lp.loginToApp(Username, Password);
	
	
	/*step:-3 Navigate to contact page*/
	Home hp=new Home(driver);
	hp.getContactEdt().click();
	
	/*step4:-Navigate to create new contact page*/
	Contact c=new Contact(driver);
	c.getCreateContact().click();
	
	/*step5:-create new contact */
	CreatingNewContacts cn=new CreatingNewContacts(driver);
	cn.CreateCon(Lname);
	
	/*step6:-verify the contact details*/
	ContactInformation ci=new ContactInformation(driver);
	String cin = ci.getSucess().getText();
	
	if(cin.contains(Lname))
	{
		System.out.println(" conatact created pass");
	}
	else
	{
		System.out.println("contact not created fail");
	}
	
	/*step7:-Logout*/
	hp.logout();
	
	/*step8:-close */
	driver.close();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}

package comm.crm.TestingcreateOrgCont;

import java.io.IOException;

import org.testng.annotations.Test;

import comm.crm.Genericlibary.BaseClass;
import comm.vtiger.comcast.pomrepositylib.Contact;
import comm.vtiger.comcast.pomrepositylib.ContactInformation;
import comm.vtiger.comcast.pomrepositylib.CreateNewOrganization;
import comm.vtiger.comcast.pomrepositylib.CreatingNewContacts;
import comm.vtiger.comcast.pomrepositylib.Home;
import comm.vtiger.comcast.pomrepositylib.Organization;
import comm.vtiger.comcast.pomrepositylib.Organizationinfo;

public class CreatecontactTest extends BaseClass{
	
	@Test
	public void Createconorg() throws Throwable, IOException
	{
		/*read test data from Excel File*/
		
		
		String Lname = eLib.getDataFromExcel("Contact", 1, 1)+jLib.getRandomNumber();
		
		
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
		
	}
	
	
	@Test
	public void Createcontactwithorg() throws Throwable, IOException
	{
		/*  READ TEST DATA FROM EXCEL FILES  */
		String OrgName = eLib.getDataFromExcel("Org", 1, 1)+jLib.getRandomNumber();
		String lastname = eLib.getDataFromExcel("Contact", 1, 1)+jLib.getRandomNumber();
		
		
		
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
		
		
		
	}
	
	
	

}

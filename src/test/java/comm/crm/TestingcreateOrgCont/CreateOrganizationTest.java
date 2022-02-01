package comm.crm.TestingcreateOrgCont;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import comm.crm.Genericlibary.BaseClass;
import comm.vtiger.comcast.pomrepositylib.CreateNewOrganization;
import comm.vtiger.comcast.pomrepositylib.Home;
import comm.vtiger.comcast.pomrepositylib.Organization;
import comm.vtiger.comcast.pomrepositylib.Organizationinfo;

public class CreateOrganizationTest extends BaseClass {
	
	
	
	
	@Test(groups="Smoke Testing")
	public void Createorg() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		
		/*test script Data*/
	String OrgName = eLib.getDataFromExcel("Org", 1, 1)+jLib.getRandomNumber();
		
		
		String orgName = eLib.getDataFromExcel("Org",1,1)+"_"+jLib.getRandomNumber();
		
		
		
		  /* : navigate to organization*/
				Home hp=new Home(driver);
				hp.getOrganizationlink().click();
				
		
 /* : navigate to "create new organization"page by click on "+" image */
		
		Organization op=new Organization(driver);
		op.getCreateorgImg().click();
		
		/* : create organization*/
		CreateNewOrganization cno=new CreateNewOrganization(driver);
		cno.createOrg(orgName);
		
		 /*: verify the successful msg with org name*/
		Organizationinfo org=new Organizationinfo(driver);
		String orl = org.getSuccessfull().getText();
		
		if(orl.contains(orgName))
		{
			System.out.println("org is created pass");
		}
		else
		{
			System.out.println("org is not created fail");
		}
		
		
	}

	
	@Test(groups="Regression Testing")
public void CreateOrganizationwithIndustry() throws EncryptedDocumentException, IOException {
		
		/*reading data from Excel*/
		String OrgName = eLib.getDataFromExcel("Org", 1, 1)+jLib.getRandomNumber();
		
		
		//String orgName = eLib.getDataFromExcel("Org",1,1)+"_"+jLib.getRandomNumber();
		
		/* : navigate to organization*/
		wLib.waitUntilPageLoad1(driver);
		Home hp=new Home(driver);
		hp.getOrganizationlink().click();
		
        /* : navigate to "create new organization"page by click on "+" image */
		
		Organization op=new Organization(driver);
		op.getCreateorgImg().click();
		
        /*: create organization*/
		CreateNewOrganization cno=new CreateNewOrganization(driver);
		wLib.select("Banking",cno.getInd());
		cno.createOrg(OrgName);
		
		
		/*verify orgname & industry */
		Organizationinfo org=new Organizationinfo(driver);
		String orl = org.getSuccessfull().getText();
		
		if(orl.contains(OrgName))
		{
			System.out.println("org  n ind is created pass");
		}
		else
		{
			System.out.println("org n ind is not created fail");
		}
	}

		
		
		

}

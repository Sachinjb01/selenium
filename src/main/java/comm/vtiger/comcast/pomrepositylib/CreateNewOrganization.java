package comm.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganization {
	
	public CreateNewOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement createOrgName;
	
	
	@FindBy(name="industry")
	private WebElement ind;
	
	
	@FindBy(xpath="//input[@accesskey='S']")
	private WebElement saveBtn;
	
	


	public WebElement getInd() {
		return ind;
	}

	




	public void createOrg(String OrgName)
	{
		createOrgName.sendKeys(OrgName);
		saveBtn.click();
	}
	
	
	
	

	
}

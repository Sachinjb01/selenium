package comm.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
	public Home(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(linkText="Organizations")
	private WebElement organizationlink;
	
	
	@FindBy(linkText="Contacts")
	private WebElement ContactEdt;
	
	
	
@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement adminimg;

@FindBy(linkText="Sign Out")
private WebElement signoutlink;



public WebDriver getDriver() {
	return driver;
}

public WebElement getOrganizationlink() {
	return organizationlink;
	
}
public WebElement getContactEdt() {
	return ContactEdt;
}

public WebElement getCreateContact() {
	// TODO Auto-generated method stub
	return null;
}

public WebElement getAdminimg() {
	return adminimg;
}

public WebElement getSignoutlink() {
	return signoutlink;
}


public void logout()
{
	Actions ac=new Actions(driver);
	ac.moveToElement(adminimg).perform();
	signoutlink.click();
}









	
	
	

	
}

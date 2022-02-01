package comm.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comm.crm.Genericlibary.WebDriverUtility;

public class CreatingNewContacts extends WebDriverUtility{

	WebDriver driver=null;
	public CreatingNewContacts(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(name="lastname")
	private WebElement Createnewcontact;
	
	
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement clickon;
	
	
	
	@FindBy(xpath="//input[@accesskey='S']")
	private WebElement saveBtn;
	
	
	public WebElement getCreatenewcontact() {
		return Createnewcontact;
	}
	
	
	




	public WebElement getClickon() {
		return clickon;
	}




	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void CreateCon(String Lname, String orgName) throws InterruptedException
	{
		
		Createnewcontact.sendKeys(Lname);
		clickon.click();
		switchToWindow(driver, "Accounts&action");
		Organization org=new Organization(driver);
		org.getSearchtext().sendKeys(orgName);
		org.getSearch().click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts&action");
		saveBtn.click();
	
	}
	public void CreateCon(String Lname)
	{
		
		Createnewcontact.sendKeys(Lname);
		saveBtn.click();


	}




	private void switchTOWindow(WebDriver driver2, String string) {
		// TODO Auto-generated method stub
		
	}
	
	
}

package comm.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformation {
	
	WebDriver driver;
	public ContactInformation(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement sucess;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement oname;
	
	
	
	
	public WebElement getOname() {
		return oname;
	}




	public WebElement getSucess() {
		return sucess;
	}
	
	
	
	
	
	
	

}

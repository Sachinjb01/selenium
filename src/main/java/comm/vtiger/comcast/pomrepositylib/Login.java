package comm.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement userName;
	
	@FindBy(name="user_password")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginbtn;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	public void loginToApp(String Username,String Password)
	{
		userName.sendKeys(Username);
		password.sendKeys(Password);
		loginbtn.click();
	}
	
	
	
	
}

package Com.crm.CreateOrgTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import comm.crm.Genericlibary.ExcelUtility;
import comm.crm.Genericlibary.FileUtility;
import comm.crm.Genericlibary.JavaUtility;
import comm.crm.Genericlibary.WebDriverUtility;

public class organization {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//object creation
		
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	
	int randomnum = jLib.getRandomNumber();
	//excel read
	String value = eLib.getDataFromExcel("Org", 1, 1)+randomnum;
	String Username = fLib.getPropertykeyValue("username");
	String Password = fLib.getPropertykeyValue("password");
	String Browser = fLib.getPropertykeyValue("browser");
	String Url = fLib.getPropertykeyValue("url");
	
	WebDriver driver=null;
	if(Browser.equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();
	}
	
	wLib.waitUntilPageLoad(driver);
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(Url);
	driver.findElement(By.name("user_name")).sendKeys(Username);
	driver.findElement(By.name("user_password")).sendKeys(Password);
	driver.findElement(By.xpath("(//input[@value='Login'])[2]")).click();
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(value);
	driver.findElement(By.name("button")).click();
	
	String msg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(msg.contains(value))
	{
		System.out.println("pass");
	}
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
	String value2 = eLib.getDataFromExcel("Contact", 1, 1)+randomnum;
	driver.findElement(By.name("lastname")).sendKeys(value2);
	driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[1]")).click();
	wLib.switchToWindow(driver, "Accounts");
	driver.findElement(By.id("search_txt")).sendKeys(value);
	driver.findElement(By.xpath("//input[@name='search']")).click();
	driver.findElement(By.linkText(value)).click();
	wLib.switchToWindow(driver, "Contacts");
	driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
	String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(ContactHeader.contains(value2))
	{
		System.out.println("TEst script 2 got passed");
	}
	
	 WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
	wLib.mousehover(driver, element);
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	driver.quit();

	
	
	
	
	
	
	
	
	
	}
	

	}



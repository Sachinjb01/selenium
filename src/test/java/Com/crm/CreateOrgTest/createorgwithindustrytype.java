package Com.crm.CreateOrgTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import comm.crm.Genericlibary.ExcelUtility;
import comm.crm.Genericlibary.FileUtility;
import comm.crm.Genericlibary.JavaUtility;
import comm.crm.Genericlibary.WebDriverUtility;

public class createorgwithindustrytype {
	public static void main(String[] args) throws IOException {
		
		//Object creation
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		int randomnum = jLib.getRandomNumber();
		//Excel read
		String value = eLib.getDataFromExcel("Org", 1, 1)+randomnum;
		
		
		/*read common Data*/
		String USERNAME = fLib.getPropertykeyValue("username");
		String PASSWORD = fLib.getPropertykeyValue("password");
		String BROWSER = fLib.getPropertykeyValue("browser");
		String URL = fLib.getPropertykeyValue("url");
		WebDriver driver=null;
		
		//Launch the Browser
		if(BROWSER.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}
		wLib.waitUntilPageLoad1(driver);
		
		//Login to Application
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Navigate to Organization
		
		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(value);
		WebElement dd = driver.findElement(By.name("industry"));
		wLib.select("Education", dd);
		WebElement type = driver.findElement(By.name("accounttype"));
		wLib.select("Customer",type );
		driver.findElement(By.name("button")).click();
		String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(header.contains(value))
		{
			System.out.println(header);
			System.out.println("Tscript1 passed");
		}
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		wLib.mousehover(driver, element);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.quit();
	
	}
}

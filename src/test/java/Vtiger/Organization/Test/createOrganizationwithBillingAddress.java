package Vtiger.Organization.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class createOrganizationwithBillingAddress {

	static WebDriver driver;
		public static void main(String[] args) throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			
			FileInputStream fis=new FileInputStream("./data/comdata.properties");
			Properties po=new Properties();
			po.load(fis);
			
			String br = po.getProperty("browser");
			
			String Url = po.getProperty("url");
			
			String uname = po.getProperty("uname");
			
			String pwd = po.getProperty("pwd");
			FileInputStream fis2=new FileInputStream("./data/Book2.xlsx");
			Workbook wb=WorkbookFactory.create(fis2);
			 Sheet sh = wb.getSheet("Sheet1");
			 Row row = sh.getRow(1);
			 Cell c = row.getCell(0);
			String value = c.getStringCellValue();
			System.out.println(value);
			
			
			
			if(br.equals("firefox"))
			{
				driver=new FirefoxDriver();
			}
			
			else if(br.equals("chrome"))
			{
				driver=new ChromeDriver();
			}
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.get(Url);
			driver.findElement(By.name("user_name")).sendKeys(uname);
			driver.findElement(By.name("user_password")).sendKeys(pwd);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
			
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
			driver.findElement(By.name("accountname")).sendKeys(value);
			Thread.sleep(2000);
			driver.findElement(By.name("bill_street")).sendKeys("CAM**");
			
			
			WebElement ele = driver.findElement(By.name("industry"));
			Select s=new Select(ele);
			s.selectByValue("Engineering");
			driver.findElement(By.name("button")).click();
			
			
		Actions ac=new Actions(driver);
		Thread.sleep(2000);
		WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		ac.moveToElement(ele2).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

		}

	


	}



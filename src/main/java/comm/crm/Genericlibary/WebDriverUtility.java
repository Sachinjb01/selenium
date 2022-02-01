package comm.crm.Genericlibary;


	
	import java.io.File;
	import java.io.IOException;
	import java.util.Iterator;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.google.common.io.Files;

	/**
	 * This class contains generic methods for all WebDriver actions
	 * @author ELCOT
	 *
	 */
	public class WebDriverUtility {
		/**
		 * This method will maximize the window
		 * @param driver
		 */
		public void maximizeWindow(WebDriver driver) {
			driver.manage().window().maximize();
		}
		/**
		 * This method will wait until page gets loaded
		 * @param driver
		 */
		public void waitUntilPageLoad1(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		}
		public void waitForpageLoad(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		}
		
		public void waitForElementToBeClickable(WebDriver driver, WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		public void waitUntilelementVisible(WebDriver driver, WebElement element){
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		public void waitAndClick(WebElement element) throws Throwable
		{
			int count =0;
			while(count<20);
			{
				try {
					element.click();
					
				}
				catch(Exception e) {
					Thread.sleep(1000);
					count++;
				}
			}
		}
		
		public void select(WebElement ele,int index)
		{
			Select sel=new Select(ele);
			sel.selectByIndex(index);
			
		}
		public void select(WebElement ele, String value)
		{
			Select sel=new Select(ele);
			sel.selectByValue(value);
		}
		public void select( String text,WebElement elem)
		{
			Select sel=new Select(elem);
			sel.selectByVisibleText(text);
		}
		
		public void doubleClick(WebDriver driver)
		{
			Actions a=new Actions(driver);
			a.doubleClick().perform();
		}
		public void mousehover(WebDriver driver,WebElement ele)
		{
			Actions a=new Actions(driver);
			a.moveToElement(ele).perform();
		}
		public void rightClick(WebDriver driver, WebElement ele)
		{
			Actions a=new Actions(driver);
			a.contextClick(ele).perform();
		}
		public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest)
		{
			Actions a=new Actions(driver);
			
			a.dragAndDrop(src, dest).perform();
		}
		/**
		 * This method is used to accept the alert popup
		 * @param driver
		 */
		public void acceptAlert(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		/**
		 * This method is used to dismiss the alert popup
		 * @param driver
		 */
		public void dismissAlert(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		
		/**
		 * This method is used to takeScreenshot of a failed testcases
		 * @param driver
		 * @param screenshotname
		 * @throws IOException
		 */
		public void getScreenshot(WebDriver driver,String screenshotname) throws IOException
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./Photo/"+screenshotname+".PNG");
			Files.copy(src, dest);
		}
		/**
		 * Switch to window depending on partial title
		 * @param driver
		 * @param partialWinTitle
		 */
		public void switchToWindow(WebDriver driver,String partialWinTitle)
		{
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			while(it.hasNext())
			{
				String windowid = it.next();
				driver.switchTo().window(windowid);
				String currentwindowtitle = driver.getTitle();
				if(currentwindowtitle.contains(partialWinTitle))
				{
					break;
				}
			}
		}
		public void switchtoFrame(WebDriver driver, int index)
		{
			driver.switchTo().frame(index);
		}
		public void  switchtoFrame(WebDriver driver, String idOrName)
		{
			driver.switchTo().frame(idOrName);
			
		}
		public void switchtoFrame(WebDriver driver, WebElement ele)
		{
			driver.switchTo().frame(ele);
		}
		public void switchtoDefaultFrame(WebDriver driver)
		{
			driver.switchTo().defaultContent();
		}
		public void switchtoFrame(WebDriver driver)
		{
			driver.switchTo().parentFrame();
		}
		/**
		 * Scroll until
		 * @param driver
		 * 
		 * @param element
		 */
		public void scrollToElement(WebDriver driver,WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("argument[0].scrollIntoView()",element);
		}
		public void waitUntilPageLoad(WebDriver driver) {
			// TODO Auto-generated method stub
			
	
		}
	}
	
